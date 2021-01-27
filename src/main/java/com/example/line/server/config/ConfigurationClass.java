package com.example.line.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ConfigurationClass {

    @Value("${" + PropertiesValues.FOLDER_PATH + ":#{null}}")
    private String receiveFolderPath;

}
