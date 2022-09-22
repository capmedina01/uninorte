/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author CARLOS
 */
public class DensidadPoblacional extends ObjetoGeografico {
    private int numhabitantes;

    public DensidadPoblacional(int numhabitantes, String nombre, int idCuerpoDeAgua, String municipio) {
        super(nombre, idCuerpoDeAgua, municipio);
        this.numhabitantes = numhabitantes;
    }
    
    public String afeccion(){
        String nivel="";
        
        if(numhabitantes<10000)
            nivel="0";
        
        if(numhabitantes>=10000 && numhabitantes<=50000)
            nivel="1";
        
        if(numhabitantes>50000)
            nivel="2";
        
        return nivel;
        
    }

    public int getNumhabitantes() {
        return numhabitantes;
    }

    public void setNumhabitantes(int numhabitantes) {
        this.numhabitantes = numhabitantes;
    }
    
    
    
    
    
}
