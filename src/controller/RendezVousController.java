package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.RendezVousDAO;
import model.MyRdv;
import model.RendezVous;


@WebServlet(urlPatterns={"/VerifRendezVous","/AddRendezVous","/Mrdv"})
public class RendezVousController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RendezVousController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getServletPath();
		
		if(path.equals("/VerifRendezVous"))
		{
			PrintWriter out = response.getWriter();
			int cinMed = Integer.parseInt(request.getParameter("cinm"));
			String date = request.getParameter("date");
			String heure = request.getParameter("heure");
			JSONObject obj = new JSONObject();
			
			
			RendezVous r = RendezVousDAO.chercherRDV(date, heure, cinMed);
			
			if(r==null)
			{
				obj.put("res","succ");
				out.write(obj.toString());
			}
			else
			{
				obj.put("res","err");
				out.write(obj.toString());
			}
		}
		else if(path.equals("/AddRendezVous"))
		{
			PrintWriter out = response.getWriter();
			int cinMed = Integer.parseInt(request.getParameter("cinm"));
			int cinPat = Integer.parseInt(request.getParameter("cinp"));
			String date = request.getParameter("date");
			String heure = request.getParameter("heure");
			
			int res = 0;
			
			RendezVous r = new RendezVous(date, heure,cinMed,cinPat);
			res = RendezVousDAO.AjouterRDV(r);
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
		else if(path.equals("/Mrdv"))
		{
			PrintWriter out = response.getWriter();
			JSONArray array = new JSONArray();
			int cinPat = Integer.parseInt(request.getParameter("cinp"));
			
			ArrayList<MyRdv> allrdv = RendezVousDAO.MesRDV(cinPat);
			for(int i=0;i<allrdv.size();i++)
			{
				JSONObject obj = new JSONObject();
				obj.put("date",allrdv.get(i).getDate());
				obj.put("heure",allrdv.get(i).getHeure());
				obj.put("nompren",allrdv.get(i).getNom()+" "+allrdv.get(i).getPrenom());
				obj.put("tel",allrdv.get(i).getTel_cabinet());
				obj.put("adresse",allrdv.get(i).getAdresse());
				array.put(obj);
			}
			
			response.setContentType("application/json;charset=UTF-8"); 
			 response.setCharacterEncoding("UTF-8");
			 out.write(array.toString());
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
