package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloAlumnos;
import clases.Alumno;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;


public class Formulario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblAlumno;
	private JScrollPane scrollPane;
	private JButton btnListar;
	private JButton btnReportar;
	private JTextArea txtResultado;
	private JTextField txtCodigo;
	private JTextField txtAlumno;
	private JButton btnAgregar;
	private DefaultTableModel modelo; //crea el modelo de la tabla

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 791);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnListar = new JButton("listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(150, 39, 89, 23);
		contentPane.add(btnListar);
		
		btnReportar = new JButton("reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(339, 39, 89, 23);
		contentPane.add(btnReportar);
		
		JScrollPane tblAlumnos = new JScrollPane();
		tblAlumnos.setBounds(36, 85, 494, 216);
		contentPane.add(tblAlumnos);
		
		tblAlumno = new JTable();
		tblAlumnos.setViewportView(tblAlumno);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 317, 494, 169);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		
		//Dibujando los campos de la tabla alumos
		modelo = new DefaultTableModel();
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Nota1");
		modelo.addColumn("Nota2");
		modelo.addColumn("Promedio");
		
		tblAlumno.setModel(modelo);
		
		panel = new JPanel();
		panel.setBounds(36, 497, 494, 233);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Generar nuevos alumnos");
		lblNewLabel.setBounds(10, 11, 152, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Alumnos:");
		lblNewLabel_1.setBounds(20, 61, 83, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Codigo:");
		lblNewLabel_2.setBounds(20, 36, 83, 14);
		panel.add(lblNewLabel_2);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(78, 30, 104, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtAlumno = new JTextField();
		txtAlumno.setColumns(10);
		txtAlumno.setBounds(78, 58, 152, 20);
		panel.add(txtAlumno);
		
		lblNewLabel_3 = new JLabel("Nota 1");
		lblNewLabel_3.setBounds(31, 109, 54, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nota 2");
		lblNewLabel_4.setBounds(186, 109, 54, 14);
		panel.add(lblNewLabel_4);
		
		cboNota1 = new JComboBox();
		cboNota1.setBounds(98, 105, 45, 22);
		panel.add(cboNota1);
		
		cboNota2 = new JComboBox();
		cboNota2.setBounds(250, 105, 54, 22);
		panel.add(cboNota2);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(363, 32, 89, 23);
		panel.add(btnAgregar);
		
		btnUltimo = new JButton("elimina ultimo");
		btnUltimo.addActionListener(this);
		btnUltimo.setBounds(54, 149, 108, 23);
		panel.add(btnUltimo);
		
		btnElimCodigo = new JButton("elimina por cod");
		btnElimCodigo.addActionListener(this);
		btnElimCodigo.setBounds(186, 149, 121, 23);
		panel.add(btnElimCodigo);
		
		btnTodo = new JButton("eliminar todo");
		btnTodo.addActionListener(this);
		btnTodo.setBounds(338, 149, 121, 23);
		panel.add(btnTodo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(93, 183, 89, 23);
		panel.add(btnBuscar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(273, 183, 114, 23);
		panel.add(btnEditar);
		
		listar();
		cargarNotas();
			
	}
	
	ArregloAlumnos aa = new ArregloAlumnos();
	
	
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox cboNota1;
	private JComboBox cboNota2;
	
	
	void listar() {
		modelo.setRowCount(0);
		for(int i = 0; i<aa.tamaño(); i++) {
			Object[] fila = {aa.obtener(i).getCodigo(),
							 aa.obtener(i).getNombre(),
							 aa.obtener(i).getNota1(),
							 aa.obtener(i).getNota2(),
							 aa.obtener(i).promedio(),};    
			modelo.addRow(fila);
		}
	}
	
	void reporte() {
		txtResultado.setText(null);
		txtResultado.append("Cantidad de alumnos: \t" + aa.tamaño() + "\n");
		txtResultado.append("Promedio general: " + aa.promedioGeneral() + "\n");
	}
	
	void cargarNotas() {
		for(int i= 0; i<=20; i++) {
			
			cboNota1.addItem(i);
			cboNota2.addItem(i);	
		}
		cboNota1.setSelectedIndex(-1);
		cboNota2.setSelectedIndex(-1);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
			buscarPresentar();
		}
		if (e.getSource() == btnElimCodigo) {
			actionPerformedBtnElimCodigo(e);
			removeCodigo();
		}
		if (e.getSource() == btnTodo) {
			actionPerformedBtnTodo(e);
			removeTodo();
		}
		if (e.getSource() == btnUltimo) {
			actionPerformedBtnNewButton(e);
			removeUltimo();
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
			/*Alumno nuevoAlumno = llamar();
			aa.agregarAlumno(nuevoAlumno);
			listar();*/
			agregar();
		}
		if (e.getSource() == btnReportar) {
			actionPerformedBtnReportar(e);
			reporte();
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
			
			//listar();
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
	}
	protected void actionPerformedBtnReportar(ActionEvent e) {
	}
	int codigo,nota1,nota2;
	String nombre;
	private JButton btnUltimo;
	private JButton btnElimCodigo;
	private JButton btnTodo;
	private JButton btnBuscar;
	private JButton btnEditar;
	void llamar() {
		codigo = Integer.parseInt(txtCodigo.getText());
		nombre = txtAlumno.getText();
		nota1 =  cboNota1.getSelectedIndex();
		nota2 = cboNota2.getSelectedIndex();
	}
		
		/*Alumno a = new Alumno(codigo, nombre, nota1, nota2);
		
		return a;
		
	}*/
		void agregar() {
			llamar();
			
			
			
			Alumno a =  new Alumno(codigo, nombre, nota1, nota2);
			aa.adicionar(a);
			listar();
		}
		
		void removeUltimo() {
			if(aa.tamaño()>0) {
				if(JOptionPane.showConfirmDialog(this, "esta seguro de elimnar ultimo registro?","Eliminar Ultimno", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			aa.eliminaUltimo();
			listar();
			}
			
			else
				JOptionPane.showMessageDialog(this, "Esta vacio pe  kunno" );
		}
		
		void removeTodo() {
			if(aa.tamaño()>0) {
				if(JOptionPane.showConfirmDialog(this, "esta seguro de elimnar todo el registro?","Eliminar todo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					aa.elimarTodo();
				listar();
			}
			else
				JOptionPane.showMessageDialog(this, "Esta vacio pe  kunno" );
				
		}
		
		void removeCodigo() {
			int cod = Integer.parseInt(JOptionPane.showInputDialog("ingrese codigo del alumno"));
			Alumno a = aa.buscar(cod);
			if(a==null)
				JOptionPane.showMessageDialog(this,"el codigo no existe");
			
			else {
				aa.eliminar(a);
				listar();
			}
		}
		
		void buscarPresentar() {
			int cod = Integer.parseInt(JOptionPane.showInputDialog("ingrese codigo del alumno"));
			Alumno a = aa.buscar(cod);
			if(a==null)
				JOptionPane.showMessageDialog(this,"el codigo no existe");
			
			else {
				txtCodigo.setText(a.getCodigo()+"");
				txtAlumno.setText(a.getNombre());
				cboNota1.setSelectedIndex(a.getNota1());
				cboNota2.setSelectedIndex(a.getNota2());
				listar();
			}
		}
	
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
	protected void actionPerformedBtnTodo(ActionEvent e) {
	}
	protected void actionPerformedBtnElimCodigo(ActionEvent e) {
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
	}
}
