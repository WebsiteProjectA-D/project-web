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

import org.json.JSONArray;
import org.json.JSONObject;

import dao.MedecinDAO;
import dao.PatientDAO;
import model.Medecin;
import model.Patient;


@WebServlet(urlPatterns={"/listeMedecin","/listePatient"})
public class MedecinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MedecinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		
		if(path.equals("/listeMedecin"))
		{
			
			PrintWriter out = response.getWriter();
			JSONArray array = new JSONArray();
			ArrayList<Medecin> listeMed = MedecinDAO.listeMedecins();
			for(int i=0;i<listeMed.size();i++)
			{
				JSONObject obj = new JSONObject();
				obj.put("cinmed",listeMed.get(i).getCIN());
				obj.put("nomPren", listeMed.get(i).getNom()+" "+listeMed.get(i).getPrenom());
				obj.put("adr",listeMed.get(i).getAdresse());
				obj.put("telc",listeMed.get(i).getTel_cabinet());
				obj.put("spec",listeMed.get(i).getSpecialite_id());
				obj.put("region",listeMed.get(i).getRegion_id());
				array.put(obj);
			}
			response.setContentType("application/json;charset=UTF-8"); 
			 response.setCharacterEncoding("UTF-8");
			 out.write(array.toString());
			
		}
		else if(path.equals("/listePatient"))
		{
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			Medecin med = (Medecin)  session.getAttribute("medecin");
			int cinm = med.getCIN();
			
			JSONArray array = new JSONArray();
			ArrayList<Patient> listePat = PatientDAO.patientByMed(cinm);
			for(int i=0;i<listePat.size();i++)
			{
				JSONObject obj = new JSONObject();
				obj.put("cinp",listePat.get(i).getCin());
				obj.put("nomPren", listePat.get(i).getNom()+" "+listePat.get(i).getPrenom());
				obj.put("adr",listePat.get(i).getAdresse());
				obj.put("tel",listePat.get(i).getTel());
				obj.put("daten",listePat.get(i).getDateNaissance());
				obj.put("sexe",listePat.get(i).getSexe());
				array.put(obj);
			}
			response.setContentType("application/json;charset=UTF-8"); 
			 response.setCharacterEncoding("UTF-8");
			 out.write(array.toString());
			
		}
	}

}
