/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author macbookpro
 */
public class Inscripcion {
        /**
    * Puerto
    * */
    private final static int PORT = 5000;
    /**
    * Host
    * */
    private final static String SERVER = "192.168.0.104";
    
    
    
   public String generarContraseña(){
    char letra;
       
        //pass es el String que almacenará la contraseña final.
        String pass = "", texto = "8";
       
        //'num' y 'aleatorio' almacenarán números aleatorios.
        //'repet' es la cantidad de veces que se repetirá el bucle de la contraseña.
        int num, repet, aleatorio;
       
        //Método que permitirá crear un número aleatorio.
        Random r = new Random();
       
      
        repet = Integer.parseInt(texto);
       
        //Comenzamos el bucle para crear la contraseña.
        for(int i = 1; i <= repet; i++)
        {  
            //Creamos un número aleatorio del 1 al 3
            aleatorio = r.nextInt(3)+1;
           
            //Si el número es 1 crearemos un número aleatorio
            if(aleatorio == 1)
            {
                //Hacemos llamado al método 'randomNum' y le asignamos el valor que devolverá a la variable 'num'.
                num = randomNum();
                //Concatenamos el número que recibimos con el resto de la cadena que llevamos.
                pass += String.valueOf(num);
            }
           
            //Si el número es 2 crearemos una letra minúscula aleatoria
            if(aleatorio == 2)
            {
                //Hacemos llamado al método 'randomLetraMinus' y le asignamos el char que devolverá a la variable 'letra'.
                letra = randomLetraMinus();
                //Concatenamos el char que recibimos con el resto de la cadena que llevamos.
                pass += String.valueOf(letra);
            }
           
            //Si el número es 3 crearemos una letra mayúscula aleatoria
            if(aleatorio == 3)
            {
                //Hacemos llamado al método 'randomLetraMayus' y le asignamos el char que devolverá a la variable 'letra'.
                letra = randomLetraMayus();
                //Concatenamos el char que recibimos con el resto de la cadena que llevamos.
                pass += String.valueOf(letra);
            }
           
        }
       
        //Imprimimos en pantalla la contraseña.
        JOptionPane.showMessageDialog(null, "Su contraseña es : "+pass+" se le enviara al correo");
        
       return pass;
    }

    private static int randomNum() {
        Random r = new Random();
        int aleatorio = r.nextInt(9)+1;
        return aleatorio;     
    }

    private static char randomLetraMinus() {
        char a;
       
        Random r = new Random();
        double aleatorio = Math.floor(Math.random()*(122-97+1)+97);
       
        a = (char)aleatorio;
       
        return a;
    }

    private static char randomLetraMayus() {
        char a;
       
        Random r = new Random();
        double aleatorio = Math.floor(Math.random()*(90-65+1)+65);
       
        a = (char)aleatorio;
       
        return a;
    }

    public String agregar (Estudiante objEs){
      String cadena =objEs.getCedula()+","+objEs.getPnombre()+","+objEs.getSnombre()+","+objEs.getPapellido()+","+objEs.getMapellido()+","+objEs.getFnac()+","+objEs.getGenero()+","+objEs.getCiudad()+","+objEs.getCorreo()+","+objEs.getTipo_est()+","+objEs.getClave();
       System.out.println("+++++++++++++"+cadena);
        enviar(cadena);
       return  cadena;
     
  } 

    public String enviar(String cadena) {
    	boolean exit=false;//bandera para controlar ciclo del programa
        Socket socket;//Socket para la comunicacion cliente servidor        
               System.out.println("........."+cadena);
               
            System.out.println("Cliente> Inicio");  
           
                try {
                //ciclo repetitivo
                socket = new Socket(SERVER, PORT);//abre socket
                //Para leer lo que envie el servidor
                BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                //para imprimir datos del servidor
                PrintStream output = new PrintStream(socket.getOutputStream());
                //Para leer lo que escriba el usuario
                //BufferedReader brRequest = new BufferedReader(new InputStreamReader(System.in));
                //System.out.println("Cliente> Escriba comando");                
                //captura comando escrito por el usuario
                String request = cadena;                
                //manda peticion al servidor
                output.println(request); 
                //captura respuesta e imprime
                String st = input.readLine();
                if( st != null ) System.out.println("Servidor> " + st );    
                if(request.equals("exit")){//terminar aplicacion
                    exit=true;
                    System.out.println("Cliente> Fin de programa");
                }  
                socket.close();
                } //end while                                    
                catch (IOException ex) {
                    Logger.getLogger(Inscripcion.class.getName()).log(Level.SEVERE, null, ex);
                }
            
      return cadena;
    }    
   
   
   public static String validarC(String correo){
     
    String msn = "";       
// Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar
        
 
        Matcher mather = pattern.matcher(correo);
 
        if (mather.find() == true) {
          msn = "ok";
        } else {
           msn = "fall";
        }
        return msn;
    }
    
}
