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
public  abstract class Persona {
    
    private String nif;
    private String nombre;
    private String direccion;
    private String codigo_postal;
    private String telefono;

    public Persona(String nif, String nombre, String direccion, String codigo_postal, String telefono) {
        this.nif = nif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.telefono = telefono;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return 
                "\nNif: " + nif + 
                "\nNombre: " + nombre +
                "\nDireccion: " + direccion +
                "\nCodigo_postal: " + codigo_postal +
                "\nTelefono: " + telefono;
    }
    
    /*
    Método para escribir en Xml. 
    */
    public Element escribirXML(Document doc){
        
        String[] atributos= {"nif", "nombre", "direccion", "codigo_postal", "telefono"};
        String[] contenido_atributos = { nif, nombre, direccion, codigo_postal, telefono};
        String nombre_subclase = this.getClass().getSimpleName();
        
        Element ePersona=doc.createElement(nombre_subclase);
        for( int i =0; i < atributos.length; i++) {
            
            Element eAtributo = doc.createElement(atributos[i]);
            eAtributo.appendChild(doc.createTextNode(contenido_atributos[i]));
            ePersona.appendChild(eAtributo);
        }
        try{
            if(nombre_subclase.equals("Profesor")){
                 doc.getElementsByTagName("Profesores").item(0).appendChild(ePersona);
            }
            else {
                doc.getElementsByTagName("Estudiantes").item(0).appendChild(ePersona);
            }
        }
        catch(NullPointerException ex){}
       
        
        return ePersona;
    }  
}
