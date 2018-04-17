import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class NewTarjeta extends JFrame {

	private JPanel contentPane;
	private JTextField txtPropietario;
	private JTextField txtLugar;
	private JTextField txtFecha;
	private JTextField txtFolio;
	private JTextField txtRecaudadora;
	private JTextField txtClave;

	public NewTarjeta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 812, 452);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblSecetaria = new JLabel("Secretar\u00EDa de Movilidad");
		lblSecetaria.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		lblSecetaria.setBounds(10, 11, 165, 14);
		mainPanel.add(lblSecetaria);
		
		JLabel lblPlaneacion = new JLabel("Secretar\u00EDa de Planeaci\u00F3n");
		lblPlaneacion.setBounds(10, 36, 125, 14);
		mainPanel.add(lblPlaneacion);
		
		JLabel lblAdmon = new JLabel("Administraci\u00F3n y Finanzas");
		lblAdmon.setBounds(10, 50, 125, 14);
		mainPanel.add(lblAdmon);
		
		JLabel lblServicio = new JLabel("Servicio Part\u00EDcular");
		lblServicio.setEnabled(false);
		lblServicio.setBounds(232, 0, 101, 14);
		mainPanel.add(lblServicio);
		
		JLabel lblNewLabel = new JLabel("Tarjeta de Circulaci\u00F3n");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 70, 165, 14);
		mainPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 87, 792, 354);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblPropietario = new JLabel("PROPIETARIO");
		lblPropietario.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblPropietario.setBounds(10, 11, 58, 14);
		panel.add(lblPropietario);
		
		txtPropietario = new JTextField();
		txtPropietario.setBounds(65, 11, 182, 16);
		panel.add(txtPropietario);
		txtPropietario.setColumns(10);
		
		JLabel lblFecha = new JLabel("LUGAR Y FECHA DE EXPEDICION");
		lblFecha.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblFecha.setBounds(10, 30, 121, 14);
		panel.add(lblFecha);
		
		txtLugar = new JTextField();
		txtLugar.setBounds(127, 28, 120, 16);
		panel.add(txtLugar);
		txtLugar.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(257, 28, 120, 16);
		panel.add(txtFecha);
		
		txtFolio = new JTextField();
		txtFolio.setColumns(10);
		txtFolio.setBounds(492, 28, 120, 16);
		panel.add(txtFolio);
		
		JLabel lblFolio = new JLabel("FOLIO");
		lblFolio.setEnabled(false);
		lblFolio.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblFolio.setBounds(461, 30, 29, 14);
		panel.add(lblFolio);
		
		JLabel lblRecaudadora = new JLabel("RECAUDADORA");
		lblRecaudadora.setEnabled(false);
		lblRecaudadora.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblRecaudadora.setBounds(10, 52, 58, 14);
		panel.add(lblRecaudadora);
		
		txtRecaudadora = new JTextField();
		txtRecaudadora.setColumns(10);
		txtRecaudadora.setBounds(75, 48, 120, 16);
		panel.add(txtRecaudadora);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(492, 50, 120, 16);
		panel.add(txtClave);
		
		JLabel lblClave = new JLabel("CLAVE VEH\u00CDCULAR");
		lblClave.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblClave.setEnabled(false);
		lblClave.setBounds(417, 52, 73, 14);
		panel.add(lblClave);
	}
}
