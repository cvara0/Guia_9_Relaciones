
package e1g9Paquete;

import java.util.Locale;
import java.util.Scanner;


public class ServiciosPerro {
    
    public static Perro crearPerro(){
        Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        System.out.print("Ingrese nombre: ");
        String nombre=entrada.next();
        System.out.print("Ingrese Raza: ");
        String raza=entrada.next();
        System.out.print("Ingrese edad: ");
        Byte edad=entrada.nextByte();
        System.out.print("Ingrese tamaño: ");
        Character tamanio=entrada.next().charAt(0);
        return new Perro(nombre,raza,edad,tamanio);
    }
    
}
