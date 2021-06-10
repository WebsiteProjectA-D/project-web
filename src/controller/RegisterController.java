package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.Medecin;
import model.Patient;
import dao.MedecinDAO;
import dao.PatientDAO;


@WebServlet(urlPatterns={"/addMed","/addPatient"})
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		
		if(path.equals("/addMed"))
		{
			PrintWriter out = response.getWriter();
			int cin = Integer.parseInt(request.getParameter("cin"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String daten = request.getParameter("daten");
			String tel = request.getParameter("tel");
			String adr = request.getParameter("adr");
			String sexe = request.getParameter("sexe");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String telc = request.getParameter("telc");
			String specialite = request.getParameter("specialite");
			String region = request.getParameter("region");
			
			Medecin med = new Medecin(cin, nom, prenom, daten, email, pass, tel,20, sexe, adr, telc, specialite, region);
			
			int res = 0;
			
			res = MedecinDAO.Ajouter(med);
			
			JSONObject obj = new JSONObject();
			if(res==1)
			{
				obj.put("res","succ");
				out.write(obj.toString());
			}else
			{
				obj.put("res","err");
				out.write(obj.toString());
			}
		}
		else if(path.equals("/addPatient"))
			{
				PrintWriter out = response.getWriter();
				int cin = Integer.parseInt(request.getParameter("cin"));
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String daten = request.getParameter("daten");
				String tel = request.getParameter("tel");
				String adr = request.getParameter("adr");
				String sexe = request.getParameter("sexe");
				String email = request.getParameter("email");
				String pass = request.getParameter("pass");
				
				
				Patient p = new Patient(cin, nom, prenom, daten, email, pass, tel, 20, sexe, adr);
				
				int res = 0;
				
				res = PatientDAO.Ajouter(p);
				
				JSONObject obj = new JSONObject();
				if(res==1)
				{
					obj.put("res","succ");
					out.write(obj.toString());
				}else
				{
					obj.put("res","err");
					out.write(obj.toString());
				}
			}
		
	}

}
