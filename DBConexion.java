/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Franco
 */
public class DBConexion implements Serializable {
    private final String db_url="jdbc:mysql://127.0.0.1/fordsql";
    private final String db_username="root";
    private final String db_password="";
    
    private Connection connection=null;
    protected PreparedStatement ps=null;
    
    protected ResultSet rs=null;
    
    public Connection connect() throws SQLException{
        DriverManager.registerDriver(new Driver());
        connection=DriverManager.getConnection(db_url,db_username,db_password);
        return connection;
        
    }
    public void disconnect(){
        try {
            connection.close();
            ps.close();
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
