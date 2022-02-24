package e4ExG9Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Voto {

    private Alumno alumnoQueVota;
    private ArrayList<Alumno> alumnosVotados;
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
    public HashMap<Alumno, ArrayList<Alumno>> votanteY3Votados(ArrayList<Alumno> listaAlumnosVotantes) {
        HashMap<Alumno, ArrayList<Alumno>> votanteY3VotadosMap = new HashMap<>();
        ArrayList<Alumno> listaAlumnosAVotar = (ArrayList) listaAlumnosVotantes.clone();

        ArrayList<Alumno> tresAlumnos = new ArrayList<>();
        ArrayList<ArrayList<Alumno>> listaDeATres = new ArrayList<>();

        for (Alumno j : listaAlumnosVotantes) {
            Collections.shuffle(listaAlumnosAVotar);
            int k = 0;
            for (Alumno i : listaAlumnosAVotar) {
                if (!i.equals(j)) {
                    //j.setNroDeVotos(0);
                    //i.setNroDeVotos(0);
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
        System.out.println("------------------------------------------------------------");
        System.out.println("----------Alumn@ y a quienes votó----------");
        for (Map.Entry<Alumno, ArrayList<Alumno>> i : votanteY3VotadosMap.entrySet()){
            System.out.println("------------------------------------------------------------");
            System.out.println(i.getKey().getNombreCompleto()+i.getKey().getDni()+"votó a:\n");
            for(Alumno j:i.getValue()){
            System.out.println((j.getNombreCompleto()+"--"+j.getDni()).replaceAll("\\[|\\]",""));
            }
            System.out.println("------------------------------------------------------------");
        }
        
        
        return votanteY3VotadosMap;
    }

    /*
    Se debe crear un método que muestre a cada Alumno con su cantidad de votos y
    cuales fueron sus 3 votos.
     */
    public void alumnosVotosRecividosYQuienesVotaronPorEllos(HashMap<Alumno, ArrayList<Alumno>> votanteY3VotadosMap) {
        int k = 0;
        HashMap<String, ArrayList<String>> alumnoYQuienesVotaronPorEl = new HashMap<>();
        
        for (Map.Entry<Alumno, ArrayList<Alumno>> j : votanteY3VotadosMap.entrySet()) {
            ArrayList<String> QuienesVotaronPorEl = new ArrayList<>();
            for (Map.Entry<Alumno, ArrayList<Alumno>> i : votanteY3VotadosMap.entrySet()) {
                if (i.getValue().contains(j.getKey())) {
                    QuienesVotaronPorEl.add("\n"+i.getKey().getNombreCompleto()+"--"+i.getKey().getDni());
                    alumnoYQuienesVotaronPorEl.put(j.getKey().getNombreCompleto(), QuienesVotaronPorEl);
                    k++;
                    j.getKey().setNroDeVotos(k);  
                    
                }
            }
            
            alumnosVotados.add(j.getKey());
            //alumnoYsusVotosRecibidos.add...
            k = 0;
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("\n----------Alumn@s y sus votos recibidos----------");
        for (Alumno i : alumnosVotados) {
            System.out.print(i);
        }
        System.out.println("\n------------------------------------------------------------");
        System.out.println("----------Alumn@s votad@s y quienes votaron por ell@s----------");
        for (Map.Entry<String, ArrayList<String>> i : alumnoYQuienesVotaronPorEl.entrySet()) {
            System.out.println("------------------------------------------------------------");
            System.out.println(i.getKey() + "fue votad@ por:");

            System.out.println(i.getValue().toString().replaceAll("\\[|\\]|[,]", ""));

            System.out.println("------------------------------------------------------------");
        }
    }

    //System.out.println(alumnoYsusVotosRecibidos.toString());//mostrar en for
    //System.out.println("Alumno y los que votaron por el/lla:");
    //System.out.println(alumnoYQuienesVotaronPorEl.toString());
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
Alumnos y comienza a hacer el recuento de votos.
• Se deben crear 5 facilitadores con los 5 primeros alumnos votados y se deben crear
5 facilitadores suplentes con los 5 segundos alumnos más votados. A continuación,
mostrar los 5 facilitadores y los 5 facilitadores suplentes.*/
