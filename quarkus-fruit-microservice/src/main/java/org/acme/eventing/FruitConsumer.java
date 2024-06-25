package org.acme.eventing;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.Fruit;
import org.acme.repository.FruitRepository;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class FruitConsumer {

    private final FruitRepository repo;
    private static final Logger LOG = Logger.getLogger(FruitConsumer.class);

    public FruitConsumer(FruitRepository repo) {
        this.repo = repo;
    }

    @Incoming("fruits")
    @Transactional
    public void consumeFruit(Fruit fruit) {
        LOG.infof("Event %s", fruit.name);
        repo.addFruit(fruit);
    }
}
