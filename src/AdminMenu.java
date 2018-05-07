
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
		mainPanel.setBounds(0, 0, 227, 278);
		s.mdPanel(mainPanel,Color.white);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
	
		JPanel mainCard = new JPanel();
		mainCard.setBounds(10, 89, 207, 155);
		mainCard.setLayout(null);
		s.mdPanel(mainCard,Color.WHITE);
		mainPanel.add(mainCard);
		
		btnCard.setBounds(10, 11, 53, 53);
		btnCard.addActionListener(this);
		mainCard.add(btnCard);
		s.imgBtn(btnCard, "views/addCard.png");
		s.btnPointer(btnCard);
		
		JLabel lblAddCard = new JLabel("Tarjetas");
		lblAddCard.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblAddCard.setBounds(73, 32, 124, 14);
		mainCard.add(lblAddCard);
		
		btnSettings = new JButton();
		btnSettings.setBounds(10, 91, 53, 53);
		mainCard.add(btnSettings);
		s.imgBtn(btnSettings, "views/settings.png");
		s.btnPointer(btnSettings);
		
		JLabel lblSettings = new JLabel("Configuracion");
		lblSettings.setBounds(73, 112, 124, 14);
		mainCard.add(lblSettings);
		lblSettings.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		
		
		btnRegresar.setBounds(0, 0, 35,35);
		mainPanel.add(btnRegresar);
		s.btnPointer(btnRegresar);
		s.imgBtn(btnRegresar, s.urlIcon);
		lblBienvenido.setBounds(10, 35, 207, 16);
		mainPanel.add(lblBienvenido);
		lblBienvenido.setHorizontalAlignment(SwingConstants.LEFT);
		lblBienvenido.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		s.imgBtn(btnAddUser, "views/profile.png");
		btnAddUser.setBounds(192, 0, 35, 35);
		mainPanel.add(btnAddUser);
		btnAddUser.addActionListener(this);
		s.btnPointer(btnAddUser);
		
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
