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

    
    public Grafo(Lista letras){
        this.letras = letras;
        for (int i = 0; i < 16; i++) {
            double aleatorio1 = Math.random()*100;
            double aleatorio2 = Math.random()*100;
            while(aleatorio1 > this.letras.Tamaño()){
                aleatorio1 = Math.random()*100;
            }
            while(aleatorio2 > this.letras.Tamaño()){
                aleatorio2 = Math.random()*100;
            }
            int a1= (int) aleatorio1;
            int b1 = (int) aleatorio2;
            this.letras.Desorganizar(a1, b1);
        }
        
        this.Crear_Vertices();
    }
    
    private void Crear_Vertices(){
        Vertice x;
        for (int i = 0; i < 16; i++) {
            x = new Vertice(letras.Nodos(i)); 
            Vertices[i] = x;
        }
        this.Crear_Aristas();
    }
    
        private void Crear_Aristas(){

        for (int i = 0; i < 16; i++) {

            if (i!=3 ||i!= 7 ||i!=11){

                Vertices[i].crear_vecinos(Vertices[i+1],0);
            }
            if(i!=0 || i!= 4 ||i!=8){  
                Vertices[i].crear_vecinos(Vertices[i-1],0);
            }  

        }

        for (int i = 0; i < 16; i++) {

            if(i<=3){
                Vertices[i].crear_vecinos(Vertices[i+4],1);
            }
            if(i<=12){
                Vertices[i].crear_vecinos(Vertices[i-4],1);
            }
        }

        for (int i = 0; i < 16; i++) {

            if(i != 0 || i != 4 || i!=8 || i!= 12){
                    Vertices[i].crear_vecinos(Vertices[i+5],2);
            }
            if(i != 3 || i!= 7 || i!= 11 || i!= 15){
                if (i == 0){
                    for (int j = 5; j <= 15; j = j+5) {
                        Vertices[i].crear_vecinos(Vertices[j],2);
                    }
                }else{
                    for (int j = 0; j <= 15; j = i+5) {    
                    }   
                }
                    Vertices[i].crear_vecinos(Vertices[i+3],3);
            }
        }   
    }   
    /**
     *
     * @param i
     * @return
     */
    public Vertice get_vertice(int i){
        return Vertices[i];
    }

}
