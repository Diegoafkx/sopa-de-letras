/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

/**
 * Se encarga de crear los Vertices del grafo
 * @author Diego Arreaza
 */
public class Vertice {
    
    /**
     * Atributos de la clase
     * vecinos es una matriz con las Aristas del vertice
     * letra es letra que contiene el vertice
     * visited es el estado del vertice para saber si con esta se forma una palabra
     */
    private final Arista[] vecinos;
    private final String letra;
    private boolean visited;
    
    /**
     * Constructor de la clase
     * @param n1 Nodo con la letra que contendra el Vertice
     */
    public Vertice(Nodo n1){
        vecinos = new Arista[8];
        letra = n1.data;
        visited = false;
    } 
    
    /**
     * Metodo que se encarga de retornar el Vertice vecino de este de la ubicacion del indice p
     * @param p indice de la ubicacion del vertice vecino que se requiere
     * @return Vertice vecino de la ubicacion p de la matriz vecinos
     */
    public Vertice dar_vecino(int p){
        if (vecinos[p]==null) {
            return null;
        }
        return vecinos[p].get_N2();
    }
    
    /**
     * Este metodo se encarga de crear los vecinos del Vertice
     * @param n2 El Vertice que va a ser el vecino
     * @param ub la orientacion de la arista
     */
    public void crear_vecinos(Vertice n2, int ub){
        Arista x = new Arista(this, n2, ub);
        int y = 0;
        while (vecinos[y]!=null){
            y++;
        }
        vecinos[y] = x;
    }
    
    /**
     * Este metodo se encarga de retornar la letra del vertice
     * @return letra del Vertice
     */
    public String get_dato(){
        return letra;
    }
    
    /**
     * Este metodo se encraga de retornar el estado en el que se encuentra el Vertice
     * @return visited El estado que se encuentra el Vertice
     */
    public boolean get_status(){
        return visited;
    }
    
    /**
     * Este metodo marca al Vertice como visitado
     */
    public void visit(){
        visited = true;
    }
    
    /**
     * Este metodo marca al Vertice como no visitado
     */
    public void desvisitar(){
        visited = false;
    }
    
}
