/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author mgb
 *
 */
public class IO_ES {

   // Constructor
   IO_ES() {

   }

   //--------------------------------------------------------------------
   /**
    *
    * @return
    */
   public static int leerInteger() {

      boolean correcto = true;
      Scanner sc = new Scanner(System.in);
      int num = 0;
      do {
         System.out.print("Introduzca un número entero.");

         try {
            num = Integer.parseInt(sc.nextLine());
            correcto = true;
         } catch (NumberFormatException e) {
            escribirLN("\nERROR: El dato introducido no es correcto");
            correcto = false;
         }
      } while (!correcto);

      return (num);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    * @return
    */
   public static int leerInteger(String msg) {

      boolean correcto = true;
      Scanner sc = new Scanner(System.in);
      int num = 0;

      do {
         System.out.print(msg);

         try {
            num = Integer.parseInt(sc.nextLine());
            correcto = true;
         } catch (Exception e) {
            escribirLN("\nERROR: El dato introducido no es correcto");
            correcto = false;
         }
      } while (!correcto);
      return (num);

   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    * @param min
    * @param max
    * @return
    */
   public static int leerInteger(String msg, int min, int max) {

      //Deberemos introducir un messaje y dos números entre los que se encuentre el introducido por teclado
      boolean correcto = true;
      Scanner sc = new Scanner(System.in);
      int num = 0;

      do {
         System.out.print(msg);

         try {
            num = Integer.parseInt(sc.nextLine());
            if (num >= min && num <= max) {
               correcto = true;
            } else {
               correcto = false;
            }
         } catch (Exception e) {
            escribirLN("\nERROR: El dato introducido no es correcto");
            correcto = false;
         }
      } while (!correcto);
      return (num);

   }
//--------------------------------------------------------------------

   /**
    *
    * @param msg
    * @param min
    * @return
    */
   public static int leerInteger(String msg, int min) {

      //Deberemos introducir un messaje y un número que sea menor que el introducido por teclado
      boolean correcto = true;
      Scanner sc = new Scanner(System.in);
      int num = 0;

      do {
         System.out.print(msg);

         try {
            num = Integer.parseInt(sc.nextLine());
            if (num >= min) {
               correcto = true;
            } else {
               correcto = false;
            }
         } catch (Exception e) {
            escribirLN("\nERROR: El dato introducido no es correcto");
            correcto = false;
         }
      } while (!correcto);

      return (num);

   }

   //--------------------------------------------------------------------
   /**
    *
    * @return
    */
   public static long leerEnteroLargo() {

      boolean correcto = true;
      Scanner sc = new Scanner(System.in);
      long numLong = 0;
      do {
         System.out.print("Introduzca número largo: ");

         try {
            numLong = Long.parseLong(sc.nextLine());
            correcto = true;
         } catch (Exception e) {
            escribirLN("\nERROR: El dato introducido no es correcto");
            correcto = false;
         }
      } while (!correcto);
      return (numLong);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    * @return
    */
   public static int leerEnteroLargo(String msg) {

      boolean correcto = true;
      Scanner sc = new Scanner(System.in);
      int num = 0;

      do {
         System.out.print(msg);

         try {
            num = Integer.parseInt(sc.nextLine());
            correcto = true;
         } catch (Exception e) {
            escribirLN("\nERROR: El dato introducido no es correcto");
            correcto = false;
         }
      } while (!correcto);
      return (num);

   }

   //--------------------------------------------------------------------
   /**
    *
    * @return
    */
   public static float leerReal() {

      boolean correcto = true;
      Scanner sc = new Scanner(System.in);
      float numFloat = 0.0f;
      do {
         System.out.print("Introduzca un número float: ");

         try {
            numFloat = Float.parseFloat(sc.nextLine());
            correcto = true;
         } catch (Exception e) {
            escribirLN("\nERROR: El dato introducido no es correcto");
            correcto = false;
         }
      } while (!correcto);
      return (numFloat);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    * @return
    */
   public static float leerReal(String msg) {

      boolean correcto = true;
      Scanner sc = new Scanner(System.in);
      float numFloat = 0.0f;

      do {
         System.out.print(msg);

         try {
            numFloat = Float.parseFloat(sc.nextLine());
            correcto = true;
         } catch (Exception e) {
            escribirLN("\nERROR: El dato introducido no es correcto");
            correcto = false;
         }
      } while (!correcto);

      return (numFloat);
   }
//--------------------------------------------------------------------

   /**
    *
    * @param msg
    * @param min
    * @return
    */
   public static float leerReal(String msg, float min) {

      boolean correcto = false;
      Scanner sc = new Scanner(System.in);
      float numFloat = 0;

      do {
         System.out.println(msg);

         try {
            numFloat = Float.parseFloat(sc.nextLine());
            if (numFloat > min) {
               correcto = true;
            } else {
               correcto = false;
            }
         } catch (Exception e) {
            escribirLN("ERROR: El dato introducido no es correcto");
            correcto = false;
         }
      } while (!correcto);
      return (numFloat);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @return
    */
   public static double leerRealLargo() {

      boolean correcto = true;
      Scanner sc = new Scanner(System.in);
      double numDouble = 0.0;
      do {
         System.out.print("Introduzca número real double: ");

         try {
            numDouble = Double.parseDouble(sc.nextLine());
            correcto = true;
         } catch (Exception e) {
            escribirLN("\nERROR: El dato introducido no es correcto");
            correcto = false;
         }
      } while (!correcto);
      return (numDouble);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    * @return
    */
   public static double leerRealLargo(String msg) {

      boolean correcto = true;
      Scanner sc = new Scanner(System.in);
      double numDouble = 0.0d;

      do {
         System.out.print(msg);

         try {
            numDouble = Double.parseDouble(sc.nextLine());
            correcto = true;
         } catch (Exception e) {
            escribirLN("\nERROR: El dato introducido NO es correcto");
            correcto = false;
         }
      } while (!correcto);
      return (numDouble);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @return
    */
   public static String leerCadena() {
      String cad;

      System.out.print("Introduzca una cadena de caracteres: ");
      Scanner sc = new Scanner(System.in);
      cad = (sc.nextLine());

      return (cad);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    * @return
    */
   public static String leerCadena(String msg) {
      String cad;

      System.out.print(msg+ " -->");
      Scanner sc = new Scanner(System.in);
      cad = (sc.nextLine());

      return (cad);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    * @param longitud
    * @return
    */
   public static String leerCadena(String msg, int longitud) {
      String cad;
      Scanner sc = new Scanner(System.in);
      boolean correcto = true;

      do {
         System.out.print(msg);
         cad = sc.nextLine();

         if (cad.length() == longitud) {
            correcto = true;
         } else {
            correcto = false;
         }

      } while (!correcto);

      return (cad);
   }
   

   //--------------------------------------------------------------------
   /**
    *
    * @return
    */
   public static char leerCaracter() {

      Scanner sc = new Scanner(System.in);
      char caracter = '\0';

      while (caracter == '\0') {
         String cara;

         System.out.print("Introduzca un caracter: ");
         cara = sc.nextLine();
         caracter = cara.charAt(0);
      }

      return (caracter);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    * @return
    */
   public static char leerCaracter(String msg) {

      Scanner sc = new Scanner(System.in);
      char caracter = '\0';

      while (caracter == '\0') {
         String cara;

         System.out.print(msg);
         cara = (sc.nextLine());
         caracter = cara.charAt(0);
      }
      return (caracter);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @return
    */
   public static boolean leerBoolean() {
      String opcion = "";
      Scanner sc = new Scanner(System.in);
      //Igualamos el Si a true y el No a false
      boolean resul = true;
      //Utilizamos un boolean para determinar si se ha introducido si o no y salir del do
      boolean valido = false;

      do {
         System.out.print("Introduzca S para Si o N para No: ");
         opcion = sc.next();

         if (opcion.equalsIgnoreCase("S")) {
            valido = true;
            resul = true;
         } else {
            if (opcion.equalsIgnoreCase("N")) {
               valido = true;
               resul = false;
            }
         }
      } while (valido == false);

      return (resul);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    * @return
    */
   public static boolean leerBoolean(String msg) {
      String opcion = "";
      Scanner sc = new Scanner(System.in);
      //Igualamos el Si a true y el No a false
      boolean resul = true;
      //Utilizamos un boolean para determinar si se ha introducido si o no y salir del do
      boolean valido = false;

      do {
         System.out.print(msg);
         opcion = sc.next();

         if (opcion.equalsIgnoreCase("S")) {
            valido = true;
            resul = true;
         } else {
            if (opcion.equalsIgnoreCase("N")) {
               valido = true;
               resul = false;
            }
         }
         if (valido == false) {
            System.out.println("Introduzca S para Si o N para No.");
         }
      } while (valido == false);
      return (resul);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    */
   public static void escribir(String msg) {
      System.out.print(msg);
   }

   //--------------------------------------------------------------------
   public static void escribir(String _color, String msg) {
      System.out.print(_color + msg);
   }

   //--------------------------------------------------------------------
   /**
    *
    * @param msg
    */
   public static void escribirLN(String msg) {
      System.out.println(msg);
   }

   //--------------------------------------------------------------------
   public static void escribirLN(String _color, String msg) {
      System.out.print(_color + msg);
   }

   //--------------------------------------------------------------------
   /**
    * guardar la información que recibe por parámetro datos en el fichero de
    * texto indicado en ruta
    *
    * @param ruta Cadena de caractCadenaeres que indica la ruta y archivo donde
    * se quieren guardar los datos
    *
    * @param datos Cadena de caracteres que contiene la información que se
    * quiere guardar.
    *
    * @param sobreEscribir booleano que indica si se sobreescribe el contenido
    * del archivo (verdadero) o se añade al final del mismo (falso)
    *
    * @return verdadero si se ha guardado correctamente y falso si se produce
    * algun error
    */
   public static boolean escribirArchivo(String ruta, String datos, boolean sobreEscribir) {
      boolean res;
      FileWriter fichero;

      try {
         fichero = new FileWriter(ruta, sobreEscribir);
         fichero.write(datos);
         fichero.close();
         res = true;

      } catch (FileNotFoundException ex) {
         System.out.println("Fichero " + ruta + " no encontrado");
         res = false;

      } catch (Exception e) {
         System.out.println("Mensaje:  " + e.getMessage());
         res = false;
      }

      return res;
   }

   //-----------------------------------------------------------------------
   /**
    * leer todo el contenido de un archivo.
    *
    * @param rutaArchivo parámetro que recibe el método con la ruta (y nombre
    * del archivo) del que se quiere realizar la lectura
    * @return Devuelve todo el contenido como una cadena de caracteres
    */
   public static String leerArchivo(String rutaArchivo) {
      String res = "";
      Scanner sc = null;
      File fichero = new File(rutaArchivo);

      try {
         System.out.println("Leyendo el contenido del fichero..........");
         sc = new Scanner(fichero);

         // leer línea a linea el fichero
         while (sc.hasNextLine()) {
            res += sc.nextLine() + "\n";
         }
         System.out.println("Lectura terminada......");

      } catch (FileNotFoundException e) {
         System.out.println("Fichero " + rutaArchivo + " no encontrado.");
      } catch (Exception e) {
         System.out.println("Mensaje:  " + e.getMessage());
      } finally {
         try {
            if (sc != null) {
               sc.close();
            }
         } catch (Exception e2) {
            System.out.println("Mensaje fichero:   " + e2.getMessage());
         }

      }

      return res;

   }

   //-----------------------------------------------------------------------
   /**
    * Esrbir fecha (Calendar) a String en formato DD/MM/AÑO
    *
    * @param fecha fecha de Calendar
    * @return String con la fecha guay
    */
   public static String fechaAString(Calendar fecha) {
      int dia, mes, anio;
      String res;

      dia = fecha.get(Calendar.DATE);
      mes = fecha.get(Calendar.MONTH);
      anio = fecha.get(Calendar.YEAR);

      res = dia + "/" + (mes + 1) + "/" + anio;

      return res;
   }

   //-----------------------------------------------------------------------
   /**
    * Transforma de String a Fecha (Calendar)
    *
    * @param fecha
    * @return
    */
   public static Calendar stringAFecha(String fecha) {
      Calendar res = Calendar.getInstance();

      String[] partesFecha = fecha.split("/");
      int dia = IO_ES.stringAInteger(partesFecha[0]);
      int mes = IO_ES.stringAInteger(partesFecha[1]);
      int anio = IO_ES.stringAInteger(partesFecha[2]);

      res.set(anio, (mes - 1), dia);

      return res;

   }

   //-----------------------------------------------------------------------
   public static int stringAInteger(String cadena) {
      int res = 0;

      try {
         res = Integer.parseInt(cadena);

      } catch (NumberFormatException e) {
         System.out.println("Formato de numero incorrecto -> Revisar Datos, te devuelve un 0");

      } catch (Exception e) {
         System.out.println("NO se ha podido realizar la conversión -> Revisar Datos, te devuelve un 0");

      }
      return res;
   }
}
