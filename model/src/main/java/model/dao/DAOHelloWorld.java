package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.DBConnection;

import entity.GameObject;
import entity.HelloWorld;

public class DAOHelloWorld {

	private Connection connection;

	public DAOHelloWorld(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	public int getLar(int id){
		try {
			final String sql = "{call getLar(?)}";
			final CallableStatement call = this.connection.prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if(resultSet.first()) {
				return resultSet.getInt("compte");
			} else {
				return 0;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}


	public GameObject[] getMap(final int id) {

		GameObject[] objectList = new GameObject[2000];
		int i = 0;
		GameObject temp;
		try {
			final String sql = "{call getMap(?)}";
			final CallableStatement call = this.connection.prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			while (resultSet.next()) {
				temp = new GameObject(resultSet.getString("sprite"), resultSet.getInt("Xposition"), resultSet.getInt("Yposition"));
				objectList[i] = temp;
				i++;
			}
			return objectList;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	}
