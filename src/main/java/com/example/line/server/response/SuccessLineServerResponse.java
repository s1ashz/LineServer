package com.example.line.server.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SuccessLineServerResponse extends ResponseEntity {

    public SuccessLineServerResponse(Object body) {
        super(body, HttpStatus.OK);
    }

}
