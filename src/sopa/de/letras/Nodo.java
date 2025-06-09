/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

/**
 *
 * @author Windows 10 Pro
 */
public class Nodo {
    protected Vertice v;
    /**
     *
     */
    protected String data;

    /**
     *
     */
    protected Nodo  pNext;
    
    protected Nodo pPrevious;
    
    public Nodo(String elem){
        data=elem;
        pNext=null;
    }
    
    public Nodo (Vertice v){
        this.v = v;
    }
}