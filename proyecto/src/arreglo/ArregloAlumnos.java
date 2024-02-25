package arreglo;

import java.util.ArrayList;
import clases.Alumno;


public class ArregloAlumnos {
	
	//Atributo de tipo ArrayList de la calse ArregloAlumnos
	 private ArrayList<Alumno> alu;

	 public ArregloAlumnos() {
		 alu = new ArrayList<Alumno>();
		 alu.add(new Alumno(123, "Kunno", 15, 13));
		 alu.add(new Alumno(123, "Kina", 17, 14));
		 alu.add(new Alumno(123, "Lana", 14, 19));
		 alu.add(new Alumno(123, "Kalifa", 20, 20));
	 }
	 
	 //Metodos personalizados
	 public int tamaño() {
		 return alu.size();
	 }
	 
	 public Alumno obtener(int i) {
		 return alu.get(i);
	 }
	 public double promedioGeneral() {
		 double suma = 0.0;
		 for(int i = 0; i<tamaño(); i++) {
			 suma+= obtener(i).promedio();
		 }
		 return suma/tamaño();
	 }
}
