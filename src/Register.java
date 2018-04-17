import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Register extends JFrame implements ActionListener{

	Conexion c = new Conexion();
	
	ResultSet rs;
	private static final long serialVersionUID = 1L;
	Users u = new Users();
	private JPanel contentPane;
	private JTextField password,password2,name;
	JButton reg = new JButton("Registrar");
	private JLabel lblIngresaTusDatos,lblIngresaTuNombre,lblIngresaTuContrasea,lblConfirmaTuContrasea;
	private TextPrompt tpPass2;
	public boolean userOk = false,userName = false;
	private JLabel lblWarning;

		public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 254, 268);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		name = new JTextField();
		name.setBounds(42, 61, 176, 20);
		mainPanel.add(name);
		name.setColumns(10);
		
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(42, 117, 176, 20);
		mainPanel.add(password);
		
		password2 = new JTextField();
		password2.setColumns(10);
		password2.setBounds(42, 169, 176, 20);
		mainPanel.add(password2);
		TextPrompt tpUs = new TextPrompt("Usuario",name);
		
		TextPrompt tpPass1 = new TextPrompt("Contraseña",password);
		tpPass2 = new TextPrompt("Confirma Contraseña",password2);
		tpPass2.setText("Confirmacion");
		tpUs.changeStyle(Font.ITALIC);
		tpPass1.changeStyle(Font.ITALIC);
		tpPass2.changeStyle(Font.ITALIC);
		
		reg.addActionListener(this);
		reg.setBounds(87, 220, 89, 23);
		
		mainPanel.add(reg);
		
		lblIngresaTusDatos = new JLabel("Ingresa tus datos");
		lblIngresaTusDatos.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		lblIngresaTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaTusDatos.setBounds(42, 11, 176, 23);
		mainPanel.add(lblIngresaTusDatos);
		
		lblIngresaTuNombre = new JLabel("Ingresa tu nombre de usuario");
		lblIngresaTuNombre.setBounds(42, 45, 176, 14);
		mainPanel.add(lblIngresaTuNombre);
		
		lblIngresaTuContrasea = new JLabel("Ingresa tu contrase\u00F1a");
		lblIngresaTuContrasea.setBounds(42, 104, 176, 14);
		mainPanel.add(lblIngresaTuContrasea);
		
		lblConfirmaTuContrasea = new JLabel("Confirma tu contrase\u00F1a");
		lblConfirmaTuContrasea.setBounds(42, 156, 176, 14);
		mainPanel.add(lblConfirmaTuContrasea);
		
		JLabel lblPass = new JLabel("");
		lblPass.setFont(new Font("Yu Gothic Light", Font.ITALIC, 10));
		lblPass.setBounds(42, 189, 176, 14);
		mainPanel.add(lblPass);
		
		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 10));
		lblWarning.setBounds(42, 79, 176, 14);
		mainPanel.add(lblWarning);

		password2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(!password.getText().equals(password2.getText()) && (password2.getText().length() > 0 || password.getText().length() > 0)){
					lblPass.setForeground(new Color(244, 66, 38));
					lblPass.setText("La contraseña no coincide");
				}else if(password.getText().equals(password2.getText())){
					lblPass.setForeground(new Color(63, 155, 19));
					lblPass.setText("Contraseña correcta");
					userOk = true;
				}else if(password.getText().length() == 0 && password2.getText().length() == 0) {
					lblPass.setText("");
				}
			}
		});
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(!password.getText().equals(password2.getText()) && (password.getText().length() > 0 || password.getText().length() > 0)){
					lblPass.setForeground(new Color(244, 66, 38));
					lblPass.setText("La contraseña no coincide");
				}else if(password.getText().equals(password2.getText())){
					lblPass.setForeground(new Color(63, 155, 19));
					lblPass.setText("Contraseña correcta");
					userOk = true;
				}else if(password.getText().length() == 0 && password2.getText().length() == 0) {
					lblPass.setText("");
				}
			}
		});


		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if(u.userExist(name.getText()) && name.getText().length() > 0) {
						lblWarning.setForeground(new Color(244, 66, 38));
						lblWarning.setText("Usuario no disponible");					
					}else if(!u.userExist(name.getText()) && name.getText().length() > 0){
						if(name.getText().length() < 5) {
							lblWarning.setForeground(new Color(244, 66, 38));
							lblWarning.setText("Debe contener al menos 5 caracteres");
						}else {
						lblWarning.setForeground(new Color(63, 155, 19));
						lblWarning.setText("Usuario disponible");
						userName = true;
						}
					}else if(name.getText().length() < 1) {
						lblWarning.setText("");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == reg) {
				try {
					if (userOk && userName) {
						u.insertUser(name.getText(),password.getText());
//						w.setVisible(true);
						this.setVisible(false);
						
					} else {

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
}
