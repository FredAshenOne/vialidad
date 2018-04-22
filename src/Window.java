
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

public class Window extends JFrame implements ActionListener,MouseListener {
	
	private static final long serialVersionUID = 1L;
	Users u = new Users();
	ResultSet rs;
	Style l = new Style();
	Conexion c = new Conexion();
	private JPanel contentPane;
	public JTextField user,password;
	JButton btnIngresar = new JButton("Ingresar"),btnRegresar;
	JLabel lblInicioSesion = new JLabel("Inicio Sesion");
	private JButton nuevoUser;
	Register r = new Register();
	private JLabel lblWarningLog;
	AdminMenu am = new AdminMenu();
	
	
	public Window() {
		r.getContentPane().setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		r.lblConfirmaTuContrasea.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		r.lblIngresaTuContrasea.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		r.lblIngresaTuNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		r.lblApellidoM.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		r.lblApellidoP.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		r.lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		r.lblIngresaTusDatos.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
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
		
		
		lblInicioSesion.setFont(new Font("Yu Gothic UI Light", Font.PLAIN,16));
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setBounds(27, 11, 188, 25);
		mainPanel.add(lblInicioSesion);

		btnIngresar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnIngresar.setBounds(10, 177, 230, 34);
		btnIngresar.addActionListener(this);
		mainPanel.add(btnIngresar);
		btnIngresar.addMouseListener(this);
		
		btnRegresar = new JButton();
		btnRegresar.setBounds(10, 11, 35,35);
		mainPanel.add(btnRegresar);
		l.btnPointer(btnRegresar);
		l.imgBtn(btnRegresar, l.urlIcon);
		
		nuevoUser = new JButton("Registrate aqui");
		nuevoUser.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 10));
		nuevoUser.setBounds(28, 127, 187, 25);
		nuevoUser.setHorizontalAlignment(SwingConstants.LEFT);
		l.mdBtn(nuevoUser, Color.white, Color.blue);
		mainPanel.add(nuevoUser);
		nuevoUser.addActionListener(this);
		
		TextPrompt tpUs = new TextPrompt("Usuario",user,l.f12,Color.black);
		tpUs.changeStyle(Font.PLAIN);
		TextPrompt tpPass = new TextPrompt("Contraseña",password,l.f12,Color.BLACK);
		
		lblWarningLog = new JLabel("");
		lblWarningLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningLog.setForeground(new Color(244, 66, 38));
		lblWarningLog.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 10));
		lblWarningLog.setBounds(28, 152, 187, 14);
		mainPanel.add(lblWarningLog);
		
		tpPass.changeStyle(Font.ITALIC);
		am.btnRegresar.addActionListener(this);
		r.reg.addActionListener(this);
		r.btnRegresar.addActionListener(this);
		l.mdBtn(btnIngresar, Color.decode(l.color),Color.white);
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
							am.setVisible(true);
							am.lblBienvenido.setText(am.lblBienvenido.getText()+u.name(user.getText()));
							this.setVisible(false);
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
		if(e.getSource() == r.btnRegresar) {
			r.clearText();
			r.setVisible(false);
			this.setVisible(true);
		}
		if(e.getSource() == am.btnRegresar) {
			user.setText("");
			password.setText("");
			am.setVisible(false);
			this.setVisible(true);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnIngresar) {
			l.btnHover(btnIngresar,Color.WHITE,Color.decode(l.color), Color.decode(l.color));
			
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnIngresar){
		l.mdBtn(btnIngresar, Color.decode(l.color), Color.white);
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

