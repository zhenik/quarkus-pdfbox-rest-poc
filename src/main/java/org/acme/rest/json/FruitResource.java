package org.acme.rest.json;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fruits")
public class FruitResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Fruit> fruits() {
    return Fruit.generateFruits();
  }
}
