package com.j32bit.service;
 
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import com.j32bit.bean.Person;

 
@Path("/")
public class RESTfulService{
   
	final Logger logger = Logger.getLogger(RESTfulService.class);
    
    @GET
	@Path("/getPeople")
	@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Person> getAllCustomer() throws Exception {
    	logger.debug("getAllCustomer called");
	    return ServiceFacade.getInstance().getPersonDAO().getAllCustomer();
	}
    
    
    @POST
    @Path("/getPerson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
       public Person getPerson(String tcno) throws Exception {
    	logger.debug("getPerson called");
       	return ServiceFacade.getInstance().getPersonDAO().getPerson(tcno);
   	}
    
    @POST
    @Path("/addPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    public void storePerson(Person person) throws Exception {
    	ServiceFacade.getInstance().getPersonDAO().savePerson(person,"register");
    	logger.debug("New person is saved to database "+person.getTcno());
    }
    
    
    @PUT
    @Path("/updatePerson")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(Person person) throws Exception {
    	ServiceFacade.getInstance().getPersonDAO().savePerson(person,"update");
    	logger.debug("Person is updated "+person.getTcno()+" "+person.getPhone());
    }
    
    
    @POST
    @Path("/deletePerson")
    @Consumes(MediaType.APPLICATION_JSON)
	public void deletePerson(String tcno) throws Exception{
		ServiceFacade.getInstance().getPersonDAO().deletePerson(tcno);
    	logger.debug("Person is deleted "+tcno);
	}
   
}