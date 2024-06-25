package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.Fruit;
import org.acme.repository.FruitRepository;
import org.jboss.logging.Logger;

import java.util.Set;

@ApplicationScoped
public class FruitUseCasesImpl implements FruitUseCases {

    FruitRepository repo;
    private static final Logger LOG = Logger.getLogger(FruitUseCasesImpl.class);

    @Inject
    FruitUseCasesImpl(FruitRepository repo) {
        this.repo = repo;
    }

    @Override
    public Set<Fruit> getAllFruits() {
        LOG.info("Get all fruits");
        return repo.getAllFruits();
    }

    @Override
    public Set<Fruit> addFruit(Fruit fruit) {
        LOG.infof("Add fruit %s", fruit.name);
        return repo.addFruit(fruit);
    }

    @Override
    public void deleteFruit(Fruit fruit) {
        LOG.infof("Delete fruit %s", fruit.name);
        repo.deleteFruit(fruit);
    }
}
