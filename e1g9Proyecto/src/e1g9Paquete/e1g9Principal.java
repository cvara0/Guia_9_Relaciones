
package e1g9Paquete;

import java.util.Locale;
import java.util.Scanner;


public class e1g9Principal {

    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        
        System.out.println("Ingrese datos de persona 1: ");
        Persona persona1=ServicioPersona.crearPersona();
        System.out.println("");
        System.out.println("Ingrese datos de perro a asignarle: ");
        Perro perro1=ServiciosPerro.crearPerro();
        ServicioPersona.asignarPerroAPersona(persona1, perro1);
        System.out.printf("%s fue asignado a %s \n\n",perro1.getNombre(),persona1.getNombre());
        
       /* System.out.println("Ingrese datos de persona 2: ");
        Persona persona2=ServicioPersona.crearPersona();
        System.out.println("");
        System.out.println("Ingrese datos de perro a asignarle: ");
        Perro perro2=ServiciosPerro.crearPerro();
        ServicioPersona.asignarPerroAPersona(persona2, perro2);
        System.out.printf("%s fue asignado a %s \n\n",perro2.getNombre(),persona2.getNombre());*/
        
        System.out.println(persona1);
        //System.out.println(persona2);
        
    }

    
}

/*

 Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de
dos clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase
Persona con atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener
que pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo,
mostrar desde la clase Persona, la información del Perro y de la Persona

*/