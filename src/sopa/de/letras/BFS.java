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
    private Vertice v1,v2,v3;
    
    
    public BFS(Grafo g, Lista p){
        gf = g;
        this.Agregar_p( p);
        this.Solucion();
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
        for (String palabra1 : palabras) {
            palabra = palabra1;   
            long StartTime = System.nanoTime();
            for (int i = 0; i < 16; i++) {
                v1 = gf.get_vertice(i);
                if(v1.get_status()==false){
                    Cola v2s= new Cola();
                    Cola v3s= new Cola();
                    Cola v4s= new Cola(); 
                    for (int j = 0; j<8; j++) {
                        if (v1.dar_vecino(j)!=null && v1.dar_vecino(j).get_status() ==false ) {
                            v2s.encolar(v1.dar_vecino(j));
                        }
                    
                    v2 = v2s.desencolar();
                    for (int k = 0; k<8; k++) {
                        if (v1!=v2.dar_vecino(k) && v2.dar_vecino(k)!=null && v2.dar_vecino(k).get_status()== false) {
                           v3s.encolar(v2.dar_vecino(k)); 
                        }
                        
                    
                    v3 = v3s.desencolar();
                    for (int l = 0; l<8; l++) {
                        v4s.encolar(v3s.desencolar());
                    }
                    } 
                    }
                }
            }
        }
    }
    
    private void searching(Vertice v){
        
    }
}
