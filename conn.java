/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package atm.stimulator.system;

import java.sql.*;


public class conn {
    Connection c;
    Statement s;
    conn(){
        try{
            //register driver 
           // Class.forName(com.mysql.cj.jdbc.Driver);
            //no need to register the driver explicitly its already persent in the classpath of library
            //create connection
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","jain@sumedha27082004");
            //create statement
            s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
