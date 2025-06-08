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
    private Arista aris1;
    private long startTime;
    private long endTime;
    
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
        for (int i = 0; i < 16; i++) {
            startTime = System.nanoTime();
            Vertice v1 = mG.get_vertice(i);
            boolean x = false;
            for (int j = 0; j < 9; j++) {
                if(v1.get_status() == false){
                    if(v1.dar_vecino(j)!= null){
                        aris1 = v1.dar_vecino(j);
                        Vertice  v2 = aris1.get_N2();
                        if (v2.get_status()== false){
                            for (int k = 0; k < palabras.length; k++) {
                                palabra = palabras[k];
                                boolean aux = false;
                                int u = 0;
                                while(this.ps[u]!=null){
                                    if (ps[u].equals(palabra)) {
                                        aux = true;
                                        break;
                                    }
                                    u++;
                                }
                                if(aux == false){
                                    String p = Character.toString(palabra.charAt(0))+Character.toString(palabra.charAt(1));
                                    String p2 = v1.get_dato()+v2.get_dato();
                                    if(p.equals(p2)){
                                        v1.visit();
                                        v2.visit();
                                        x = this.search(v2,2);
                                        if(x == true){
                                            endTime = System.nanoTime();
                                            u = 0;
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
            }
        } 
    }
         
    
    private boolean search(Vertice v1,int v){
        if(v < palabra.length()){
                for (int i = 0; i < 9; i++) {
                String y = Character.toString(palabra.charAt(v));
                if(v1.dar_vecino(i)!= null){
                    Arista aris2 = v1.dar_vecino(i);
                        Vertice  v2 = aris2.get_N2();
                        if(v2.get_status()== false){
                                if(v2.get_dato().equals(y)){
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
