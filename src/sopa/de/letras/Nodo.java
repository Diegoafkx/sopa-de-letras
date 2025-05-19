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
    
    /**
     *
     */
    protected String data;

    /**
     *
     */
    protected Nodo  pNext;
    
    protected Nodo pPrevious;
    Nodo(String elem){
        data=elem;
        pNext=null;
        pPrevious = null;
    }
}