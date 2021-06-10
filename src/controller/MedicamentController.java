package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.MedicamentDAO;
import model.Medicament;

import java.util.*;

/**
 * Servlet implementation class MedicamentController
 */
@WebServlet(urlPatterns={"/getAllmedc"})
public class MedicamentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicamentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String path=request.getServletPath();
		
		if(path.equals("/getAllmedc"))
		{
			PrintWriter out = response.getWriter();
			ArrayList<Medicament> allm = MedicamentDAO.getAllMedicament();
			
			JSONArray array = new JSONArray();
			for(int i=0;i<allm.size();i++)
			{
				JSONObject obj = new JSONObject();
				obj.put("id",allm.get(i).getId());
				obj.put("nom",allm.get(i).getNom());
				
				array.put(obj);
			}
			response.setContentType("application/json;charset=UTF-8"); 
			 response.setCharacterEncoding("UTF-8");
			 out.write(array.toString());
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
