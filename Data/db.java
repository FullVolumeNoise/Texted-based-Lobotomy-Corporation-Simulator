package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Abnormal;
import Model.Agent;

public class db {
 
    private static Connection connection;

	// public db(){
	// 	try {
	// 		try {
	// 			initDatabaseConnection();
	// 		//	readData();

	// 		} catch (SQLException e) {
	// 			// TODO Auto-generated catch block
	// 			e.printStackTrace();
	// 		}
         
	// 	} finally {
	// 		if (connection != null) {
	// 			try {
	// 				closeDatabaseConnection();
	// 			} catch (SQLException e) {
	// 				// TODO Auto-generated catch block
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	}
	// }

    public static void main(String[] args) throws SQLException {
		try {
			//initDatabaseConnection();
            //readData();
			getAbnormalitiesFromDB();

		} finally {
			// if (connection != null) {
			// 	closeDatabaseConnection();
			// }
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


	public static void getAgentsFromDB() throws SQLException {
		initDatabaseConnection();
		try (PreparedStatement statement = connection.prepareStatement("""
				    SELECT agent_id, name, department_id, current_level, current_health_stat, max_health_stat,
					current_sanity_stat, max_sanity_stat, current_armor_id, current_weapon_id, isPanicked
				    FROM agents 
				""")) {
			try (ResultSet resultSet = statement.executeQuery()) {
				boolean empty = true;
				while (resultSet.next()) {
					empty = false;
					int agent_id = resultSet.getInt("agent_id");
					String name = resultSet.getString("name");
					int department_id = resultSet.getInt("department_id");
					
					int currentLevel = resultSet.getInt("current_level");
					int currentHealth = resultSet.getInt("current_health_stat");
					int maxHealth = resultSet.getInt("max_health_stat");
					int currentSanity = resultSet.getInt("current_sanity_stat");
					int maxSanity = resultSet.getInt("max_sanity_stat");

					int currentArmor = resultSet.getInt("current_armor_id");	
					int currentWeapon = resultSet.getInt("current_weapon_id");	

					boolean maxEnergyGiven = resultSet.getBoolean("isPanicked");

					Agent thing = new Agent(name);

					System.out.println(thing);

				//	int rating = resultSet.getInt("pl_rating");
					System.out.println("\t> " + name);
				}
				if (empty) {
					System.out.println("\t (no data)");
				}
			}
		}
		closeDatabaseConnection() ;
	}

	//armors_id, weapons_id, department_id, currentlyBreaching 
    public static void getAbnormalitiesFromDB() throws SQLException {
		initDatabaseConnection();
		try (PreparedStatement statement = connection.prepareStatement("""
				    SELECT abnormality_id, name, quote, description,
					rank, counter_max, current_counter_value, max_energy_given, breachable
				    FROM abnormalities 
				""")) {
			try (ResultSet resultSet = statement.executeQuery()) {
				boolean empty = true;
				while (resultSet.next()) {
					empty = false;
					int abnormality_id = resultSet.getInt("abnormality_id");
					String name = resultSet.getString("name");
					String quote = resultSet.getString("quote");
					String description = resultSet.getString("description");
					String rank = resultSet.getString("rank");
					int counterMax = resultSet.getInt("counter_max");
					int currentCounter = resultSet.getInt("current_counter_value");
					int maxEnergyGiven = resultSet.getInt("max_energy_given");
					
// 					Abnormal(int ID, String name, String rank,  int counterMax,  int currentCounter,
//   int maxEnergyGiven, boolean canEscape, int armorsID, int weaponsID, int departmentID, boolean currentlyBreaching,
//   String damageType)

					Abnormal thing = new Abnormal(abnormality_id, name, rank, counterMax, currentCounter, maxEnergyGiven, false, 1, 1, 1, false, "BLACK");
					System.out.println(thing);

				//	int rating = resultSet.getInt("pl_rating");
					System.out.println("\t> " + name + ", " + quote);
				}
				if (empty) {
					System.out.println("\t (no data)");
				}
			}
		}
		closeDatabaseConnection() ;
	}
}
