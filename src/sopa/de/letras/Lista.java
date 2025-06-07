/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopa.de.letras;

/**
 *
 * @author Windows 10 Pro
 */
public class Lista  {
    private Nodo pfirst;
    private Nodo pfinal;
    private Nodo pNew; 
    private int iN;


    Lista (){
        iN = 0;
        pfirst = null; 
        pfinal = null;

    }

    /**
     *
     * @return
     */
    public int Tamaño( ){
        return this.iN;
    }

    /**
     *
     * @return
     */
    public  Nodo Primero(){
    return this.pfirst;
    }

    /**
     *
     * @param pValor
     * @return
     */
    public String Leer(Nodo pValor){
        return pValor.data;

    }
        
        
    /**
     *
     * @param x
     */
    public void PreInsertar(String x){
        pNew = new Nodo(x);
        iN++;
        if(pfinal == null){
            this.pfirst = this.pfinal = pNew ;
            
            }else{
            pNew.pNext = pfirst;
            pfirst.pPrevious = pNew; 
            pfirst = pNew;
            }
        }
    
    /**
     *
     * @param x
     */
    public void Insertar(String x){
        
        pNew = new Nodo(x);
        iN++;
        if(pfinal == null){
            this.pfirst = this.pfinal =pNew;
            
        }else{
            pNew.pPrevious = pfinal;
            pfinal.pNext = pNew;
            pfinal = pNew;
            }
        }   
        
    /**
     *
     * @return
     */
    public String Datos(int posicion){
        Nodo aux = pfirst;
        if (posicion!= 0){ 
            for (int i = 0; i < posicion; i++) {
                aux = aux.pNext;
            }
        }
        return aux.data;
    }
    
    public Nodo Nodos(int posicion){
        Nodo aux = pfirst;
        if (posicion!= 0){ 
            for (int i = 0; i < posicion; i++) {
                aux = aux.pNext;
            }
        }
        return aux;
    }
}