/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopas_de_letras;

/**
 *
 * @author Windows 10 Pro
 */
public class Lista <T> {
    private Nodo <T> pfirst;
    private String name;
    
    private int iN;
    
    
    Lista (String n ){
        name = n;
        iN = 0;
        pfirst = null; 
        
    }
    
    public int Tamaño( ){
        return this.iN;
    }
    
    public boolean Es_Vacio(){
        return this.pfirst == null;
    }
    
    public  Nodo<T> Primero(){
    return this.pfirst;
    }
    
    public T Leer(Nodo<T> pValor){
        return pValor.data;
        
    }
    
    public Nodo Ultimo(){
        return null;
    }
    
    public Nodo<T> Proximo(Nodo pValor){
        if (pValor !=null){
            pValor = pValor.pNext;
            return pValor;
        }
        else{
            return null;
        }
    }
    
    public void Insertar(T x,Nodo <T> pValor){
        Nodo <T> pNew = new Nodo<>(x);
        if(this.Es_Vacio()){
            this.pfirst =pNew;
            iN++;
        }
        else{
            if(pValor != this.Ultimo()){
                pNew.pNext = pValor.pNext;
                pValor.pNext = pNew;
                iN++;
            }   
        }
    }
    
    public String Recorrer(){
        Nodo <T> pAux;
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
