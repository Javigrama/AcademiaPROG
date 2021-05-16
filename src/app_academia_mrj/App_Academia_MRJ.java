/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_academia_mrj;

import estructura.Estudiante;
import estructura.Modulo;
import estructura.Persona;
import estructura.Profesor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import static utiles.Global.RUTAXML;
import utiles.IO_ES;
import utiles.ValidarCadenas;
import utiles.XML;


/**
 *
 * @author Javier Martínez Ruiz. DAW Programación
 */
public class App_Academia_MRJ {

    
    ArrayList<Persona> LEstudiantes=new ArrayList<>();
    ArrayList<Persona> LProfesorado=new ArrayList<>();
    ArrayList<Modulo> LModulo=new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        App_Academia_MRJ academia=new App_Academia_MRJ();
        academia.generarEntorno();
        academia.importarXML();
        academia.menu();
    }
    
    /**
     * Genera la carpeta en la que serán almacenados los datos
     */
    
    private void generarEntorno(){
        
        try {
            Files.createDirectories(Paths.get(RUTAXML));
        } catch (IOException ex) {
            Logger.getLogger(App_Academia_MRJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lista que almacena personas, en este caso estudiantes
     * @return la lista de estudiantes
     */
    public ArrayList<Persona> getLEstudiantes() {
        return LEstudiantes;
    }
    
    /**
     * Lista que almacena personas, en este caso profesores
     * @return la lista de profesores
     */

    public ArrayList<Persona> getLProfesorado() {
        return LProfesorado;
    }

    /**
     * Lista que almacena Módulos
     * @return la lista de módulos
     */
    public ArrayList<Modulo> getLModulo() {
        return LModulo;
    }
    
    /**
     * 
     * @param personas
     * @param persona 
     */
    
    public void aniadirPersona(List<Persona> personas, Persona persona){
        
       personas.add(persona);
        
    }
    
    /**
     * Método que busca un persona
     * @param personas que pueden ser estudiantes o profesores
     * @param nif es el dato a contrastar
     * @return una pesona o null si no existe la persona en la lista
     */
    
    public Persona getPersona(List<Persona> personas, String nif){
        
        return   personas
                .stream()
                .filter(p-> p.getNif().equalsIgnoreCase(nif))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Retorna la size de la lista recibida por parámetro
     * @param list es la lista de la que se quiere averigüar la longitud
     * @return 
     */
    public int getSize(List<Persona> list){
        
        return list.size();
    }
    
    
    /**
     * Método que busca un módulo en la lista de módulos
     * @param nombre_modulo es el dato que deseamos contrastar
     * @return null si no hay módulo en lista o el módulo si existe
     */
    private Modulo getModulo(String nombre_modulo){
        
        return LModulo
                .stream()
                .filter(m->m.getNombre().equalsIgnoreCase(nombre_modulo))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Método funcional para interactuar con la app
     */
    private void menu() {

        int opcion;
        boolean guardado=false;
        do {

            System.out.println("\nMenu principal Academia_MRJ\n");

            System.out.println("1.  Insertar estudiante");
            System.out.println("2.  Eliminar estudiante");
            System.out.println("3.  Añadir Módulo");
            System.out.println("4.  Quitar Módulo");
            System.out.println("5.  Listar Estudiantes");
            System.out.println("6.  Listar módulos de un estudiante con total de horas semanales");
            System.out.println("--------------------------------------------------------------");
            System.out.println("7.  Insertar Profesor");
            System.out.println("8.  Eliminar Profesor");
            System.out.println("9.  Modificar Profesor");
            System.out.println("10. Listar Profesores");
            System.out.println("11. Listar alumnado del profesor");
            System.out.println("--------------------------------------------------------------");
            System.out.println("12. Insertar Módulo");
            System.out.println("13. Eliminar Módulo");
            System.out.println("14. Modificar Módulo");
            System.out.println("15. Listar Módulo");
            System.out.println("--------------------------------------------------------------");
            System.out.println("16. Guardar datos");
            System.out.println("17. Importar XML");
            System.out.println("18. Exportar XML");
            System.out.println("--------------------------------------------------------------");
            System.out.println("0. Salir");
            opcion = IO_ES.leerInteger("\nInserte una opción: \n");

            switch (opcion) {

                case 0:
                    guardado=IO_ES.leerBoolean("Desea Guardar");
                    break;
                case 1:
                    insertarPersona(opcion);
                    break;
                case 2:
                    eliminarPersona(LEstudiantes);
                    break;
                case 3: 
                    aniadirModulo();
                    break;
                case 4:
                    quitarModulo();
                    break;
                case 5: 
                    listarPersonas(LEstudiantes);
                    break;
                case 6:
                    listarModulosHoras();
                    break;
                case 7: 
                    insertarPersona(opcion);
                    break;
                case 8:
                    eliminarPersona(LProfesorado);
                    break;
                case 9:
                    modificarProfesor();
                    break;
                case 10: 
                    listarPersonas(LProfesorado);
                    break;
                case 11:
                    listarAlumnosProfesor();
                    break;
                case 12: 
                    insertarModulos();
                    break;
                case 13:
                    eliminarModulo();
                    break;
                case 15: 
                    listarModulos();
                    break;
                case 17:
                    importarXML();
                    break;
                case 18:
                    exportarXML();
                    break;
                    
            }
        }while(opcion!=0);
        if(guardado){
            exportarXML();
        }
        
        
    }
    
    /**
     * método que crea una persona, estudiante o profesor
     * en función de la opción elegida
     * @param opcion 
     */
    private void insertarPersona(int opcion) {

        String nif;
        String nombre;
        String direccion;
        String codigo_postal;
        String telefono;
        Persona persona;

        if (opcion == 1) {
            System.out.println("--> INSERTAR ESTUDIANTE");
        } else if (opcion == 7) {
            System.out.println("--> INSERTAR PROFESOR");
        }

        nombre = IO_ES.leerCadena("Inserte el nombre: ");
        direccion = IO_ES.leerCadena("Inserte la dirección: ");
        codigo_postal = IO_ES.leerCadena("Inserte el código postal: ");
        if (ValidarCadenas.verificarCP(codigo_postal)) {
            telefono = IO_ES.leerCadena("Inserte el teléfono: ");
            if (ValidarCadenas.validarTelefono(telefono)) {
                nif = IO_ES.leerCadena("Inserte el nif: ").toUpperCase();
                if (ValidarCadenas.validarNIF(nif)) {
                    if (opcion == 1) {
                        persona = getPersona(LEstudiantes, nif);
                        if (persona == null) {
                            persona = new Estudiante(nif, nombre, direccion, codigo_postal, telefono);
                            LEstudiantes.add(persona);
                            System.out.println("INFORMACIÓN --> Estudiante insertado correctamente"); 
                        }
                        else {
                            System.out.println("Ese nif ya existe");
                        }
                    } else if (opcion == 7) {
                        persona = getPersona(LProfesorado, nif);
                        if (persona == null) {
                            String nombre_modulo = IO_ES.leerCadena("Qué módulo imparte el  profesor?");
                            Modulo modulo = getModulo(nombre_modulo);
                            if (modulo != null) {
                                persona = new Profesor(nif, nombre, direccion, codigo_postal, telefono, modulo);
                                LProfesorado.add(persona);
                            } else {
                                System.out.println("INFORMACIÓN --> El módulo " + nombre_modulo + " no se encuentra en la lista."
                                        + " No se ha podido insertar al profesor");
                            }

                        }
                    }
                } else {
                    System.out.println("El nif no es válido");
                }
            } else {
                System.out.println("El teléfono no es válido");
            }
        } else {
            System.out.println("El código postal no es válido");
        }

    }
    
   
    /**
     * Listado de personas
     * @param personas 
     */

    private void listarPersonas(List<Persona> personas){
        
        if(personas.isEmpty()){
            System.out.println("La lista está vacía");
        }
        personas.stream().forEach(System.out::println);
    }
    
    
    /**
     * Borra un objeto de la lista recibida por parámetro
     * @param personas 
     */
    private void eliminarPersona(List<Persona> personas){
        
        String nif=IO_ES.leerCadena("Inserte el nif");
        Persona persona=getPersona(personas, nif);
        if(persona!=null){
            personas.remove(persona);
        }
    }
    
    
    
    /**
     * Inserta un nuevo módulo si no existe en la lista de módulos.
     * Los valores enteros serán mayores de 0. En cualquier caso ya es
     * setedo en el constructor
     */
    private void insertarModulos(){
        
        String nombre_modulo;
        int horas_semanales;
        int unidades;
        
        System.out.println("INSERTAR MÓDULO");
        nombre_modulo=IO_ES.leerCadena("Inserte el nombre del módulo");
        Modulo modulo=getModulo(nombre_modulo);
        if(modulo==null){
           
            horas_semanales=IO_ES.leerInteger("Inserte las horas semanales: ", 1, 30);
            unidades=IO_ES.leerInteger("Inserte las unidades: ", 1);
            modulo=new Modulo(nombre_modulo, horas_semanales, unidades);
            LModulo.add(modulo);
        }
        else {
            System.out.println("El módulo ya está en la lista de módulos");
        }
        
        System.out.println("Módulo insertado correctamente");
        
    }
    
    /**
     * devuleve un listado con los módulos disponibles
     */
    private void listarModulos(){
        
        LModulo.forEach(System.out::println);
    }
    
    /**
     * Añade un módulo a un estudiante si este tiene horas disponibles, si el
     * módulo existem, si existe el estudiante etc.
     */
    
    private void aniadirModulo(){
        
        String nif;
        Estudiante estudiante;
        String nombre_modulo;
        Modulo modulo;
        System.out.println("--> AÑADIR MÓDULO");
        
        nif=IO_ES.leerCadena("Inserte el nif: ");
        nif=nif.toUpperCase();
        if(ValidarCadenas.validarNIF(nif)){
            estudiante=(Estudiante)getPersona(LEstudiantes, nif);
           
            if(estudiante!=null){
                int sizeModulos=estudiante.getNombreModulos().length;
                nombre_modulo=IO_ES.leerCadena("Inserte el nombre del módulo");
                modulo=getModulo(nombre_modulo);
                if(modulo!=null){
                    estudiante.aniadirModulo(modulo);
                    if(sizeModulos < estudiante.getNombreModulos().length){
                        System.out.println("INFORMACIÓN-->"
                                + "El estudiante con nif "+ nif+ " ha sido matriculado en"
                                        + "el módulo de "+ nombre_modulo);
                    }
                    else{
                        System.out.println("INFORMACIÓN -->  + El estudiante con nif "+ nif+ 
                                "\nno se puede matricular en el móduo de "+ nombre_modulo+
                                ". \nYa está matriculado o se pasa de horas");
                    }
                }
                else {
                    System.out.println("INFORMACIÓN--> El modulo" +  nombre_modulo + " no ha sido encontrdo");
                }
            }
            else {
                System.out.println("El estudiante no existe");
            }
        }
        else {
            System.out.println("El nif no es válido");
        }
        
    }
    
    
    /**
     * Elimina un módulo de los asignados al alumno
     */
    private void quitarModulo(){
        
        System.out.println("-->> ANULAR MÓDULO");
        
        String nif = IO_ES.leerCadena("Inserte el nif");
        if(ValidarCadenas.validarNIF(nif)){
            Estudiante estudiante=(Estudiante)getPersona(LEstudiantes, nif);
            if(estudiante!=null){
                String nombre_modulo=IO_ES.leerCadena("Inserte el nombre del módulo");
                Modulo modulo=getModulo(nombre_modulo);
                if(modulo!=null){
                    estudiante.quitarModulo(modulo);
                    System.out.println("El estudiante  con NIF "+ nif+ " ha anulado "
                            + "\n matrícula en el módulo "+ nombre_modulo);
                }
                else {
                    System.out.println("El módulo "+ nombre_modulo + " no ha sido encontrado");
                }
            }
            else {
                System.out.println("No existe ese estudiante");
            }
        }
        else {
            System.out.println("El nif no es válido");
        }
    }
    
    
    /**
     * Listado de los módulos y las horas semanales de los estudiantes
     */
    private void listarModulosHoras(){
        
        System.out.println("-->> MÓDULOS Y HORAS TOTALES DEL ESTUDIANTE");
        String nif=IO_ES.leerCadena("Inserte el nif del estudiante");
        if(ValidarCadenas.validarNIF(nif)){
            Estudiante estudiante=(Estudiante)getPersona(LEstudiantes, nif);
            if(estudiante!=null){
                for(String nombres_modulos: estudiante.getNombreModulos()){
                    Modulo modulo =getModulo(nombres_modulos);
                        if(modulo!=null){
                            System.out.println(modulo);
                        }
                    
                }
                System.out.println("Horas totales semanales: "+estudiante.getTotalHoras());
            }
        }
        
    }
    
    /**
     * Modifica datos de un porfesor
     */
    
    private void modificarProfesor(){
        
        System.out.println("-->> MODIFICAR PROFESOR");
        int opcion;
        String nif=IO_ES.leerCadena("Inserte el nif del profesor");
        if(ValidarCadenas.validarNIF(nif)){
            Profesor profesor=(Profesor) getPersona(LProfesorado, nif);
            if(profesor!=null){
                do{
                    System.out.println(profesor);
                    System.out.println("\n1. Nombre");
                    System.out.println("2. Dirección");
                    System.out.println("3. Código Postal");
                    System.out.println("4. Teléfono");
                    System.out.println("5. Módulo");
                    System.out.println("0. Volver");
                    opcion=IO_ES.leerInteger("Inserte una opción: ", 0, 5);
                    
                    
                    switch(opcion){
                    
                        case 1:
                            actualizarNombre(profesor);
                            break;
                        case 2:
                            actualizarDireccion(profesor);
                            break;
                        case 3:
                            actualizarCodigoPostal(profesor);
                            break;
                        case 4:
                            actualizarTelefono(profesor);
                            break;
                        case 5:
                            actualizarModulo(profesor);
                            break;
                            
                    
                    }
                   
                }while(opcion!=0);
            }
            else{
                 System.out.println("El profesor no existe");
            }
           
        }
        else {
            System.out.println("El nif no es válido");
        }
 
    }
    
    /**
     * Actualiza el nombre del profesor
     * @param persona 
     */
    
    private void actualizarNombre(Persona persona){
        
        String nombre=IO_ES.leerCadena("Inserte el nombre");
        persona.setNombre(nombre);
    }
    
    /**
     * Actualiza la dirección
     * @param persona 
     */
    
    private void actualizarDireccion(Persona persona){
        
        String direccion=IO_ES.leerCadena("Inserte la dirección");
        persona.setDireccion(direccion);
    }
    
    /**
     * actualiza el código postal
     * @param persona 
     */
    private void actualizarCodigoPostal(Persona persona){
        
        String codigo_postal=IO_ES.leerCadena("Inserte el código postal");
        persona.setTelefono(codigo_postal);
    }
    /**
     * Actualiza el teléfono
     * @param persona 
     */
    private void actualizarTelefono(Persona persona){
        
        String telefono=IO_ES.leerCadena("Inserte el telefono");
        persona.setTelefono(telefono);
    }
    
        /**
     * Actualiza el teléfono
     * @param persona 
     */
    private void actualizarModulo(Persona persona){
        
        String nombre_modulo=IO_ES.leerCadena("Inserte el nombre del módulo");
        Modulo modulo=getModulo(nombre_modulo);
        if(modulo!=null){
            Profesor profesor=(Profesor) persona;
            profesor.setImparte(modulo);
            System.out.println("\nMódulo modificado\n");
        }
        else {
            System.out.println("\nNo existe ese módulo\n");
        }
    }
        
    /**
     * Eliminando módulos
     */
    private void eliminarModulo(){
        
        System.out.println("-->>ELIMINAR MÓDULO");
        String nombre_modulo=IO_ES.leerCadena("inserte el nombre del módulo");
        Modulo modulo=getModulo(nombre_modulo);
        if(modulo!=null){
            LModulo.remove(modulo);
            System.out.println("Módulo eliminado");
        }
        else {
            System.out.println("El módulo no existe");
        }
        
    }

    
    /**
     * Persistencia de objetos con formato xml
     */
    private void exportarXML(){
        
        String nombre_archivo=IO_ES.leerCadena("Inserte el nombre del archivo");
        String[] nombre_elementos= {"Modulos", "Estudiantes", "Profesores"};
        Document doc=XML.iniciarDocument();
        doc=XML.estructurarDocument(doc, nombre_elementos);
        
        for(Persona estudiante : LEstudiantes){
            estudiante.escribirXML(doc);
        }
        for(Persona profesor : LProfesorado){
            profesor.escribirXML(doc);
        }
        for(Modulo modulo: LModulo){
            modulo.escribirXML(doc);
        }
        
        XML.domTransformacion(doc, RUTAXML, nombre_archivo);
        
    }
    
    /**
     * Método para importar datos guardados
     */
    
    private void importarXML(){
        
        String nombre_archivo=IO_ES.leerCadena("Inserte el nombre del archivo");
        
        if(Files.exists(Paths.get(RUTAXML+nombre_archivo))){
            
            LModulo.clear();
            LEstudiantes.clear();
            LProfesorado.clear();
            
            leerModulosXML(RUTAXML+nombre_archivo);
            leerPersonasXML(RUTAXML+nombre_archivo);
            
        }
        else {
            System.out.println("No existe ese archivo");
        }
    }
    
    /**
     * Devuelve una lista con los alumnos que están apuntados al 
     * módulo que imparte el profesor
     * @return 
     */
    
    private void listarAlumnosProfesor(){
        
        System.out.println("-->>LISTAR ALUMNOS DE PROFESOR");
        String listaAlumos="";
        String nif=IO_ES.leerCadena("Inserte el nif");
        if(ValidarCadenas.validarNIF(nif)){
            Profesor profesor=(Profesor)getPersona(LProfesorado, nif);
            if(profesor!=null){
                String nombre_modulo=profesor.getImparte().getNombre();
                Modulo modulo=getModulo(nombre_modulo);
                if(modulo!=null){
                    
                    for(Persona persona: LEstudiantes){
                        Estudiante estudiante=(Estudiante) persona;
                        for(String nombre_modulo_alumno: estudiante.getNombreModulos()){
                            
                            if(nombre_modulo_alumno.equalsIgnoreCase(modulo.getNombre())){
                                
                                listaAlumos+=estudiante.getNombre()+"\n";
                            }
                        }
                    
                    }
                }
            }
              
        } 
           
        
        System.out.println(listaAlumos);
    }
    
    
    /**
     * 
     * @param ruta 
     */
    
    private void leerPersonasXML(String ruta){
        
        String nif;
        String nombre;
        String direccion;
        String codigo_postal;
        String telefono;
        Document doc=XML.analizarDoc(ruta);
        String[] elementos ={"Estudiante", "Profesor"};
        for (String elemento: elementos){
            try{
                NodeList listaPersonas=doc.getElementsByTagName(elemento);
                for(int i=0; i<listaPersonas.getLength(); i++){
                    Node nodo=listaPersonas.item(i);
                    
                    if(nodo.getNodeType()==Node.ELEMENT_NODE){
                        Element ePersona=(Element) nodo;
                        nombre=ePersona.getElementsByTagName("nombre").item(0).getTextContent();
                        direccion=ePersona.getElementsByTagName("direccion").item(0).getTextContent();
                        codigo_postal=ePersona.getElementsByTagName("codigo_postal").item(0).getTextContent();
                        
                        if(ValidarCadenas.verificarCP(codigo_postal)){
                            telefono=ePersona.getElementsByTagName("telefono").item(0).getTextContent();
                            
                            if(ValidarCadenas.validarTelefono(telefono)){
                                nif=ePersona.getElementsByTagName("nif").item(0).getTextContent();
                                
                                if(elemento.equalsIgnoreCase("Estudiante")){
                                    if(ValidarCadenas.validarNIF(nif)){
                                        if(getPersona(LEstudiantes, nif)==null){
                                            String nombres_mods=ePersona.getElementsByTagName("ListaModulo").item(0).getTextContent();
                                            String[] nombres_modulos=nombres_mods.split("\n");
                                            Estudiante estudiante=new Estudiante(nif, nombre, direccion, codigo_postal, telefono);
                                            for(int j=0; j<nombres_modulos.length; j++){
                                                Modulo modulo=getModulo(nombres_modulos[j]);
                                                if(modulo!=null){
                                                    estudiante.aniadirModulo(modulo);
                                                }
                                            } 
                                            LEstudiantes.add(estudiante);
                                        }
                                      
                                    }
                                }
                                else if(elemento.equalsIgnoreCase("Profesor")){
                                    if(ValidarCadenas.validarNIF(nif)){
                                        if(getPersona(LProfesorado, nif)==null){
                                            if(getPersona(LProfesorado, nif)==null){
                                                String nombre_imparte=ePersona.getElementsByTagName("imparte").item(0).getTextContent();
                                                Modulo imparte=getModulo(nombre_imparte);
                                                if(imparte!=null){
                                            
                                                    Profesor profesor=new Profesor(nif, nombre, direccion, codigo_postal, telefono, imparte);
                                                    LProfesorado.add(profesor);
                                                }
                                            }
                                        }
                                    }
                                }  
                            }
                        }
                    }
                }
            }
            catch(NullPointerException |IllegalArgumentException ex){}
        }
        
    }
    

    /**
     * Lectura de modulos
     * @param ruta 
     */
    
    private void leerModulosXML(String ruta){
        
        String nombre_modulo;
        int unidades;
        int horas;
        Document doc=XML.analizarDoc(ruta);
        NodeList listaModulos=doc.getElementsByTagName("Modulo");
        for(int i=0; i<listaModulos.getLength(); i++){
            Node nodo=listaModulos.item(i);
            if(nodo.getNodeType()==Node.ELEMENT_NODE){
                Element eModulo=(Element) nodo;
                try{
                    nombre_modulo=eModulo.getElementsByTagName("nombre").item(0).getTextContent();
                    if(getModulo(nombre_modulo)==null){
                        horas=Integer.parseInt(eModulo.getElementsByTagName("horas").item(0).getTextContent());
                        unidades=Integer.parseInt(eModulo.getElementsByTagName("unidades").item(0).getTextContent());
                        
                        Modulo modulo=new Modulo(nombre_modulo, horas, unidades);
                        LModulo.add(modulo);
                    }
                    else {
                        System.out.println("Ese módulo ya está en la lista de módulos");
                    }                    
                    
                }
                catch(NullPointerException | IllegalArgumentException ex){}
                    
                
            }
        }
        
        
    }
}
