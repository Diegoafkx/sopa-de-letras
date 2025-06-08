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
    private int in;
    private Vertice pFirst;
    private Vertice pFinal;
    public Cola() {
        pFirst = null;
        pFinal = null;
        in =0;
    }
    
    private void insertar(Vertice v){
        if (pFinal == null) {
            pFinal = v;
            pFirst = v;
        }else{
            pFinal.pNext= v;
            pFinal = v;
        }   
        in = in+1;
    }
    
    public int Tamaño(){
     return in;   
    }
    
    public Vertice desencolar(){
        Vertice ptemp = pFirst;
        pFirst = pFirst.pNext;
        return ptemp;
    }
    
    public void encolar(Vertice v){
        this.insertar(v);
    }
    
}
