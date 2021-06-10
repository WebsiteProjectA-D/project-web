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

import dao.RendezVousDAO;
import dao.VisiteDAO;
import model.Medecin;
import model.Visite;


@WebServlet(urlPatterns={"/addVisite","/visiteByPatient","/VerifOrd"})
public class VisiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VisiteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getServletPath();
		
		if(path.equals("/addVisite"))
		{
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			String date = request.getParameter("datee");
			String heure = request.getParameter("heure");
			String observation = request.getParameter("observation");
			Medecin med = (Medecin)  session.getAttribute("medecin");
			int cinm = med.getCIN();
			int res = 0;
			Visite v = new Visite(date, observation, heure, cinm);
			res = VisiteDAO.Ajouter(v);
			RendezVousDAO.UpdateRDV(date, heure, cinm);
			JSONObject obj = new JSONObject();
			if(res==0)
			{
				obj.put("res","err");
				out.write(obj.toString());
			}
			else
			{
				obj.put("res","succ");
				out.write(obj.toString());
			}
		}
		else if(path.equals("/visiteByPatient"))
		{
			PrintWriter out = response.getWriter();
			int cinp = Integer.parseInt(request.getParameter("cinp"));
			ArrayList<Visite> allv = VisiteDAO.getAllVisiteByPatient(cinp);
			JSONArray array = new JSONArray();
			for(int i=0;i<allv.size();i++)
			{
				JSONObject obj = new JSONObject();
				obj.put("id",allv.get(i).getId());
				obj.put("date",allv.get(i).getDate());
				obj.put("heure",allv.get(i).getHeure());
				obj.put("observation",allv.get(i).getObservation());
				array.put(obj);
			}
			response.setContentType("application/json;charset=UTF-8"); 
			 response.setCharacterEncoding("UTF-8");
			 out.write(array.toString());
		}
		else if(path.equals("/VerifOrd"))
		{
			PrintWriter out = response.getWriter();
			int idv = Integer.parseInt(request.getParameter("idv"));
			int res = VisiteDAO.checkOrd(idv);
			
			JSONObject obj = new JSONObject();
			obj.put("res",res);
			out.write(obj.toString());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
