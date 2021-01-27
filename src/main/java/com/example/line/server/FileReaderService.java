package com.example.line.server;


import com.example.line.server.exception.LineServerException;
import com.example.line.server.file.reader.FileReaderCacheImpl;
import org.springframework.stereotype.Service;

@Service
public class FileReaderService {

    private FileReaderCacheImpl fileReaderCache;

    public FileReaderService() {
        this.fileReaderCache = FileReaderCacheImpl.getInstance();
    }

    public String getLineByIndex(int index) throws LineServerException {
        return fileReaderCache.getLineAtIndex(index);
    }

}
