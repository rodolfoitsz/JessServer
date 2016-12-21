package com.jess.server;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;

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
	

	
	 static boolean getResponse(char c) {
		 return c == 's'; 
		 }
	
  
  @Path("analysis")
  @POST
  @Consumes("application/json ")
  @Produces( MediaType.TEXT_PLAIN )
  public String sayPlainTextHello(String checkBoxes) throws Exception {
	  
   
	  Rete r = new Rete();
      r.eval("(reset)");
               
      r.eval("(defrule meningitis (sin vomito) (sin nausea) (sin insomnia) => (printout t \"tiene meningitis\n\"))");
      r.eval("(defrule tubercolosis (sin fiebre) (sin dolordecabeza) (sin insomnia) => (printout t \"tiene tubercolosis\n\"))");
      r.eval("(defrule sarna (sin prurito) (sin manchasenlapiel) (sin fiebre) => (printout t \"tiene sarna\n\"))");
      r.eval("(defrule salmonela (sin vomito) (sin nausea) (sin diarrea) => (printout t \"tiene salmonela\n\"))");     
       
      StringWriter sw = new StringWriter();
      // Connect the "t" router to the StringWriter
      r.addOutputRouter("t", sw);
       
      char[] res = checkBoxes.toCharArray();
      if (getResponse(res[0])) r.eval("(assert (sin vomito))");
      if (getResponse(res[1])) r.eval("(assert (sin nausea))");
      if (getResponse(res[2])) r.eval("(assert (sin insomnia))");
      if (getResponse(res[3])) r.eval("(assert (sin fiebre))");
      if (getResponse(res[4])) r.eval("(assert (sin dolordecabeza))");
      if (getResponse(res[5])) r.eval("(assert (sin prurito))");
      if (getResponse(res[6])) r.eval("(assert (sin manchasenlapiel))");
      if (getResponse(res[7])) r.eval("(assert (sin diarrea))");
               
      r.eval("(run)");
       
      return (sw.toString().length() > 0 ? sw.toString() : "Usted esta perfectamente!\n"); 
 
  }

 
}