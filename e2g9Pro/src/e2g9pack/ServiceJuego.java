package e2g9pack;

import java.util.ArrayList;

public class ServiceJuego {

    private ServiceJugador partida;
    private ArrayList<Jugador> listaJugadores;

    public void nuevoJuego() {
        this.partida = new ServiceJugador();
        this.listaJugadores = partida.cargarJugadoresYLlenarRevolver();

    }

    public void ronda() {
        boolean balazo;
        byte ronda = 1;
        do {
            balazo = false;
            System.out.println("\n----------------Ronda: " + (ronda++) + "----------------");
            for (Jugador i : this.listaJugadores) {
                i.setMojado(partida.disparo());
                
                System.out.println(i+"\n");
                
                if (i.getMojado()) {
                    balazo = i.getMojado();
                    break;
                }
            }
        } while (!balazo);
        System.out.print("︻╦╤─ ҉ \n\n̿̿");
    }
}
/*
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los
jugadores y el revolver para guardarlos en los atributos del juego.
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego,
sino se moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se
tiene que mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Jugador
 */
