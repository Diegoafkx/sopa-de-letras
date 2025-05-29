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
    /**
     *
     * @param daux
     * @return
     */
    public String Eliminar(String daux){
        
        if(daux.equals(this.Leer(pfirst))== false){
            Nodo paux = pfirst.pNext;
            Nodo paux1 = paux;
            
            for (int i = 0; i < 10; i++) {
                if(daux.equals(this.Leer(paux))== false){
                    paux = paux.pNext;
                    
                }
                else{
                    paux1.pNext = paux.pNext;
                    return "Se a eliminado con exito";
                }    
            }
        }
        else{
            pfirst = pfirst.pNext;
            return "Se a eliminado con exito";
        }
        return "Ha surgido un error.\nNo se encuentro la palabra";
    }

    public void Desorganizar(int i, int y){
        String a = this.Datos(i);
        String b = this.Datos(y);
        Nodo aux = pfirst;
            for (int j = 0; j < this.Tamaño(); j++) {
                if(j == i){
                    aux.data = b;
                }else if (i==y){
                    aux.data = a;
                }
                aux = aux.pNext;
            }
    } 
}