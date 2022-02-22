
package e1g9Paquete;

import java.util.Locale;
import java.util.Scanner;


public class ServicioPersona {
    
    public static Persona crearPersona(){
        Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        System.out.print("Ingrese nombre: ");
        String nombre=entrada.next();
        System.out.print("Ingrese apellido: ");
        String apellido=entrada.next();
        System.out.print("Ingrese edad: ");
        Byte edad=entrada.nextByte();
        System.out.print("Ingrese documento: ");
        String documento=entrada.next();
        return new Persona(nombre,apellido,edad,documento);
    }
    
    public static void asignarPerroAPersona(Persona persona,Perro perro){
        
        persona.setPerro(perro);
    }
    
}
