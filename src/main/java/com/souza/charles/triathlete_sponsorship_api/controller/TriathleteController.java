package com.souza.charles.triathlete_sponsorship_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TriathleteController {

    @GetMapping("/")
    public String triathleteReadAll() {
        return "triathletes-list"; // Sem a barra no início
    }
}