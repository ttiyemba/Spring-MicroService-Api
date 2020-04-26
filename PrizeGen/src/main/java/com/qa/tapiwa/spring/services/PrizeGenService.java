package com.qa.tapiwa.spring.services;

import org.springframework.stereotype.Service;

@Service
public class PrizeGenService {


    public double checkPrize(String accNum) {

        if (accNum.toLowerCase().startsWith("c")) {
            if (accNum.length() == 11) {
                return 10000;
            } else if (accNum.length() == 9) {
                return 750;
            } else {
                return 100;
            }

        } else if (accNum.toLowerCase().startsWith("b")) {
            if (accNum.length() == 11) {
                return 5000;
            } else if (accNum.length() == 9) {
                return 500;
            } else {
                return 50;
            }

        }

        return 0;

    }


}
