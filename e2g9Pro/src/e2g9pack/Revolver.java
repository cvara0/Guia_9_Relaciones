
package e2g9pack;


public class Revolver {
    private Byte posicionActual;
    private Byte posicionAgua;

    public Revolver() {
    }

    public Revolver(Byte posicionActual, Byte posicionAgua) {
        this.posicionActual = posicionActual;
        this.posicionAgua = posicionAgua;
    }

    public Byte getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Byte posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Byte getPosicionAgua() {
        return posicionAgua;
    }

    public void setPosicionAgua(Byte posicionAgua) {
        this.posicionAgua = posicionAgua;
    }   
}
/*

Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual
(posición del tambor que se dispara, puede que esté el agua o no) y posición agua (la
posición del tambor donde se encuentra el agua). Estas dos posiciones, se generarán
aleatoriamente.

*/