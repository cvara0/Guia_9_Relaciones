package e4ExG9Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Spliterator;

public class Simulador {
private final Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    /*
    La clase Simulador debe tener un método que genere un listado de alumnos de manera
    aleatoria y lo retorne. 
    Las combinaciones de nombre y apellido deben ser generadas
    de manera aleatoria. Nota: usar listas de tipo String para generar los nombres y los
    apellidos.
    
     */
    public ArrayList<String> generarListadoNombreApellidoAleatorio(Integer cantidad) {
        
        
        ArrayList<String> nombresF = new ArrayList<>(Arrays.asList("Ana", "Noelia", "Yenifer", "Adriana", "Sofía", "Mariana", "Miriam", "Rosa", "María", "Florencia", "Beatriz", "Raquel", "Pamela", "Carolina", "Fernanda", "Laura", "Carla", "Diana"));
        ArrayList<String> nombresM = new ArrayList<>(Arrays.asList("Mario", "Alejandro", "Daniel", "Eduardo", "Ricardo", "Federico", "Andres", "Franciso", "Hector", "Mauricio", "Alberto", "Aaron", "Juan", "Dylan", "Brian", "Alfredo", "Sebastián", "Maximiliano"));
        ArrayList<String> segundosNombresF = new ArrayList<>(Arrays.asList("Victoria", "Patricia", "Estefania", "Erica", "Jacinta", "Ramona", "Andrea", "Liliana", "Yanina", "Mirta", "Lorena", "Mara"));
        ArrayList<String> segundosNombresM = new ArrayList<>(Arrays.asList("Manuel", "Fernando", "Rodrigo", "Esteban", "Victor", "Pablo", "Ruben", "Gustavo", "Ricardo", "Jose", "Julian", "Pedro"));
        ArrayList<String> apellidos = new ArrayList<>(Arrays.asList("Pérez", "Sanchez", "Sandoval", "Toledo", "Vallejos", "Salinas", "Salazar", "Pedrozo", "Ojeda", "Rojas", "Cáceres", "Oviedo", "Rodriguez", "Gonzales", "Gomez", "García", "Cardozo", "Andrade", "Ayala", "Sotelo", "Carvallo", "Benitez", "Santiago", "Aquino", "Villalba", "Silva", "Maciel", "Escobar", "Sosa", "Diaz", "Dominguez", "Olivera", "Barbosa"));
        ArrayList<String> nombresCompletos = new ArrayList<>();
        byte i = 0;
        
        
        /*System.out.println("nombresF "+nombresF.size());
        System.out.println("nombresM "+nombresM.size());
        System.out.println("segundosNombresF "+segundosNombresF.size());
        System.out.println("segundosNombresM "+segundosNombresM.size());
        System.out.println("apellidos "+apellidos.size());*/
        while (nombresCompletos.size() < cantidad) {
            Collections.shuffle(nombresF);
            Collections.shuffle(nombresM);
            Collections.shuffle(segundosNombresF);
            Collections.shuffle(segundosNombresM);
            Collections.shuffle(apellidos);
            if ((int) (Math.random() * 3 + 1) % 2 == 0) {
                if ((int) (Math.random() * 3 + 1) % 2 == 0) {//otra forma tambien .replaceAll("\\[|\\]", " ").replaceAll("\\s\\s", " ")
                    nombresCompletos.add((nombresF.subList(i, i + 1).toString() + apellidos.subList(i, i + 1).toString()).replace("[", "").replace("]", " "));//corregir los tostring
                } else {
                    nombresCompletos.add((nombresF.subList(i, i + 1).toString() + segundosNombresF.subList(i, i + 1).toString() + apellidos.subList(i, i + 1).toString()).replace("[", "").replace("]", " "));
                }
            } else {
                if ((int) (Math.random() * 3 + 1) % 2 == 0) {
                    nombresCompletos.add((nombresM.subList(i, i + 1).toString() + apellidos.subList(i, i + 1).toString()).replace("[", "").replace("]", " "));
                } else {
                    nombresCompletos.add((nombresM.subList(i, i + 1).toString() + segundosNombresM.subList(i, i + 1).toString() + apellidos.subList(i, i + 1).toString()).replace("[", "").replace("]", " "));
                }
            }
        }
        return nombresCompletos;
    }

    /*
    Ahora hacer un generador de combinaciones de DNI posibles, deben estar dentro
    de un rango real de números de documentos. Y agregar a los alumnos su DNI. Este
    método debe retornar la lista de dnis.*/
    public ArrayList<Long> generarCombinacionesDni(Integer cantidad) {
        HashSet<Long> dnisHash = new HashSet<>();

        while (dnisHash.size() < cantidad) {

            dnisHash.add((long) (Math.random() * (46000001 - 31500001 + 1) + 31500001));
        }

        return new ArrayList<>(dnisHash);
    }

    /*
    Ahora tendremos un método que, usando las dos listas generadas, cree una cantidad
    de objetos Alumno, elegidos por el usuario, y le asigne los nombres y los dnis de las
    dos listas a cada objeto Alumno. No puede haber dos alumnos con el mismo dni,
    pero si con el mismo nombre.*/
    public ArrayList<Alumno> crearListaAlumnos(Integer cantidad) {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        ArrayList<String> listaDeNombres = generarListadoNombreApellidoAleatorio(cantidad);
        ArrayList<Long> listaDeDnis = generarCombinacionesDni(cantidad);
        int i = 0;
        while (listaAlumnos.size() < cantidad) {
            listaAlumnos.add(new Alumno(listaDeNombres.subList(i, i + 1).toString().replace("[", "").replaceAll("\\[|\\]", ""), listaDeDnis.subList(i, i + 1).toString().replaceAll("\\[|\\]", " "), 0));
            i++;
        }
        System.out.println("Lista de alumnos creada");
        return listaAlumnos;
    }

    public void imprimirListaAlumnos(ArrayList<Alumno> listaAlumnos) {
       // if (listaAlumnos.isEmpty()) {
        //    System.out.println("Cree una lista de alumnos para mostrarla");
        //} else {
            System.out.println("------------------------------------------------------------");
                        System.out.println("----------Lista de estudiantes completa----------");
            for (Alumno i : listaAlumnos) {
                System.out.println(i);
            }
       // }
    }
}
