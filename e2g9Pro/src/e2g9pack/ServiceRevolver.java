package e2g9pack;

public class ServiceRevolver {

    private Revolver revolverCargado;

    /*llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los
        valores deben ser aleatorios.*/
    public void llenarRevolver() {
        this.revolverCargado = new Revolver((byte) (Math.random() * 6 + 1), (byte) (Math.random() * 6 + 1));
    }

    /*mojar(): devuelve true si la posición del agua coincide con la posición actual*/
    public boolean mojar() {
        return ((int) this.revolverCargado.getPosicionActual() == (int) this.revolverCargado.getPosicionAgua());
    }

    /*siguienteChorro(): cambia a la siguiente posición del tambor*/
    public void siguienteChorro() {

        if (this.revolverCargado.getPosicionActual() <= 6) {
            this.revolverCargado.setPosicionActual((byte) (this.revolverCargado.getPosicionActual() + 1));
            //System.out.println(this.revolverCargado.getPosicionActual());
            //System.out.println(this.revolverCargado.getPosicionAgua());
        } else {
            this.revolverCargado.setPosicionActual((byte) 1);
        }
        

    }

    /*toString(): muestra información del revolver (posición actual y donde está el agua)*/
    @Override
    public String toString() {
        return "revolverCargado= " + revolverCargado + '}';
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
