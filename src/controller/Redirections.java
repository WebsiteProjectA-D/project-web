package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns={"/DashP"})
public class Redirections extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Redirections() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path=request.getServletPath();
		
		if(path.equals("/DashP"))
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp") ;
		    requestDispatcher.forward(request, response) ;
		}
	}

}
