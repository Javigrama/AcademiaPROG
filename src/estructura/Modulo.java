/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Javier Martínez Ruiz. DAW Programación
 */
public class Modulo {
    
    private String nombre;
    private int horas;
    private int unidades;

    public Modulo(String nombre, int horas, int unidades) {
        this.nombre = nombre;
        this.horas = horas >0 ? horas: 0;
        this.unidades = unidades > 0 ? unidades: 0;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "\n-------------------\n"+
                "\nNombre: "+ nombre + 
                "\nHoras: " + horas +
                "\nUnidades: " + unidades;
    }
    
    /**
     * Escribe xml
     * @param doc 
     */
    public void escribirXML(Document doc){
        
        Element eModulo = doc.createElement("Modulo");
        String[] atributos= {"nombre", "horas", "unidades"};
        String[] contenido_atributos = {nombre, String.valueOf(horas), String.valueOf(unidades)};
        
        for(int i =0; i<atributos.length; i++){
            Element eAtributo=doc.createElement(atributos[i]);
            eAtributo.appendChild(doc.createTextNode(contenido_atributos[i]));
            eModulo.appendChild(eAtributo);
        }
        try{
            doc.getElementsByTagName("Modulos").item(0).appendChild(eModulo);
        }
        catch(NullPointerException ex){}
         
    }
    
}
