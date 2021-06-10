package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Region;
import model.Specialite;

public class SpecialiteDAO {
	
	public static ArrayList<Specialite> getAllSpecialite() {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Specialite> allmedic = new ArrayList<Specialite>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from specialite");		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Specialite m = new Specialite();
				m.setId(rs.getInt("id"));
				m.setNom(rs.getString("nom"));
				allmedic.add(m);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allmedic;
	}
	
	
	public static int AjouterSpecialite(Specialite m) {
		Connection connection = ConnectionBD.getConnection();
		int res =0;
		
		try {
			PreparedStatement ps = connection.prepareStatement("insert into specialite (nom) values (?) ");		
			ps.setString(1,m.getNom());
			res=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static int UpdateSpecialite(Specialite m) {
		Connection connection = ConnectionBD.getConnection();
		int res =0;
		
		try {
			PreparedStatement ps = connection.prepareStatement("update Specialite set nom = ? where id = ?");	
			ps.setInt(2,m.getId());
			ps.setString(1,m.getNom());
			res=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
