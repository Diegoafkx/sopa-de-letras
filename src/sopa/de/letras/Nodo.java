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
    
    protected String data;
    protected Nodo  pNext;
    
    Nodo(String elem, Nodo sig){
        data=elem;
        pNext=sig;
    }
    
    
    
}