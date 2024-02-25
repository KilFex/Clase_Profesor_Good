package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloAlumnos;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
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
		
		textField = new JTextField();
		textField.setBounds(78, 30, 104, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 58, 152, 20);
		panel.add(textField_1);
		
		lblNewLabel_3 = new JLabel("Nota 1");
		lblNewLabel_3.setBounds(31, 109, 54, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nota 2");
		lblNewLabel_4.setBounds(186, 109, 54, 14);
		panel.add(lblNewLabel_4);
		
		comboBox = new JComboBox();
		comboBox.setBounds(98, 105, 45, 22);
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(250, 105, 54, 22);
		panel.add(comboBox_1);
		
		btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(363, 135, 89, 23);
		panel.add(btnNewButton);
		
		listar();
		
	}
	
	ArregloAlumnos aa = new ArregloAlumnos();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnNewButton;
	
	
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
	public void actionPerformed(ActionEvent e) {
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
}
