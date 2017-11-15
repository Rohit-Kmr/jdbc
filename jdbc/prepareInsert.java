import java.sql.*;
import javax.sql.*;
import java.util.Scanner;

//********** CLASS PREPARE INSERT**************

class prepareInsert
{

//############ MAIN FUNCTION ##################
 
	public static void main(String args[])
	{
		String url="jdbc:odbc:Student_Info";						//url for the DATA SOURCE(DATA SOOURCE NAME- Student_Info) 
		PreparedStatement pst;									// Object of Statement class
		Connection Db;									// Object of Connection class
		int rowsupdate = 0;									// variable to count the no. of rows updated


		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");				// to Load the JDBC DRIVER
			Db=DriverManager.getConnection(url);					// TO Connect with the data source


			try
			{
				String query="INSERT INTO Student VALUES(?,?,?,?)";	// Prepare Statement Query to INSERT RECORD
				pst=Db.prepareStatement(query);					// TO create the Prepare query statement
				pst.setInt(1,3);
				pst.setString(2,"Jack");
				pst.setInt(3,24);
				pst.setInt(4,3656);
				rowsupdate+=pst.executeUpdate();				// execute the query and store the no. of updated rows in rowsupdate
		
				
				pst.setInt(1,4);
				pst.setString(2,"Simon");
				pst.setInt(3,25);
				pst.setInt(4,2756);
				rowsupdate+=pst.executeUpdate();	
				
				
				pst.setInt(1,5);
				pst.setString(2,"Kiran");
				pst.setInt(3,12);
				pst.setInt(4,4656);
				rowsupdate+=pst.executeUpdate();	
				

				pst.setInt(1,6);
				pst.setString(2,"Den");
				pst.setInt(3,27);
				pst.setInt(4,2856);
				rowsupdate+=pst.executeUpdate();	
				


										
				if(rowsupdate!=0)
					System.out.print(rowsupdate+" ROWS INSERTED");
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