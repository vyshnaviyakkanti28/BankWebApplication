package com.mybankwebapp.revature;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybankwebapp.dboperations.DbConnections;
import com.mybankwebapp.model.Customer;
import com.mybankwebapp.model.CustomerValidation;


@Path("/customer")
public class CustomerRest  {
	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/newcustomer")	
	@POST
	public String customerAdd(@FormParam("name") String name, @FormParam("email") String email, @FormParam("phn-no") String phnNo, @FormParam("pancard") String pancard, @FormParam("address") String address, @FormParam("initialBalance") int iniBalance,@FormParam("dob") String dob, @FormParam("age") int age, @FormParam("Gender") String gender, @FormParam("password") String password ) {
		System.out.println("heloooo");
		Customer cust=new Customer();	
		cust.setName(name);
		cust.setEmail(email);
		cust.setPhnNo(phnNo);
		cust.setPanCard(pancard);
		cust.setAddress(address);
		cust.setInitialBalance(iniBalance);
		cust.setDob(dob);
		cust.setAge(age);
		cust.setPassword(password);
		cust.setGender(gender);
		DbConnections db=new DbConnections();
		db.addToCustTable(cust);
		
		return "DETAILS ADDED SUCCESSFULLY";
	}
}
