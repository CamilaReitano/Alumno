/*
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
 */
package servicio;

import entidad.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

public class ServicioAlumno {
    Scanner leer = new Scanner(System.in);
    ArrayList<Alumno> alumnos = new ArrayList();
    
    
    public void crearListaDeAlumnos(){
        
        String op = "";
        String opPromedio = "";
        do{
           Alumno alumno = crearAlumno();
           alumnos.add(alumno);
            System.out.println("Desea calcular el promedio de este alumno? precione s");
            opPromedio = leer.next();
            if (opPromedio.equals("s")){
                System.out.println(notaFinal(alumno.getNotas()));
            }
            System.out.println("Desea introducir un alumno -Presione 's' para si");
            op = leer.next();          
        } while(op.equals("s"));
    }
    
    public Alumno crearAlumno(){
        ArrayList<Integer> notas = new ArrayList();
        System.out.println("Introdusca el nombre del alumno");
        String nombre = leer.next();
        for (int i = 0; i < 3; i++) {
          System.out.println("Introdusca la nota N°"+ (i+1));
          notas.add(leer.nextInt());
        }
       
        return new Alumno(nombre, notas);
    }
    
//    Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
//final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
//del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
//promedio final, devuelto por el método y mostrado en el main.
    public int notaFinal(ArrayList<Integer> notas){
        int notaFinal = 0;
        for (Integer nota : notas) {
            notaFinal += nota;
        }
        
        notaFinal= (notaFinal/3);
        return notaFinal;
    }
    
    //Mostrar lisa de alumnos
    public void mostrarListaAlumno(){
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
}
