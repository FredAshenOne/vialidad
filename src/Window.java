import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Window extends JFrame implements ActionListener {
	Functions f = new Functions();
	Conexion c = new Conexion();
	private JPanel contentPane;
	private JTextField user;
	private JTextField password;
	JButton btnIngresar = new JButton("Ingresar");
	JLabel lblInicioSesion = new JLabel("Inicio Sesion");
	private JButton nuevoUser;
	Register r = new Register();
	
	
	
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 250, 222);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		user = new JTextField();
		user.setBounds(28, 64, 187, 25);
		mainPanel.add(user);
		user.setColumns(10);
		
		password = new JTextField();
		password.setBounds(28, 100, 187, 25);
		mainPanel.add(password);
		password.setColumns(10);
		
		
		lblInicioSesion.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 17));
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setBounds(27, 11, 188, 25);
		mainPanel.add(lblInicioSesion);
		
		
		btnIngresar.setBounds(126, 177, 89, 23);
		btnIngresar.addActionListener(this);
		mainPanel.add(btnIngresar);
		
		nuevoUser = new JButton("Registrate aqui");
		nuevoUser.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 10));
		nuevoUser.setBounds(28, 127, 187, 25);
		nuevoUser.setHorizontalAlignment(SwingConstants.LEFT);
		nuevoUser.setBorderPainted(false);
		nuevoUser.setOpaque(false);
		nuevoUser.setBackground(Color.WHITE);
		nuevoUser.setForeground(Color.BLUE);
		nuevoUser.addActionListener(this);
		mainPanel.add(nuevoUser);
		
		TextPrompt tpUs = new TextPrompt("Usuario",user);
		tpUs.changeStyle(Font.ITALIC);
		TextPrompt tpPass = new TextPrompt("Contraseña",password);
		tpPass.changeStyle(Font.ITALIC);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nuevoUser) {
			r.setVisible(true);
			c.query("Select * from usuario");
		}
	}
}
