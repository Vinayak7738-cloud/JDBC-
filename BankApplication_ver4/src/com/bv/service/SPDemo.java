package com.bv.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.bv.connection.DBConnect;

public class SPDemo {
	
	public static void callSp()
	{
		String sql = "{call fetchdetails(?,?,?)}";
		Connection connection = DBConnect.getConnection();
		try {
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.setInt(1, 101);
			
			//Retrieve data from Database where datatype is Varchar
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
			callableStatement.execute();
			
			String uname = callableStatement.getString(2);
			String password = callableStatement.getString(3);
			
			System.out.println(uname+" "+password);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
