package uoodle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
	public static final String DB_NAME = "uoodle";
	public static final String CONNECTION_STRING = "jdbc:mqsql://localhost/" + DB_NAME;

	public static final String TABLE_CAR = "cars";
	public static final String COLUMN_CAR_ID = "id";
	public static final String COLUMN_CAR_NAME = "name";
	public static final String COLUMN_CAR_MODEL = "model";
	public static final String COLUMN_CAR_YEAR = "year";

	private Connection conn;

	public boolean open() {
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING);
			return true;
		} catch (SQLException e) {
			System.out.println("Couldn't connect to the database" + e.getMessage());
			return false;
		}
	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Couldn't close connection: " + e.getMessage());
		}
	}
}
