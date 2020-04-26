package com.qa.tapiwa.spring.rest;

import com.qa.tapiwa.spring.services.AccountNumGenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/numGen")
public class AccountNumGenController {

    private AccountNumGenService accountNumGenService;

    public AccountNumGenController(AccountNumGenService accountNumGenService) {
        this.accountNumGenService = accountNumGenService;
    }

    @GetMapping("/generate")
    public String numGen(){

        return this.accountNumGenService.accountNumberGenerator();
    }
}



