import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuAdminTarjetas extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	NewTarjeta nt = new NewTarjeta();
	Users u = new Users();
	Style s = new Style();
	Consulta con = new Consulta();
	private JPanel contentPane;
	JButton btnCrear = new JButton(),btnRegresar = new JButton(), btnRemover= new JButton(),btnConsultar=new JButton();
	public MenuAdminTarjetas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 220, 297);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		
		btnCrear.setBounds(10, 70, 64, 64);
		mainPanel.add(btnCrear);
		
		JLabel lblCrear = new JLabel("Nueva Tarjeta");
		lblCrear.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblCrear.setBounds(81, 91, 129, 14);
		mainPanel.add(lblCrear);
		
		btnConsultar.setBounds(10, 143, 64, 64);
		mainPanel.add(btnConsultar);
		
		btnRemover.setBounds(10, 218, 64, 64);
		mainPanel.add(btnRemover);
		
		
		btnRegresar.setBounds(10, 11, 35,35);
		mainPanel.add(btnRegresar);
		
		JLabel lblConsultar = new JLabel("Buscar Tarjeta");
		lblConsultar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblConsultar.setBounds(81, 163, 129, 14);
		mainPanel.add(lblConsultar);
		
		JLabel lblRemover = new JLabel("Remover Tarjeta");
		lblRemover.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblRemover.setBounds(81, 243, 129, 14);
		mainPanel.add(lblRemover);
		
		JLabel lblTitle = new JLabel("Selecciona un movimiento");
		lblTitle.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 14));
		lblTitle.setBounds(47, 21, 163, 14);
		mainPanel.add(lblTitle);
		btnConsultar.addActionListener(this);
		btnCrear.addActionListener(this);
		nt.btnSave.addActionListener(this);
		s.imgBtn(btnCrear, s.urlbtn);
		s.btnPointer(btnConsultar);
		s.btnPointer(btnCrear);
		s.btnPointer(btnRegresar);
		s.imgBtn(btnRegresar, s.urlIcon);
		s.btnPointer(btnRemover);
		s.imgBtn(btnConsultar, "views/search.png");
		s.imgBtn(btnRemover, "views/delete.png");
		s.mdPanel(mainPanel, Color.white);
		
		nt.btnRegresar.addActionListener(this);
		con.btnRegresar.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == nt.btnSave) {
			
			if(nt.dataComplete()) {
				try {
					nt.saveCard();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				nt.setVisible(false);
				this.setVisible(true);
				
			}
		}
		if(e.getSource() == btnCrear) {
			nt.setVisible(true);
			this.setVisible(false);
		}if(e.getSource() == btnConsultar) {
			con.setVisible(true);
			this.setVisible(false);
		}if(e.getSource() == con.btnRegresar) {
			this.setVisible(true);
			con.setVisible(false);
		}if(e.getSource() == nt.btnRegresar) {
			this.setVisible(true);
			nt.setVisible(false);
		}
	}
}
