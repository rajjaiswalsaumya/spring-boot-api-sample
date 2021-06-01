package com.example.parser;

import com.example.models.FileDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class FlatFileParser implements IParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlatFileParser.class);

    @Override
    public List<FileDataModel> parse(String filePath) throws IOException {
        Resource resource = new FileSystemResource(filePath);
        List<FileDataModel> data = new LinkedList<>();
        FileDataModel model = new FileDataModel();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getURL().openStream()))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!StringUtils.hasText(line))
                    continue;
                else if (isJavaComment(line)) {
                    model = new FileDataModel();
                    data.add(model);
                    continue;
                } else {
                    Map<String, Object> parsedAttributesMap = parseLineContent(line);
                    if (parsedAttributesMap.size() > 0) {
                        model.putAll(parsedAttributesMap);
                    }
                }
            }
        }

        return data;
    }

    public boolean isJavaComment(String line) {
        return line.startsWith("/*") && line.endsWith("*/");
    }

    public Map<String, Object> parseLineContent(String line) {
        boolean foundKey = false;
        boolean foundValue = false;
        boolean isSpace = false;
        String currentKey = null;
        Object currentValue = null;

        Map<String, Object> content = new HashMap<>();

        List<Character> chars = new ArrayList<>();
        char ch = '\0';
        char[] lineChars = line.toCharArray();
        for (int i = 0; i < lineChars.length; i++) {
            ch = lineChars[i];
            if (!foundKey) {
                if (ch != ':') {
                    chars.add(ch);
                } else {
                    foundKey = true;
                    currentKey = chars.stream().map(String::valueOf).collect(Collectors.joining());
                    chars = new ArrayList<>();
                    i += 1;
                }
            } else {
                if (!foundValue) {
                    if (!Character.isWhitespace(ch)) {
                        chars.add(ch);
                    } else {
                        foundValue = true;
                        currentValue = chars.stream().map(String::valueOf).collect(Collectors.joining());
                        chars = new ArrayList<>();
                    }
                }
            }

            if (foundKey && foundValue) {
                content.put(currentKey, currentValue);
                foundKey = false;
                foundValue = false;
            }
        }

        if (foundKey && !foundValue) {
            currentValue = chars.stream().map(String::valueOf).collect(Collectors.joining());
            content.put(currentKey, currentValue);
        }
        return content;
    }
}
