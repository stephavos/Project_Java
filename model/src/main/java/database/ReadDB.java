package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadDB {

	String map;
	int ID_Map, Width_Map, Height_Map, PosX_Player, PosY_Player;
	
	public void read(int id_map) {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String connectionUrl = "jdbc:mysql://localhost/jpublankproject?autoReconnect=true&useSSL=false";
		String connectionUser = "root";
		String connectionPassword = "";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM map WHERE `ID_Map` =" + id_map);
		while (rs.next()) {
			ID_Map = rs.getInt("ID_Map");
			Width_Map = rs.getInt("Width_Map");
			Height_Map = rs.getInt("Height_Map");
			PosX_Player = rs.getInt("PosX_Player");
			PosY_Player = rs.getInt("PosY_Player");
			map = rs.getString("Map");
			/*System.out.println("ID_Map: " + ID_Map + ", Width_Map: " + Width_Map
					+ ", Height_Map: " + Height_Map+ ", PosX_Player "+ PosX_Player +", PosY_Player "+ PosY_Player + ", Map : \n"+ map);
		*/}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
}
	public String getMap() {
		return map;
	}
	
	public int getID_Map() {
		return ID_Map;
	}

	public int getWidth_Map() {
		return Width_Map;
	}

	public int getHeight_Map() {
		return Height_Map;
	}

	public int getPosX_Player() {
		return PosX_Player;
	}

	public int getPosY_Player() {
		return PosY_Player;
	}
}
