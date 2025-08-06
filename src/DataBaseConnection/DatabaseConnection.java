
package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import EmailConfigurations.Emailconfigure;

public class DatabaseConnection
{

	public static void main(String args[]) {
	
	 String Url="jdbc:mysql://localhost:3306/DemoDatabase";
	 String Username="root";
	 String Password="root";	
     { 
         try 
          {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(Url,Username,Password);
            System.out.println("DataBase connected successfully");
            LocalDate today = LocalDate .now();
            String query="Select EmployeeName,Email From EmployeeMaster Where Day(DOB)=? AND Month(DOB)=?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,today.getDayOfMonth());
            stmt.setInt(2,today.getMonthValue());
            
            
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()) 
            {
              String Name=rs.getString("EmployeeName");
              String Email=rs.getString("Email");
              
             Emailconfigure.SendEmail(Email, Name);
            }
				
          }
     catch(Exception e) 
     {
    	 System.out.println("Error to connect");
    	 e.printStackTrace();
    
     }
  }
	}

	public static void sendEmail()
	{
		
		
	}
}
