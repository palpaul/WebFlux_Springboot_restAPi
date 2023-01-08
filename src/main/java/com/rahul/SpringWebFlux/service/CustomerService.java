package com.rahul.SpringWebFlux.service;

import com.rahul.SpringWebFlux.dao.CustomerDao;
import com.rahul.SpringWebFlux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomer(){
        long start = System.currentTimeMillis();
           List<Customer> customers= customerDao.getCustomer();
           long end = System.currentTimeMillis();
           System.out.println("Total execution time: " +(end-start));
           return  customers;
    }


    //webflux appraoch , reactive programing
    public Flux<Customer> loadAllCustomerStream(){
        long start = System.currentTimeMillis();
        Flux<Customer> customers= customerDao.getCustomerStream();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time: " +(end-start));
        return  customers;
    }

}
