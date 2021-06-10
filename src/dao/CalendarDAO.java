package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CalendarDTO;

public class CalendarDAO {
	
	public static ArrayList<CalendarDTO> AllRdv(int cinM) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<CalendarDTO> allr = new ArrayList<CalendarDTO>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT date,heure,p.nom,p.prenom from rendez_vous r join patient p on r.cin_patient = p.cin where r.cin_medecin = ? and r.etat = 0 and DATE_FORMAT(date, '%d/%m/%Y') >= DATE_FORMAT(SYSDATE(), '%d/%m/%Y')");
			ps.setInt(1,cinM);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				CalendarDTO c = new CalendarDTO();
				c.setStart(rs.getString("date"));
				c.setTitle(rs.getString("nom")+" "+rs.getString("prenom"));
				c.setHeure(rs.getString("heure"));
				c.setEnd(rs.getString("date"));
				c.setColor("#fc1245");
				allr.add(c);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allr;
	}

}
