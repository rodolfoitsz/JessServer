package com.jess.server;



import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import jess.Rete;


// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/server")
public class Analysis {
	

	
	 static boolean getResponse(String s) { return s.equals("si") || s.equals("s"); }
	
  
  @Path("analysis")
  @POST
  @Consumes("application/json ")
  public Response sayPlainTextHello(String string) throws Exception {
	  
   
	 
		  Rete r = new Rete();
	        r.eval("(reset)");     
	        r.eval("(defrule meningitis (sin vomito) (sin nausea) (sin insomnia) => (printout t \"\ntiene meningitis\"))");
	        r.eval("(defrule tubercolosis (sin fiebre) (sin dolordecabeza) (sin insomnia) => (printout t \"\ntiene tubercolosis\"))");
	        r.eval("(defrule sarna (sin prurito) (sin manchasenlapiel) (sin fiebre) => (printout t \"\ntiene sarna\"))");
	        r.eval("(defrule salmonela (sin vomito) (sin nausea) (sin diarrea) => (printout t \"\ntiene salmonela\"))");     
	         
	     
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	         
	        System.out.println("\nDomanda 1:\nSe tiene vomito? (s/n)");     
	            
	        if (getResponse(Character.toString(string.charAt(0)))) r.eval("(assert (sin vomito))");
	         
	        System.out.println("\nDomanda 2:\nSe tiene nausea? (s/n)");     
	      
	        if (getResponse(Character.toString(string.charAt(1)))) r.eval("(assert (sin nausea))");
	         
	        System.out.println("\nDomanda 3:\nSe tiene insomnia? (s/n)");       
	              
	        if (getResponse(Character.toString(string.charAt(2)))) r.eval("(assert (sin insomnia))");
	         
	        System.out.println("\nDomanda 4:\nSe tiene fiebre? (s/n)");     
	              
	        if (getResponse(Character.toString(string.charAt(3)))) r.eval("(assert (sin fiebre))");
	         
	        System.out.println("\nDomanda 5:\nSe tiene dolor de cabeza? (s/n)");        
	            
	        if (getResponse(Character.toString(string.charAt(4)))) r.eval("(assert (sin dolordecabeza))");
	         
	        System.out.println("\nDomanda 6:\nSe tiene prurito? (s/n)");        
	           
	        if (getResponse(Character.toString(string.charAt(5)))) r.eval("(assert (sin prurito))");
	             
	        System.out.println("\nDomanda 7:\nSe tiene manchas en la piel? (s/n)");     
	          
	        if (getResponse(Character.toString(string.charAt(6)))) r.eval("(assert (sin manchasenlapiel))");
	             
	        System.out.println("\nDomanda 8:\nSe tiene diarrea? (s/n)");        
	            
	        if (getResponse(Character.toString(string.charAt(7)))) r.eval("(assert (sin diarrea))");
	         
	        System.out.println("\n ----- \n Las sintomas son:\n");      
	        r.eval("(facts)");  
	                     
	        System.out.println("\n ----- \n Analisis del experto:\n");      
	    
	        
	        String a=  r.eval("(run)").toString();
	         
  
	  
	  return Response.status(200).build();
  }

 
}