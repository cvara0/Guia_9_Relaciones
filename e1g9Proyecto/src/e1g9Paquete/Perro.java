
package e1g9Paquete;

public class Perro {
    private String nombre;
    private String raza;
    private Byte edad;
    private Character tamanio;

    public Perro(String nombre, String raza, Byte edad, Character tamanio) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamanio = tamanio;
    }

    public Perro() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Byte getEdad() {
        return edad;
    }

    public void setEdad(Byte edad) {
        this.edad = edad;
    }

    public Character getTamanio() {
        return tamanio;
    }

    public void setTamanio(Character tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "\nPerro asignado:\n" + "nombre: " + nombre + ", raza: " + raza + ", edad: " + edad + ", tamanio: " + tamanio;
    }
   
    
}
