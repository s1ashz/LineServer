package com.example.line.server.file.reader;

import com.example.line.server.exception.LineServerException;

import java.util.List;

public interface FileReaderCache {

    void reloadCache();
    List<String> getFileList();
    String getLineAtIndex(int index) throws LineServerException;

}
