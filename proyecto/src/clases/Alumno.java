package clases;

public class Alumno {
	//atributos
	private int codigo, nota1, nota2;
	private String nombre;
	
	//constructor
	public Alumno(int codigo, String nombre, int nota1, int nota2 ) {
		
		this.codigo = codigo;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nombre = nombre;
	}
	
	//metodos de acceso getters y setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//metodo publico
	public double promedio() {
		return (nota1 + nota2)/2.0;
	}	
	
	
	
	
	
	
	
	
	
	
}
