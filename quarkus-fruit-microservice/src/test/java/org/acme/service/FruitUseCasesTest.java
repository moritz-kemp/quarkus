package org.acme.service;

import org.acme.model.Fruit;
import org.acme.repository.FruitRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

class FruitUseCasesTest {

    FruitRepository repoMock = mock(FruitRepository.class);
    FruitUseCases fruitUseCases = new FruitUseCasesImpl(repoMock);

    @Test
    void getAllFruits() {
        // given
        Set<Fruit> mockedFruits = new HashSet<>();
        mockedFruits.add(new Fruit(1, "Apple", "Red colour", 0));
        when(repoMock.getAllFruits()).thenReturn(mockedFruits);

        // when
        Set<Fruit> fruits = fruitUseCases.getAllFruits();

        // then
        assertEquals(1, fruits.size());
    }

    @Test
    void addFruit() {
        // given
        Fruit apple = new Fruit(1, "Apple", "Red colour", 0);
        Fruit pear = new Fruit(2, "Pear", "Green colour", 0);
        Set<Fruit> mockedFruits = new HashSet<>();
        mockedFruits.add(apple);
        mockedFruits.add(pear);
        when(repoMock.addFruit(apple)).thenReturn(mockedFruits);

        // when
        Set<Fruit> fruits = fruitUseCases.addFruit(apple);

        // then
        assertEquals(2, fruits.size());
        assertTrue(fruits.contains(apple));
        assertTrue(fruits.contains(pear));
    }

    @Test
    void deleteFruit() {
        // given
        Fruit fruit = new Fruit(1, "Apple", "Red", 0);

        // when
        fruitUseCases.deleteFruit(fruit);

        // then
        verify(repoMock).deleteFruit(fruit);
    }
}
