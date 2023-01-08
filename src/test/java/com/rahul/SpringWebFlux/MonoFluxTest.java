package com.rahul.SpringWebFlux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {


    // writing test case
    @Test
    public  void testMono(){
        //creation of the object of Mono
        Mono<?> monoString = Mono.just("javaTechie")
                .then(Mono.error(new RuntimeException("run time exception occurred")))
                .log();
        monoString.subscribe(System.out::println, (e)->System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("WebFlux", "SpringBoot", "Hibernate", "Microservices")
                .concatWithValues("AWS")
                // forcefully sending some error
                .concatWith(Flux.error(new RuntimeException("Runtime exception occurred")))
                .concatWithValues("Angular")
                .log();
        fluxString.subscribe(System.out::println);
    }
}
