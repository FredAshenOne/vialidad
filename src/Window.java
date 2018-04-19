
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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

public class Window extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	Users u = new Users();
	ResultSet rs;
	Style l = new Style();
	Conexion c = new Conexion();
	private JPanel contentPane;
	private JTextField user;
	private JTextField password;
	JButton btnIngresar = new JButton("Ingresar");
	JLabel lblInicioSesion = new JLabel("Inicio Sesion");
	private JButton nuevoUser;
	Register r = new Register();
	private JLabel lblWarningLog;
	AdminMenu am = new AdminMenu();
	
	
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
		mainPanel.setOpaque(true);
		mainPanel.setBackground(new Color(255,255,255));
		
		user = new JTextField();
		user.setBounds(28, 64, 187, 25);
		mainPanel.add(user);
		user.setColumns(10);
		user.setBorder(null);
		
		password = new JTextField();
		password.setBounds(28, 100, 187, 25);
		mainPanel.add(password);
		password.setBorder(null);
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
		
		lblWarningLog = new JLabel("");
		lblWarningLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningLog.setForeground(new Color(244, 66, 38));
		lblWarningLog.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 10));
		lblWarningLog.setBounds(28, 152, 187, 14);
		mainPanel.add(lblWarningLog);
		tpPass.changeStyle(Font.ITALIC);
		am.btnExit.addActionListener(this);
		r.reg.addActionListener(this);
		r.btnCancelar.addActionListener(this);
		l.mdBtn(btnIngresar, Color.decode("#2196F3"));
		l.btnPointer(btnIngresar);
		l.btnPointer(nuevoUser);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nuevoUser) {
			r.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource() == btnIngresar) {
			try {
				if(u.login(password.getText(), user.getText())) {
						if (u.tipo(user.getText()) == 1) {
							am.setVisible(true);
							am.lblBienvenido.setText(am.lblBienvenido.getText()+u.name(user.getText()));
							this.setVisible(false);
						}else {
							
							this.setVisible(false);
							
						}
					
				}else {
					lblWarningLog.setText("Usuario o Contraseña no coinciden");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == r.reg) {
			try {
				if(u.dataCheck(r.txtNombre, r.txtApellidoP, r.txtApellidoM,r.name,r.password,r.password2)) {
					if (r.userOk && r.userName) {	
					u.insertUser(r.name.getText(),r.password.getText(),r.txtNombre.getText(),r.txtApellidoP.getText(),r.txtApellidoM.getText());		
					this.setVisible(true);
					r.setVisible(false);
					}
				} else {
					r.lblDataComplete.setForeground(new Color(244, 66, 38));
					r.lblDataComplete.setText("Datos Incompletos");
				}
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == r.btnCancelar) {
			r.clearText();
			r.setVisible(false);
			this.setVisible(true);
		}
		if(e.getSource() == am.btnExit) {
			user.setText("");
			password.setText("");
			am.setVisible(false);
			this.setVisible(true);
		}
	}	
}

