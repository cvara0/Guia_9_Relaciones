package e2g9pack;

public class ServiceRevolver {

    private Revolver revolverCargado;

    public void llenarRevolver() {
        this.revolverCargado = new Revolver((byte) (Math.random() * 6 + 1), (byte) (Math.random() * 6 + 1));
    }

    public boolean mojar() {
        return ((int) this.revolverCargado.getPosicionActual() == (int) this.revolverCargado.getPosicionAgua());
    }

    public void siguienteChorro() {

        if (this.revolverCargado.getPosicionActual() < 6) {
            this.revolverCargado.setPosicionActual((byte) (this.revolverCargado.getPosicionActual() + 1));
   
        } else {
            this.revolverCargado.setPosicionActual((byte) 1);
        }
    }

    @Override
    public String toString() {
        return "Posición actual: " + this.revolverCargado.getPosicionActual() + ", Posición del agua: "+this.revolverCargado.getPosicionAgua();
    }

}

/*


Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los
valores deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)


 */
