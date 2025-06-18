/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
/**
 *
 * @author Windows 10 Pro
 */
public class Mostrar_Busquedabfs {
    
    private Lista p;
    private String palabra;
    private Graph graph;
    private Node n1, n2, n3;
    
    public Mostrar_Busquedabfs(Lista p, String w){
        this.p = p;
        palabra = w;
        graph = new SingleGraph("Mostrar grafico");
        this.inizializar();
        graph.display();
        this.busqueda();
    }
    
    private void inizializar(){
        
        int x = 1;
        int y = 0;
        for (int i = 0; i < p.Tamaño(); i++) {
            if (x == 5){
                x = 0;
                y++;
            }
            graph.addNode(p.Datos(i));
            Node n = graph.getNode(p.Datos(i));
            n.setAttribute("x", x);
            n.setAttribute("y", y);
            
            x++;
        }
        
        for (int i = 0; i < 16; i++) {

            if (i!=3 && i!= 7 && i!=11 && i!=15){
                graph.addEdge(p.Datos(i)+p.Datos(1+i), i, i+1);
            }
            if(i != 0 && i != 4 && i!=8 && i!= 12){  
                graph.addEdge(p.Datos(i)+p.Datos(i-1), i, i-1);
            }  
            if(i<=11){
                graph.addEdge(p.Datos(i)+p.Datos(i+4), i, i+4);
            }
            if(i >= 4){
                graph.addEdge(p.Datos(i)+p.Datos(i-4), i, i-4);
            }
            if(i != 3 && i!= 7 && i<11){
                graph.addEdge(p.Datos(i)+p.Datos(i+5), i, i+5);
            }
            if(i != 0 && i != 4 && i!=8 && i<12){
                graph.addEdge(p.Datos(i)+p.Datos(i+3), i, i+3);
            }
            if(i>= 5 && i!=8 && i !=12){
                graph.addEdge(p.Datos(i)+p.Datos(i-5), i, i-5);
            }
            if(i>3&& i!= 7 && i !=11 && i!= 15){
                graph.addEdge(p.Datos(i)+p.Datos(i-3), i, i-3);
            }
        }
        
        String css = "node {" +
                     "   fill-color: orange;" +
                     "   size: 20px;" +
                     "}";
        
        graph.setAttribute("ui.stylesheet", css);
    }
    
    private void busqueda(){
        String aux = "";
        String s = Character.toString(palabra.charAt(0));
        for (int i = 0; i < 16; i++) {
            if(aux.equals(palabra)){
                break;
            }
            Node n1 = graph.getNode(p.Datos(i));
            if (n1.getId().equals(s) == true) {
                n1.setAttribute("ui.style", "fill-color: yellow;");
                Cola v2s= new Cola();
                for (int j = 0;j<8; j++) {
                    if (n1.getEdge(j) != null) {
                        v2s.encolar(n1.getEdge(i).getNode1()); 

                    }
                }
            }else{
                n1.setAttribute("ui.style", "fill-color: red;");
                        
            }
        }
    }
}
