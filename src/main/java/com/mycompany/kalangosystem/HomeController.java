package com.mycompany.kalangosystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicial() {
        return "index"; // Isso vai abrir o seu index.html da pasta templates
    }
}