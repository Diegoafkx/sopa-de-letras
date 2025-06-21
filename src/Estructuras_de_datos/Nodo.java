package Estructuras_de_datos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase que crea los Nodos para las Clases Lista y Cola
 * @author Diego Arreaza
 * @param <T>
 */
public class Nodo<T> {
    
    /**
     * data es el dato que guarda el Nodo
     */
    protected T data;
    /**
     * pNext es el Nodo que le sigue en la estructuras de datos Lista
     */
    protected Nodo  pNext;
    /**
     * pPrevious es el Nodo que le antecede en la estructuras de datos Lista
     */
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
