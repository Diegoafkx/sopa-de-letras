/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;
import java.lang.System;
/**
 *
 * @author diego
 */
public class DFS {
    
    private Grafo mG;
    private String[] palabras;
    private String palabra;
    private double[] tiempo;
    private String[] ps;
    private Arista aris1;
    private long startTime;
    private long endTime;
    private Vertice v1; 
    
    public DFS(Grafo G, Lista p){
        mG =G;
        palabras = new String[p.Tamaño()];
        tiempo = new double[7];
        ps = new String[7];
        this.Agregar_p(p);
        this.searching();
    }
    
    public DFS(Grafo G, String p){
        palabra = p;
        mG = G;
    }
    
    private void Agregar_p(Lista p){
        for (int i = 0; i < p.Tamaño(); i++) {
            palabras[i] = p.Datos(i);
        }
    }
    
    private void searching(){
        
        startTime = System.nanoTime();
        for (int i = 0; i < 16; i++) {
            if (mG.get_vertice(i).get_status()== false){
                v1 = mG.get_vertice(i);
                boolean x = false;
                for (int j = 0; j < 9; j++) {
                    if(v1.dar_vecino(j)!= null){
                        aris1 = v1.dar_vecino(j);
                        if (aris1.get_N2().get_status()== false){
                            Vertice  v2 = aris1.get_N2();
                            for (String palabra1 : palabras) {
                                palabra = palabra1;
                                String p = Character.toString(palabra.charAt(0))+Character.toString(palabra.charAt(1));
                                String p2 = v1.get_dato()+v2.get_dato();
                                if(p.equals(p2)){
                                    x = this.search(v2, aris1,2);
                                    if(x == true){
                                        endTime = System.nanoTime();
                                        while(this.ps[j]!=null){
                                        j++;
                                        }
                                        this.ps[j] = palabra;
                                        long elapsedTimeNanos = endTime - startTime;
                                        this.tiempo[j] = (double) elapsedTimeNanos / 1000000000.0;
                                        v1.visit();
                                        v2.visit();

                                        break;
                                    }
                                }        
                            }
                        }
                    }   
                }
            }
        }
    }  
    
    private boolean search(Vertice v1, Arista aris1,int v){
        if(v<palabra.length()){
            for (int i = 0; i < 9; i++) {
                String y = Character.toString(palabra.charAt(v));
                if(v1.dar_vecino(i)!= null){

                    if(this.aris1.igual(v1.dar_vecino(i).get_N2())!= true){
                        if((v1.dar_vecino(i).igual(aris1.get_N1()))== false){
                            Arista aris2 = v1.dar_vecino(i);
                            if(this.v1 != aris2.get_N2()){
                                if (aris2.get_N2().get_status()== false){
                                    Vertice  v2 = aris2.get_N2();
                                    if(v2.get_dato().equals(y)){
                                        if(v == palabra.length()-1){
                                            v2.visit();
                                            return true;
                                        }
                                        else{
                                        boolean x = this.search(v2,  aris2, v+1);
                                        if(x == true){
                                            v1.visit();
                                            return true; 
                                        }

                                        }
                                    }
                                }else{
                                    break;
                                }
                            }
                        }
                    }   
                }
            }
        }
        return false; 
    }  

    public String[] get_palabras(){
        return ps;
    }
    
    public double[] get_time(){
        return tiempo;
    }
}
