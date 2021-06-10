package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Patient;
import model.Visite;

public class VisiteDAO {
	
	public static int Ajouter(Visite v)
	{
		int res=0;
		Connection connection = ConnectionBD.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into visite (date,observation,heure,cin_medecin) values (?,?,?,?) ");
			ps.setString(1,v.getDate());
			ps.setString(2,v.getObservation());
			ps.setString(3,v.getHeure());
			ps.setInt(4,v.getCin_medecin());
			res=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;		
	}
	
	public static ArrayList<Visite> getAllVisiteByPatient(int cinp) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Visite> allv = new ArrayList<Visite>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select v.* from visite v join rendez_vous r on r.date = v.date and r.heure = v.heure and r.cin_medecin = v.cin_medecin where r.cin_patient = ?");
			ps.setInt(1,cinp);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Visite v = new Visite();
				v.setId(rs.getInt("id"));
				v.setDate(rs.getString("date"));
				v.setObservation(rs.getString("observation"));
				v.setCin_medecin(rs.getInt("cin_medecin"));
				allv.add(v);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allv;
	}
	
	public static int checkOrd(int idv) {
		Connection connection = ConnectionBD.getConnection();
		int res = 0;
		
		try {
			PreparedStatement ps = connection.prepareStatement("select count(*) as 'total' from ordonnance where visite_id = ?");
			ps.setInt(1,idv);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res = rs.getInt("total");
				return res;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static Visite getVisite(int idv) {
		Connection connection = ConnectionBD.getConnection();
		Visite v = new Visite();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from visite where id = ?");
			ps.setInt(1,idv);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				v.setId(rs.getInt("id"));
				v.setDate(rs.getString("date"));
				v.setObservation(rs.getString("observation"));
				v.setHeure(rs.getString("heure"));
				v.setCin_medecin(rs.getInt("cin_medecin"));
				return v;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
