/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras_de_datos;

/**
 * clase que se encarga de ser el puente entre dos vertices en un grafo
 * @author Diego Arreaza
 */
public class Arista {
    /**
     * direccion contendra un entero que indicara la orientacion del puente entre el N1 y el N2
     */
    private final int direccion;
    /**
     *  N1 es el vertice inicial de la arista
     */
    private final Vertice N1;
    /**
     * N2 es el vertice final de la arista
     */
    private final Vertice N2;
    
    /**
     * 
     * @param n1 Vertice inicial
     * @param n2 Vertice final
     * @param ub orientacion
     */
    public Arista(Vertice n1, Vertice n2, int ub){
        N1 = n1;
        N2 = n2;
        direccion = ub;
    }
    
    /**
     * Se retorna el primer vertice de la Arista
     * @return N1 primer Vertice 
     */
    public Vertice get_N1(){
        return N1;
    }
    
    /**
     * Se retorna el segundo Vertice de la Arista
     * @return N2 segundo Vertice
     */
    public Vertice get_N2(){
        return N2;
    }
    
}  
