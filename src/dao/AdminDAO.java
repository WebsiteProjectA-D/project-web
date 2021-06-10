package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;

public class AdminDAO {
	
	public static Admin chercher(String email,String password) {
		Connection connection = ConnectionBD.getConnection();
		Admin a = new Admin();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from admin where email = ? and password = ?");
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

}
