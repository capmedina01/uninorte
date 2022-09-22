/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CuerpoDeAgua;
import java.util.ArrayList;
import Model.DensidadPoblacional;

/**
 *
 * @author CARLOS
 */
public class GestionAnalisis {
    
    public static ArrayList<CuerpoDeAgua> cuerpos = new ArrayList<CuerpoDeAgua>();
    public static ArrayList<DensidadPoblacional> densidades = new ArrayList<DensidadPoblacional>();
    
    public static void capturarDatos(
            String tipoCuerpoAgua, 
            String tipoAgua, 
            String irca, 
            String nombre, 
            String idCuerpoDeAgua, 
            String municipio,
            String densidad
    ){
        
            
        cuerpos.add(new CuerpoDeAgua(
                tipoCuerpoAgua, 
                tipoAgua, 
                Float.parseFloat(irca), 
                nombre, 
                Integer.parseInt(idCuerpoDeAgua), 
                municipio));
         
        densidades.add(new DensidadPoblacional(
                Integer.parseInt(densidad), 
                nombre, 
                Integer.parseInt(idCuerpoDeAgua), 
                municipio));
        
    }
    
   
    
    public static ArrayList<String> Analisis(){
        ArrayList<String> resultados = new ArrayList<String>();
        
        int cont=0;
        //Analisis de Riesgo por Cada cuerpo de Agua
        for(int i=0; i<cuerpos.size();i++){
            resultados.add(cuerpos.get(i).nivel() +" "+ densidades.get(i).afeccion());
            
        // Contar los niveles inferriores o iguales a medio
        
        if(cuerpos.get(i).nivel()=="MEDIO" || 
           cuerpos.get(i).nivel()=="BAJO" || 
           cuerpos.get(i).nivel()=="SIN RIESGO")
           cont++; 
        }
        
        resultados.add(Integer.toString(cont));
        
        boolean encontro=false;
        for(int i=0; i<cuerpos.size();i++){
                    
        if(cuerpos.get(i).nivel()=="MEDIO"){
            encontro=true;
            resultados.add(cuerpos.get(i).getNombre());
        }
        
        }
        
        if(encontro==false)
            resultados.add("NA");
               
        
        double menor;
        int pos = 0;
        menor = cuerpos.get(0).getIrca();
        for (int i = 1; i < cuerpos.size(); i++) {
            if (cuerpos.get(i).getIrca() < menor) {
                menor = cuerpos.get(i).getIrca();
                pos = i;
            }
        }
           
      resultados.add(cuerpos.get(pos).getNombre()+" " +cuerpos.get(pos).getIdCuerpoDeAgua());
        
        return resultados;
    }
    
    public static ArrayList<String> nivelAfectacciones(){
        ArrayList<String> resultadoAfectacciones = new ArrayList<String>();
               
        for(int i=0; i<densidades.size();i++){
            resultadoAfectacciones.add( densidades.get(i).getNombre()+" "+ 
                    densidades.get(i).getMunicipio()+" "+                    
                    densidades.get(i).afeccion());
            
            
        }       
        return resultadoAfectacciones;
    }
    
    
    
}
