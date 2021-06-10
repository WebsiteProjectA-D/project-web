package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dao.MedecinDAO;
import dao.PatientDAO;
import model.Medecin;
import model.Patient;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String type = request.getParameter("type");
		System.out.print(type);
		if(type.equals("p"))
		{
			Patient p = PatientDAO.chercher(login, pass);
			JSONObject obj = new JSONObject();
			if(p==null)
			{
				obj.put("res","err");
				out.write(obj.toString());
			}
			else
			{
				session.setAttribute("patient",p);
				obj.put("res","succ");
				out.write(obj.toString());
			}
		}
		if(type.equals("m"))
		{
			Medecin m = MedecinDAO.Exist(login, pass);
			JSONObject obj = new JSONObject();
			if(m==null)
			{
				obj.put("res","err");
				out.write(obj.toString());
			}
			else
			{
				session.setAttribute("medecin",m);
				obj.put("res","succ");
				out.write(obj.toString());
			}
		}
		 
	}

}
