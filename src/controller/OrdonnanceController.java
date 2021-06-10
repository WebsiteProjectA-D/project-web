package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.OrdonnanceDAO;
import dao.VisiteDAO;
import model.Ordonnance;
import model.Ordonnance_detail;
import model.Visite;


@WebServlet(urlPatterns={"/CreateOrd"})
public class OrdonnanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrdonnanceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getServletPath();
		
		if(path.equals("/CreateOrd"))
		{
			PrintWriter out = response.getWriter();
			int idVisite = Integer.parseInt(request.getParameter("idVisite"));
			
			String tabMed[] = request.getParameterValues("tabMed[]");
			String tabQt[] = request.getParameterValues("tabQt[]");
			String tabDr[] = request.getParameterValues("tabDr[]");
			
			Visite v = VisiteDAO.getVisite(idVisite);
			
			Ordonnance o = new Ordonnance(v.getDate(), idVisite);
			
			int res = OrdonnanceDAO.Ajouter(o);
			
			if(res==1)
			{
				int idOrd = OrdonnanceDAO.getOrd(idVisite);
				int res2=0;
				for(int i=0;i<tabDr.length;i++)
				{
					int duration = Integer.parseInt(tabDr[i]);
					int qte = Integer.parseInt(tabQt[i]);
					int idMed = Integer.parseInt(tabMed[i]);
					
					Ordonnance_detail d = new Ordonnance_detail(duration, qte, idOrd, idMed);
					res2=OrdonnanceDAO.AjouterLigneOrd(d);
					
				}
				
				JSONObject obj = new JSONObject();
				if(res2==0)
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
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
