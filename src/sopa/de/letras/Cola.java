/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

/**
 *
 * @author diego
 */
public class Cola {
    private int in = 0;
    private Nodo pFirst;
    private Nodo pFinal;
    public Cola() {
        pFirst = null;
        pFinal = null;
    }
    
    public void encolar(Nodo n){
        if (pFinal == null) {
            pFinal = n;
            pFirst = n;
        }else{
            pFinal.pNext= n;
            pFinal = n;
        }   
        in++;
    }
    
    public int Tamaño(){
     return in;   
    }
    
    public Nodo desencolar(){
        Nodo ptemp = pFirst;
        pFirst = pFirst.pNext;
        ptemp.pNext = null;
        in--;
        return ptemp;
    }
    
}
