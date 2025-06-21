/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras_de_datos;

/**
 * Clase que se encarga de crear la Estructura de Datos Lista
 * @author Diego Arreaza
 */
public class Lista<T>  {
    
    /**
     * pfirst es el primer Nodo de la Lista
     */
    private Nodo pfirst;
    /**
     * pfinal es el ultimo Nodo de la Lista
     */
    private Nodo pfinal;
    /**
     * pNew es el nuevo Nodo que se crea cuando se inserta un nuevo integrante a la Lista
     */
    private Nodo pNew; 
    /**
     * iN es el tamaño de la Lista
     */
    private int iN;

    /**
     * Constructor de la clase 
     */
    public Lista (){
        
        iN = 0;
        pfirst = null; 
        pfinal = null; 

    }

    /**
     * Este metodo se encarga de retornar el tamaño de la lista
     * @return iN tamaño de la Lista
     */
    public int Tamaño( ){
        return iN;
    }

    /**
     * Este metodo retorna el primero de la lista
     * @return pfirst primer Nodo de la Lista
     */
    public  Nodo Primero(){
        return pfirst;
    } 
    
    /**
     * Este metodo se encarga de agregar a la Lista al primer o los siguiwntwa Nodos de la Lista
     * @param x es el dato que pertenece al nuevo Nodo de la Lista
     */
    public void Insertar(T x){
        
        pNew = new Nodo(x);
        iN++;
        if(pfinal == null){
            this.pfirst = this.pfinal =pNew;
            
        }else{
            pNew.pPrevious = pfinal;
            pfinal.pNext = pNew;
            pfinal = pNew;
            }
        }   
        
    /**
     *Este metodo se encarga de retornar el dato del Nodo de la posicion del parametro posicion
     * @param posicion es la posicion del dato que se requiere 
     * @return aux.data el dato que se requiere
     */
    public T Datos(int posicion){
        Nodo aux = pfirst;
        if (posicion!= 0){ 
            for (int i = 0; i < posicion; i++) {
                aux = aux.pNext;
            }
        }
        return (T) aux.data;
    }
    
    /**
     * Este metodo se encarga de retornar al Nodo del parametro posicion que se requiere
     * @param posicion la ubicacion del Nodo que se requiere
     * @return aux el Nodo que se requiere
     */
    public Nodo Nodos(int posicion){
        Nodo aux = pfirst;
        if (posicion!= 0){ 
            for (int i = 0; i < posicion; i++) {
                aux = aux.pNext;
            }
        }
        return aux;
    }
}