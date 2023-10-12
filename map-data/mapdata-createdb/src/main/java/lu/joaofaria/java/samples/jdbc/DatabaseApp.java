package lu.joaofaria.java.samples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseApp {

	private String url;
	private String user;
	private String password;

	public static void main(String[] args) {
		DatabaseApp app = new DatabaseApp();
		app.buildDb();
	}

	public void buildDb() {
		loadProps();
		try (Connection conn = DriverManager.getConnection(url, user, password);
				Statement statement = conn.createStatement()) {
			System.out.println("Successfully connected");
			DatabaseModel.createDb(statement);
//			DatabaseModel.createTable(statement);
//			DatabaseModel.createSequence(statement);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private void loadProps() {
		String propFile = "/properties/db.properties";
		Properties appProps = Utils.loadPropFile(propFile);
		url = appProps.getProperty("mapdata.db.url");
		user = appProps.getProperty("mapdata.db.user");
		password = appProps.getProperty("mapdata.db.pwd");

	}
}