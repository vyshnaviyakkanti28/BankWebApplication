package com.mybankwebapp.dboperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mybankwebapp.model.Customer;
import com.mybankwebapp.model.CustomerValidation;
import com.mybankwebapp.model.Employee;
import com.mybankwebapp.Utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class DbConnections 
{
	
   
//    public static void addToEmpTable()
//    {
//    		Session session=null;
//    		Transaction transaction=null;
//    		
//    		try {
//    			session = HibernateUtil.getSessionFactory().openSession();
//    			transaction= session.beginTransaction();
//    			Employee s=new Employee("Hemalatha","cjjhemalatha@gmail.com","5678987657","ghjjk");
//    			session.save(s);
//    			transaction.commit();
//    		}
//    		catch(Exception e) {
//    			if(transaction!=null) {
//    				transaction.rollback();
//    			}
//    			e.printStackTrace();
//    		}finally {
//    			if(session!=null) {
//    				session.close();
//    			}
//    		}
//    	}
//    
    
    public void addToCustTable(Customer customer) {
    	Session session=null;
    	Transaction transaction=null;
    	
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		session.save(customer);
    		transaction.commit();
    		
    	}
    	catch(Exception e) {
    		if(transaction!=null) {
    			transaction.rollback();
    		}
    		e.printStackTrace();
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
    	}
    	
    }


	public Employee getEmpForValidation(int empId) {
		Session session=null;
    	Transaction transaction=null;
    	Employee empFromDB=null;
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		empFromDB=(Employee)session.get(Employee.class, empId);
    		
    		transaction.commit();
    		
    		System.out.println(empFromDB.getEmpName());
    		
    		return empFromDB;
    	}
    	catch(Exception e) {
    		if(transaction!=null) {
    			transaction.rollback();
    		}
    		throw e;
    		
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
    	}
		
    	
		
	}


	public Customer custDataToValidate(int id) {
		// TODO Auto-generated method stub
		Session session=null;
    	Transaction transaction=null;
    	Customer custm=null;
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		custm=(Customer)session.get(Customer.class, id);
    		
    		transaction.commit();
    		System.out.println(custm.getName());
    		
    		return custm;
    	}
    	catch(Exception e) {
    		if(transaction!=null) {
    			transaction.rollback();
    		}
    		throw e;
    	
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
    	}
		
    	
		
	}
	
	
	public Customer updateInDB(Customer custm) {
		// TODO Auto-generated method stub
		Session session=null;
    	Transaction transaction=null;
    	
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		session.saveOrUpdate(custm);
    		
    		transaction.commit();
    		System.out.println(custm.getName());
    		
    		return custm;
    	}
    	catch(Exception e) {
    		if(transaction!=null) {
    			transaction.rollback();
    		}
    		throw e;
    	
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
    	}
	}
	
	public List < Customer > getCustomer() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Customer", Customer.class).list();
        }
    }
	
    } 


