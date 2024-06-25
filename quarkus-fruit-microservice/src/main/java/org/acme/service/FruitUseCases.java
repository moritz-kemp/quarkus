package org.acme.service;

import org.acme.model.Fruit;

import java.util.Set;

/**
 * Use cases for fruits
 */
public interface FruitUseCases {

    /**
     * Get all fruits
     * @return a set of fruits
     */
    Set<Fruit> getAllFruits();

    /**
     * Add a fruit.
     * If the fruit already exists, it will be updated.
     * @param fruit the fruit to add
     * @return the new set of fruits
     */
    Set<Fruit> addFruit(Fruit fruit);

    /**
     * Delete a fruit
     * @param fruit the fruit to delete
     */
    void deleteFruit(Fruit fruit);
}
