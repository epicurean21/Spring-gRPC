package com.example.grpcclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grpcclient.service.GreetingsClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class GreetingsClientController {
    private final GreetingsClientService greetingsClientService;

    @GetMapping("/test")
    public String printMessage() {
        return greetingsClientService.greetingsToServer("from user jm");
    }
}
