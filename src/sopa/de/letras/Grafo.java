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
    private Lista palabras;

    
    public Grafo(Lista letras, Lista palabras){ 
        this.palabras = palabras;
        this.tamanio_de_ps(letras);
    }
    
    private void tamanio_de_ps(Lista letras){
        int aux = 0;
        for (int i = 0; i < 16; i++) {
            if(i < palabras.Tamaño()){
                aux = aux + palabras.Datos(i).length();
                for (int j = 0; j < palabras.Datos(i).length(); j++) {
                    this.letras.Insertar(Character.toString(palabras.Datos(i).charAt(j)));
                }
            }else{
                double z = Math.random()*10;
                while(z>letras.Tamaño()){
                    z = Math.random()*10;
                }
                int y = (int) z;
                this.letras.Insertar(letras.Datos(y));
            }
        }this.Crear_Vertices(aux);
    }
    
    private void Crear_Vertices(int aux){
        Vertice x;
        for (int i = 0; i < 16; i++) {
                x = new Vertice(letras.Nodos(i));
                Vertices[i] = x;
        }
        this.Crear_Aristas(aux);
        
    }
    
    private void Crear_Aristas(int aux){
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
            if(i != 3 || i!= 7 || i!= 11 || i!= 15){
                    Vertices[i].crear_vecinos(Vertices[i+5],2);
            }
            if(i != 0 || i != 4 || i!=8 || i!= 12){
                    Vertices[i].crear_vecinos(Vertices[i+3],3);   
            }
            
        }   
    }
    
    public Vertice get_vertice(int i){
        Vertice aux = Vertices[0];
        for (int j = 0; j < i; j++) {
            aux = Vertices[j];
        }
        return aux;
    }

}
