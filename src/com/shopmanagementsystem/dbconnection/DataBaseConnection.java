/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.dbconnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ahsan
 */
public class DataBaseConnection {
    
    private static Connection con;
    
    private DataBaseConnection(){}
    
    static{
    
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctask","root","root");
            
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class Not Found Connection in Data Base Connection Class");
            
        }catch (SQLException ex) {
            //Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL Exception in Data Base Connection Class");
            
        }
        catch(Exception e){
            System.out.println("Other Exception in Data Base Connection Class");
        }
        
    }
    
    public static Connection getDBConnection(){
        
        return con;
        
    }
}
