
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
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
	JButton btnExit = new JButton("Salir"),btnSettings,btnAddUser = new JButton(),btnAddCard = new JButton();
	CircleButton cbUsers = new CircleButton("");
	
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 246, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 227, 311);
		s.mdPanel(mainPanel,Color.white);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);	
		
		JPanel header = new JPanel();
		header.setBounds(10, 11, 207, 38);
		header.setLayout(null);
		mainPanel.add(header);
		s.mdPanel(header,Color.white);
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 11));
				
		lblBienvenido.setBounds(10, 11, 187, 16);
		header.add(lblBienvenido);
	
		JPanel mainCard = new JPanel();
		mainCard.setBounds(10, 60, 207, 207);
		mainCard.setLayout(null);
		s.mdPanel(mainCard,Color.WHITE);
		mainPanel.add(mainCard);
		
		
		btnAddUser.setBounds(10, 11, 53, 53);
		btnAddUser.setIcon(new ImageIcon("views/addUser.png"));
		btnAddUser.setContentAreaFilled(false);
		btnAddUser.setBorder(null);
		btnAddUser.addActionListener(this);
		mainCard.add(btnAddUser);
		
		
		btnAddCard.setContentAreaFilled(false);
		btnAddCard.setBorder(null);
		btnAddCard.setBounds(10, 79, 53, 53);
		btnAddCard.setIcon(new ImageIcon("views/addCard.png"));
		btnAddCard.addActionListener(this);
		mainCard.add(btnAddCard);
		s.btnPointer(btnAddCard);
		
		JLabel lblAddUser = new JLabel("Usuarios");
		lblAddUser.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		lblAddUser.setBounds(73, 29, 124, 14);
		mainCard.add(lblAddUser);
		
		JLabel lblAddCard = new JLabel("Tarjetas");
		lblAddCard.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		lblAddCard.setBounds(73, 100, 124, 14);
		mainCard.add(lblAddCard);
		s.btnPointer(btnAddUser);
		
		btnSettings = new JButton();
		btnSettings.setContentAreaFilled(false);
		btnSettings.setBorder(null);
		btnSettings.setBounds(10, 143, 53, 53);
		btnSettings.setIcon(new ImageIcon("views/settings.png"));
		mainCard.add(btnSettings);
		s.btnPointer(btnSettings);
		
		JLabel lblSettings = new JLabel("Configuraci\u00F3n");
		lblSettings.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		lblSettings.setBounds(73, 162, 124, 14);
		mainCard.add(lblSettings);
		
		
		btnExit.setBounds(128, 278, 89, 23);
		mainPanel.add(btnExit);
		s.mdBtn(btnExit,Color.decode("#F44336"));
		s.btnPointer(btnExit);
		
		nt.btnSave.addActionListener(this);
		cr.btnContinue.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAddCard) {
			nt.setVisible(true);
			this.setVisible(false);
		}if(e.getSource() == nt.btnSave) {
			if(nt.dataComplete()) {
				cr.setVisible(true);
			}
		}if(e.getSource() == cr.btnContinue) {
			cr.setVisible(false);
			nt.setVisible(false);
			this.setVisible(true);
			
		}
		
		
	}
}
