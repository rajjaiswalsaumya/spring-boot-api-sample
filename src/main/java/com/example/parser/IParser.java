package com.example.parser;

import com.example.models.FileDataModel;

import java.io.IOException;
import java.util.List;

public interface IParser {
    List<FileDataModel> parse(String filePath) throws IOException;
}
