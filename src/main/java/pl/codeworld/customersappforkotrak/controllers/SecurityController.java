package pl.codeworld.customersappforkotrak.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecurityController {


    @GetMapping("/auth")
    public void auth(){
        System.out.println("Zalogowano");
    }
}
