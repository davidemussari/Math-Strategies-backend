package tesi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	String url = "jdbc:mysql://localhost/tesidb?useLegacyDatetimeCode=false&serverTimezone=UTC";
	String userName = "tesista";
	String password = "T3sista+";

	public String readDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection(url,userName,password);

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from tesidb.utenti");
			System.out.println("Questo e' il risultato:");
			List rowValues = new ArrayList();
			while (resultSet.next()) {
			    rowValues.add(resultSet.getString("nome"));
			} 
			System.out.println(rowValues);
			return rowValues.toString();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}
