/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Javier Martínez Ruiz. DAW Programación
 */
public class Estudiante extends Persona {

    private final ArrayList<Modulo> LModulos;

    /**
     * Constructor con todos los argumentos de Persona
     *
     * @param nif
     * @param nombre
     * @param direccion
     * @param codigo_postal
     * @param telefono
     */
    public Estudiante(String nif, String nombre, String direccion, String codigo_postal, String telefono) {
        super(nif, nombre, direccion, codigo_postal, telefono);
        LModulos = new ArrayList<>();
    }

    public Estudiante(String nif, String nombre, String direccion, String codigo_postal, String telefono, ArrayList LModulo) {
        super(nif, nombre, direccion, codigo_postal, telefono);
        this.LModulos = LModulo;
    }

    /**
     * Método que añade un módulo al array de módulos si las horas totales del
     * estudiante dedicada a módulos es menor de 30 y no está matriculado ya en
     * ese módulo
     *
     * @param modulo
     */
    public void aniadirModulo(Modulo modulo) {

        double horas_semanales = getTotalHoras();
        String[] nombre_modulos = getNombreModulos();
        boolean encontrado = false;

        for (int i = 0; i < nombre_modulos.length; i++) {

            if (nombre_modulos[i].equalsIgnoreCase(modulo.getNombre())) {
                encontrado = true;
            }
        }
        if (!encontrado && (horas_semanales + modulo.getHoras()) < 30) {
            LModulos.add(modulo);
        }

    }

    public void quitarModulo(Modulo modulo) {

        LModulos.remove(modulo);
    }

    /**
     * Método que obtienen los nombres de los módulos en los que está
     * matriculado un estudiante
     *
     * @return un array que contiene los nombres de los módulos
     */
    public String[] getNombreModulos() {

        String[] nombre_modulos = new String[LModulos.size()];

        for (int i = 0; i < nombre_modulos.length; i++) {
            nombre_modulos[i] = LModulos.get(i).getNombre();

        }
        return nombre_modulos;

    }

    /**
     * Obtiene el número total de horas dedicadas a los módulos
     *
     * @return
     */
    public double getTotalHoras() {

        double horas_semanales = 0;

        for (int i = 0; i < LModulos.size(); i++) {
            horas_semanales += LModulos.get(i).getHoras();
        }
        return horas_semanales;

    }

    @Override
    public String toString() {

        String modulos = "";
        for (int i = 0; i < LModulos.size(); i++) {
            modulos += LModulos.get(i).toString();
        }

        return "\nEstudiante :" + super.toString()
                + "\n\nModulos: " + modulos;
    }

    /**
     * Escribe xml
     * @param doc
     * @return 
     */
    @Override
    public Element escribirXML(Document doc) {
        
        Element eEstudiante= super.escribirXML(doc); 
        String[] nombres_modulos=getNombreModulos();
        
        Element eModulos=doc.createElement("ListaModulo");
        for(int i=0; i<nombres_modulos.length; i++){
            
             eModulos.appendChild(doc.createTextNode(nombres_modulos[i]+"\n"));
        }
        eEstudiante.appendChild(eModulos);
        
        return null;
    }
}
