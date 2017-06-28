package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.model.Result;

@Component
@Path("/api/foos/hello")
public class HelloWorldService {

	@GET
	@Produces("application/json")
    @Path("/world")
    public Result test() {
		Result r = new Result();
		r.setId(12);
		r.setMessage("Hello World");
        return r;
    }
}
