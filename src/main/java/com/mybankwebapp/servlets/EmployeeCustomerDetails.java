package com.mybankwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybankwebapp.dboperations.DbConnections;
import com.mybankwebapp.model.Customer;

/**
 * Servlet implementation class EmployeeCustomerDetails
 */
public class EmployeeCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeCustomerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		DbConnections db=new DbConnections();
		List<Customer> li=db.getCustomer();
		 out.println("<table id=\"customers\">");  
         out.println("<tr><th>CustomerId</th><th>CustomerName</th><th>customerContact</th><th>customerPanCard</th><th>Balance</th><tr>");  
         
		for(int i=0;i<li.size();i++) {
			int cust_id=li.get(i).getId();
			String cust_name=li.get(i).getName();
			String cust_contact=li.get(i).getPhnNo();
			String cust_Pan=li.get(i).getPanCard();
			int cust_balance=li.get(i).getInitialBalance();
			
			out.println("<tr><td>" + cust_id + "</td><td>" + cust_name + "</td><td>" + cust_contact + "</td><td>" + cust_Pan + "</td><td>"+ cust_balance+ "</td></tr>"); 
			
		}
		 RequestDispatcher rd=request.getRequestDispatcher("/employeeDashBoard.html");  
         rd.include(request, response); 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

}
	
}