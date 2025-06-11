/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;
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
    private int[] posiciones;
    
    public DFS(Grafo G, Lista p){
        mG =G;
        palabras = new String[p.Tamaño()];
        tiempo = new double[7];
        ps = new String[7];
        this.Agregar_p(p);
        for (String palabra1 : palabras) {
            palabra = palabra1;
            this.searching();
        }
    }
    
    public DFS(Grafo G, String p){
        palabra = p;
        tiempo = new double[1];
        ps = new String[1];
        mG = G;
        posiciones = new int[7];
        this.Desvisitar();
        this.searching();
    }
    
    public void Visitar(){
        for (int j = 0; j < 7; j++) {
            if (j>0 && posiciones[j] == 0) {
                break;
            }
            mG.get_vertice(posiciones[j]).visit();
        }
    }
    
    private void Desvisitar(){
        int aux = 0;
            for (int i = 0; i < 16; i++) {
                if (mG.get_vertice(i).get_status() == true) {
                    mG.get_vertice(i).desvisitar();
                    posiciones[aux] = i;
                    aux++;
                }
            }
    }
    
    private void Agregar_p(Lista p){
        for (int i = 0; i < p.Tamaño(); i++) {
            palabras[i] = p.Datos(i);
        }
    }
    
    
    private void searching(){
        for (int i = 0; i < 16; i++) {
            long startTime = System.nanoTime();
            Vertice v1 = mG.get_vertice(i);
            boolean x = false;
            for (int j = 0; j < 8; j++) {
                if(v1.dar_vecino(j)!= null && v1.get_status() == false && v1.get_dato().equals(Character.toString(palabra.charAt(0)))){
                    Vertice  v2 = v1.dar_vecino(j);
                    if (v2.get_status()== false && v2.get_dato().equals(Character.toString(palabra.charAt(1)))){
                        boolean aux = false;
                        if(aux == false){
                            v1.visit();
                            v2.visit();
                            x = this.search(v2,2);
                            if(x == true){
                                long endTime = System.nanoTime();
                                int u = 0;
                                while(this.ps[u]!=null){
                                    u++;
                                }
                                this.ps[u] = palabra;
                                long elapsedTimeNanos = endTime - startTime;
                                this.tiempo[u] = (double) elapsedTimeNanos / 1000000000.0;
                                v1.visit();
                                v2.visit();
                                break;
                            }else{
                                v1.desvisitar();
                                v2.desvisitar();
                            }               
                        }
                    } 
                }
            }
        }
        } 
    
         
    
    private boolean search(Vertice v1,int v){
        if(v < palabra.length()){
            for (int i = 0; i < 8; i++) {
            String y = Character.toString(palabra.charAt(v));
            if(v1.dar_vecino(i)!= null){
                    Vertice  v2 = v1.dar_vecino(i);
                    if(v2.get_status()== false && v2.get_dato().equals(y)){
                        if(v == palabra.length()-1){
                            v2.visit();
                            return true;
                        }else{
                            v1.visit();
                            v2.visit();
                            boolean x = this.search(v2, v+1);
                            if(x == true){
                                return true; 
                            }else{

                                v2.desvisitar();

                            }
                        }
                    }
                }
            }   
        }return false;
    }
        
        
      

    public String[] get_palabras(){
        return ps;
    }
    
    public double[] get_time(){
        return tiempo;
    }
}
