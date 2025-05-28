/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

/**
 *
 * @author Windows 10 Pro
 */
public class Grafo {
    
    private Vertice[] Vertices = new Vertice[16];
    private Lista letras;
    
    public Grafo(Lista palabras){
    letras = palabras;    
    this.Crear_Vertices();
    
    }

    private void Crear_Vertices(){
        Vertice x;
        for (int i = 0; i < 15; i++) {
            x = new Vertice(letras.Nodos(i));
            Vertices[i] = x;
        }
        this.Crear_Aristas();
    }
    
    private void Crear_Aristas(){
        for (int i = 0; i < 16; i++) {
            if (i!=3 ||i!= 7 ||1!=11){
                Vertices[i].crear_vecinos(Vertices[i+1],0);
            }    
        }
        for (int i = 0; i < 16; i++) {
            if(i<=3){
                Vertices[i].crear_vecinos(Vertices[i+4],1);
            }
            else if(i>4&&i<=12){
                Vertices[i].crear_vecinos(Vertices[i+4],1);
                Vertices[i].crear_vecinos(Vertices[i-4],1);
            }else{
                Vertices[i].crear_vecinos(Vertices[i-4],1);
            }
        }
        for (int i = 0; i < 16; i++) {
            if(i != 0 || i != 4 || i!=8 || i!= 12){
                    Vertices[i].crear_vecinos(Vertices[i+5],2);
            }
            if(i != 3 || i!= 7 || i!= 11 || i!= 15){
                    Vertices[i].crear_vecinos(Vertices[i+3],3);   
            }
            
        }   
    }

}
