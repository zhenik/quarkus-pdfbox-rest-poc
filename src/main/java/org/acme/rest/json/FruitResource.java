package org.acme.rest.json;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fruits")
public class FruitResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Fruit> fruits() {
    return generateFruits();
  }

  List<Fruit> generateFruits() {
    final Random random = new Random();
    int amount = random.nextInt(10) + 1;
    final List<Fruit> fruits = new ArrayList<>();

    for (int i = 0; i < amount; i++) {
      fruits.add(new Fruit(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
    }
    return fruits;
  }
}
