package ASimulatorSystem;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  //mysql enternal entity hai tu run time per error aa nay kay chances hain iss liyay exceptional handling ki hai
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  //driver ka naam
            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","");    
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
