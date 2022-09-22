/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author CARLOS
 */
public class Conexion {
    
    String conexionDb="jdbc:sqlite:bd.s3db";
    Connection conn =null;
    
    
    public Conexion(){
        
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(conexionDb);
            System.out.println("Conexión exitosa");
        }catch(Exception e){
            System.out.println("Conexion: "+ e);
        }
    }
    
    public int ejecutarSQL(String sentencia){
       try{
            PreparedStatement pst=conn.prepareStatement(sentencia);
            pst.execute();
            System.out.println("Conexión exitosa ejecutar");
            return 1;
        }catch(SQLException e){
            System.out.println("Consulta1: "+ e);
            return 0;
        }
    }
    
     public ResultSet consultaSQL(String sentencia){
       try{
            PreparedStatement pst=conn.prepareStatement(sentencia);
            ResultSet response= pst.executeQuery();
            System.out.println("Conexión exitosa consulta");
            return response;
        }catch(SQLException e){
            System.out.println("Consulta 2: "+ e);
            return null;
        }
    }
     
    
}
