package com.mybankwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybankwebapp.dboperations.DbConnections;
import com.mybankwebapp.model.Customer;
import com.mybankwebapp.model.Employee;

/**
 * Servlet implementation class TransactionsDeposit
 */
public class TransactionsDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionsDeposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("custName");
		
		int id= Integer.parseInt(request.getParameter("custId"));
		String password= request.getParameter("password");
		int money=Integer.parseInt(request.getParameter("money"));
		DbConnections db= new DbConnections();
		Customer cust= db.custDataToValidate(id);
		
		
		if(cust!=null && cust.getId()==id && cust.getName().equals(name) && cust.getPassword().equals(password)) {
			PrintWriter out= response.getWriter();
			int newBalance=cust.getInitialBalance()+money;
			cust.setInitialBalance(newBalance);
			db.updateInDB(cust);
			out.println("<html>"
					+ "<head><title>Deposit Amount</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Your current balance is:"+cust.getInitialBalance()+"</h1>"
					+ "</body>"
					+ "</html>");     
	        
		}
		else if(cust!=null && cust.getId()!=id && !(cust.getName().equals(name)) && !(cust.getPassword().equals(password))) {
			PrintWriter out=response.getWriter();
				//String htmlRespone = "<html>";
			out.println("<html>"
					+ "<head><title>Error</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Sorry There is a error</h1>"
					+ "</body>"
					+ "</html>");       
		       
				
		}
		
	}

}
