import java.sql.*;
public class qa {
  public static void main(String args[]) 
  {
      try{
    Class.forName("org.postgresql.Driver");
    Connection cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234"); 
    Statement st=cn.createStatement();
    st.executeUpdate("update table1 set sub1=85,sub2=85,sub3=85 where rollno=15567");
    ResultSet tb=st.executeQuery("select count(*) as count from table1");
    /*while(tb.next())
    {
        System.out.println(tb.getString("rollno")+" "+tb.getString("name")+" "+tb.getString("sub1")+" "+tb.getString("sub2")+" "+tb.getString("sub3"));
    }*/
    tb.next();
    System.out.println(tb.getString("count"));
    cn.close();
    }
   catch(Exception e)
   {
       System.out.print("EXception"+e);
   }
 }
}
