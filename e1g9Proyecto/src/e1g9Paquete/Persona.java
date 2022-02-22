
package e1g9Paquete;


public class Persona {
    private String nombre;
    private String apellido;
    private Byte edad;
    private String documento;
    private Perro perro;

    public Persona(String nombre, String apellido, Byte edad, String documento, Perro perro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perro = perro;
    }
    public Persona(String nombre, String apellido, Byte edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }
    

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Byte getEdad() {
        return edad;
    }

    public void setEdad(Byte edad) {
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    @Override
    public String toString() {
        return "\nPersona:\n" + "nombre: " + nombre + ", apellido: " + apellido + ", edad: " + edad + ", documento: " + documento + perro;
    }
    
    
    
    
}
