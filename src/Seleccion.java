
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;


public class Seleccion extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table = new JTable();
	JButton btnContinuar,btnRegresar;
	Users u = new Users();
	ResultSet rs;
	UpdateTarjeta ut = new UpdateTarjeta();
	int index = 0;
	
	DefaultTableModel model = new DefaultTableModel();
	Style s = new Style();
	Conexion c= new Conexion();
	ViewTarjeta vt = new ViewTarjeta();
	JLabel lblPropietario;
	
	public Seleccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 267, 318);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblHeader = new JLabel("Seleccionar Vehiculo");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblHeader.setBounds(44, 11, 198, 26);
		mainPanel.add(lblHeader);
		
		lblPropietario = new JLabel("Vehiculos de ");
		lblPropietario.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblPropietario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPropietario.setBounds(10, 59, 257, 14);
		mainPanel.add(lblPropietario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 247, 162);
		mainPanel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		btnRegresar = new JButton();
		btnRegresar.setBounds(10, 11, 35,35);
		mainPanel.add(btnRegresar);
		s.btnPointer(btnRegresar);
		s.imgBtn(btnRegresar, s.urlIcon);
		
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnContinuar.setBounds(168, 284, 89, 23);
		mainPanel.add(btnContinuar);
		btnContinuar.addActionListener(this);
		ut.btnRegresar.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnContinuar) {
			model = (DefaultTableModel) table.getModel();
			index = table.getSelectedRow();
			ut.setVisible(true);
			try {
				rs = c.query("SELECT * FROM propietario p LEFT JOIN tarjetas t ON p.id = t.idPropietario WHERE t.placas = '"+model.getValueAt(index, 0)+"';");
				rs.next();
				ut.setFields(rs);
				u.getPropietario(rs, vt.txtPropietario, vt.txtAp1, vt.txtAp2);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		if(e.getSource() == ut.btnRegresar) {
			this.setVisible(true);
			ut.setVisible(false);
		}
	}
}
