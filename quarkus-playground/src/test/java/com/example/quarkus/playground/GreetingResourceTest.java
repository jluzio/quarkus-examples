package com.example.quarkus.playground;

import io.quarkus.test.junit.QuarkusTest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

  @Test
  public void testHelloEndpoint() {
    given()
        .when().get("/hello")
        .then()
        .statusCode(200)
        .body(is("Hello RESTEasy"));
  }

  @Test
  public void testGreetingEndpoint() {
    String uuid = UUID.randomUUID().toString();
    given()
        .pathParam("name", uuid)
        .when().get("/hello/greeting/{name}")
        .then()
        .statusCode(200)
        .body(is("hello " + uuid));
  }

}