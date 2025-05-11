/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopas_de_letras;

/**
 *
 * @author Windows 10 Pro
 */
public class Nodo<T> {
    
    protected T data;
    protected Nodo <T> pNext;
    
    Nodo(T elem){
        data=elem;
        pNext=null;
    }
    
    
    
}


