/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

/**
 * Clase que se encarga de realizar la busqueda Breadth First Search mediante el uso de colas 
 * @author Diego Arreaza
 */
public class BFS {
    
    /**
     * Atributos de clase
     * ps contiene las palabras encontradas de la sopa de letras
     * palabras contiene las palabras del diccionario.txt
     * time contiene el tepo en milisegundos en la que cada palabra se encontro
     * gf contiene el grafo de la sopa de letras
     * palabra contiene la palabra ue se esta buscando
     * v1 es el primer vertice con el que se esta intenado formar la palabra
     * v2 es el segundo vertice con el que se esta intenado formar la palabra
     * v3 es el tercer vertice con el que se esta intenado formar la palabra
     * v4 es el cuarto vertice con el que se esta intenado formar la palabra
     * posiciones contiene la posicion de los vertices que orman las letras para auxiliar al momento de uscar una palara escrita por el usuario
     */
    private String[] ps;
    private String[] palabras;
    private double[] time;
    private Grafo gf;
    private String palabra;
    private Vertice v1,v2,v3,v4 = null;
    private int[] posiciones;
    
    /**
     * constructor de la clase cuando se le entrega el parametro tipo garfo y tipo Lista
     * llama al metodo Search para iniciar la busqueda
     * @param g es el grafo que se le va a asignar a gf
     * @param p  es la Lista con las palabras dl diccionario.txt
     */
    public BFS(Grafo g, Lista p){
        gf = g;
        palabras = new String[p.Tamaño()];
        time = new double[7];
        ps = new String[7];
        this.Agregar_p( p);
        for (String palabra1 : palabras) {
            palabra = palabra1;
            this.Search();
        }
    }
    
    /**
     * constructor de la clase cuando se le entrega el parametro grafo y p
     * llama al metodo Search para iniciar la busqueda
     * @param g es el grafo que se le va a asignar a gf
     * @param p  es la Lista con las palabras dl diccionario.txt
     */
    public BFS(Grafo g, String p){
        gf = g;
        palabra = p;
        time = new double[1];
        ps = new String[1];
        posiciones = new int[7];
        this.Desvisitar();
        this.Search();    
    }
    
    /**
     * Este metodo se encarga de re-marcar como visitado los vectores de la ubicaciones de la matriz posiciones
     */
    public void Visitar(){
        for (int j = 0; j < 7; j++) {
            if (j>0 && posiciones[j] == 0) {
                break;
            }
            gf.get_vertice(posiciones[j]).visit();
        }
    }
    
    /**
     * Este metodo se encarga de asignar la ubicacion de los vertices que han sido visitados en la matriz posiciones
     * luego los desmarca, esto para haer mas visual la busueda de la palabra que el usuario ingreso
     */
    private void Desvisitar(){
        int aux = 0;
            for (int i = 0; i < 16; i++) {
                if (gf.get_vertice(i).get_status() == true) {
                    gf.get_vertice(i).desvisitar();
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
            palabras[i] = p.Datos(i);
        }
    }
    
    /**
     * Metodo se encarga de realizar  la  busqueda 
     */
    private void Search(){
        String aux = "";
        String s = Character.toString(palabra.charAt(0));
        long StartTime = System.nanoTime();
        for (int i = 0; i < 16; i++) {
            v1 = gf.get_vertice(i);
            if(s.equals(v1.get_dato())){
                Cola v2s= new Cola();
                for (int j = 0;j<8; j++) {
                    if (v1.dar_vecino(j)!=null) {
                        v2s.encolar(v1.dar_vecino(j)); 

                    }
                }
                int t2 = v2s.Tamaño();
                for (int j = 0; j < t2; j++) {
                    v2 = v2s.desencolar().v;
                    Cola v3s= new Cola();
                    for (int k = 0; k<8; k++) {
                        if (v1!=v2.dar_vecino(k) && v2.dar_vecino(k)!=null) {
                            v3s.encolar(v2.dar_vecino(k));
                        }
                    }
                    int t3 = v3s.Tamaño();
                    for (int k = 0; k < t3; k++) {
                        v3 = v3s.desencolar().v;
                        aux =v1.get_dato() +v2.get_dato()+v3.get_dato();
                        if(palabra.length()==4){
                            Cola v4s= new Cola();
                            for (int l = 0; l<8; l++) {
                                if (v2!=v3.dar_vecino(l)&&v1!=v3.dar_vecino(l) && v3.dar_vecino(l)!=null) {
                                    v4s.encolar(v3.dar_vecino(l));   
                                }
                            }
                            int t4 = v4s.Tamaño();
                            for (int l = 0; l < t4; l++) {
                                v4 = v4s.desencolar().v;
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
                                    return;
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
                                return;
                            }
                        }              
                    }
                }
            }
        }
    }
    
    /**
     * Este metodo se  encarga  de retornar la matriz con el tiempo en el que se encontro cada palabra
     * @return time[] tiempo en el que se encontro la palabra
     */
    public double[] get_time(){
        return time;
    }
    
    /**
     * Este metodo se  encarga  de retornar la matriz con las palabras que se encontraron en la sopa de letras
     * @return ps[] las palabras que se encontraron en la sopa de letras
     */
    public String[] get_palabras(){
        return ps;
    }
}
