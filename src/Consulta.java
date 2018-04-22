
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Consulta extends JFrame implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;

	Style s = new Style();
	
	private JPanel contentPane;
	private JTextField txtPlacas;
	private JTextField txtSerie;
	JButton btnConsultar,btnRegresar;

	public Consulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 231, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 215, 261);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnConsultar.setBounds(10, 207, 195, 43);
		mainPanel.add(btnConsultar);
		btnConsultar.addMouseListener(this);
		
		txtPlacas = new JTextField();
		txtPlacas.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlacas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPlacas.setBounds(10, 70, 195, 43);
		mainPanel.add(txtPlacas);
		txtPlacas.setColumns(10);
		
		txtSerie = new JTextField();
		txtSerie.setHorizontalAlignment(SwingConstants.CENTER);
		txtSerie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSerie.setColumns(10);
		txtSerie.setBounds(10, 161, 195, 43);
		mainPanel.add(txtSerie);
		
		btnRegresar = new JButton();
		btnRegresar.setBounds(10, 11, 35,35);
		mainPanel.add(btnRegresar);
		s.btnPointer(btnRegresar);
		s.imgBtn(btnRegresar, s.urlIcon);
		JLabel lblTitle = new JLabel("Consulta");
		lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 195, 14);
		mainPanel.add(lblTitle);
		
		JLabel lblPlacas = new JLabel("Ingrese el codigo de placas");
		lblPlacas.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblPlacas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlacas.setBounds(10, 48, 195, 14);
		mainPanel.add(lblPlacas);
		String textlbl = "<html><body>Ingrese los ultimos 5 digitos<br> del numero de serie del vehiculo</body></html>";
		JLabel lblSerie = new JLabel(textlbl);
		lblSerie.setLabelFor(txtPlacas);
		lblSerie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSerie.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblSerie.setBounds(10, 124, 195, 26);
		mainPanel.add(lblSerie);
		
		s.mdBtn(btnConsultar,Color.decode(s.color),Color.white);
		s.mdPanel(mainPanel, Color.white);
		s.mdTxt(txtPlacas, Color.white,Color.black);
		s.mdTxt(txtSerie, Color.WHITE,Color.black);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==btnConsultar) {
		s.btnHover(btnConsultar, Color.white,Color.decode(s.color),Color.decode(s.color));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnConsultar) {
			s.mdBtn(btnConsultar, Color.decode(s.color), Color.WHITE);
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
