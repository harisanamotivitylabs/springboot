//package com.example.WebClientPoc.service;
//
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//@Service
//public class CustomerService {
//
//    private final WebClient webClient;
//
//    Customer c = new Customer(1l,"venu","venu@gamil.com");
//
//
//    public CustomerService(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder.baseUrl("http://localhost:8083").build();
//    }
//
//    public Mono<Customer> getCustomerById(Long id) {
//        return this.webClient.get().uri("/customers/{id}", id)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Customer.class);
//    }
//}
//
