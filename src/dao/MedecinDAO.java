package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Medecin;

public class MedecinDAO {
	
	public static Medecin Exist(String email,String password) {
		Connection connection = ConnectionBD.getConnection();
		Medecin a = new Medecin();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from medecin where email = ? and password = ? ");
			ps.setString(1,email);
			ps.setString(2,password);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				a.setCIN(rs.getInt("CIN"));
				a.setNom(rs.getString("nom"));
				a.setPrenom(rs.getString("prenom"));
				a.setDateNaissance(rs.getString("datenaissance"));
				a.setEmail(rs.getString("Email"));
				a.setPassword(rs.getString("password"));
				a.setTel(rs.getString("tel"));
				a.setAge(rs.getInt("age"));
				a.setSexe(rs.getString("sexe"));
				a.setAdresse(rs.getString("adresse"));
				a.setTel_cabinet(rs.getString("tel_cabinet"));
				a.setSpecialite_id(rs.getString("specialite_id"));
				a.setRegion_id(rs.getString("region_id"));
				return a;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int Ajouter(Medecin m)
	{
		int res=0;
		Connection connection = ConnectionBD.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into medecin  values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,m.getCIN());
			ps.setString(2,m.getNom());
			ps.setString(3,m.getPrenom());
			ps.setString(4,m.getDateNaissance());
			ps.setString(5,m.getEmail());
			ps.setString(6,m.getPassword());
			ps.setString(7,m.getTel());
			ps.setInt(8,m.getAge());
			ps.setString(9,m.getSexe());
			ps.setString(10,m.getAdresse());
			ps.setString(11,m.getTel_cabinet());
			ps.setString(12,m.getSpecialite_id());
			ps.setString(13,m.getRegion_id());
			res=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;		
	}
	
	public static void modifier(int cin,Medecin m) {
		Connection connection = ConnectionBD.getConnection();
		
		try {
			PreparedStatement ps = connection
					.prepareStatement("update medecin set nom = ? , prenom = ? , datenaissance = ?, email = ?,"
							+ " password = ?,tel = ?, age = ?, sexe = ?, adresse = ?, tel_cabinet = ?, "
							+ "specialite_id = ?, region_id = ? where cin = ?");
			
			ps.setString(1,m.getNom());
			ps.setString(2,m.getPrenom());
			ps.setString(3,m.getDateNaissance());
			ps.setString(4,m.getEmail());
			ps.setString(5,m.getPassword());
			ps.setString(6,m.getTel());
			ps.setInt(7,m.getAge());
			ps.setString(8,m.getSexe());
			ps.setString(9,m.getAdresse());
			ps.setString(10,m.getTel_cabinet());
			ps.setString(1,m.getSpecialite_id());
			ps.setString(12,m.getRegion_id());
			ps.setInt(13,m.getCIN());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static ArrayList<Medecin> listeMedecins()
	{
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Medecin> lmed = new ArrayList<Medecin>();
		try {
			PreparedStatement ps = connection.prepareStatement("select m.cin,m.nom,m.prenom,m.datenaissance,m.email,m.password,m.tel,m.age,m.sexe,m.adresse,m.tel_cabinet,s.nom as 'spacialite',r.nom as 'region' from medecin m join specialite s on s.id = m.specialite_id join region r on r.id = m.region_id ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Medecin a = new Medecin();
				a.setCIN(rs.getInt("CIN"));
				a.setNom(rs.getString("nom"));
				a.setPrenom(rs.getString("prenom"));
				a.setDateNaissance(rs.getString("datenaissance"));
				a.setEmail(rs.getString("Email"));
				a.setPassword(rs.getString("password"));
				a.setTel(rs.getString("tel"));
				a.setAge(rs.getInt("age"));
				a.setSexe(rs.getString("sexe"));
				a.setAdresse(rs.getString("adresse"));
				a.setTel_cabinet(rs.getString("tel_cabinet"));
				a.setSpecialite_id(rs.getString("spacialite"));
				a.setRegion_id(rs.getString("region"));
				lmed.add(a);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lmed;
	}
	
	public static void supprimer(int cin)
	{
		Connection connection = ConnectionBD.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("delete from medecin where cin = ?");
			ps.setInt(1,cin);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Medecin MedecinByCin(int cin)
	{
		Connection connection = ConnectionBD.getConnection();
		Medecin a = new Medecin();
		try {
			PreparedStatement ps = connection.prepareStatement("select m.cin,m.nom,m.prenom,m.datenaissance,m.email,m.password,m.tel,m.age,m.sexe,m.adresse,m.tel_cabinet,s.nom as 'spacialite',r.nom as 'region' from medecin m join specialite s on s.id = m.specialite_id join region r on r.id = m.region_id where cin = ?");
			ps.setInt(1,cin);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a.setCIN(rs.getInt("CIN"));
				a.setNom(rs.getString("nom"));
				a.setPrenom(rs.getString("prenom"));
				a.setDateNaissance(rs.getString("datenaissance"));
				a.setEmail(rs.getString("Email"));
				a.setPassword(rs.getString("password"));
				a.setTel(rs.getString("tel"));
				a.setAge(rs.getInt("age"));
				a.setSexe(rs.getString("sexe"));
				a.setAdresse(rs.getString("adresse"));
				a.setTel_cabinet(rs.getString("tel_cabinet"));
				a.setSpecialite_id(rs.getString("spacialite"));
				a.setRegion_id(rs.getString("region"));
				return a;
			}
			ps.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	

}
