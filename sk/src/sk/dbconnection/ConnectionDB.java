//$Id$
package sk.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sk.check.UserDefinedException;

public class ConnectionDB {
	// Get PreparedStatement
	public PreparedStatement getPreparedStatement(String query)throws UserDefinedException{
		try {
			Connection connection=connectionDB();
			PreparedStatement pStatement=connection.prepareStatement(query);
			return pStatement;
		}
		catch(SQLException ex) {
			throw new UserDefinedException("Error Occur : ",ex);
		}
	}
	// Get Connection
	public Connection connectionDB()throws UserDefinedException{
		String dataBase="jdbc:mysql://localhost:3306/senthilkumarfinance";
		String uName="pasu";
		String uPassword="Pasu@143";
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(dataBase,uName,uPassword);
		}
		catch(SQLException ex) {
			throw new UserDefinedException("Error Occur : ",ex);
		}
		catch(ClassNotFoundException ex) {
			throw new UserDefinedException("Error Occur : ",ex);
		}
		return con;
	}
}
