import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.LineBorder;
public class MainWindow extends JFrame implements ActionListener,MouseListener{
	
	
	
	private static final long serialVersionUID = 1L;
	Style s = new Style();
	Window w = new Window();
	private JPanel contentPane;

	JButton btnConsulta,btnInicio;
	
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 241, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 225, 263);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta Veh\u00EDcular");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 28, 205, 28);
		mainPanel.add(lblNewLabel);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnConsulta.setBounds(10, 84, 205, 47);
		mainPanel.add(btnConsulta);
		btnConsulta.addActionListener(this);
		btnConsulta.addMouseListener(this);
		
		btnInicio = new JButton("Iniciar Sesi\u00F3n");
		btnInicio.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnInicio.setBounds(10, 163, 205, 47);
		btnInicio.addActionListener(this);
		mainPanel.add(btnInicio);
		btnInicio.addMouseListener(this);
		
		s.mdPanel(mainPanel, Color.WHITE);
		s.mdBtn(btnConsulta, Color.decode(s.color),Color.white);
		s.mdBtn(btnInicio, Color.decode(s.color),Color.white);
		s.btnPointer(btnConsulta);
		s.btnPointer(btnInicio);
		
		w.btnRegresar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnConsulta) {
			
		}
		if (e.getSource() == btnInicio) {
			w.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource() == w.btnRegresar) {
			this.setVisible(true);
			w.setVisible(false);

		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnConsulta) {
			s.btnHover(btnConsulta, Color.WHITE, Color.decode(s.color), Color.decode(s.color));
		}if(e.getSource() == btnInicio) {
			s.btnHover(btnInicio, Color.WHITE, Color.decode(s.color), Color.decode(s.color));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnConsulta) {
			s.mdBtn(btnConsulta, Color.decode(s.color),Color.white);
		}
		if(e.getSource() == btnInicio) {
			s.mdBtn(btnInicio, Color.decode(s.color),Color.white);
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
