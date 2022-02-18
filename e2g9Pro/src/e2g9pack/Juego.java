package e2g9pack;

public class Juego {

    private final ServiceJuego objeto = new ServiceJuego();

    public void jugar() {
        objeto.nuevoJuego();
        objeto.ronda();
    }

}
/*Clase Juego: esta clase posee los siguientes atributos: Juego (conjunto de
Juego) y Revolver*/
