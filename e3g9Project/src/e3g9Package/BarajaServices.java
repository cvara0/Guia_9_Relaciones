package e3g9Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class BarajaServices {

    Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    private Baraja mazo;
    private Byte posicionActual = 0;
    private ArrayList<Carta> salidas=new ArrayList<>();

    public void nuevaBaraja() {
        mazo = new Baraja();
        mazo.crearBarajaEspaniola();
    }

    public void barajar() {

        Collections.shuffle(this.mazo.getNuevaBaraja());
        //System.out.println(mazo.getNuevaBaraja());

    }

    public void siguienteCarta() {
        Character otra;
        // byte var=this.posicionActual;
        do {
            System.out.print("¿Mostrar siguiente? s/n: ");
            otra = entrada.next().charAt(0);

            if (otra == 's') {

                //System.out.println((int)this.posicionActual);
                //cartasDisponibles();
                
                System.out.println(this.mazo.getNuevaBaraja().subList((this.posicionActual), (this.posicionActual + 1)));
                this.salidas.addAll(this.mazo.getNuevaBaraja().subList((this.posicionActual), (this.posicionActual + 1)));
                System.out.println();
                this.posicionActual++;
            }
        } while (otra == 's' && this.posicionActual < 40);
        //System.out.println(mazo.getNuevaBaraja());
        if (this.posicionActual == 40) {
            System.out.println("No quedan mas cartas en el mazo!");
        }
    }
//
    public void cartasDisponibles() {
        System.out.println("Cartas disponibles: " + (40 - this.posicionActual));
    }
//
    public void darCartas() {
        byte posActualAux = this.posicionActual;
        System.out.print("Cantidad de cartas a retirar: ");
        byte retirar = entrada.nextByte();
        if (retirar <= 40 - this.posicionActual) {
            System.out.printf("Dando %d cartas:\n\n", retirar);
            do {
                this.salidas.addAll(this.mazo.getNuevaBaraja().subList((this.posicionActual), (this.posicionActual + 1)));
                System.out.println(this.mazo.getNuevaBaraja().subList((this.posicionActual), (this.posicionActual + 1)));
                System.out.println();
                this.posicionActual++;

            } while (this.posicionActual < retirar + posActualAux && this.posicionActual < 40);
            if (this.posicionActual == 40) {
                System.out.println("No quedan mas cartas en el mazo!");
            }
        } else {
            System.out.printf("No hay %d cartas en el mazo\n",retirar);
        }
    }
    //
    public void cartasMonton(){
    
        System.out.println("Cartas que ya han salido:");
        for(Carta i:this.salidas){
        System.out.println(i);
        }
       
    }
    //
    public void mostrarBaraja(){
    System.out.println("Cartas en el mazo:");
        for(Carta i:this.mazo.getNuevaBaraja().subList((this.posicionActual), 40)){
        System.out.println(i);
        }
        
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
