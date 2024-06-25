package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.model.Fruit;
import org.acme.service.FruitUseCases;

import java.util.Set;

@Path("/fruits")
public class FruitResource {

    FruitUseCases fruitUseCases;

    @Inject
    public FruitResource(
        FruitUseCases fruitUseCases
    ) {
        this.fruitUseCases = fruitUseCases;
    }

    @GET
    public Set<Fruit> list() {
        return fruitUseCases.getAllFruits();
    }

    @POST
    public Set<Fruit> add(Fruit fruit) {
        return fruitUseCases.addFruit(fruit);
    }

    @DELETE
    public void delete(Fruit fruit) {
        fruitUseCases.deleteFruit(fruit);
    }
}
