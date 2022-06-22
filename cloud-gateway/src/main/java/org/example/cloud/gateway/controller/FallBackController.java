package org.example.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/country/*")
    public String countryStatisticsFallBack() {

        return "Statistics service is currently unavailable!";
    }
}
