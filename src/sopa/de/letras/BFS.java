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
    private double[] time;
    private Grafo gf;
    private String palabra;
    private Vertice v1,v2,v3,v4 = null;
    private long StartTime;
    public BFS(Grafo g, Lista p){
        gf = g;
        palabras = new String[p.Tamaño()];
        time = new double[7];
        ps = new String[7];
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
        String aux = "";
        for (String palabra1 : palabras) {
            palabra = palabra1;
            String s = Character.toString(palabra.charAt(0));
            StartTime = System.nanoTime();
            for (int i = 0; i < 16; i++) {
                if(aux.equals(palabra)){
                    break;
                }
                v1 = gf.get_vertice(i);
                v1.Poner_Nod();
                if(v1.get_status()==false && s.equals(v1.get_dato())){
                    Cola v2s= new Cola();
                    String[] inc = new String[8];
                    for (int j = 0;j<8; j++) {
                        if (v1.dar_vecino(j)!=null && v1.dar_vecino(j).get_status() ==false ) {
                            v2s.encolar(v1.dar_vecino(j).Dar_Nodo()); 
                            int o = 0;
                            while(inc[o]!=null){
                            o++;
                            }
                            inc[o] = Integer.toString(j);
                            
                        }
                    }
                    for (int j = 0; j < v2s.Tamaño(); j++) {
                        if(aux.equals(palabra)){
                            break;
                        }
                        v2 = v2s.desencolar().v;
                        v2.Poner_Nod();
                        String[] inx = new String[8];
                        Cola v3s= new Cola();
                        for (int k = 0; k<8; k++) {
                            if (v1!=v2.dar_vecino(k) && v2.dar_vecino(k)!=null && v2.dar_vecino(k).get_status()== false) {
                                v3s.encolar(v2.dar_vecino(k).Dar_Nodo());
                                int o = 0;
                                while(inx[o]!=null){
                                o++;
                                }
                                inx[o] = Integer.toString(k);
                            }
                        }
                        for (int k = 0; k < v3s.Tamaño(); k++) {
                            if(aux.equals(palabra)){
                                break;
                            }   
                            v3 = v3s.desencolar().v;
                            v3.Poner_Nod();
                            aux =v1.get_dato() +v2.get_dato()+v3.get_dato();
                            if(palabra.length()==4){
                                Cola v4s= new Cola();
                                String[] inv = new String[8];
                                for (int l = 0; l<8; l++) {
                                    if (v2!=v3.dar_vecino(l)&&v1!=v3.dar_vecino(l) && v3.dar_vecino(l)!=null && v3.dar_vecino(l).get_status()== false) {
                                        v4s.encolar(v3.dar_vecino(l).Dar_Nodo());   
                                        int o = 0;
                                        while(inv[o]!=null){
                                        o++;
                                        }
                                        inv[o] = Integer.toString(l);
                                    }
                                }
                                for (int l = 0; l < v4s.Tamaño(); l++) {
                                    v4 = v4s.desencolar().v;
                                    v4.Poner_Nod();
                                    aux =v1.get_dato() +v2.get_dato()+v3.get_dato()+v4.get_dato();
                                    if(aux.equals(palabra)){
                                        long endTime = System.nanoTime();
                                        long elapsedTimeNanos = endTime - StartTime;
                                        v1.visit();
                                        v2.visit();
                                        v3.visit();
                                        if(palabra.length()==4){
                                            v4.visit();
                                        }
                                        int m = 0;
                                        while(ps[m]!=null){
                                            m++;
                                        }
                                        ps[m] = palabra;
                                        time[m] = (double) elapsedTimeNanos / 1000000000.0;
                                    }
                                    if(aux.equals(palabra)){
                                        break;
                                    }      
                                }
                            }else{
                                if(aux.equals(palabra)){
                                    long endTime = System.nanoTime();
                                    long elapsedTimeNanos = endTime - StartTime;
                                    v1.visit();
                                    v2.visit();
                                    v3.visit();
                                    if(palabra.length()==4){
                                        v4.visit();
                                    }
                                    int m = 0;
                                    while(ps[m]!=null){
                                        m++;
                                    }
                                    ps[m] = palabra;
                                    time[m] = (double) elapsedTimeNanos / 1000000000.0;
                                }
                            }
                        }              
                    }
                }
            }
        }
    }
    
    public double[] get_time(){
        return time;
    }
    
    public String[] get_palabras(){
        return ps;
    }
}
