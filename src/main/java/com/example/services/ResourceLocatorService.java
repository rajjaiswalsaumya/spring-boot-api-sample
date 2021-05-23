package com.example.services;

import com.example.config.FileSystemConfig;
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

    public Stream<Path> list() throws IOException {
        return Files.list(Paths.get(this.fileSystemConfig.getFilesLocation()));
    }
}
