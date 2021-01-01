package com.javabullets.javaee8.healthcheck;

import java.lang.ProcessHandle.Info;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("healthcheck")
public class Healthcheck {

    @GET
    @Path("pid")
    public Long getPid() {
    	return ProcessHandle.current().pid();
    }
    
    @GET
    @Path("full")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getProperties() {
    	JsonObjectBuilder builder = Json.createObjectBuilder();
    	
    	Info processInfo = ProcessHandle.current().info();
    	
    	builder.add("totalCpuDuration", processInfo.totalCpuDuration().get().toMillis());
    	builder.add("startInstantMilli", processInfo.startInstant().get().toEpochMilli());
    	
    	return builder.build();
    }
    		
}