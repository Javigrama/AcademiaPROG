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
public class Profesor extends Persona {
    
    private Modulo imparte;
    
    public Profesor(String nif, String nombre, String direccion, String codigo_postal, String telefono, Modulo imparte) {
        super(nif, nombre, direccion, codigo_postal, telefono);
        this.imparte=imparte;
    }

    public Modulo getImparte() {
        return imparte;
    }

    public void setImparte(Modulo imparte) {
        this.imparte = imparte;
    }
    


    @Override
    public String toString() {
        
        return "Profesor: " + super.toString()
                + "\nimparte: " + imparte;
    }

    /*
    Overwrite de escribirXML que añade el elemento imparte
    */
    @Override
    public Element escribirXML(Document doc) {
        
        Element ePersona=super.escribirXML(doc); 
        Element eImparte=doc.createElement("imparte");
        eImparte.appendChild(doc.createTextNode(imparte.getNombre()));
        ePersona.appendChild(eImparte);
        return null;
    }
    
    
    
    
}
