package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Patient;

public class PatientDAO {
	
	public static int Ajouter(Patient m)
	{
		int res=0;
		Connection connection = ConnectionBD.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into patient  values (?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,m.getCin());
			ps.setString(2,m.getNom());
			ps.setString(3,m.getPrenom());
			ps.setString(4,m.getDateNaissance());
			ps.setString(5,m.getEmail());
			ps.setString(6,m.getPassword());
			ps.setString(7,m.getTel());
			ps.setInt(8,m.getAge());
			ps.setString(9,m.getSexe());
			ps.setString(10,m.getAdresse());
			res=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;		
	}
	
	public static Patient chercher(String email,String password) {
		Connection connection = ConnectionBD.getConnection();
		Patient a = new Patient();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from patient where email = ? and password = ?");
			ps.setString(1,email);
			ps.setString(2,password);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				a.setCin(rs.getInt("cin"));
				a.setNom(rs.getString("nom"));
				a.setPrenom(rs.getString("prenom"));
				a.setDateNaissance(rs.getString("datenaissance"));
				a.setEmail(rs.getString("email"));
				a.setPassword(rs.getString("password"));
				a.setTel(rs.getString("tel"));
				a.setAge(rs.getInt("age"));
				a.setSexe(rs.getString("sexe"));
				a.setAdresse(rs.getString("adresse"));
				return a;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Patient> patientByMed(int cinm) {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Patient> allp = new ArrayList<Patient>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select DISTINCT p.* from patient p join rendez_vous r on r.cin_patient = p.cin join visite v on v.date = r.date and v.heure = r.heure and r.cin_medecin = v.cin_medecin where v.cin_medecin = ?");
			ps.setInt(1,cinm);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Patient a = new Patient();
				a.setCin(rs.getInt("cin"));
				a.setNom(rs.getString("nom"));
				a.setPrenom(rs.getString("prenom"));
				a.setDateNaissance(rs.getString("datenaissance"));
				a.setEmail(rs.getString("email"));
				a.setPassword(rs.getString("password"));
				a.setTel(rs.getString("tel"));
				a.setAge(rs.getInt("age"));
				a.setSexe(rs.getString("sexe"));
				a.setAdresse(rs.getString("adresse"));
				allp.add(a);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allp;
	}
	
	public static int NbPatient(int cinm) {
		Connection connection = ConnectionBD.getConnection();
		int nb =0;
		
		try {
			PreparedStatement ps = connection.prepareStatement("select count(DISTINCT p.cin) as 'totalp' from patient p join rendez_vous r on r.cin_patient = p.cin join visite v on v.date = r.date and v.heure = r.heure and r.cin_medecin = v.cin_medecin where v.cin_medecin = ?");
			ps.setInt(1,cinm);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nb = rs.getInt("totalp");
				return nb;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nb;
	}

}
