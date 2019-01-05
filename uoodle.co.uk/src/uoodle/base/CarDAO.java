package uoodle.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public CarDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}

	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public boolean insertCar(Car car) throws SQLException {
		String sql = "Insert into cars(name, model, year) VALUES (?, ?, ?)";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, car.getName());
		statement.setString(2, car.getModel());
		statement.setString(3, car.getYear());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}

	public List<Car> listAllCars() throws SQLException {
		List<Car> listCar = new ArrayList<>();

		String sql = "SELECT * FROM cars";
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String model = resultSet.getString("model");
			String year = resultSet.getString("year");
		
		Car car = new Car(id, name, model, year);
		listCar.add(car);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listCar;
	}

	public boolean deleteCar(Car car) throws SQLException {
		String sql = "DELETE FROM cars where id = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, car.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;

	}

	public boolean updateCar(Car car) throws SQLException {
		String sql = "UPDATE cars SET name = ?, model = ?, year = ?";
		sql += "WHERE id = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, car.getName());
		statement.setString(2, car.getModel());
		statement.setString(3, car.getYear());
		statement.setInt(4, car.getId());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;

	}
	
	public Car getCar(int id) throws SQLException {
		Car car = null;
		String sql = "SELECT * FROM cars WHERE id = ?";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1,  id);
		
		ResultSet resultSet =  statement.executeQuery();
		
		if (resultSet.next()) {
			String name = resultSet.getString("name");
			String model = resultSet.getString("model");
			String year = resultSet.getString("year");
			
			car = new Car(id, name, model, year);
			
		}
		resultSet.close();
		statement.close();
		
		return car; 
		
	}

}
