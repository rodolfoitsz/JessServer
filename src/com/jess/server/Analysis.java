package com.jess.server;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/server")
public class Analysis {
	

  // This method is called if TEXT_PLAIN is request
  @Path("analysis")
  @POST
  @Consumes("application/json ")
  public Response sayPlainTextHello() {
	  
	  System.out.println("server");
	  
	  return Response.status(200).build();
  }

 
}