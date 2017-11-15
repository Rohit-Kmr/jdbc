import java.sql.*;
public class JavaApplication1 {
  public static void main(String args[]) 
  {
      try{
    Class.forName("org.postgresql.Driver");
    Connection cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234"); 
    Statement st=cn.createStatement();
    st.executeUpdate("update table1 set sub1=85,sub2=85,sub3=85 where rollno=15567");
    ResultSet tb=st.executeQuery("select avg(sub1) as avg_sub1,avg(sub2) as avg_sub2,avg(sub3) as avg_sub3 from table1");
    while(tb.next())
    {
        System.out.println(tb.getString("avg_sub1")+" "+tb.getString("avg_sub2")+" "+tb.getString("avg_sub3"));
    }
    }
   catch(Exception e)
   {
       System.out.print("EXception"+e);
   }
 }
}
