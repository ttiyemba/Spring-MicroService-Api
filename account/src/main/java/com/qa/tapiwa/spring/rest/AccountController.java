package com.qa.tapiwa.spring.rest;

import com.qa.tapiwa.spring.data.domain.Account;
import com.qa.tapiwa.spring.dto.AccountDto;

import com.qa.tapiwa.spring.services.AccountService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    



    public AccountController(AccountService accountService) {
        this.accountService = accountService;


        
    }

    @PostMapping("/create")
    public AccountDto create(@RequestBody Account account) {



        return this.accountService.create(account);
    }

    @GetMapping("/read")
    public List<AccountDto> read(){
        return this.accountService.read();
    }

    @PutMapping("/update/{id}")
    public Account update(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName, @PathVariable Long id){
        return this.accountService.update(firstName,lastName,id);
    }

    @DeleteMapping("/delete/{id}")
    public  boolean delete(@PathVariable Long id){
        return  this.accountService.delete(id);
    }
}
