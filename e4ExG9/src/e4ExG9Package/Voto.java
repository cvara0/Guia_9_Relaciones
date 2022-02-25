package e4ExG9Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Voto {

    private Alumno alumnoQueVota;
    private ArrayList<Alumno> alumnosVotados;

    private Integer cantidadVotosTotales = 0;
    private final HashMap<Alumno, ArrayList<String>> alumnoYQuienesVotaronPorEl = new HashMap<>();
    private final HashMap<Alumno, ArrayList<Alumno>> votanteY3VotadosMap = new HashMap<>();
    //

    public Voto() {
        alumnosVotados = new ArrayList<>();
    }

    public Voto(Alumno alumnoQueVota, ArrayList<Alumno> alumnosQueVoto) {
        this.alumnoQueVota = alumnoQueVota;
        this.alumnosVotados = alumnosQueVoto;
    }
    //

    public Alumno getAlumnoQueVota() {
        return alumnoQueVota;
    }

    public void setAlumnoQueVota(Alumno alumnoQueVota) {
        this.alumnoQueVota = alumnoQueVota;
    }
    //

    public ArrayList<Alumno> getAlumnosQueVoto() {
        return alumnosVotados;
    }

    public void setAlumnosQueVoto(ArrayList<Alumno> alumnosQueVoto) {
        this.alumnosVotados = alumnosQueVoto;
    }

    //
    /*Crearemos un método votación en la clase Simulador que, recibe el listado de
      alumnos y para cada alumno genera tres votos de manera aleatoria. En este método
      debemos guardar a el alumno que vota, a los alumnos a los que votó y sumarle uno
      a la cantidad de votos a cada alumno que reciba un voto, que es un atributo de la
      clase Alumno.
      Tener en cuenta que un alumno no puede votarse a sí mismo o votar más de una vez
      al mismo alumno. Utilizar un hashset para resolver esto.*/
    public void votanteY3Votados(ArrayList<Alumno> listaAlumnosVotantes) {
        ArrayList<Alumno> listaAlumnosAVotar = (ArrayList) listaAlumnosVotantes.clone();
        ArrayList<Alumno> tresAlumnos = new ArrayList<>();
        ArrayList<ArrayList<Alumno>> listaDeATres = new ArrayList<>();

        for (Alumno j : listaAlumnosVotantes) {
            Collections.shuffle(listaAlumnosAVotar);
            int k = 0;
            for (Alumno i : listaAlumnosAVotar) {
                if (!i.equals(j)) {
                    tresAlumnos.add(i);
                    k++;
                }
                if (k == 3) {
                    break;
                }
            }
            listaDeATres.add((ArrayList<Alumno>) tresAlumnos.clone());
            votanteY3VotadosMap.put(j, (ArrayList<Alumno>) tresAlumnos.clone());
            listaDeATres.clear();
            tresAlumnos.clear();
        }

    }

    /*
    Se debe crear un método que muestre a cada Alumno con su cantidad de votos y
    cuales fueron sus 3 votos.
     */
    public void conteoDeVotos(/*HashMap<Alumno, ArrayList<Alumno>> votanteY3VotadosMap*/) {
        int k = 0;

        for (Map.Entry<Alumno, ArrayList<Alumno>> j : votanteY3VotadosMap.entrySet()) {
            ArrayList<String> QuienesVotaronPorEl = new ArrayList<>();
            for (Map.Entry<Alumno, ArrayList<Alumno>> i : votanteY3VotadosMap.entrySet()) {
                if (i.getValue().contains(j.getKey())) {
                    QuienesVotaronPorEl.add("\n" + i.getKey().getNombreCompleto() + "--" + i.getKey().getDni());
                    alumnoYQuienesVotaronPorEl.put(j.getKey(), QuienesVotaronPorEl);
                    k++;
                    j.getKey().setNroDeVotos(k);
                }
            }
            alumnosVotados.add(j.getKey());
            k = 0;
        }
    }

    public void mostrarAlumnoYQuienesVotaronPorEl() {
        System.out.println("\n------------------------------------------------------------");
        System.out.println("----------Alumn@s votad@s y quienes votaron por ell@s----------");
        for (Map.Entry<Alumno, ArrayList<String>> i : alumnoYQuienesVotaronPorEl.entrySet()) {
            System.out.println("------------------------------------------------------------");
            System.out.println(i.getKey() + " fue votad@ por:");

            System.out.println(i.getValue().toString().replaceAll("\\[|\\]|[,]", ""));

            System.out.println("------------------------------------------------------------");
        }
    }

    public void mostrarAlumnosYCantidadDeVotosRecibidos() {
        System.out.println("------------------------------------------------------------");
        System.out.println("\n----------Alumn@s y sus votos recibidos----------");
        for (Alumno i : alumnosVotados) {
            cantidadVotosTotales += i.getNroDeVotos();
            System.out.println(i);
            System.out.print("------------------------------------------------------------");
        }

    }

    public void mostrarVotanteYSus3Votados() {

        System.out.println("------------------------------------------------------------");
        System.out.println("----------Alumn@ y a quienes votó----------");
        for (Map.Entry<Alumno, ArrayList<Alumno>> i : votanteY3VotadosMap.entrySet()) {
            System.out.println("------------------------------------------------------------");
            System.out.println(i.getKey().getNombreCompleto() + i.getKey().getDni() + "votó a:\n");
            for (Alumno j : i.getValue()) {
                System.out.println((j.getNombreCompleto() + "--" + j.getDni()).replaceAll("\\[|\\]", ""));
            }
            System.out.println("------------------------------------------------------------");
        }

    }

    public void mostrar5FacilitadoresYSuplentes() {
        Collections.sort(alumnosVotados);
        System.out.println("------------------------------------------------------------");
        System.out.println("\n--------------5 facilitadores y 5 suplentes---------------");
        byte j = 0;
        for (Alumno i : alumnosVotados) {
            System.out.println(i);
            j++;
            if (j == 10) {
                break;
            }
            System.out.print("------------------------------------------------------------");
        }
    }

    public void mostrarCantidadDeVotosTotal() {
        for (Alumno i : alumnosVotados) {
            cantidadVotosTotales += i.getNroDeVotos();
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("La cantidad de votos emitidos fue: " + cantidadVotosTotales);
        System.out.println("------------------------------------------------------------");
    }

}

/*Una vez hecho esto debemos generar una clase Voto, esta clase tendrá como
atributos, un objeto Alumno que será el alumno que vota y una lista de los alumnos a
los que votó.
• Crearemos un método votación en la clase Simulador que, recibe el listado de
alumnos y para cada alumno genera tres votos de manera aleatoria. En este método
debemos guardar a el alumno que vota, a los alumnos a los que votó y sumarle uno
a la cantidad de votos a cada alumno que reciba un voto, que es un atributo de la
clase Alumno.
Tener en cuenta que un alumno no puede votarse a sí mismo o votar más de una vez
al mismo alumno. Utilizar un hashset para resolver esto.
• Se debe crear un método que muestre a cada Alumno con su cantidad de votos y
cuales fueron sus 3 votos.
• Se debe crear un método que haga el recuento de votos, este recibe la lista de
Alumnos y comienza a hacer el recuento de votos.?¿?¿?¿??¿ votos totales?
• Se deben crear 5 facilitadores con los 5 primeros alumnos votados y se deben crear
5 facilitadores suplentes con los 5 segundos alumnos más votados. A continuación,
mostrar los 5 facilitadores y los 5 facilitadores suplentes.*/
