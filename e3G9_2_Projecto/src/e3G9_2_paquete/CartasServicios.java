package e3G9_2_paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class CartasServicios {//PREGUNTAR

    private static Carta carta;
    private static final ArrayList<Carta> barajaEspaniola = new ArrayList<>();//PREGUNTAR
    private static final ArrayList<Carta> cartasSacadas = new ArrayList<>();//PREGUNTAR
    //
    public static Carta getCarta() {
        return CartasServicios.carta;
    }
    public static ArrayList<Carta> getBarajaEspaniola() {
        return CartasServicios.barajaEspaniola;
    }
    public static ArrayList<Carta> getCartasSacadas() {
        return CartasServicios.cartasSacadas;
    }
    //
    public static void crearBarajaEspaniola() {
        CartasServicios.cartasSacadas.clear();
        CartasServicios.barajaEspaniola.clear();
        for (byte i = 0; i < 13; i++) {
            if (i > 0 && i < 8 || i > 9 && i < 13) {
                CartasServicios.barajaEspaniola.add(new Carta(i, 'c'));
                CartasServicios.barajaEspaniola.add(new Carta(i, 'd'));
                CartasServicios.barajaEspaniola.add(new Carta(i, 't'));
                CartasServicios.barajaEspaniola.add(new Carta(i, 'p'));
            }
        }
        Collections.shuffle(CartasServicios.barajaEspaniola);
    }
    //
    public static void siguienteCarta() {
        Iterator<Carta> iteradorBarajaEspaniola = CartasServicios.barajaEspaniola.iterator();
        if (!CartasServicios.barajaEspaniola.isEmpty()) {
            Carta cartaSacada = iteradorBarajaEspaniola.next();
            System.out.print("La siguiente carta es: " + cartaSacada);
            CartasServicios.cartasSacadas.add(cartaSacada);
            iteradorBarajaEspaniola.remove();
            if (CartasServicios.barajaEspaniola.isEmpty()) {
                System.out.println("No quedan mas cartas!");
            }
        } else {
            System.out.println("No quedan mas cartas!");
        }
    }
    //
    public static void cartasDisponibles() {
        System.out.printf("Aun se pueden repartir %d cartas\n", CartasServicios.barajaEspaniola.size());
        System.out.printf("Se han retirado %d cartas\n", CartasServicios.cartasSacadas.size());
    }
    //
    public static void darCartas(byte cantidad) {
        if (!CartasServicios.barajaEspaniola.isEmpty()) {
            if (cantidad <= CartasServicios.barajaEspaniola.size()) {
                System.out.println(cantidad + " cartas sacadas: ");
                Iterator<Carta> iteradorBarajaEspaniola = CartasServicios.barajaEspaniola.iterator();
                for (int i = 0; i < cantidad; i++) {
                    Carta cartaSacada = iteradorBarajaEspaniola.next();
                    System.out.print(cartaSacada);
                    CartasServicios.cartasSacadas.add(cartaSacada);
                    iteradorBarajaEspaniola.remove();
                }
                if (CartasServicios.barajaEspaniola.isEmpty()) {
                    System.out.println("No quedan mas cartas!");
                }
            } else {
                System.out.println("No hay suficientes cartas!");
            }
        } else {
            System.out.println("No quedan mas cartas!");
        }
    }
    //
    public static void cartasMonton() {
        System.out.println("Cartas que ya han salido:");
        System.out.println(CartasServicios.cartasSacadas.toString().replaceAll("\\[|\\]|[,]", ""));
    }
    //
    public static void mostrarBaraja() {
        System.out.println("Mostrando todas las cartas:");
        System.out.print(CartasServicios.cartasSacadas.toString().replaceAll("\\[|\\]|[,]", ""));
        System.out.println(CartasServicios.barajaEspaniola.toString().replaceAll("\\[|\\]|[,]", ""));
    }
    //
    public static void menu() {
        Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
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
                    crearBarajaEspaniola();
                    creada = true;
                    System.out.println("Creada y mezclada nueva baraja española\n");
                    break;
                case 2:
                    if (creada) {
                        siguienteCarta();
                    } else {
                        System.out.println("Cree una nueva baraja para comenzar\n");
                    }
                    break;
                case 3:
                    if (creada) {
                        System.out.print("Ingrese cantidad de cartas a sacar: ");
                        byte cantidad = entrada.nextByte();
                        darCartas(cantidad);
                    } else {
                        System.out.println("Cree una nueva baraja para comenzar\n");
                    }
                    break;
                case 4:
                    if (creada) {
                        cartasMonton();
                    } else {
                        System.out.println("Cree una nueva baraja para comenzar\n");
                    }
                    break;
                case 5:
                    if (creada) {
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
