/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras_de_datos;

/**
 * Clase que se encarga de crear la Estructura de Datos cola para el metodo de busqueda BFS
 * @author Diego Arreaza
 * @param <T>
 */
public class Cola<T> {
    /**
     * in Es el tamaño de la cola
     */
    private int in = 0;
    /**
     * pFirst es el Nodo inicial de la cola
     */
    private Nodo pFirst;
    /**
     * pFirst es el Nodo final de la cola
     */
    private Nodo pFinal;
    
    /**
     * Constructor de la clase
     */
    public Cola() {
        pFirst = null;
        pFinal = null;
    }
    
    /**
     * Aqui Se inicializa la cola o se agrega el siguiente en la cola
     * @param v es el dato que se va a agregar a la cola
     */
    public void encolar(T v){
        Nodo n = new Nodo(v);
        if (pFinal == null) {
            pFinal = n;
            pFirst = n;
        }else{
            pFinal.pNext= n;
            pFinal = n;
        }   
        in++;
    }

    /**
     * Este metodo se encarga de retornar el tamaño de la cola
     * @return in el tamaño de la cola
     */
    public int Tamaño(){
     return in;   
    }
    
    /**
     * Este metodo se encarga de sacar al primero de la cola y retornarlo 
     * @return ptemp.v es el Vertice del primero de la cola
     */
    public T desencolar(){
        Nodo ptemp = pFirst;
        pFirst = pFirst.pNext;
        ptemp.pNext = null;
        in--;
        return (T) ptemp.data;
    }
    
}
