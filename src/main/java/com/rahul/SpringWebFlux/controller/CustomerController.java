package com.rahul.SpringWebFlux.controller;

import com.rahul.SpringWebFlux.dto.Customer;
import com.rahul.SpringWebFlux.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


        // this is traditional approach (blocking , synchronization,normal approach)
        @RequestMapping("/")
        public List<Customer> getAllCustomers(){
            return  customerService.loadAllCustomer();
        }


        //this is non-blocking approach method non synchronised(Webflux reactive approach)
    @RequestMapping("/stream")
    public Flux<Customer> getAllCustomersStream(){
        return  customerService.loadAllCustomerStream();

        //
    }

}
