/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

/**
 *
 * @author diego
 */
public class BFS {
    private String[] ps;
    private String[] palabras;
    private Boolean[] time;
    private Grafo gf;
    private String palabra;
    public BFS(Grafo g, Lista p){
        gf = g;
        Agregar_p( p);
    }
    
    public BFS(Grafo g, String p){
        gf = g;
        palabra = p;
    }
    private void Agregar_p(Lista p){
        for (int i = 0; i < p.Tamaño(); i++) {
            palabras[i] = p.Datos(i);
        }
    }
    
    private void Solucion(){
        
    }
}
