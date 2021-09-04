package com.example.demo.controller;

import com.example.demo.entity.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
public class HelloController {

    @GetMapping("/success")
    public ResponseEntity getHelloWorld() {
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping(value = "/serverError", produces="application/json")
    public ResponseEntity serverErrorMessage() {
        Message message = Message.builder()
                .message1("First Message")
                .message2("Second Message")
                .build();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/onlystatus")
    public ResponseEntity onlystatus() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/header")
    public ResponseEntity header() {
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("AUTHCODE", "xxxxxxxxxx");
        header.add("TOKEN", "tttttt");
        return new ResponseEntity(header, HttpStatus.OK);
    }
}
