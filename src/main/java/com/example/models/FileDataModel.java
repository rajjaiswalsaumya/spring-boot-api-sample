package com.example.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class FileDataModel extends TreeMap<String, Object> {
    public FileDataModel() {
        super();
    }

    public FileDataModel(Comparator<? super String> comparator) {
        super(comparator);
    }

    public FileDataModel(Map<? extends String, ?> m) {
        super(m);
    }

    public FileDataModel(SortedMap<String, ?> m) {
        super(m);
    }
}
