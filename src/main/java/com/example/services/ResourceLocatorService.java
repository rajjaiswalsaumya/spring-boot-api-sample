package com.example.services;

import com.example.config.FileSystemConfig;
import com.example.models.FileListModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class ResourceLocatorService {
    private final FileSystemConfig fileSystemConfig;

    public ResourceLocatorService(FileSystemConfig fileSystemConfig) {
        this.fileSystemConfig = fileSystemConfig;
    }

    public Stream<FileListModel> list() throws IOException {
        return Files.list(Paths.get(this.fileSystemConfig.getFilesLocation())).map(item-> new FileListModel(item.getFileName().toString(), item.toAbsolutePath()));
    }
}
