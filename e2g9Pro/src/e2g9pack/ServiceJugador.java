package e2g9pack;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class ServiceJugador {

    private final Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    private final ServiceRevolver revolver = new ServiceRevolver();
    //   

    public ArrayList<Jugador> cargarJugadoresYLlenarRevolver() {
        ArrayList<Jugador> nuevosJugadores = new ArrayList<>();
        System.out.print("Ingrese cantidad de jugadores (entre 1 y 6): ");
        byte cantidad = entrada.nextByte();
        if (cantidad < 1 || cantidad > 6) {
            cantidad = 6;
        }
        for (byte i = 1; i <= cantidad; i++) {
            nuevosJugadores.add(new Jugador(i, ("Jugador " + i), false));
        }
        this.revolver.llenarRevolver();
        return nuevosJugadores;
    }
    //

    public void mostrarJugadores() {
        System.out.println(cargarJugadoresYLlenarRevolver());
    }

    //
    public boolean disparo() {
        
        this.revolver.siguienteChorro();
        System.out.print(this.revolver.toString());
        return this.revolver.mojar();
    }
}

/*
nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo)

El número de jugadores será decidido por el
usuario, pero debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.

Métodos:

• disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false.*/
