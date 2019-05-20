/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.model.Autos;
import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franco
 */
public class ListQuery extends DBConexion implements  Serializable  {
    
    public List<Autos> listAutos(){
        List<Autos> list = new ArrayList<Autos>();
        try {
            ps = (PreparedStatement) connect().prepareStatement("select id,nombre,color,año,stock from autos");
            Autos s;
            rs = ps.executeQuery();
            
            while(rs.next()){
                s=new Autos();
                s.setId(rs.getInt("id"));
                s.setNombre(rs.getString("nombre"));
                s.setColor(rs.getString("color"));
                s.setAño(rs.getInt("año"));
                s.setStock(rs.getInt("stock"));
                list.add(s);
            }
            
            return list;
            
        } catch (Exception e) {
            return null;
        
        }
    }
}    
