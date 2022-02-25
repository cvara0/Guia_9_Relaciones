package e4ExG9Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class e4ExG9Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ArrayList<Alumno> nuevaListaAlumnos = new ArrayList<>();
        HashMap<Alumno, ArrayList<Alumno>> nuevoVotanteY3Votados = new HashMap<>();
        Simulador objetoSimulador = new Simulador();
        Voto objetoVoto = new Voto();

        //objeto.imprimirListaAlumnos(listaAlumnos);
        //System.out.println(objeto2.votanteY3Votados(listaAlumnos).toString().replace("=", "\n"));
        //objetoVoto.conteoDeVotos(objetoVoto.votanteY3Votados(nuevaListaAlumnos));
        byte opcion;
        boolean creada = false;
        do {
            System.out.println("");
            System.out.println("1. Generar lista de estudiantes");
            System.out.println("2. Mostrar lista de estudiantes");
            System.out.println("3. Mostrar cada estudiante y sus 3 votad@s");
            System.out.println("4. Mostrar cada estudiante votad@ la cantidad de votos recibidos");
            System.out.println("5. Mostrar estudiantes votad@s y quienes votaron por ell@os");
            System.out.println("6. Mostrar recuento de votos(cantidad de votos emitidos)");
            System.out.println("7. Mostrar 5 facilitadores y 5 facilitadores suplentes");
            System.out.println("\n8. Salir");
            System.out.print("\nOpción: ");
            opcion = entrada.nextByte();
            System.out.println();
            switch (opcion) {
                case 1:

                    System.out.println("Ingrese cantidad de estudiantes (entre 15 y 30): ");
                    Integer cantidad;
                    do {
                        cantidad = entrada.nextInt();
                        if (cantidad < 15 || cantidad > 35) {
                            System.out.print("Error. Ingrese cantidad entre 15 y 30: ");
                            continue;
                        }
                        nuevaListaAlumnos = objetoSimulador.crearListaAlumnos(cantidad);
                        objetoVoto.votanteY3Votados(nuevaListaAlumnos);
                        objetoVoto.conteoDeVotos();

                    } while (cantidad < 15 || cantidad > 35);

                    creada = true;

                    break;
                case 2:
                    if (creada) {
                        objetoSimulador.imprimirListaAlumnos(nuevaListaAlumnos);
                    } else {
                        System.out.println("Error. Genere una nueva lsita para comenzar\n");
                    }
                    break;
                case 3:
                    if (creada) {
                        objetoVoto.mostrarVotanteYSus3Votados();
                    } else {
                        System.out.println("Error. Genere una nueva lsita para comenzar\n");
                    }
                    break;
                case 4:
                    if (creada) {
                        objetoVoto.mostrarAlumnosYCantidadDeVotosRecibidos();
                    } else {
                        System.out.println("Error. Genere una nueva lsita para comenzar\n");
                    }
                    break;
                case 5:
                    if (creada) {
                        objetoVoto.mostrarAlumnoYQuienesVotaronPorEl();
                    } else {
                        System.out.println("Error. Genere una nueva lsita para comenzar\n");
                    }
                    break;
                case 6:
                    if (creada) {
                       objetoVoto.mostrarCantidadDeVotosTotal();
                    } else {
                        System.out.println("Error. Genere una nueva lsita para comenzar\n");
                    }
                    break;
                case 7:
                    if (creada) {
                      objetoVoto.mostrar5FacilitadoresYSuplentes();
                    } else {
                        System.out.println("Error. Genere una nueva lsita para comenzar\n");
                    }
                    break;
                case 8:
                    System.out.println("Fin\n");
                    break;
                default:
                    System.out.println("Error, ingreso incorrecto\n");
            }
        } while (opcion != 8);

    }
}
/*Desarrollar un simulador del sistema de votación de facilitadores en Egg 

El sistema de votación de Egg tiene una 

clase llamada Alumno con los siguientes
atributos: nombre completo, DNI y cantidad de votos. 

Además, crearemos una clase Simulador que va a tener los métodos para manejar los alumnos 
y sus votaciones. Estos métodos serán llamados desde el main.

• La clase Simulador debe tener un método que genere un listado de alumnos manera
aleatoria y lo retorne. 

Las combinaciones de nombre y apellido deben ser generadas
de manera aleatoria. Nota: usar listas de tipo String para generar los nombres y los
apellidos.
• Ahora hacer un generador de combinaciones de DNI posibles, deben estar dentro
de un rango real de números de documentos. Y agregar a los alumnos su DNI. Este
método debe retornar la lista de dnis.
11
• Ahora tendremos un método que, usando las dos listas generadas, cree una cantidad
de objetos Alumno, elegidos por el usuario, y le asigne los nombres y los dnis de las
dos listas a cada objeto Alumno. No puede haber dos alumnos con el mismo dni,
pero si con el mismo nombre.
• Se debe imprimir por pantalla el listado de alumnos.
• Una vez hecho esto debemos generar una clase Voto, esta clase tendrá como
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
