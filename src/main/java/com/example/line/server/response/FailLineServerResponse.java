package com.example.line.server.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FailLineServerResponse extends ResponseEntity {

    public FailLineServerResponse() {
        super( HttpStatus.PAYLOAD_TOO_LARGE );
    }

}
