package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Medicament;
import model.Region;

public class RegionDAO {
	
	
	public static ArrayList<Region> getAllRegion() {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Region> allmedic = new ArrayList<Region>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from region");		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Region m = new Region();
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
	
	
	public static int AjouterRegion(Region m) {
		Connection connection = ConnectionBD.getConnection();
		int res =0;
		
		try {
			PreparedStatement ps = connection.prepareStatement("insert into region (nom) values (?) ");		
			ps.setString(1,m.getNom());
			res=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static int UpdateRegion(Region m) {
		Connection connection = ConnectionBD.getConnection();
		int res =0;
		
		try {
			PreparedStatement ps = connection.prepareStatement("update region set nom = ? where id = ?");	
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
