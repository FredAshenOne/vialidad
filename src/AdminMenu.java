
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.SwingConstants;

public class AdminMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ConfirmRequest cr = new ConfirmRequest();
	public JLabel lblBienvenido = new JLabel("Bienvenido! ");
	Style s = new Style();
	NewTarjeta nt = new NewTarjeta();
	JButton btnRegresar = new JButton(),btnSettings,btnAddUser = new JButton(),btnCard = new JButton();
	MenuAdminTarjetas mat = new MenuAdminTarjetas();
	
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 243, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 217, 291);
		s.mdPanel(mainPanel,Color.white);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
	
		JPanel mainCard = new JPanel();
		mainCard.setBounds(10, 73, 207, 207);
		mainCard.setLayout(null);
		s.mdPanel(mainCard,Color.WHITE);
		mainPanel.add(mainCard);
		
		
		btnAddUser.setBounds(10, 11, 53, 53);
		s.imgBtn(btnAddUser, "views/addUser.png");
		btnAddUser.addActionListener(this);
		mainCard.add(btnAddUser);
		
		btnCard.setBounds(10, 79, 53, 53);
		btnCard.addActionListener(this);
		mainCard.add(btnCard);
		s.imgBtn(btnCard, "views/addCard.png");
		s.btnPointer(btnCard);
		
		JLabel lblAddUser = new JLabel("Usuarios");
		lblAddUser.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblAddUser.setBounds(73, 29, 124, 14);
		mainCard.add(lblAddUser);
		
		JLabel lblAddCard = new JLabel("Tarjetas");
		lblAddCard.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblAddCard.setBounds(73, 100, 124, 14);
		mainCard.add(lblAddCard);
		s.btnPointer(btnAddUser);
		
		btnSettings = new JButton();
		btnSettings.setBounds(10, 145, 53, 53);
		s.imgBtn(btnSettings, "views/settings.png");
		mainCard.add(btnSettings);
		s.btnPointer(btnSettings);
		
		JLabel lblSettings = new JLabel("Configuraci\u00F3n");
		lblSettings.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblSettings.setBounds(73, 162, 124, 14);
		mainCard.add(lblSettings);
		
		
		btnRegresar.setBounds(10, 11, 35,35);
		mainPanel.add(btnRegresar);
		s.btnPointer(btnRegresar);
		s.imgBtn(btnRegresar, s.urlIcon);
		lblBienvenido.setBounds(10, 46, 207, 16);
		mainPanel.add(lblBienvenido);
		lblBienvenido.setHorizontalAlignment(SwingConstants.LEFT);
		lblBienvenido.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		
		nt.btnSave.addActionListener(this);
		cr.btnContinue.addActionListener(this);
		mat.btnRegresar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCard) {
			mat.setVisible(true);
			this.setVisible(false);
		
		}if(e.getSource() == cr.btnContinue) {
			cr.setVisible(false);
			nt.setVisible(false);
			this.setVisible(true);
			
		}if(e.getSource() == mat.btnRegresar) {
			this.setVisible(true);
			mat.setVisible(false);
		}
		
	}
}
