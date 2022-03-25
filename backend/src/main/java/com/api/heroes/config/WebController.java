package com.api.heroes.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController
{
    @RequestMapping("/login")
    public String showUserMsg()
    {
        return "User has logged in!!!";

    }
}
