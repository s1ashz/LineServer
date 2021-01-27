package com.example.line.server.file.reader;

import com.example.line.server.LineServerApplication;
import com.example.line.server.constants.ConstantManager;
import com.example.line.server.exception.LineServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FileReaderCacheImpl implements FileReaderCache {

    private static final Logger logger = LoggerFactory.getLogger(LineServerApplication.class);

    private static FileReaderCacheImpl instance = null;

    private List<String> fileLineList = new ArrayList<>();

    public static FileReaderCacheImpl getInstance() {
        if (instance == null) {
            instance = new FileReaderCacheImpl();
        }
        return instance;
    }

    private FileReaderCacheImpl() {
    }

    @Override
    public void reloadCache() {
        FileReader fileReader = new FileReader(ConstantManager.FILE_PATH.getValue());
        fileLineList = fileReader.readFromFile();
        logger.info("File was successfully read!");
    }

    @Override
    public List<String> getFileList() {
        return fileLineList;
    }

    @Override
    public String getLineAtIndex(int index) throws LineServerException {
        String line = "";
        try {
            line = fileLineList.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new LineServerException();
        }
        return line;
    }

}
