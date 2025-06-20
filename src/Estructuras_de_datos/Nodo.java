package Estructuras_de_datos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import org.graphstream.graph.Node;

/**
 * Clase que crea los Nodos para las Clases Lista y Cola
 * @author Diego Arreaza
 * @param <T>
 */
public class Nodo<T> {
    
    /**
     * Atributos de la clase
     * data es el dato que guarda el Nodo
     * pNext es el Nodo que le sigue en la estructuras de datos Lista
     * pPrevious es el Nodo que le antecede en la estructuras de datos Lista
     */
    protected T data;
    protected Nodo  pNext;
    protected Nodo pPrevious;
    
    /**
     * Constructor de la clase cuando se usar para la estructura de datos Lista
     * @param elem es el dato que guarda el Nodo
     */
    public Nodo(T elem){
        data=elem;
        pNext=null;
    }
}
