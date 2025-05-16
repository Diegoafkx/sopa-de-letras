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
     * @param pValor
     * @return
     */
    public Nodo Proximo(Nodo pValor){
        
        pValor = pValor.pNext;
        return pValor;
        
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
    public String Datos(){
        String aux;
        if(pfirst != null){
            aux = this.Leer(pfirst);
            Nodo paux = this.Proximo(pfirst);
            while(this.Proximo(paux)!= null){
                aux =aux+"\n"+this.Leer(paux);
                paux = this.Proximo(paux);
            }
            aux =aux+"\n"+this.Leer(paux);
        }
        else if(pfirst == null){
            aux = this.Leer(pfirst);
        }else{
           aux = "La lista esta vacia";
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
            Nodo paux = this.Proximo(pfirst);
            Nodo paux1 = paux;
            
            for (int i = 0; i < 10; i++) {
                if(daux.equals(this.Leer(paux))== false){
                    paux = this.Proximo(paux);
                    
                }
                else{
                    paux1.pNext = paux.pNext;
                    return "Se a eliminado con exito";
                }    
            }
        }
        else{
            pfirst = this.Proximo(pfirst);
            return "Se a eliminado con exito";
        }
        return "Ha surrgido un error.\nNo se encuentro la palaabraa";
    }
}