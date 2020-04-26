package com.qa.tapiwa.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.tapiwa.spring.services.PrizeGenService;

@RestController
@RequestMapping("/prizeGen")
public class PrizeGenController {
	
	private PrizeGenService priceGen;

	public PrizeGenController(PrizeGenService priceGen) {
		super();
		this.priceGen = priceGen;
	}
	
	 	@GetMapping("/generate/{accNum}")
	   public double numGen(@PathVariable String accNum){
	
	       return this.priceGen.checkPrize(accNum);
	   }

}


