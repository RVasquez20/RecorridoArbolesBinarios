/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_binario;

/**
 *
 * @author paiz2
 */
public class ArbolBinario {
    
    Nodo raiz;
    
    public ArbolBinario(){
        raiz = null;
    }
    
    public void insertar(int i, String contenido){
        Nodo n = new Nodo(i);
        n.valor = contenido;
        
        //INICIALIZANDO LA RAÍZ DEL ÁRBOL
        if(raiz == null)
            raiz = n;
        else{
            //RECORRIENDO EL ARBOL
            Nodo aux = raiz;
            while(aux != null){
                n.padre = aux;
                
                if(n.llave >= aux.llave)
                    aux = aux.derecha;
                else
                    aux = aux.izquierda;
            }
            
            //INSERCIÓN DEL NUEVO NODO
            if(n.llave < n.padre.llave)
                n.padre.izquierda = n;
            else
                n.padre.derecha = n;        
        }
    }
    
    public void recorrer(Nodo n){
        if(n != null)
        {
            recorrer(n.izquierda);
            System.out.println("Indice: " + n.llave + ", Valor: " + n.valor);
            recorrer(n.derecha);
        }
    }
 
    private class Nodo{
        public Nodo padre;
        public Nodo derecha;
        public Nodo izquierda;
        public int llave;
        public String valor;
        
        public Nodo(int indice){
            padre = null;
            derecha = null;
            izquierda = null;
            llave = indice;
            valor = null;
        }
    }
}
