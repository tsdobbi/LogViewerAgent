package com.service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/LogService")
public class LogService {
	LogRetriever logRetriever = new LogRetriever();
	
	@GET
	@Path("/loglist/{dir}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> getLogList(@PathParam("dir") String dir) {
		return logRetriever.getAllLogs(dir);
	}
	
	@GET
	@Path("/log/{name}/{dir}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getLog(@PathParam("name") String name, @PathParam("dir") String dir) {
		
		return logRetriever.getLogFile(name, dir);
	}
	
	@GET
	@Path("/healthcheck")
	@Produces(MediaType.APPLICATION_JSON)
	public String healthCheck() {
		
		return "OK";
	}

}
