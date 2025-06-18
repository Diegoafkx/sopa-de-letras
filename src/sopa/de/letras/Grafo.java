/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

/**
 * Clase que se  encarga de crear el grafo para la sopa de letras
 * @author Diego Arreaza
 */
public class Grafo {
    /**
     * Atributos de la clase
     * Vertices es una matriz que contiene todos los Vertices de l sopaa de letras 
     */
    private final Vertice[] Vertices = new Vertice[16];

    /**
     * Constructor de la sopa de letras y que aleatoriza el orden de la sopa de letras
     * @param letras Lista de las 16 letras que estaran en la sopa de letras
     */
    public Grafo(Lista letras){
        for (int i = 0; i < 16; i++) {
            Vertice x = new Vertice(letras.Nodos(i));
            Vertices[i] = x;
        }
        for (int i = 0; i < 16; i++) {
            double aleatorio1 = Math.random()*100;
            double aleatorio2 = Math.random()*100;
            while(aleatorio1 > letras.Tamaño()){
                aleatorio1 = Math.random()*100;
            }
            while(aleatorio2 > letras.Tamaño()){
                aleatorio2 = Math.random()*100;
            }
            int a1= (int) aleatorio1;
            int b1 = (int) aleatorio2;
            if(a1 != b1){
                Vertice x1 = Vertices[a1];
                Vertice x2 = Vertices[b1];
                Vertices[a1] = x2;
                Vertices[b1] = x1;
                
            }else{
                i--;
            }
        }
        this.Crear_Aristas();
    }
    
    /**
     * Este metodo se encarga de crear las aristas de cada vertice de la matriz Vertices
     */
    private void Crear_Aristas(){

        for (int i = 0; i < 16; i++) {

            if (i!=3 && i!= 7 && i!=11 && i!=15){
                Vertices[i].crear_vecinos(Vertices[i+1],0);
            }
            if(i != 0 && i != 4 && i!=8 && i!= 12){  
                Vertices[i].crear_vecinos(Vertices[i-1],0);
            }  
            if(i<=11){
                Vertices[i].crear_vecinos(Vertices[i+4],1);
            }
            if(i >= 4){
                Vertices[i].crear_vecinos(Vertices[i-4],1);
            }
            if(i != 3 && i!= 7 && i<11){
                Vertices[i].crear_vecinos(Vertices[i+5],2);
            }
            if(i != 0 && i != 4 && i!=8 && i<12){
                
                Vertices[i].crear_vecinos(Vertices[i+3],3);
            }
            if(i>= 5 && i!=8 && i !=12){
                Vertices[i].crear_vecinos(Vertices[i-5],2);
            }
            if(i>3&& i!= 7 && i !=11 && i!= 15){
                
                Vertices[i].crear_vecinos(Vertices[i-3],3);
            }
        }
    }   
    
    /**
     * Este metodo retorna el vertice que se encuentra en la ubicacion i de la matriz Vertices
     * @param i indice de la ubicacion del vertice del que se requiere 
     * @return el vertice de la ubicacion i
     */
    public Vertice get_vertice(int i){
        return Vertices[i];
    }
    
}
