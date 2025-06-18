/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

import org.graphstream.graph.Node;

/**
 * Clase que crea los Nodos para las Clases Lista y Cola
 * @author Diego Arreaza
 */
public class Nodo {
    
    /**
     * Atributos de la clase
     * v es Vertice que contiene cuando se usa la Estructura de Datos Cola
     * data es el dato que guarda el Nodo
     * pNext es el Nodo que le sigue en la estructuras de datos Lista
     * pPrevious es el Nodo que le antecede en la estructuras de datos Lista
     */
    protected Vertice v;
    protected String data;
    protected Nodo  pNext;
    protected Nodo pPrevious;
    protected Node n;
    
    /**
     * Constructor de la clase cuando se usar para la estructura de datos Lista
     * @param elem es el dato que guarda el Nodo
     */
    public Nodo(String elem){
        data=elem;
        pNext=null;
    }
    
    /**
     * Constructor de la clase cuando se usar para la estructura de datos Cola
     * @param v es el Vertice que guarda el Nodo
     */
    public Nodo (Vertice v){
        this.v = v;
    }

    Nodo(Node n) {
        this.n = n;
    }
}