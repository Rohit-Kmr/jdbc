import java.sql.*;
import javax.sql.*;
import java.util.Scanner;

//********** CLASS LOAD DATA BASE**************

class load_DB
{

//############ MAIN FUNCTION ##################
 
	public static void main(String args[])
	{
		String url="jdbc:odbc:Customer_Info";						//url for the DATA SOURCE(DATA SOOURCE NAME- Customer_Info) 
		Statement st;									// Object of Statement class
		Connection Db;									// Object of Connection class
		int rowsupdate = 0;									// variable to count the no. of rows updated


		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");				// to Load the JDBC DRIVER
			Db=DriverManager.getConnection(url);					// TO Connect with the data source


			try
			{
				String query="INSERT INTO Customer VALUES(6,'tarun',45,3856)";	// Query to INERT RECORD
				String query1="INSERT INTO Customer VALUES(7,'mehul',23,4567)";
				st=Db.createStatement();					// TO create the query statement
				rowsupdate+=st.executeUpdate(query);				// execute the query and store the no. of updated rows in rowsupdate
				rowsupdate+=st.executeUpdate(query1);	
				if(rowsupdate!=0)
					System.out.print("ROW INSERTED");
				else
					System.out.print("ERROR ! row not inserted");
				st.close();							//to close the the statement
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