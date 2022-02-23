package e3G9_2_paquete;

public class Carta {
    
    private Byte numero;
    private Character palo;

    public Carta(Byte numero, Character palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public Carta() {
    }

    public Byte getNumero() {
        return numero;
    }

    public void setNumero(Byte numero) {
        this.numero = numero;
    }

    public Character getPalo() {
        return palo;
    }

    public void setPalo(Character palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "nro: " + numero + " palo: " + palo+"\n";
    }
    
    
}
