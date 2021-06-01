package com.example.indexer;

import com.example.config.FileSystemConfig;
import com.example.entity.JobData;
import com.example.models.FileDataModel;
import com.example.models.FileListModel;
import com.example.parser.IParser;
import com.example.repository.JobDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatabaseIndexer implements CommandLineRunner {
    private final IParser parser;
    private final FileSystemConfig fileSystemConfig;
    private final JobDataRepository jobDataRepository;
    private final ConversionService conversionService;

    public DatabaseIndexer(IParser parser, FileSystemConfig fileSystemConfig, JobDataRepository jobDataRepository, ConversionService conversionService) {
        this.parser = parser;
        this.fileSystemConfig = fileSystemConfig;
        this.jobDataRepository = jobDataRepository;
        this.conversionService = conversionService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<FileListModel> files = Files
                .list(Paths.get(this.fileSystemConfig.getFilesLocation()))
                .map(item -> new FileListModel(item.getFileName().toString(), item.toAbsolutePath())).collect(
                        Collectors.toList());
        for (FileListModel file : files) {
            List<FileDataModel> parsedModels = parser.parse(file.getFilePath().toString());
            parsedModels.stream().map(fileDataModel -> conversionService.convert(fileDataModel, JobData.class))
                        .forEach(jobData -> jobDataRepository.save(jobData));
        }
    }
}
