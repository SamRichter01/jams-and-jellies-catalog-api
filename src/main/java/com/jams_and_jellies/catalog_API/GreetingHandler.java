package com.jams_and_jellies.catalog_API;

import org.hibernate.reactive.mutiny.Mutiny;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import jakarta.persistence.*;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

    // Creating the entity manager for hibernate
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jelly-postgresql");
    Mutiny.SessionFactory sessionFactory = emf.unwrap(Mutiny.SessionFactory.class);

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
    }
}
