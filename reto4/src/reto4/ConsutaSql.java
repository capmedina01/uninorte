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
public class ConsutaSql {
    
    
    public static void insertar(String tipoCuerpoDeAgua,
            String tipoDeAgua, float clasificacion, 
            String nombre, int idCuerpoDeAgua, String municipio){
        
        CuerpoDeAgua cuerpo = new CuerpoDeAgua(tipoCuerpoDeAgua,
                tipoDeAgua, clasificacion, nombre,
                idCuerpoDeAgua, municipio );
        
        Conexion conexion = new Conexion();
        
        String sql;
        sql = String.format("INSERT INTO cuerposAgua"+
                "(id, nombre, municipio, tipoCuerpo, tipoAgua, irca)"+
                "VALUES('%s','%s','%s','%s','%s','%s')",
                cuerpo.getIdCuerpoDeAgua(),
                cuerpo.getNombre(),
                cuerpo.getMunicipio(),
                cuerpo.getTipoCuerpoDeAgua(),
                cuerpo.getTipoDeAgua(),
                cuerpo.getClasificacion());
                
        conexion.ejecutarSQL(sql);
        
    }
    
    public static ResultSet listar(){
        Conexion conectar = new Conexion();
        ResultSet respuesta=null;
        try{
            respuesta=conectar.consultaSQL("SELECT *FROM cuerposAgua");
            
        }catch(Exception e){
            System.out.println("Listar: "+ e);
        }         
        
        return respuesta;           
            
    }
    
    public static ResultSet buscar(String idBusqueda){
        Conexion conectar = new Conexion();
        ResultSet respuesta=null;
        try{
            respuesta=conectar.consultaSQL("SELECT *FROM cuerposAgua WHERE id='"+ idBusqueda+"'");
            
        }catch(Exception e){
            System.out.println("Buscar: "+ e);
        }         
        
        return respuesta;           
            
    }
    
    public static void modificar(String tipoCuerpoDeAgua,
            String tipoDeAgua, float clasificacion, 
            String nombre, int idCuerpoDeAgua, String municipio){
        
        CuerpoDeAgua cuerpo = new CuerpoDeAgua(tipoCuerpoDeAgua,
                tipoDeAgua, clasificacion, nombre,
                idCuerpoDeAgua, municipio );
        
        Conexion conexion = new Conexion();
        
        String sql;
        sql = String.format("UPDATE cuerposAgua "+
                "SET nombre='%s',"
                + "SET municipio='%s',"
                + "SET tipoCuerpo='%s',"
                + "SET tipoAgua='%s',"
                + "SET irca='%s' "
                + "WHERE id='%s' ",
                
                
               
                cuerpo.getNombre(),
                cuerpo.getMunicipio(),
                cuerpo.getTipoCuerpoDeAgua(),
                cuerpo.getTipoDeAgua(),
                cuerpo.getClasificacion(),
                cuerpo.getIdCuerpoDeAgua());
                
        conexion.ejecutarSQL(sql);
        
    }
    
     public static int eliminar(String idBusqueda){
        Conexion conectar = new Conexion();
        
        try{
            conectar.ejecutarSQL("DELETE FROM cuerposAgua WHERE id='"+ idBusqueda+"'");
            return 1;
        }catch(Exception e){
            System.out.println("Buscar: "+ e);
            return 0;
        }         
        
   
    }
}
