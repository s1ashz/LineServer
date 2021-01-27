package com.example.line.server.file.reader;

import com.example.line.server.constants.ConstantManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileReader {

    private FileInputStream inputStream;
    private File fileToRead;

    private List<String> fileLineList = new ArrayList<>();

    public FileReader(String value) {
        fileToRead = new File(value);
    }

    public List<String> readFromFile() {
        try {
            fileToRead = new File(ConstantManager.FILE_PATH.getValue());
            readFromFileAndAddToSet();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileLineList;
    }

    private void readFromFileAndAddToSet() throws FileNotFoundException {
        inputStream = new FileInputStream(fileToRead);
        Scanner sc = new Scanner(inputStream);
        while (sc.hasNextLine()) {
            String line = null;
            line = sc.nextLine();
            fileLineList.add(line);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
