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
	 
	 /*public void ArregloAlumnos(int codigo, String Nombre, ) {
		
		
	}*/
	  /*public void agregarAlumno(Alumno a) {
		  alu.add(a);
	  }*/
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

	 public Alumno buscar(int cod)	 {
		 for(int i = 0; i<tamaño(); i++)
			 if(obtener(i).getCodigo() == cod)
				 return obtener(i);
						 return null;
	 }
	 
	 public void eliminar(Alumno a) {
		 alu.remove(a);
	 }
	 public void elimarTodo() {
		 alu.clear();
	 }
	 
	 /*public notaAlumno(Alumno x, int nota) {
		 
	 }*/
	  public void adicionar(Alumno a) {
		  alu.add(a);
	  }
	 
	  
	  public void eliminaUltimo() {
		  alu.remove(tamaño()-1);
	  }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

