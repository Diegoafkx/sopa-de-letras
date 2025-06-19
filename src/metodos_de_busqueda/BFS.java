/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos_de_busqueda;

import Estructuras_de_datos.Cola;
import Estructuras_de_datos.Grafo;
import Estructuras_de_datos.Lista;
import Estructuras_de_datos.Vertice;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
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
    private Graph grafo;
    private boolean option;
    
    /**
     * constructor de la clase cuando se le entrega el parametro tipo garfo y tipo Lista
     * llama al metodo Search para iniciar la busqueda
     * @param g es el grafo que se le va a asignar a gf
     * @param p  es la Lista con las palabras dl diccionario.txt
     */
    public BFS(Grafo g, Lista p){
        gf = g;
        option = false;
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
        option = true;
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
                Cola v2x = new Cola();
                for (int j = 0;j<8; j++) {
                    if (v1.dar_vecino(j)!=null) {
                        v2s.encolar(v1.dar_vecino(j)); 
                        v2x.encolar(v1.dar_vecino(j)); 
                    }
                }
                
                int t2 = v2s.Tamaño();
                for (int j = 0; j < t2; j++) {
                    v2 = v2s.desencolar().v;
                    Cola v3s= new Cola();
                    Cola v3x = new Cola();
                    for (int k = 0; k<8; k++) {
                        if (v1!=v2.dar_vecino(k) && v2.dar_vecino(k)!=null) {
                            v3s.encolar(v2.dar_vecino(k));
                            v3x.encolar(v2.dar_vecino(k));
                        }
                    }
                    int t3 = v3s.Tamaño();
                    for (int k = 0; k < t3; k++) {
                        v3 = v3s.desencolar().v;
                        aux =v1.get_dato() +v2.get_dato()+v3.get_dato();
                        Cola v4s= new Cola();
                        Cola v4x = new Cola();
                        if(palabra.length()==4){
                            for (int l = 0; l<8; l++) {
                                if (v2!=v3.dar_vecino(l)&&v1!=v3.dar_vecino(l) && v3.dar_vecino(l)!=null) {
                                    v4s.encolar(v3.dar_vecino(l));
                                    v4x.encolar(v3.dar_vecino(l));
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
                                    v4.visit();
                                    int m = 0;
                                    while(ps[m]!=null){
                                        m++;
                                    }
                                    ps[m] = palabra;
                                    time[m] = (double) elapsedTimeNanos / 1000000.0;
                                    if (option == true) {
                                        this.Mostrar_Grafo(v2x, v3x, v4x);
                                    }
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
                                int m = 0;
                                while(ps[m]!=null){
                                    m++;
                                }
                                ps[m] = palabra;
                                time[m] = (double) elapsedTimeNanos / 1000000.0;
                                if (option == true) {
                                    this.Mostrar_Grafo(v2x, v3x, v4x);
                                }
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
    
    private void Mostrar_Grafo(Cola v2s, Cola v3s, Cola v4s){

        System.setProperty("org.graphstream.ui", "swing"); 
        grafo = new SingleGraph("Mostrar grafico");
        Node n1 = grafo.addNode("1");
        n1.setAttribute("ui.label", v1.get_dato());
        Node n2 = grafo.addNode("2"); 
        n2.setAttribute("ui.label", v2.get_dato());
        Node n3 = grafo.addNode("3");
        n3.setAttribute("ui.label", v3.get_dato());
        grafo.addEdge("1", n1, n2);
        grafo.addEdge("2", n2, n3);
        int x = 4;
        int y = 3;
        
        n1.setAttribute("ui.class", "greenNode");
        n2.setAttribute("ui.class", "greenNode");
        n3.setAttribute("ui.class", "greenNode");
        
        if (palabra.length() == 4) {   
            Node n4 = grafo.addNode("4");
            n4.setAttribute("ui.label", v4.get_dato());
            n4.setAttribute("ui.class", "greenNode");
            grafo.addEdge("3", n3, n4);
            x++;
            y++;
        }
        
        for (int z = 0;z < 8; z++) {
            Vertice v2x = null;
            Vertice v3x = null;
            Vertice v4x = null;
            if (v2s.Tamaño()>0) {
                v2x = v2s.desencolar().v;
            }
            if (v3s.Tamaño()>0) {
                v3x = v3s.desencolar().v;
            }
            
            if (v2s.Tamaño()>=0 && v2x !=v2 && v2x != null) {
                Node n = grafo.addNode(String.valueOf(x));
                n.setAttribute("ui.label", v2x.get_dato() );
                grafo.addEdge(String.valueOf(y), n1,n);
                x++;
                y++;
            }
            if (v3s.Tamaño()>=0 && v3x !=v3 && v3x != null) {
                Node n = grafo.addNode(String.valueOf(x));
                n.setAttribute("ui.label", v3x.get_dato() );
                grafo.addEdge(String.valueOf(y), n2, n);
                x++;
                y++;
            }
            if (palabra.length() == 4) {
                if (v4s.Tamaño()>0) {
                    v4x = v4s.desencolar().v;
                }
                if (v4s.Tamaño()>=0 && v4x !=v4 && v4x != null) {
                    Node n = grafo.addNode(String.valueOf(x));
                    n.setAttribute("ui.label", v4x.get_dato() );
                    grafo.addEdge(String.valueOf(y), n3, n);
                    x++;
                    y++;
                }
            }
            z++;
        }
    String styleSheet =
    "node {" +
    "   fill-color: red;" + 
    "   size: 30px;" +
    "   text-mode: normal;" + 
    "   text-color: black;" +
    "   text-alignment: center;" +
    "}" +
    "node.greenNode {" +
    "   fill-color: green;" +
    "}";
    
    grafo.setAttribute("ui.stylesheet", styleSheet);
    }
    
    public Graph get_grafo(){
        return grafo;
    }
}
