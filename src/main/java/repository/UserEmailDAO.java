package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;

public class UserEmailDAO {
	public boolean EmailCheckExits(String email)
	{
		Connection conn = DBContext.getConnection();
		try {
			String sql = "SELECT COUNT(*) AS count FROM user_email WHERE email=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1 , email);
			ResultSet rs = st.executeQuery();
			 if (rs.next()) {
	                return rs.getInt("count") > 0;
	            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public int EmailCheck(String email )
	{
		
		Connection conn = DBContext.getConnection();
		try {
			String sql = "select userid FROM user_email WHERE email=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1 , email);
			ResultSet rs = st.executeQuery();
			 if (rs.next()) {
	                return rs.getInt("userid");
	            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public static String getEmail(int id)
	{
		Connection conn = DBContext.getConnection();
		try {
			String sql = "select email FROM user_email WHERE userid=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			 if (rs.next()) {
	                return rs.getString("email");
	            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	
	
	
	public static void main(String[] args) {
			System.out.println(getEmail(1));
	}

}
