
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class ConsultaRemover extends JFrame implements ActionListener,MouseListener{
	
	private static final long serialVersionUID = 1L;
	Warnings w = new Warnings();
	Remover r = new Remover();
	Users u = new Users();
	Style s = new Style();
	ResultSet rs,rp;
	Conexion c = new Conexion();
	ViewTarjeta vt = new ViewTarjeta();
	private JPanel contentPane;
	JTextField txtPlacas;
	JTextField txtSerie;
	JLabel lblWarn;
	JButton btnConsultar,btnRegresar;
	JLabel lblTitle = new JLabel("Remover Tarjeta");
	

	public ConsultaRemover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 231, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 215, 285);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnConsultar.setBounds(10, 231, 195, 43);
		mainPanel.add(btnConsultar);
		btnConsultar.addMouseListener(this);
		
		txtPlacas = new JTextField();
		txtPlacas.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlacas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPlacas.setBounds(10, 70, 195, 43);
		mainPanel.add(txtPlacas);
		txtPlacas.setColumns(6);
		
		txtSerie=new JTextField();
		txtSerie.setHorizontalAlignment(SwingConstants.CENTER);
		txtSerie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSerie.setColumns(5);
		txtSerie.setBounds(10, 161, 195, 43);
		mainPanel.add(txtSerie);
		
		btnRegresar = new JButton();
		btnRegresar.setBounds(10, 11, 35,35);
		mainPanel.add(btnRegresar);
		s.btnPointer(btnRegresar);
		s.imgBtn(btnRegresar, s.urlIcon);
		
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
		TextPrompt tpPl= new TextPrompt("------",txtPlacas,s.f16,s.glight);
		TextPrompt tpCs= new TextPrompt("-----",txtSerie,s.f16,s.glight);
		tpPl.setHorizontalAlignment(JLabel.CENTER);
		tpCs.setHorizontalAlignment(JLabel.CENTER);
		s.mdBtn(btnConsultar,Color.decode(s.color),Color.white);
		s.mdPanel(mainPanel, Color.white);
		s.mdTxt(txtPlacas, Color.white,Color.black);
		s.mdTxt(txtSerie, Color.WHITE,Color.black);
		
		lblWarn = new JLabel("");
		lblWarn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblWarn.setBounds(10, 206, 195, 26);
		mainPanel.add(lblWarn);
		btnConsultar.addActionListener(this);
		r.btnDelete.addActionListener(this);
		w.btnAceptar.addActionListener(this);
<<<<<<< HEAD
		r.btnRegresar.addActionListener(this);
=======
>>>>>>> 501ee14df6c19404232c0279d9b6fd3a976058c0
		w.btnCancelar.addActionListener(this);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConsultar) {
			if(!s.maxLength(txtPlacas, lblWarn, 8) && !s.maxLength(txtSerie, lblWarn, 5)) {
				rs = c.query("SELECT * FROM propietario p LEFT JOIN tarjetas t ON p.id = t.idPropietario WHERE t.placas = '" + 
						txtPlacas.getText()+"' AND t.numSerie LIKE '%"+txtSerie.getText()+"';");
				
				try {			
					if(!rs.next()) {
						lblWarn.setForeground(Color.red);
						lblWarn.setText("No se encontraron reultados");
					}else {
						r.setVisible(true);
						this.setVisible(false);
						r.getTarjetaByPlacas(rs);
						u.getPropietario(rs, r.txtPropietario, r.txtAp1, r.txtAp2);
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		if(e.getSource() == r.btnRegresar) {
			this.setVisible(true);
			r.setVisible(false);
		}if(e.getSource() == r.btnDelete) {
			w.setVisible(true);
		}
		if(e.getSource() == w.btnAceptar) {

			try {
			c.update("DELETE FROM tarjetas WHERE placas = '"+txtPlacas.getText()+"' AND numSerie LIKE '%"+txtSerie.getText()+"'");
			w.setVisible(false);
			r.setVisible(false);
			this.setVisible(true);
			}catch(Exception ex) {
				
			}
			
		
		}if(e.getSource() == w.btnCancelar) {
			w.setVisible(false);
		}
		
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