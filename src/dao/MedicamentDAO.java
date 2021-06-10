package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Medicament;

public class MedicamentDAO {
	
	public static ArrayList<Medicament> getAllMedicament() {
		Connection connection = ConnectionBD.getConnection();
		ArrayList<Medicament> allmedic = new ArrayList<Medicament>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from medicament");		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Medicament m = new Medicament();
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
	
	public static int AjouterMedicament(Medicament m) {
		Connection connection = ConnectionBD.getConnection();
		int res =0;
		
		try {
			PreparedStatement ps = connection.prepareStatement("insert into medicament (nom) values (?) ");		
			ps.setString(1,m.getNom());
			res=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static int UpdateMedicament(Medicament m) {
		Connection connection = ConnectionBD.getConnection();
		int res =0;
		
		try {
			PreparedStatement ps = connection.prepareStatement("update medicament set nom = ? where id = ?");	
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
