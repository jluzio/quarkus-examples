package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/hello")
@Slf4j
public class GreetingResource {

  @Inject
  GreetingService service;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/greeting/{name}")
  public String greeting(@PathParam String name) {
    return service.greeting(name);
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello RESTEasy";
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/log")
  public String log() {
    log.error("log::error");
    log.warn("log::warn");
    log.info("log::info");
    log.debug("log::debug");
    log.trace("log::trace");
    return "Hello log";
  }
}