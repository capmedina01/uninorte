/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto4;

/**
 *
 * @author caperdomo
 */
public class  CuerpoDeAgua extends ObjetoGeografico {
    private String tipoCuerpoDeAgua;
    private String tipoDeAgua;
    private float clasificacion;

    public CuerpoDeAgua(String tipoCuerpoDeAgua, String tipoDeAgua, float clasificacion, String nombre, int idCuerpoDeAgua, String municipio) {
        super(nombre, idCuerpoDeAgua, municipio);
        this.tipoCuerpoDeAgua = tipoCuerpoDeAgua;
        this.tipoDeAgua = tipoDeAgua;
        this.clasificacion = clasificacion;
    }
    
    public String nivel(){
        String nivel = "";
         if(getClasificacion() >= 0 && getClasificacion() <= 5){
              nivel = "SIN RIESGO";
         }else{
             if(getClasificacion() > 5 && getClasificacion() <= 14){
                 nivel = "BAJO";
             }else{
                 if(getClasificacion() > 14 && getClasificacion() <= 35){
                     nivel = "MEDIO";
                 }else{
                     if(getClasificacion() > 35 && getClasificacion() <= 80){
                         nivel = "ALTO";
                     }else{
                         if(getClasificacion() > 80 && getClasificacion() <= 100){
                            nivel = "INVIABLE SANITARIAMENTE"; 
                         }
                     }
                 }
             }
         }
         return nivel;
    }


    public String getTipoCuerpoDeAgua() {
        return tipoCuerpoDeAgua;
    }

    public void setTipoCuerpoDeAgua(String tipoCuerpoDeAgua) {
        this.tipoCuerpoDeAgua = tipoCuerpoDeAgua;
    }

    public String getTipoDeAgua() {
        return tipoDeAgua;
    }

    public void setTipoDeAgua(String tipoDeAgua) {
        this.tipoDeAgua = tipoDeAgua;
    }

    public float getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(float clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    
    
    
    
    
    
    
}
