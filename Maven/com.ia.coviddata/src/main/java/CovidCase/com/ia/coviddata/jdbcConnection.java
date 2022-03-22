package CovidCase.com.ia.coviddata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Loading the driver class
		Class.forName("org.postgresql.Driver");
		
		//Creating the connection object
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/task", "postgres", "raghu");
		
		//Creating the statement object
		
		PreparedStatement stmt = conn.prepareStatement("SELECT location,"+" Count(total_cases) FROM covid_data "+" WHERE new_cases>1000 GROUP BY location,new_cases ORDER BY new_cases");
		
		//Excuting the query
		
		ResultSet result = stmt.executeQuery();
		
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2));
	}
		//closing the connection
		conn.close();
	}
	

}
