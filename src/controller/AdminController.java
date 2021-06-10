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

import dao.AdminDAO;
import dao.MedecinDAO;
import dao.MedicamentDAO;
import dao.RegionDAO;
import dao.SpecialiteDAO;
import model.Admin;
import model.Medecin;
import model.Medicament;
import model.Region;
import model.Specialite;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(urlPatterns={"/AddMedicament","/getMedicament","/updateMedicament","/AddRegion","/getRegion","/updateRegion","/AddSpec","/getSpec","/updateSpec","/CnxAdmin"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String path=request.getServletPath();
		
		if(path.equals("/AddMedicament"))
		{
			PrintWriter out = response.getWriter();
			
			String nom = request.getParameter("nomMed");
			
			Medicament m = new Medicament(nom);
			
			int res = MedicamentDAO.AjouterMedicament(m);
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
		else if(path.equals("/getMedicament"))
		{
			PrintWriter out = response.getWriter();
			JSONArray array = new JSONArray();
			ArrayList<Medicament> listeMed = MedicamentDAO.getAllMedicament();
			for(int i=0;i<listeMed.size();i++)
			{
				JSONObject obj = new JSONObject();
				obj.put("id",listeMed.get(i).getId());
				obj.put("nom",listeMed.get(i).getNom());
				array.put(obj);
			}
			response.setContentType("application/json;charset=UTF-8"); 
			 response.setCharacterEncoding("UTF-8");
			 out.write(array.toString());
		}
		else if(path.equals("/updateMedicament"))
		{
			PrintWriter out = response.getWriter();
			
			String nom = request.getParameter("nomMed");
			int  id = Integer.parseInt(request.getParameter("idMed"));
			
			Medicament m = new Medicament();
			m.setId(id);
			m.setNom(nom);
			
			int res = MedicamentDAO.UpdateMedicament(m);
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
		else if(path.equals("/AddRegion"))
		{
			PrintWriter out = response.getWriter();
			
			String nom = request.getParameter("nomReg");
			
			Region m = new Region(nom);
			
			int res = RegionDAO.AjouterRegion(m);
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
		
		else if(path.equals("/getRegion"))
		{
			PrintWriter out = response.getWriter();
			JSONArray array = new JSONArray();
			ArrayList<Region> listeMed = RegionDAO.getAllRegion();
			for(int i=0;i<listeMed.size();i++)
			{
				JSONObject obj = new JSONObject();
				obj.put("id",listeMed.get(i).getId());
				obj.put("nom",listeMed.get(i).getNom());
				array.put(obj);
			}
			response.setContentType("application/json;charset=UTF-8"); 
			 response.setCharacterEncoding("UTF-8");
			 out.write(array.toString());
		}
		
		else if(path.equals("/updateRegion"))
		{
			PrintWriter out = response.getWriter();
			
			String nom = request.getParameter("nomReg");
			int  id = Integer.parseInt(request.getParameter("idReg"));
			
			Region m = new Region();
			m.setId(id);
			m.setNom(nom);
			
			int res = RegionDAO.UpdateRegion(m);
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
		else if(path.equals("/AddSpec"))
		{
			PrintWriter out = response.getWriter();
			
			String nom = request.getParameter("nomSpec");
			
			Specialite m = new Specialite(nom);
			
			int res = SpecialiteDAO.AjouterSpecialite(m);
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
		
		else if(path.equals("/getSpec"))
		{
			PrintWriter out = response.getWriter();
			JSONArray array = new JSONArray();
			ArrayList<Specialite> listeMed = SpecialiteDAO.getAllSpecialite();
			for(int i=0;i<listeMed.size();i++)
			{
				JSONObject obj = new JSONObject();
				obj.put("id",listeMed.get(i).getId());
				obj.put("nom",listeMed.get(i).getNom());
				array.put(obj);
			}
			response.setContentType("application/json;charset=UTF-8"); 
			 response.setCharacterEncoding("UTF-8");
			 out.write(array.toString());
		}
		
		else if(path.equals("/updateSpec"))
		{
			PrintWriter out = response.getWriter();
			
			String nom = request.getParameter("nomSpec");
			int  id = Integer.parseInt(request.getParameter("idSpec"));
			
			Specialite m = new Specialite();
			m.setId(id);
			m.setNom(nom);
			
			int res = SpecialiteDAO.UpdateSpecialite(m);
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
		else if(path.equals("/CnxAdmin"))
		{
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			
			Admin a = AdminDAO.chercher(login, pass);
			
			JSONObject obj = new JSONObject();
			if(a==null)
			{
				obj.put("res","err");
				out.write(obj.toString());
			}
			else
			{
				session.setAttribute("Admin",a);
				obj.put("res","succ");
				out.write(obj.toString());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
