package org.acme.rest.json;

import io.quarkus.runtime.annotations.RegisterForReflection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RegisterForReflection
public class Fruit {
  public String name;
  public String description;

  public Fruit() {

  }

  public Fruit(String name, String description) {
    this.name = name;
    this.description = description;
  }

  static List<Fruit> generateFruits() {
    final Random random = new Random();
    int amount = random.nextInt(10) + 1;
    final List<Fruit> fruits = new ArrayList<>();

    for (int i = 0; i < amount; i++) {
      fruits.add(new Fruit(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
    }
    return fruits;
  }
}
