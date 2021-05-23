package com.example.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Data
@Slf4j
@ConfigurationProperties(prefix = "config.autosys")
public class FileSystemConfig {
    private String filesLocation;

    @PostConstruct
    public void init() {
        this.log.debug("--------------------------- FileSystemConfig ---------------------------");
        this.log.debug("filesLocation: {}", this.filesLocation);
        this.log.debug("-------------------------------------------- ---------------------------");
    }
}

