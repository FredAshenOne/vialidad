import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Warnings extends JFrame implements MouseListener{

	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	JButton btnCancelar = new JButton("Cancelar"),btnAceptar = new JButton("Aceptar");
	Style s = new Style();
	JLabel lblWarning;
	
	public Warnings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 332, 144);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblWarning = new JLabel("Se Aceptas se borrar\u00E1 esta tarjeta de la base de datos");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblWarning.setBounds(10, 34, 312, 30);
		panel.add(lblWarning);
		
		btnCancelar.setBounds(10, 75, 151, 30);
		panel.add(btnCancelar);
		
		btnAceptar.setBounds(171, 75, 151, 30);
		panel.add(btnAceptar);;
		s.mdBtn(btnAceptar, Color.decode(s.color),Color.white);
		s.mdBtn(btnCancelar, Color.decode("#F44336"), Color.white);
		s.btnPointer(btnAceptar);
		s.btnPointer(btnCancelar);
		btnCancelar.addMouseListener(this);
		btnAceptar.addMouseListener(this);
	}@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnAceptar) {
			s.btnHover(btnAceptar, Color.WHITE, Color.decode(s.color), Color.decode(s.color));
			
		}
		if(e.getSource() == btnCancelar) {
			s.btnHover(btnCancelar, Color.white, Color.decode("#F44336"), Color.decode("#F44336"));
			
		}
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() ==btnAceptar ) {
			s.mdBtn(btnAceptar, Color.decode(s.color),Color.white);			
		}
		if(e.getSource() == btnCancelar) {
			s.mdBtn(btnCancelar, Color.decode("#F44336"), Color.white);
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
