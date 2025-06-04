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
    
    public DFS(Grafo G, Lista p){
        mG =G;
        palabras = new String[p.Tamaño()];
        tiempo = new double[7];
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
            if (mG.get_vertice(i).get_status()!= true){
                Vertice v1 = mG.get_vertice(i);
                boolean x = false;
                for (int j = 0; j < 9; j++) {
                    if (mG.get_vertice(i).get_status()!= true){
                        if(v1.dar_vecino(j)!= null){
                            aris1 = v1.dar_vecino(j);
                            Vertice  v2 = aris1.get_N2();
                            for (String palabra1 : palabras) {
                                palabra = palabra1;
                                String p = Character.toString(palabra.charAt(0))+Character.toString(palabra.charAt(1));
                                String p2 = v1.get_dato()+v2.get_dato();
                                if(p.equals(p2)){
                                    x = this.search(v2, aris1,1);
                                    if(x == true){
                                        endTime = System.nanoTime();
                                        while(this.ps[j]!=null){
                                        j++;
                                        }
                                        this.ps[j] = palabra;
                                        this.tiempo[j] = (double) endTime / 1_000_000_000.0;
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
        for (int i = 0; i < 9; i++) {
            if(v1.dar_vecino(i)!= null){
                if(this.aris1.igual(v1.dar_vecino(i).get_N2())!= true){
                    if((v1.dar_vecino(i).igual(aris1.get_N1()))== false){
                        Arista aris2 = v1.dar_vecino(i);
                        Vertice  v2 = aris2.get_N2();
                        if(v == palabra.length()-1){
                            if(v2.get_dato().equals(palabra.charAt(v))){
                                v2.visit();
                                return true;
                            }else{
                                return false;
                            }
                        }
                    }
                    else if(v1.dar_vecino(i)!= null){
                        Arista aris2 = v1.dar_vecino(i);
                        Vertice  v2 = aris1.get_N2();
                        if(v2.get_dato().equals(palabra.charAt(v))){
                            boolean x = this.search(v2,  aris2, v+1);
                            if(x == true){
                                v1.visit();
                                return true;
                            }
                        }
                    }else{
                        break;
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
