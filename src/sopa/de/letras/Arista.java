/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

/**
 *
 * @author Windows 10 Pro
 */
public class Arista {
    private final int direccion;
    private final Vertice N1;
    private final Vertice N2;
    
        public Arista(Vertice n1, Vertice n2, int ub){
        N1 = n1;
        N2 = n2;
        direccion = ub;
    }
    
    public Vertice get_N1(){
        return N1;
    }
    
    public Vertice get_N2(){
        return N2;
    }
    
    public int get_ub(){
        return direccion;
    }
    
}  
