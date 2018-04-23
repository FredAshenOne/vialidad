
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class ConfirmRequest extends JFrame {
	
	private static final long serialVersionUID = 1L;

	Style s = new Style();
	
	private JPanel contentPane;
	JButton btnCancel = new JButton("Cancelar"),btnContinue = new JButton("Continuar");
	public ConfirmRequest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 155);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 277, 116);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAlert = new JLabel("Los datos seran guardados");
		lblAlert.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 11));
		lblAlert.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlert.setBounds(10, 11, 257, 40);
		panel.add(lblAlert);
		
		btnContinue.setBounds(149, 62, 118, 23);
		panel.add(btnContinue);
		btnCancel.setBounds(10, 62, 118, 23);
		panel.add(btnCancel);
		s.mdBtn(btnContinue,Color.decode("#2196F3"),Color.white);
		s.mdBtn(btnCancel,Color.decode("#F44336"),Color.white);
		s.btnPointer(btnCancel);
		s.btnPointer(btnContinue);
	}

}
