package Manager;

import java.sql.*;
import java.util.ArrayList;

import Model.Person;

public class PersonManager {

	DBConnection dbConnection = new DBConnection();

	Connection connection = dbConnection.dbConnection();
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement;

	public ArrayList<Person> getList() {

		ArrayList<Person> list = new ArrayList<>();

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM person");

			Person obj;
			while (resultSet.next()) {

				obj = new Person();
				obj.setId(resultSet.getInt("id"));
				obj.setName(resultSet.getString("name"));
				obj.setSurname(resultSet.getString("surname"));
				obj.setEmail(resultSet.getString("email"));
				obj.setNumber(resultSet.getString("number"));

				list.add(obj);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	public boolean add(String name, String surname, String number, String email) {

		String query = "INSERT INTO person" + "(name,surname,number,email)" + "VALUES(?,?,?,?)";
		boolean key = false;
		try {

			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, number);
			preparedStatement.setString(4, email);

			preparedStatement.executeUpdate();

			key = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return key;
	}

	public boolean delete(int id) {
		String query = "DELETE FROM person WHERE id = ?";
		boolean key = false;
		try {

			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

			key = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return key;
	}
	
	public boolean update(int id, String name, String surname, String email, String number) {
		String query = "UPDATE person SET name = ?, surname = ?, email = ?, number = ? WHERE id = ?";
		boolean key = false;
		try {

			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, number);
			preparedStatement.setInt(5, id);


			preparedStatement.executeUpdate();

			key = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return key;
	}

}
