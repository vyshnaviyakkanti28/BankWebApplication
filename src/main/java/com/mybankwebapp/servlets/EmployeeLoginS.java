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
 * Servlet implementation class EmployeeLoginS
 */
public class EmployeeLoginS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name=request.getParameter("empName");
		int id= Integer.parseInt(request.getParameter("empID"));
		String password= request.getParameter("empPassword");
		DbConnections db= new DbConnections();
		Employee emp= db.getEmpForValidation(id);
		
		if(emp!=null && emp.getEmpId() ==id && emp.getEmpName().equals(name) && emp.getEmpPassword().equals(password)) {
			response.sendRedirect("employeeDashBoard.html");
		}
		else if(emp!=null && emp.getEmpId()!=id && !(emp.getEmpName().equals(name)) && !(emp.getEmpPassword().equals(password))) {
				PrintWriter out=response.getWriter();
				out.println("<html>"
						+ "<head><title>Error</title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>Invalid credentials. Please enter valid details</h1>"
						
						+ "</body>"
						+ "</html>");
		}
		
	
	}

}
