import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

public class Search extends JFrame implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNombre,txtApellidoP,txtApellidoM;
	JButton btnConsulta,btnRegresar;
	DefaultTableModel model = new DefaultTableModel();
	Seleccion sel = new Seleccion();
	Style s = new Style();
	Users u = new Users();
	Conexion c = new Conexion();
	JLabel lblWrn;
	UpdateTarjeta ut = new UpdateTarjeta();
	
	ResultSet rs;
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 214, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 198, 261);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtNombre.setBounds(10, 62, 178, 20);
		mainPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNombre.setBounds(10, 47, 178, 14);
		mainPanel.add(lblNombre);
		
		txtApellidoP = new JTextField();
		txtApellidoP.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtApellidoP.setBounds(10, 118, 178, 20);
		mainPanel.add(txtApellidoP);
		txtApellidoP.setColumns(10);
		
		btnRegresar = new JButton();
		btnRegresar.setBounds(0, 0, 35,35);
		s.btnPointer(btnRegresar);
		s.imgBtn(btnRegresar, s.urlIcon);
		mainPanel.add(btnRegresar);
		
		JLabel lblApellidoP = new JLabel("Apellido Paterno");
		lblApellidoP.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblApellidoP.setBounds(10, 103, 178, 14);
		mainPanel.add(lblApellidoP);
		
		txtApellidoM = new JTextField();
		txtApellidoM.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtApellidoM.setBounds(10, 174, 178, 20);
		mainPanel.add(txtApellidoM);
		txtApellidoM.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblApellidoMaterno.setBounds(10, 159, 178, 14);
		mainPanel.add(lblApellidoMaterno);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnConsulta.setBounds(10, 220, 178, 30);
		mainPanel.add(btnConsulta);
		
		JLabel lblHeader = new JLabel("<html><body>Ingrese el nombre <br>del propietario</html></body>");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblHeader.setBounds(10, 12, 178, 39);
		mainPanel.add(lblHeader);
		
		lblWrn = new JLabel("");
		lblWrn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblWrn.setBounds(10, 205, 178, 14);
		mainPanel.add(lblWrn);
		s.mdBtn(btnConsulta, Color.decode(s.color), Color.WHITE);
		s.btnPointer(btnConsulta);
		s.btnPointer(btnRegresar);
		btnConsulta.addMouseListener(this);
		btnConsulta.addActionListener(this);
		
		model.addColumn("Placas");
		model.addColumn("Marca");
		model.addColumn("Submarca");
		model.addColumn("Modelo");
		s.mdTxt(txtNombre, Color.WHITE, Color.BLACK);
		s.mdTxt(txtApellidoP, Color.WHITE, Color.BLACK);
		s.mdTxt(txtApellidoM, Color.WHITE, Color.BLACK);
		TextPrompt tpName= new TextPrompt("Nombre(s)",txtNombre,s.f12,s.glight);
		TextPrompt tpAp1= new TextPrompt("Nombre(s)",txtApellidoP,s.f12,s.glight);
		TextPrompt tpAp2= new TextPrompt("Nombre(s)",txtApellidoM,s.f12,s.glight);
		sel.btnRegresar.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnConsulta) {
			s.btnHover(btnConsulta, Color.white, Color.decode(s.color), Color.decode(s.color));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnConsulta) {
			s.mdBtn(btnConsulta, Color.decode(s.color), Color.WHITE);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConsulta) {
			model.setRowCount(0);
			if(u.getExistingPropietario(txtNombre.getText(), txtApellidoP.getText(), txtApellidoM.getText())) {
				try {					
					int id = u.getidUserByName(txtNombre.getText(),txtApellidoP.getText(),txtApellidoM.getText());
					rs = c.query("SELECT * FROM tarjetas t LEFT JOIN propietario p on t.idPropietario = p.id where p.id ="+id+";");
					if(rs.next()) {
						this.setVisible(false);
						sel.setVisible(true);
						sel.lblPropietario.setText(sel.lblPropietario.getText()+rs.getString("Nombre")+" "+rs.getString("ApellidoP")+" "+rs.getString("ApellidoM"));
						do {
							model.addRow(new Object[] {
								rs.getString("placas"),rs.getString("Marca"),rs.getString("submarca"),rs.getString("modelo")
							});
						}
						while(rs.next());					
						
					}
					
					sel.table.setModel(model);
				} catch (SQLException e1) {
					e1.printStackTrace();
					}
			}else{
				lblWrn.setForeground(Color.decode("#F44336"));
				lblWrn.setText("No se encontraron resultados ");
				}
		}
		if(e.getSource() == sel.btnRegresar) {
			this.setVisible(true);
			sel.setVisible(false);
		}
	}
}
