import java.sql.*;
public class updateRSet
{
	public static void main(String args[])
	{
		String url="jdbc:odbc:Customer_Info";
		Statement st;
		ResultSet rs;
		Connection Db;
		boolean haveRecords;
		String name,set=new String();
		int age;
		double sal=0;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Db=DriverManager.getConnection(url);
	
			try
			{
				String query="SELECT C_NAME,C_age,C_SAL FROM Customer WHERE C_ID=2";			// Query to SELECT 3 COLOUMNS RECORD
				st=Db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	// TO create the query statement
				rs=st.executeQuery(query);								// execute the query 
				haveRecords=rs.next();
				if(!haveRecords)
					System.out.println("NO RECORDS ARE RETURNED");
				else
				{
					try
					{
						System.out.print("RESULTSET IS \n\n");
						
						
							name=rs.getString(1);
							age=rs.getInt(2);
							sal=rs.getDouble(3);
							set=name +" "+age + " "+sal;
							System.out.print(set);
						

						sal=rs.getDouble("C_SAL")+2000.0;
						rs.updateDouble("C_SAL",sal);
						rs.updateRow();
					}
					catch(SQLException error)
					{
						System.out.println("DATA DISPLAY ERROR" + error);
					}
				}
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
