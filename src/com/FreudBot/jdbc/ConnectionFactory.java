package com.FreudBot.jdbc;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import io.github.cdimascio.dotenv.Dotenv;

	public class ConnectionFactory {
		
		private static String url;
		
		private static String username;
		
		private static String password;
		
		private static final String DB_NAME = "FreudDB";
		
		private static ConnectionFactory cf;
		
		static Dotenv dotenv = Dotenv.load();
		
		public ConnectionFactory() {
			url = dotenv.get("DB_AWS_URL");
			url = "jdbc:postgresql://" + url + ":5432/" + DB_NAME + "?";
			username = dotenv.get("DB_USERNAME");
			password = dotenv.get("DB_PASSWORD");
		}
		
		public Connection createConnection() {
			Connection conn = null;
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Failed to load Driver");
			}
			
			try {
				conn = DriverManager.getConnection(url, username, password);
				System.out.println("Connection Established and the DATABASE NAME IS:"
                        + conn.getMetaData().getDatabaseProductName());
			} catch (SQLException e) {
				System.out.println("Unable to make connection");
				e.printStackTrace();
			}
			
			return conn;
			
		}
		
		public static Connection getConnection() {
			
			if (cf == null) {
				cf = new ConnectionFactory();
			}
			
			return cf.createConnection();
			
		}

	}


