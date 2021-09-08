package com.skaczmarek.matchmakerappbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {
    @RequestMapping({ "/heartbeat" })
    public String firstPage() {
        return "test value";
    }
}
