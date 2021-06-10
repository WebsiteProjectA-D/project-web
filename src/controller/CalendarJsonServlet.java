package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.CalendarDAO;
import model.CalendarDTO;
import model.Medecin;

/**
 * Servlet implementation class CalendarJsonServlet
 */
@WebServlet("/CalendarJsonServlet")
public class CalendarJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Medecin m  = (Medecin) session.getAttribute("medecin");
		
		List l = new ArrayList();
		
		 ArrayList<CalendarDTO> allr = CalendarDAO.AllRdv(m.getCIN());
		 for(int i=0;i<allr.size();i++)
		 {
			 l.add(allr.get(i));
		 }
		 
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out = response.getWriter();
		 out.write(new Gson().toJson(l));
		
		 }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
