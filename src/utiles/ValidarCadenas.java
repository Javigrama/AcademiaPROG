/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MGB
 */
public class ValidarCadenas {


  

   //-----------------------------------------------------------------------
   // permitir valores entre 00000 - 52999
   
   public static boolean verificarCP(String _codigoPostal) {

        boolean resultado=false;
        int codigo=IO_ES.stringAInteger(_codigoPostal);
        if(codigo>=00000&&codigo<=52999){
            resultado=true;
        }
      

      return resultado;

   }

   //-----------------------------------------------------------------------
   /**
    *
    * @param _nif
    * @return devuelve true si el _nif es correcto
    */
   public static boolean validarNIF(String _nif) {
      boolean correcto = false;
      // [0-9]{8}[A-HJ-NP-TV-Z]
      Pattern pNIF = Pattern.compile("([X-Z][0-9]{7}[A-HJ-NP-TV-Z])|([0-9]{8}[A-HJ-NP-TV-Z])");
      Matcher m = pNIF.matcher(_nif);

      if (m.matches()) {
         correcto = calcularLetraNIF(_nif);
        
      }

      return correcto;

   }

   //-----------------------------------------------------------------------
   private static boolean calcularLetraNIF(String _nif) {
      boolean correcto = false;
      int num, resto;
      String numInicio = "";
      String letra[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

      String primerTermino = _nif.substring(0, 1);

      switch (primerTermino) {
         case "X":
            numInicio = "0";
            break;
         case "Y":
            numInicio = "1";
            break;
         case "Z":
            numInicio = "2";
            break;
      }

      if (numInicio.equals("")) {
         num = Integer.parseInt(_nif.substring(0, 8));
      } else {
         num = Integer.parseInt(numInicio + _nif.substring(1, 8));
      }

      resto = num % 23;
      if (letra[resto].equals(_nif.substring(8, 9))) {
         correcto = true;

      }

      return correcto;
   }

   public static boolean validarTelefono(String _telefono) {
      Pattern p = Pattern.compile("^(\\+34|0034|34)?[6|7|8|9][0-9]{8}$", Pattern.CASE_INSENSITIVE);
      Matcher m = p.matcher(_telefono);

      return m.matches();
   }
}
