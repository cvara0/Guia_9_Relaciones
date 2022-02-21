package e3g9Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class BarajaServices {

    Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    private Baraja mazo;
    private Byte posicionActual;
    private ArrayList<Carta> salidas;//preguntar por atributos vs variables, es encesario setter y getter?
//
    public void nuevaBaraja() {
        this.mazo = new Baraja();
        this.mazo.crearBarajaEspaniola();
        this.salidas = new ArrayList<>();
        this.posicionActual = 0;
    }
//
    public void barajar() {
        Collections.shuffle(this.mazo.getNuevaBaraja());
    }
//
    public List<Carta>/*String*/ siguienteCarta() { //preguntar list
        if (this.posicionActual >= 40) {
            System.out.println("No hay más cartas disponibles");
            return null;
        }
        this.salidas.addAll(this.mazo.getNuevaBaraja().subList((this.posicionActual), (this.posicionActual + 1)));
        this.posicionActual++;
        return (this.mazo.getNuevaBaraja().subList((this.posicionActual - 1), (this.posicionActual))/*.toString*/);
    }
//
    public void cartasDisponibles() {
        System.out.println("Cartas disponibles: " + (40 - this.posicionActual));
    }
//
    public ArrayList<Carta> darCartas(Byte retirar) {
        ArrayList<Carta> cartasADar = new ArrayList<>();
        if (this.posicionActual == 41 || retirar > 40 - this.posicionActual) {
            System.out.println("No quedan mas cartas en el mazo!");
            return null;
        }
        cartasADar.addAll(this.mazo.getNuevaBaraja().subList((this.posicionActual), (this.posicionActual + retirar)));
        this.salidas.addAll(cartasADar);
        this.posicionActual = (byte) ((int) this.posicionActual + (int) retirar);
        return cartasADar;
    }
    //
    public void cartasMonton() {
        if (this.salidas.isEmpty()) {
            System.out.println("Aun no ha salido ninguna carta");
        } else {
            for (Carta i : this.salidas) {
                System.out.println(i);
            }
        }
    }
    //
    public void mostrarBaraja() {
        for (Carta i : this.mazo.getNuevaBaraja().subList((this.posicionActual), 40)) {
            System.out.println(i);
        }
    }
    //
    public void menu() {
        byte opcion;
        boolean creada = false;
        do {
            System.out.println("");
            System.out.println("1. Crear nueva baraja española");
            System.out.println("2. Retirar la siguiente carta");
            System.out.println("3. Retirar varias cartas");
            System.out.println("4. Mostrar total de cartas retiradas");
            System.out.println("5. Mostrar la baraja compelta");
            System.out.println("6. Cantidad de cartas disponibles");
            System.out.println("\n7. Salir");
            System.out.print("\nOpción: ");
            opcion = entrada.nextByte();
            System.out.println();
            switch (opcion) {
                case 1:
                    nuevaBaraja();
                    barajar();
                    creada = true;
                    System.out.println("Creada y mezclada nueva baraja española\n");
                    break;
                case 2:
                    if (creada) {
                        System.out.println("La siguiente carta es: " + siguienteCarta());
                    } else {
                        System.out.println("Cree una nueva baraja para comenzar\n");
                    }
                    break;
                case 3:
                    if (creada) {
                        System.out.print("Ingrese cantidad de cartas a sacar: ");
                        byte cantidad = entrada.nextByte();
                        System.out.println("Las cartas retiradas son:\n");
                        for (Carta i : darCartas(cantidad)) {
                            System.out.println(i);
                        }
                    } else {
                        System.out.println("Cree una nueva baraja para comenzar\n");
                    }
                    break;
                case 4:
                    if (creada) {
                        System.out.println("Las cartas totales retiradas son:\n");
                        cartasMonton();
                    } else {
                        System.out.println("Cree una nueva baraja para comenzar\n");
                    }
                    break;
                case 5:
                    if (creada) {
                        System.out.println("La baraja completa es:\n");
                        cartasMonton();
                        mostrarBaraja();
                    } else {
                        System.out.println("Cree una nueva baraja para comenzar\n");
                    }
                    break;
                case 6:
                    if (creada) {
                        cartasDisponibles();
                    } else {
                        System.out.println("Cree una nueva baraja para comenzar\n");
                    }
                    break;
                case 7:
                    System.out.println("Fin\n");
                    break;
                default:
                    System.out.println("Error, ingreso incorrecto\n");
            }
        } while (opcion != 7);
    }
}
/*
  Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número
entre 1 y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas). Esta
clase debe contener un método toString() que retorne el número de carta y el palo. La
baraja estará compuesta por un conjunto de cartas, 40 exactamente.
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente.
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya
más o se haya llegado al final, se indica al usuario que no hay más cartas.
• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número
de cartas. En caso de que haya menos cartas que las pedidas, no devolveremos
nada, pero debemos indicárselo al usuario.
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
indicárselo al usuario
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta
y luego se llama al método, este no mostrara esa primera carta.
 */
