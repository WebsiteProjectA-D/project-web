package controller;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;









/**
 * Servlet implementation class GenerOrd
 */
@WebServlet("/GenerOrd")
public class GenerOrd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerOrd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
try {
			
	Connection conn = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetweb", "root", "");
    } catch (Exception ex) {
        ex.printStackTrace();
    }
			int idv = Integer.parseInt(request.getParameter("idv"));
			JasperReport jasperReport = null;
			JasperDesign jasperDesign = null;
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("id_visite",idv);
			String pp = getServletContext().getRealPath("/");
			parameters.put("realPAth",pp);
			String path = getServletContext().getRealPath("ttt.jrxml");
			jasperDesign = JRXmlLoader.load(path);
			jasperReport = JasperCompileManager.compileReport(jasperDesign);
			byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, parameters,conn);
			OutputStream outStream = response.getOutputStream();
			response.setContentType("application/pdf;charset=UTF-8");
			response.setContentLength(byteStream.length);
			response.setCharacterEncoding("UTF-8");
			outStream.write(byteStream, 0, byteStream.length);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
