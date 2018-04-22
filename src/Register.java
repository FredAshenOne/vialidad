
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
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class Register extends JFrame implements ActionListener,MouseListener{

	Conexion c = new Conexion();
	Users u = new Users();
	Style l = new Style();
	
	ResultSet rs;
	private static final long serialVersionUID = 1L;
	public boolean check = false,userOk = false,userName = false;
	private JPanel contentPane;
	public JTextField password,password2,name,txtApellidoM,txtApellidoP,txtNombre;
	JButton reg = new JButton("Registrar"),btnRegresar;
	public JLabel lblIngresaTusDatos,lblIngresaTuNombre,lblIngresaTuContrasea,lblConfirmaTuContrasea,lblApellidoM,
	lblDataComplete,lblWarning,lblPass,lblApellidoP,lblNombre;
	
		public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 254, 415);
		mainPanel.setLayout(null);
		contentPane.add(mainPanel);
		l.mdPanel(mainPanel,Color.white);
		
		name = new JTextField();
		name.setBounds(42, 214, 176, 20);
		mainPanel.add(name);
		name.setColumns(10);
		
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(42, 271, 176, 20);
		mainPanel.add(password);
		
		password2 = new JTextField();
		password2.setColumns(10);
		password2.setBounds(42, 314, 176, 20);
		mainPanel.add(password2);
		reg.setFont(new Font("Century Gothic", Font.PLAIN, 12));
				
		reg.addActionListener(this);
		reg.setBounds(42, 354, 176, 30);
		mainPanel.add(reg);
		reg.addMouseListener(this);
		
		lblIngresaTusDatos = new JLabel("Ingresa tus datos");
		lblIngresaTusDatos.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		lblIngresaTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaTusDatos.setBounds(42, 11, 176, 23);
		mainPanel.add(lblIngresaTusDatos);
		
		lblIngresaTuNombre = new JLabel("Ingresa tu nombre de usuario");
		lblIngresaTuNombre.setBounds(42, 197, 176, 14);
		mainPanel.add(lblIngresaTuNombre);
		
		lblIngresaTuContrasea = new JLabel("Ingresa tu contrase\u00F1a");
		lblIngresaTuContrasea.setBounds(42, 254, 176, 14);
		mainPanel.add(lblIngresaTuContrasea);
		
		lblConfirmaTuContrasea = new JLabel("Confirma tu contrase\u00F1a");
		lblConfirmaTuContrasea.setBounds(42, 299, 176, 14);
		mainPanel.add(lblConfirmaTuContrasea);
		
		lblPass = new JLabel("");
		lblPass.setFont(new Font("Yu Gothic Light", Font.ITALIC, 10));
		lblPass.setBounds(42, 335, 176, 14);
		mainPanel.add(lblPass);
		
		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 10));
		lblWarning.setBounds(42, 235, 176, 14);
		mainPanel.add(lblWarning);
		
		txtApellidoM = new JTextField();
		txtApellidoM.setBounds(42, 166, 176, 20);
		mainPanel.add(txtApellidoM);
		txtApellidoM.setColumns(10);
		
		txtApellidoP = new JTextField();
		txtApellidoP.setColumns(10);
		txtApellidoP.setBounds(42, 112, 176, 20);
		mainPanel.add(txtApellidoP);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(42, 61, 176, 20);
		mainPanel.add(txtNombre);
		
		lblApellidoM = new JLabel("Ingresa tu apellido materno");
		lblApellidoM.setBounds(42, 151, 176, 14);
		mainPanel.add(lblApellidoM);
		
		lblApellidoP = new JLabel("Ingresa tu apellido paterno");
		lblApellidoP.setBounds(42, 99, 176, 14);
		mainPanel.add(lblApellidoP);
		
		lblNombre = new JLabel("Ingresa tu nombre");
		lblNombre.setBounds(42, 49, 176, 14);
		mainPanel.add(lblNombre);
		TextPrompt tpUs = new TextPrompt("Usuario",name,l.f12,l.glight);
		TextPrompt tpPass1 = new TextPrompt("Contraseña",password,l.f12,l.glight);
		TextPrompt tpNombre = new TextPrompt("Nombre(s)",txtNombre,l.f12,l.glight);
		TextPrompt tpAp = new TextPrompt("Apellido Paterno",txtApellidoP,l.f12,l.glight);
		TextPrompt tpAm= new TextPrompt("Apellido Materno",txtApellidoM,l.f12,l.glight);
		TextPrompt tpPass2 = new TextPrompt("Confirma Contraseña",password2,l.f12,l.glight);
		
		lblDataComplete = new JLabel("");
		lblDataComplete.setFont(new Font("Yu Gothic UI", Font.ITALIC, 10));
		lblDataComplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataComplete.setBounds(42, 390, 176, 16);
		mainPanel.add(lblDataComplete);
		
		btnRegresar = new JButton();
		btnRegresar.setBounds(10, 11, 35,35);
		mainPanel.add(btnRegresar);
		l.btnPointer(btnRegresar);
		l.imgBtn(btnRegresar, l.urlIcon);
		
		tpUs.changeStyle(Font.ITALIC);
		tpPass1.changeStyle(Font.ITALIC);
		tpPass2.changeStyle(Font.ITALIC);
		tpNombre.changeStyle(Font.ITALIC);
		tpAp.changeStyle(Font.ITALIC);
		tpAm.changeStyle(Font.ITALIC);
		
		l.mdBtn(reg, Color.decode(l.color), Color.WHITE);
	
		l.btnPointer(reg);
		
		
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
				}else if(password.getText().equals(password2.getText()) && (password.getText().length() > 0 || password.getText().length() > 0)){
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
				
		}
			
			
	}
		public void clearText() {
			name.setText("");
			password.setText("");
			txtNombre.setText("");
			txtApellidoP.setText("");
			txtApellidoM.setText("");
			password2.setText("");
			lblWarning.setText("");
			lblPass.setText("");
			lblDataComplete.setText("");
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == reg) {
				l.btnHover(reg, Color.white, Color.decode(l.color), Color.decode(l.color));
			}	
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource() == reg) {
				l.mdBtn(reg, Color.decode(l.color), Color.white);
			}
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
