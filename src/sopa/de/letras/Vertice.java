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
    private Arista[] vecinos;
    private String letra;

    public Vertice(Nodo n1){
        vecinos = new Arista[9]; 
        letra = n1.data;
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
}
