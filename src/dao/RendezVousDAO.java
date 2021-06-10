package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.MyRdv;
import model.RendezVous;

public class RendezVousDAO {
	
	
	public static RendezVous chercherRDV(String date,String heure,int cinMed) {
		Connection connection = ConnectionBD.getConnection();
		RendezVous r = new RendezVous();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from rendez_vous where date = ? and heure = ? and cin_medecin = ? and etat = 0");
			ps.setString(1,date);
			ps.setString(2,heure);
			ps.setInt(3, cinMed);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r.setDate(rs.getString("date"));
				r.setHeure(rs.getString("heure"));
				r.setCin_medecin(rs.getInt("cin_medecin"));
				r.setCin_patient(rs.getInt("cin_patient"));
				return r;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int AjouterRDV(RendezVous r)
	{
		
		Connection connection = ConnectionBD.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into rendez_vous values (?,?,?,?,?) ");
			ps.setString(1,r.getDate());
			ps.setString(2,r.getHeure());
			ps.setInt(3,r.getCin_medecin());
			ps.setInt(4,r.getCin_patient());
			ps.setInt(5,0);
			ps.executeUpdate();
			ps.close();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;		
	}
	
	public static ArrayList<MyRdv> MesRDV(int cinPat) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<MyRdv> rdvs = new ArrayList<MyRdv>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select r.date,r.heure,m.nom,m.prenom,m.tel_cabinet,m.adresse from rendez_vous r join medecin m on r.cin_medecin = m.cin where r.cin_patient = ? and r.etat = 0");
			ps.setInt(1,cinPat);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MyRdv r = new MyRdv();
				r.setDate(rs.getString("date"));
				r.setHeure(rs.getString("heure"));
				r.setNom(rs.getString("nom"));
				r.setPrenom(rs.getString("prenom"));
				r.setTel_cabinet(rs.getString("tel_cabinet"));
				r.setAdresse(rs.getString("adresse"));
				rdvs.add(r);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rdvs;
	}
	
	public static int UpdateRDV(String date,String heure,int cinm)
	{
		
		Connection connection = ConnectionBD.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("update rendez_vous set etat = 1 where date = ? and heure = ? and cin_medecin = ? ");
			ps.setString(1,date);
			ps.setString(2,heure);
			ps.setInt(3,cinm);
			ps.executeUpdate();
			ps.close();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;		
	}
	
	public static int nbRdv(int cinm) {
		Connection connection = ConnectionBD.getConnection();
		int res = 0;
		
		try {
			PreparedStatement ps = connection.prepareStatement("select count(*) as 'nbRDV' from rendez_vous r where DATE_FORMAT(r.date, '%d/%m/%Y') = DATE_FORMAT(SYSDATE(), '%d/%m/%Y') and cin_medecin = ? and etat = 0");
			ps.setInt(1,cinm);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			 res = rs.getInt("nbRDV");
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
