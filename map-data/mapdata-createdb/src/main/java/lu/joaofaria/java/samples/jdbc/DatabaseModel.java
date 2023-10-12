package lu.joaofaria.java.samples.jdbc;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseModel {
	public static void createDb(Statement statement) throws SQLException {
		String sqlStatement = Utils.readFromInputStream("scripts/create_db.sql");
		statement.executeUpdate(sqlStatement);
		System.out.println("Database Created.");
	}

	public static void createTable(Statement statement) throws SQLException {
		String sqlStatement = Utils.readFromInputStream("scripts/create_table.sql");
		statement.executeUpdate(sqlStatement);
		System.out.println("Table Created.");
	}

	public static void createSequence(Statement statement) throws SQLException {
		String sqlStatement = Utils.readFromInputStream("scripts/create_seq.sql");
		statement.executeUpdate(sqlStatement);
		System.out.println("Sequence Created.");
	}

	public static void populate(Statement statement) throws SQLException {
		String sqlStatement = Utils.readFromInputStream("scripts/create_seq.sql");
		statement.executeUpdate(sqlStatement);
		System.out.println("Sequence Created.");
	}
}
