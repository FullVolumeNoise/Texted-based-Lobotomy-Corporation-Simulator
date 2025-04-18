import java.lang.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class TestFacility {

    private static Connection connection;
    public static void main(String[] args) throws SQLException {
		try {
			initDatabaseConnection();
            readData();

		} finally {
			if (connection != null) {
				closeDatabaseConnection();
			}
		}
	}

	private static void initDatabaseConnection() throws SQLException {
		System.out.println("Connecting to the database...");
		connection = DriverManager.getConnection(
				"jdbc:mariadb://127.0.0.1:3306/lobcorp",
				"root", "KrazyKrystal999");
		System.out.println("Connection valid: " + connection.isValid(5));

	}


	private static void closeDatabaseConnection() throws SQLException {
		System.out.println("Closing database connection...");
		connection.close();
		System.out.println("Connection valid: " + connection.isValid(5));
	}

    private static void readData() throws SQLException {
		try (PreparedStatement statement = connection.prepareStatement("""
				    SELECT name
				    FROM abnormalities
				""")) {
			try (ResultSet resultSet = statement.executeQuery()) {
				boolean empty = true;
				while (resultSet.next()) {
					empty = false;
					String name = resultSet.getString("name");
				//	int rating = resultSet.getInt("pl_rating");
					System.out.println("\t> " + name);
				}
				if (empty) {
					System.out.println("\t (no data)");
				}
			}
		}
	}

}