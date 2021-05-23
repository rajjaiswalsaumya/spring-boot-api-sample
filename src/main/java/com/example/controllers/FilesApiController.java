package com.example.controllers;

import com.example.models.FileListModel;
import com.example.services.ResourceLocatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

@RestController()
@RequestMapping("/files")
public class FilesApiController {

    private final ResourceLocatorService resourceLocatorService;

    public FilesApiController(ResourceLocatorService resourceLocatorService) {
        this.resourceLocatorService = resourceLocatorService;
    }

    @GetMapping("/list")
    public Stream<FileListModel> list() throws IOException {
        return this.resourceLocatorService.list();
    }
}
