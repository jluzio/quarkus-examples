package com.example.quarkus.playground;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

  public String greeting(String name) {
    return "hello " + name;
  }

}