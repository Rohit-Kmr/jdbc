import java.sql.*;
import javax.sql.*;
import java.util.Scanner;

//********** CLASS PREPARE INSERT**************

class proc_count
{

//############ MAIN FUNCTION ##################
 
	public static void main(String args[])
	{
		String url="jdbc:odbc:Customer_information";						//url for the DATA SOURCE(DATA SOOURCE NAME- Student_Info) 
		CallableStatement cst;									// Object of Statement class
		Connection Db;									// Object of Connection class
		int rowsupdate = 0,c;									// variable to count the no. of rows updated


		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");				// to Load the JDBC DRIVER
			Db=DriverManager.getConnection(url,"system","12345");					// TO Connect with the data source


			try
			{
				String query="{CALL Count (?)}";					// Prepare Statement Query to INSERT RECORD
				cst=Db.prepareCall(query);						// TO create the Prepare query statement
				cst.registerOutParameter(1,Types.INTEGER);
				cst.execute();
				c=cst.getInt(1);
										
				System.out.print(c);
				
				cst.close();							//to close the the statement
				Db.close();							// to close the connection
			}



			catch(SQLException e)							// Class to catch the SQL exception
			{									// which may be thrown by 2nd try due to 
				System.out.print("ERROR ! QUERY NOT EXECUTED "+e);		// the statement executeUpdate
			}	

							
		}


		catch(ClassNotFoundException e)							
		{										// Class to catch the SQL exception
			System.out.print("UNABLE TO LOAD JDBC-ODBC BRIDGE" + e);		//which may be thrown by 1st try due to 
			System.exit(1);								//the statement Class.forName
		}


		catch(SQLException e)
		{										//Class to catch the SQL exception
			System.out.print("UNABLE TO CONNECT" + e);				//which may be thrown by 1st try due to
			System.exit(2);								//the statement Driver.Manager
		}
	}
}