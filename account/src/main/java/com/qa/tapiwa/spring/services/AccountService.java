package com.qa.tapiwa.spring.services;

import com.qa.tapiwa.spring.data.domain.Account;
import com.qa.tapiwa.spring.data.repo.AccountRepo;
import com.qa.tapiwa.spring.dto.AccountDto;
import com.qa.tapiwa.spring.exceptions.AccountNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private AccountRepo accountRepo;
    private ModelMapper mapper;
    private RestTemplate restTemplate;
    private LogService log;


    public AccountService(AccountRepo accountRepo, ModelMapper mapper, RestTemplateBuilder rt, LogService log) {
        this.accountRepo = accountRepo;
        this.mapper = mapper;
        this.restTemplate = rt.build();
        this.log = log;

    }

    private AccountDto mapToDto(Account account){
        return  this.mapper.map(account, AccountDto.class);
    }

    public AccountDto create(Account account){
        account.setAccountNumber(restTemplate.getForObject("http://localhost:8081/numGen/generate", String.class));
        account.setPrize(restTemplate.getForObject("http://localhost:8082/prizeGen/generate/"+account.getAccountNumber(), Double.class));
        Account saveAccount = this.accountRepo.save(account);
        AccountDto dto = mapToDto(saveAccount);
        return dto;
    }

    public List<AccountDto> read(){
    	log.log("Get all accounts");
        return this.accountRepo.findAll().stream().map((account) -> this.mapToDto(account)).collect(Collectors.toList());
    }

    public Account update(String firstName, String lastName, Long id){
    	log.log("find account by Id: " + id);
        Account account = this.accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundException());
        log.log("update first name" + firstName);
        account.setFirstName(firstName);
        log.log("update last name" + lastName);
        account.setLastName(lastName);
        return  this.accountRepo.save(account);

    }


    public  boolean delete(long id){
    	log.log("delete id by id: :" +id);
        this.accountRepo.deleteById(id);
        return this.accountRepo.existsById(id);
    }
}
