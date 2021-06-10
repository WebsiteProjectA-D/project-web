package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Ordonnance;
import model.Ordonnance_detail;

public class OrdonnanceDAO {
	
	public static int Ajouter(Ordonnance o)
	{
		int res=0;
		Connection connection = ConnectionBD.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into ordonnance (date,visite_id) values (?,?) ");
			ps.setString(1,o.getDate());
			ps.setInt(2,o.getVisite_id());
			res=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;		
	}
	
	public static int AjouterLigneOrd(Ordonnance_detail d)
	{
		int res=0;
		Connection connection = ConnectionBD.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into detail_ordonnance (duration,quantite,ordonnance_id,medicament_id) values (?,?,?,?) ");
			ps.setInt(1,d.getDuration());
			ps.setInt(2,d.getQuantite());
			ps.setInt(3,d.getOrdonnance_id());
			ps.setInt(4,d.getMedicament_id());
			res=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;		
	}
	
	public static int getOrd(int idv) {
		Connection connection = ConnectionBD.getConnection();
		int res = 0;
		
		try {
			PreparedStatement ps = connection.prepareStatement("select id from ordonnance where visite_id = ?");
			ps.setInt(1,idv);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res = rs.getInt("id");
				return res;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
