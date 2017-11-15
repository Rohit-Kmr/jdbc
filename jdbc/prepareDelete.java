import java.sql.*;
import javax.sql.*;
import java.util.Scanner;

//********** CLASS PREPARE DELETE**************

class prepareDelete
{

//############ MAIN FUNCTION ##################
 
	public static void main(String args[])
	{
		String url="jdbc:odbc:Student_Info";						//url for the DATA SOURCE(DATA SOOURCE NAME- Student_Info) 
		PreparedStatement pst;								// Object of Statement class
		Connection Db;									// Object of Connection class
		int rowsupdate = 0;								// variable to count the no. of rows updated


		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");				// to Load the JDBC DRIVER
			Db=DriverManager.getConnection(url);					// TO Connect with the data source


			try
			{
				String query=" DELETE FROM Student WHERE S_id = ?";		// Prepare Statement Query to DELETE RECORD
				pst=Db.prepareStatement(query);					// TO create the Prepare query statement
				pst.setInt(1,3);
				rowsupdate+=pst.executeUpdate();				// execute the query and store the no. of updated rows in rowsupdate
		
				
				if(rowsupdate!=0)
					System.out.print(rowsupdate+" ROWS UPDATED");
				else
					System.out.print("ERROR ! row not inserted");
				pst.close();							//to close the the statement
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