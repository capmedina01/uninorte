/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3;

import java.util.ArrayList;

/**
 *
 * @author caperdomo
 */
public class GestionAnalisis {
    
    public static ArrayList<CuerpoDeAgua> cuerpos = new ArrayList<CuerpoDeAgua>();
    
    
    public static void capturarDatos(String tipoCuerpoDeAgua, 
            String tipoDeAgua,
            String clasificacion,
            String nombre, 
            String idCuerpoDeAgua,
            String nunicipio){
        
        cuerpos.add(new CuerpoDeAgua(
        tipoCuerpoDeAgua, 
                tipoDeAgua,
                Float.parseFloat(clasificacion),
                nombre,
                Integer.parseInt(idCuerpoDeAgua),
                nunicipio));
        
    }
    
    public static ArrayList<String> analisis(){
        ArrayList<String> resultados = new ArrayList<String>();
        int cont = 0;
        boolean medio = false;
        for(int i=0; i<cuerpos.size();i++){
            resultados.add(cuerpos.get(i).nivel());
            
            if(cuerpos.get(i).nivel()== "BAJO" || cuerpos.get(i).nivel()== "MEDIO" || cuerpos.get(i).nivel()== "SIN RISGO" )
                cont ++;
        }
        resultados.add(Integer.toString(cont));
        
        for(int i=0; i<cuerpos.size();i++){
                       
            if(cuerpos.get(i).nivel()== "MEDIO"  ){
                medio = true;
                resultados.add(cuerpos.get(i).getNombre());
            }
            
                
        }
         if(medio == false)
                resultados.add("NA");
         
          double menor;
        int pos = 0;
        menor = cuerpos.get(0).getClasificacion();
        for (int i = 1; i < cuerpos.size(); i++) {
            if (cuerpos.get(i).getClasificacion() < menor) {
                menor = cuerpos.get(i).getClasificacion();
                pos = i;
            }
        }
           
      resultados.add(cuerpos.get(pos).getNombre()+" " +cuerpos.get(pos).getIdCuerpoDeAgua());
        
        return resultados;
    }
   
    
}
