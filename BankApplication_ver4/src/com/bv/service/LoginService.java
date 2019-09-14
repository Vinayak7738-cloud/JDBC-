package com.bv.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bv.connection.DBConnect;

public class LoginService {

	// select * from LoginDetails
	public static void getDetails() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// String sql = "select * from loginDetails";

			// Step 1.B:create SQL query to fetch particular record
			String sql = "select * from loginDetails where acc_no = ?";

			// Building the Connection
			Connection connection = DBConnect.getConnection();

			// Takes the query towards the database through network
			Statement statement = connection.createStatement();

			// Step 2.B: Creating JDBC Statement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 101);

			/*
			 * ResultSet resultSet = statement.executeQuery(sql); //Fetching all records
			 * while (resultSet.next()) { System.out.println(resultSet.getInt("ACC_NO")
			 * +" "+resultSet.getString("USERNAME") +" "+resultSet.getString("PASSWORD"));
			 */

			// create SQL query to fetch particular record
			resultSet = preparedStatement.executeQuery();

			// Fetching particular record
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString("USERNAME") + " "
						+ resultSet.getString("PASSWORD"));
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public static boolean validateUser(int acc_no,String password)
	{
		//System.out.println("Choose the Account");
		boolean status = false;
		String sql = "select * from account "+"where acc_no=? and password = ?";
				Connection con = DBConnect.getConnection();
			try
			{
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setInt(1, acc_no);
				preparedStatement.setString(2, password);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next())
				{
					status = true;
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return status;
	}

}
