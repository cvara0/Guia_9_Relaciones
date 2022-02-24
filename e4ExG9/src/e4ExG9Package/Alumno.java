
package e4ExG9Package;


public class Alumno {
    private String nombreCompleto;
    private String dni;
    private Integer nroDeVotos;

    public Alumno(String nombreCompleto, String dni, Integer nroDeVotos) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.nroDeVotos = nroDeVotos;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getNroDeVotos() {
        return nroDeVotos;
    }

    public void setNroDeVotos(Integer nroDeVotos) {
        this.nroDeVotos = nroDeVotos;
    }

    @Override
    public String toString() {
        return "\n" + nombreCompleto + "--" + dni + "-- Votos: "+nroDeVotos;
    }
    
     
}
