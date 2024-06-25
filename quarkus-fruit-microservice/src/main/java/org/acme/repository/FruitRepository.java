package org.acme.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.Fruit;

import java.util.Set;
import java.util.stream.Collectors;

@Singleton
public class FruitRepository {

    private final EntityManager em;

    FruitRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public Set<Fruit> getAllFruits() {
        return em.createQuery("SELECT f FROM Fruit f ORDER BY id", Fruit.class)
            .getResultStream()
            .collect(Collectors.toSet());
    }

    @Transactional
    public Set<Fruit> addFruit(Fruit fruit) {
        em.persist(fruit);
        return em.createQuery("SELECT f FROM Fruit f ORDER BY id", Fruit.class)
            .getResultStream()
            .collect(Collectors.toSet());
    }

    @Transactional
    public void deleteFruit(Fruit fruit) {
        em.remove(fruit);
    }
}
