package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.ConnectionBD;
import dao.PatientDAO;
import dao.RendezVousDAO;
import model.Medecin;
import model.MyRdv;


@WebServlet(urlPatterns={"/NombrePatients","/NombreRDV","/LastRdv"})
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getServletPath();
		
		if(path.equals("/NombrePatients"))
		{
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			Medecin m = (Medecin) session.getAttribute("medecin");
			
			int cin = m.getCIN();
			
			int res = PatientDAO.NbPatient(cin);
			
			obj.put("nb",res);
			out.write(obj.toString());
		}
		else if(path.equals("/NombreRDV"))
		{
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			Medecin m = (Medecin) session.getAttribute("medecin");
			
			int cin = m.getCIN();
			
			int res = RendezVousDAO.nbRdv(cin);
			
			obj.put("nbR",res);
			out.write(obj.toString());
		}
		else if(path.equals("/LastRdv"))
		{
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			Medecin m = (Medecin) session.getAttribute("medecin");
			
			int cin = m.getCIN();
			
			Connection connection = ConnectionBD.getConnection();
			JSONArray array = new JSONArray();
			
			try {
				PreparedStatement ps = connection.prepareStatement("select r.heure,DATE_FORMAT(r.date, '%d/%m/%Y') as 'date', p.nom,p.prenom from rendez_vous r join patient p on p.cin = r.cin_patient where DATE_FORMAT(r.date, '%d/%m/%Y') = DATE_FORMAT(SYSDATE(), '%d/%m/%Y') and cin_medecin = ? and r.etat = 0 ORDER by r.heure LIMIT 5");
				ps.setInt(1,cin);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					
					JSONObject ob2 = new JSONObject();
					ob2.put("heure",rs.getString("heure"));
					ob2.put("date",rs.getString("date"));
					ob2.put("nompp",rs.getString("nom")+" "+rs.getString("prenom"));
					array.put(ob2);
				}
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
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
