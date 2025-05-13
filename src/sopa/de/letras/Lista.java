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

    private int iN;


    Lista (){
        iN = 0;
        pfirst = null; 
        pfinal = null;

    }

    public int Tamaño( ){
        return this.iN;
    }

    public boolean Es_Vacio(){
        return this.pfirst == null;
    }

    public  Nodo Primero(){
    return this.pfirst;
    }

    public String Leer(Nodo pValor){
        return pValor.data;

    }

    public Nodo Ultimo(){
        return null;
        
    }

    public Nodo Proximo(Nodo pValor){
        if (pValor !=null){
            pValor = pValor.pNext;
            return pValor;
        }
        else{
            return null;
        }
    }
        
        public void PreInsertar(String x){
        Nodo pNew = new Nodo(x,pfirst);
        this.pfirst =pNew;
        iN++;
        if(pfinal == null){
            
            pfinal = pfirst;
            
            }    
        }
    
        public void Insertar(String x,Nodo pValor){
        Nodo pNew = new Nodo(x,pValor);
        if(this.Es_Vacio()){
            this.pfirst =pNew;
            this.pfinal = this.pfirst;
            iN++;
        }
        else{
            if(pValor != this.Ultimo()){
                pNew.pNext = pValor.pNext;
                pValor.pNext = pNew;
                this.pfinal = pNew;
                iN++;
            }   
        }
    }
   
    public String Recorrer(){
        Nodo  pAux;
        String resultado ="";

        if (this.Es_Vacio()){
            resultado = "La lista es vacia";

        }
        else{
            pAux= this.Primero();
            while(pAux != this.Ultimo()){
                resultado = resultado + this.Leer(pAux) + ", ";
                pAux = this.Proximo(pAux);
            }
        }
        return resultado;
    }
}