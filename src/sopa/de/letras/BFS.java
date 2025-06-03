/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class BFS {
    
    private Grafo mG;
    private String[] palabras;
    private String palabra;
    private ArrayList<boolean> estado = new ArrayList<boolean>();
    
    public BFS(Grafo G, Lista p){
        mG =G;
        palabras = new String[p.Tamaño()];
        this.Agregar_p(p);
        this.searching();
    }
    
    public BFS(Grafo G, String p){
        palabra = p;
        mG = G;
    }
    
    private void Agregar_p(Lista p){
        for (int i = 0; i < p.Tamaño(); i++) {
            palabras[i] = p.Datos(i);
        }
    }
    
    private void searching(){
        for (int i = 0; i < 16; i++) {
            if (mG.get_vertice(i).get_status()!= true){
                Vertice aux = mG.get_vertice(i);
                for (int j = 0; j < 9; j++) {
                    Vertice sig = aux.dar_vecino(i);
                    for (int z = 0; z < palabras.length; z++) {
                        String p = palabras[z];
                        if(((String)p.charAt(1)+(String)p.charAt(2)).equal(aux.get_dato() +sig.get_dato())){
                            
                        }
                    }
                }
            }
        }
        
    }
    
    private void search(Vertice x, Vertice sig){
        
    }
}
