/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos_de_busqueda;

import Estructuras_de_datos.Grafo;
import Estructuras_de_datos.Lista;
import Estructuras_de_datos.Vertice;

/**
 * Clase que se encarga del metodo de busqueda DFS
 * @author Diego Arreaza
 */
public class DFS {
    /**
     * mG contiene el grafo de la sopa de letras
     */
    private Grafo mG;
    /**
     * palabras contiene las palabras del diccionario.txt
     */
    private String[] palabras;
    /**
     * palabra contiene la palabra que se esta buscando
     */
    private String palabra;
    /**
     *  tiempo contiene el tepo en milisegundos en la que cada palabra se encontro
     */
    private double[] tiempo;
    /**
     * ps contiene las palabras que se encontraros
     */
    private String[] ps;
    /**
     * posiciones contiene la posicion de los vertices que orman las letras para auxiliar al momento de uscar una palara escrita por el usuario
     */
    private int[] posiciones;
    /**
     * v1 es el primer vertice con el que se esta intenado formar la palabra
     * v2 es el segundo vertice con el que se esta intenado formar la palabra
     */
    private Vertice v1, v2;
    
    /**
     * constructor de la clase cuando se le entrega el parametro tipo garfo y tipo Lista
     * llama al metodo Search para iniciar la busqueda
     * @param G es el grafo que se le va a asignar a gf
     * @param p  es la Lista con las palabras dl diccionario.txt
     */
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
    
    /**
     * constructor de la clase cuando se le entrega el parametro grafo y p
     * llama al metodo Search para iniciar la busqueda
     * @param G es el grafo que se le va a asignar a gf
     * @param p  es la Lista con las palabras dl diccionario.txt
     */
    public DFS(Grafo G, String p){
        palabra = p;
        tiempo = new double[1];
        ps = new String[1];
        mG = G;
        posiciones = new int[7];
        this.Desvisitar();
        this.searching();
    }
    
    /**
     * Este metodo se encarga de re-marcar como visitado los vectores de la ubicaciones de la matriz posiciones
     */
    public void Visitar(){
        for (int j = 0; j < 7; j++) {
            if (j>0 && posiciones[j] == 0) {
                break;
            }
            mG.get_vertice(posiciones[j]).visit();
        }
    }
    
    /**
     * Este metodo se encarga de asignar la ubicacion de los vertices que han sido visitados en la matriz posiciones
     * luego los desmarca, esto para haer mas visual la busueda de la palabra que el usuario ingreso
     */
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
    
    /**
     * Este emtodo agrega las palabras a un arrau para facilitar el metodo Seacrh 
     * @param p Lista de las palabras
     */
    private void Agregar_p(Lista p){
        for (int i = 0; i < p.Tamaño(); i++) {
            palabras[i] = (String) p.Datos(i);
        }
    }
    
    /**
     * Metodo se encarga de realizar  la  busqueda de los 2 primeros vertices
     */
    private void searching(){
        for (int i = 0; i < 16; i++) {
            long startTime = System.nanoTime();
            v1 = mG.get_vertice(i);
            for (int j = 0; j < 8; j++) {
                if(v1.dar_vecino(j)!= null && v1.get_dato().equals(Character.toString(palabra.charAt(0)))){
                    v2 = v1.dar_vecino(j);
                    if (v2.get_dato().equals(Character.toString(palabra.charAt(1)))){
                        boolean aux = false;
                        if(aux == false){
                            boolean x = this.search(v2,2);
                            if(x == true){
                                long endTime = System.nanoTime();
                                int u = 0;
                                while(this.ps[u]!=null){
                                    u++;
                                }
                                this.ps[u] = palabra;
                                long elapsedTimeNanos = endTime - startTime;
                                this.tiempo[u] = (double) elapsedTimeNanos / 1000000.0;
                                v1.visit();
                                v2.visit();
                                return;
                            }      
                        }
                    } 
                }
            }
        }
    } 
    
    /**
     * Metodo se encarga de finaalizar la busqueda de los ultimos vertices
     */
    private boolean search(Vertice v1,int v){
        if(v < palabra.length()){
            for (int i = 0; i < 8; i++) {
            String y = Character.toString(palabra.charAt(v));
            if(v1.dar_vecino(i)!= null ){
                    Vertice  v3 = v1.dar_vecino(i);
                    if(v3.get_dato().equals(y) && v3 != this.v1 && v3 != this.v2 ){
                        if(v == palabra.length()-1){
                            v1.visit();
                            v3.visit();
                            return true;
                        }else{
                            boolean x = this.search(v3, v+1);
                            if(x == true){
                                return true; 
                            }
                        }
                    }
                }
            }   
        }return false;
    }
      
    /**
     * Este metodo se  encarga  de retornar la matriz con las palabras que se encontraron en la sopa de letras
     * @return ps[] las palabras que se encontraron en la sopa de letras
     */
    public String[] get_palabras(){
        return ps;
    }
    
    /**
     * Este metodo se  encarga  de retornar la matriz con el tiempo en el que se encontro cada palabra
     * @return tiempo[] tiempo en el que se encontro la palabra
     */ 
    public double[] get_time(){
        return tiempo;
    }
}
