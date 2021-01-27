package com.example.line.server.rest.controller;

import com.example.line.server.FileReaderService;
import com.example.line.server.exception.LineServerException;
import com.example.line.server.response.FailLineServerResponse;
import com.example.line.server.response.SuccessLineServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileReaderController {

    private FileReaderService fileReaderService;

    @Autowired
    public FileReaderController(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    @RequestMapping(value = "/line/{index}", method = RequestMethod.GET)
    public ResponseEntity getLineAtIndex(@PathVariable(required = true, value = "index") int index) {
        ResponseEntity responseEntity;
        try {
            String line = fileReaderService.getLineByIndex(index-1);
            responseEntity = new SuccessLineServerResponse(line);
        } catch (LineServerException e) {
            responseEntity = new FailLineServerResponse();
        }
        return responseEntity;
    }

}
