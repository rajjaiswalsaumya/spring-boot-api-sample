package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.nio.file.Path;

@Data
@AllArgsConstructor
public class FileListModel {
    String fileName;
    Path filePath;
}
