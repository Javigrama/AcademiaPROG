/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Semipresencial 1º
 */
public final class XML {
    
    public static Document iniciarDocument(){
        
        Document doc=null;
        try {
           
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder=dbf.newDocumentBuilder();
            doc= dBuilder.newDocument();
            
            Element eAcademia=doc.createElement("Academia");
            doc.appendChild(eAcademia);
          
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
        
    }
    
    public static Document estructurarDocument(Document doc, String[] nombres_elementos){
       
      
            for(String elemento: nombres_elementos){
            
                Element eElemento=doc.createElement(elemento);
                try {
                    doc.getElementsByTagName("Academia").item(0).appendChild(eElemento);
                }
                catch(NullPointerException ex){}
            
            }
        
                
            return doc;
    }
    
    
   /**
    * Transforma un arbol DOM  a XML
    * @param doc es el Document que deseamos convetir
    * @param ruta es la ruta en la que alojaremos el archivo
    * @param nombre_archivo es el nombre del archivo
    */
    
    public static void domTransformacion(Document doc, String ruta, String nombre_archivo){
        
     
        File archivo=new File(ruta+nombre_archivo);
        
        try {
            Transformer transformer=TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StreamResult result=new StreamResult(archivo);
            Source source=new DOMSource(doc);
            transformer.transform(source, result);
            System.out.println("Documento "+ nombre_archivo+ " creado");
            
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * ârsea documentos xml y los lleva a arbol DOM
     * @param ruta
     * @return 
     */
    public static Document analizarDoc(String ruta){
        
        Document doc=null;
        try {
           
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            doc=db.parse(ruta);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    return doc;
    }
    
}
