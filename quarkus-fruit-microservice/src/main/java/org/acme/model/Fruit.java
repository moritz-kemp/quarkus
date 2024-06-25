package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Fruit {
    @Id
    public int id;
    public String name;
    public String description;
    @Version
    public int version;

    public Fruit() {
    }

    public Fruit(int id, String name, String description, int version) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.version = version;
    }
}
