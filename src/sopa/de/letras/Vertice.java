/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

/**
 *
 * @author Windows 10 Pro
 */
public class Vertice {
    private final Arista[] vecinos;
    private final String letra;
    private boolean visited;
    protected Vertice pNext;
    private Nodo Nod;

    public Vertice(Nodo n1){
        vecinos = new Arista[8];
        Nod = n1;
        letra = n1.data;
        visited = false;
        pNext = null;
    } 
    
    public Vertice dar_vecino(int p){
        if (vecinos[p]==null) {
            return null;
        }
        return vecinos[p].get_N2();
    }
    
    public void crear_vecinos(Vertice n2, int ub){
        Arista x = new Arista(this, n2, ub);
        int y = 0;
        while (vecinos[y]!=null){
            y++;
        }
        vecinos[y] = x;
    }
    
    public String get_dato(){
        return letra;
    }
    
    public boolean get_status(){
        return visited;
    }
    
    public void visit(){
        visited = true;
    }
    public void desvisitar(){
        visited = false;
    }
    
    public Nodo get_Nodo(){
        return Nod;
    }
}
