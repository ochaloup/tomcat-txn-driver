package io.narayana;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionManager;


/**
 * Servlet implementation class MainServ
 */
@WebServlet("/*")
public class MainServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TransactionManager transactionManager;

    /**
     * Default constructor. 
     * @throws NamingException 
     */
    public MainServ() throws NamingException {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			transactionManager = InitialContext.doLookup("java:comp/env/TransactionManager");
			
			System.out.println("**************************************************");
			System.out.println(transactionManager.toString());
			System.out.println("**************************************************");
			try{
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("JBossTS");
				System.out.println("************************************************");
				
				response.getWriter().print("<br><b><h1>"+emf.toString()+"</h1></b><br>");
				
				EntityManager em = emf.createEntityManager();
				
				response.getWriter().print("<br><b><h1>"+em.toString()+"</h1></b><br>");
				
				
				transactionManager.begin();
				
				Address aa = new Address();
				aa.setId(11);
				aa.setStreet("My Home");
				
				em.persist(aa);
				
				transactionManager.commit();
				
			}catch(Exception e){
				response.getWriter().print("<br><b><h1>Not Found</h1></b><br>");
				e.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
