package com.rahul.SpringWebFlux.handler;

import com.rahul.SpringWebFlux.dao.CustomerDao;
import com.rahul.SpringWebFlux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
    @Autowired
    private CustomerDao customerDao;


    public Mono<ServerResponse> loadStreamCustomerList(ServerRequest request){
        Flux<Customer> customerStream = customerDao.getCustomerStream();
        return  ServerResponse.ok().
                contentType(MediaType.TEXT_EVENT_STREAM) // without mediaType adding its also working
                .body(customerStream,Customer.class);
    }


}
