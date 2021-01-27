package com.example.line.server.startup;

import com.example.line.server.file.reader.FileReaderCache;
import com.example.line.server.file.reader.FileReaderCacheImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @EventListener(ApplicationReadyEvent.class)
    public void initializeAfterSpringBootStartup() {
        readFile();
    }

    private void readFile() {
        FileReaderCache fileReaderCache = FileReaderCacheImpl.getInstance();
        fileReaderCache.reloadCache();
    }


}
