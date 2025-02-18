package com.jams_and_jellies.catalog_API;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.Session;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.*;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {

        // Creating the entity manager for hibernate
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jelly-postgresql");
        Mutiny.SessionFactory sessionFactory = emf.unwrap(Mutiny.SessionFactory.class);
    
        Product jam = new Product("Grape");
    
        sessionFactory.withTransaction((session, tx) -> session.persist(jam));

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
    }
}
