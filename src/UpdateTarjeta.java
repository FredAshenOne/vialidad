import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UpdateTarjeta extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Conexion c = new Conexion();
	ConfirmRequest cr = new ConfirmRequest();
	Style s = new Style();
	Users u = new Users();
	Warnings war = new Warnings();
	
	private JPanel contentPane,mainPanel = new JPanel();
	JLabel lblSecetaria,lblFolio,lblServicioPart,lblPlacas,lblPuertas,lblPasaj,lblCilindros,lblComb,lblColor2,
	lblDataComplete,lblSave,lblAp2,lblAp1,lblLogo,lblUso,lblClase,lblTipo,lblServicio,lblProced,lblNrpv,lblMotor,
	lblSerie,lblMov,lblColor1,lblVersion,lblModelo,lblMarca,lblRecaudadora,lblLinea,lblDatosVe,lblClave,lblFecha,
	lblNewLabel,lblPropietario,lblPlaneacion,lblCc,lblAdmon;
	
	public JTextField txtPropietario,txtLugar,txtFolio,txtFecha,txtClave,txtPlacas,txtMarca,txtLinea,
	txtVersion,txtModelo,txtColor1,txtColor2,txtSerie,txtMotor,txtNRPV,
	txtCC,txtCilindros,txtPuertas,txtPasaj,txtAp1,txtAp2;
	public JButton btnSave,btnRegresar = new JButton();
	public JComboBox<Integer> cbMov,cbProced,cbComb,cbServ,cbUso,cbClase,cbTipo,cbRecaudadora;
	

	
	public UpdateTarjeta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainPanel.setBounds(0, 0, 677, 452);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		lblSecetaria = new JLabel("Secretar\u00EDa de Movilidad");
		lblSecetaria.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		lblSecetaria.setBounds(44, 11, 165, 14);
		mainPanel.add(lblSecetaria);
		
		lblPlaneacion = new JLabel("Secretar\u00EDa de Planeaci\u00F3n");
		lblPlaneacion.setBounds(10, 36, 125, 14);
		mainPanel.add(lblPlaneacion);
		
		lblAdmon = new JLabel("Administraci\u00F3n y Finanzas");
		lblAdmon.setBounds(10, 50, 125, 14);
		mainPanel.add(lblAdmon);
		
		 lblServicioPart = new JLabel("Servicio Part\u00EDcular");
		 lblServicioPart.setHorizontalAlignment(SwingConstants.CENTER);
		lblServicioPart.setBounds(269, 0, 125, 14);
		mainPanel.add(lblServicioPart);
		
		lblNewLabel = new JLabel("Tarjeta de Circulaci\u00F3n");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 70, 165, 14);
		mainPanel.add(lblNewLabel);
		
		JPanel userPanel = new JPanel();
		userPanel.setBounds(10, 87, 648, 233);
		mainPanel.add(userPanel);
		userPanel.setLayout(null);
		s.mdPanel(userPanel,Color.decode("#C8E6C9"));
		
		lblPropietario = new JLabel("PROPIETARIO");
		lblPropietario.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblPropietario.setBounds(10, 11, 58, 14);
		userPanel.add(lblPropietario);
		
		txtPropietario = new JTextField();
		txtPropietario.setBounds(65, 7, 73, 16);
		userPanel.add(txtPropietario);
		txtPropietario.setColumns(10);
		s.mdTxt(txtPropietario, Color.WHITE, Color.black);
		
		lblFecha = new JLabel("LUGAR Y FECHA DE EXPEDICION");
		lblFecha.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblFecha.setBounds(10, 30, 121, 14);
		userPanel.add(lblFecha);
		
		txtLugar = new JTextField();
		txtLugar.setBounds(127, 28, 120, 16);
		userPanel.add(txtLugar);
		txtLugar.setColumns(10);
		s.mdTxt(txtLugar, Color.WHITE, Color.black);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(257, 28, 120, 16);
		userPanel.add(txtFecha);
		s.mdTxt(txtFecha, Color.WHITE, Color.black);
		
		txtFolio = new JTextField();
		txtFolio.setColumns(10);
		txtFolio.setBounds(518, 28, 120, 16);
		userPanel.add(txtFolio);
		s.mdTxt(txtFolio, Color.WHITE, Color.black);
		
		lblFolio = new JLabel("FOLIO");
		lblFolio.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblFolio.setBounds(479, 30, 29, 14);
		userPanel.add(lblFolio);
		
		lblRecaudadora = new JLabel("RECAUDADORA");
		lblRecaudadora.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblRecaudadora.setBounds(10, 52, 58, 14);
		userPanel.add(lblRecaudadora);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(518, 55, 120, 16);
		userPanel.add(txtClave);
		s.mdTxt(txtClave, Color.WHITE,Color.BLACK);
		
		lblClave = new JLabel("CLAVE VEH\u00CDCULAR");
		lblClave.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblClave.setBounds(444, 57, 73, 14);
		userPanel.add(lblClave);
		
		JPanel carPane = new JPanel();
		carPane.setBounds(0, 74, 648, 160);
		userPanel.add(carPane);
		carPane.setLayout(null);
		
		lblDatosVe = new JLabel("DATOS DEL VEH\u00CDCULO");
		lblDatosVe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosVe.setBounds(0, 0, 649, 23);
		carPane.add(lblDatosVe);
		
		
		lblPlacas = new JLabel("PLACAS");
		lblPlacas.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblPlacas.setBounds(20, 34, 40, 14);
		carPane.add(lblPlacas);
		
		lblMarca = new JLabel("MARCA");
		lblMarca.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblMarca.setBounds(20, 59, 40, 14);
		carPane.add(lblMarca);
		
		lblLinea = new JLabel("LINEA O SUBMARCA");
		lblLinea.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblLinea.setBounds(20, 84, 80, 14);
		carPane.add(lblLinea);
		
		lblVersion = new JLabel("VERSI\u00D3N");
		lblVersion.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblVersion.setBounds(20, 109, 33, 14);
		carPane.add(lblVersion);
		
		lblModelo = new JLabel("MODELO");
		lblModelo.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblModelo.setBounds(20, 134, 40, 14);
		carPane.add(lblModelo);
		
		txtPlacas = new JTextField();
		txtPlacas.setColumns(10);
		txtPlacas.setBounds(59, 34, 126, 16);
		carPane.add(txtPlacas);
		s.mdTxt(txtPlacas, Color.WHITE, Color.black);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(59, 55, 126, 16);
		carPane.add(txtMarca);
		s.mdTxt(txtMarca, Color.WHITE, Color.black);
		
		txtLinea = new JTextField();
		txtLinea.setColumns(10);
		txtLinea.setBounds(99, 80, 86, 16);
		carPane.add(txtLinea);
		s.mdTxt(txtLinea, Color.WHITE, Color.black);
		
		txtVersion = new JTextField();
		txtVersion.setColumns(10);
		txtVersion.setBounds(59, 105, 126, 16);
		carPane.add(txtVersion);
		s.mdTxt(txtVersion, Color.WHITE, Color.black);
		
		btnRegresar.setBounds(0, 0, 35,35);
		mainPanel.add(btnRegresar);
		s.btnPointer(btnRegresar);
		s.imgBtn(btnRegresar, s.urlIcon);
		
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(59, 130, 126, 16);
		carPane.add(txtModelo);
		s.mdTxt(txtModelo, Color.WHITE, Color.black);
		
		lblColor1 = new JLabel("COLOR 1");
		lblColor1.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblColor1.setBounds(195, 34, 40, 14);
		carPane.add(lblColor1);
		
		lblColor2 = new JLabel("COLOR 2");
		lblColor2.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblColor2.setBounds(195, 59, 40, 14);
		carPane.add(lblColor2);
		
		lblSerie = new JLabel("NUM. DE SERIE");
		lblSerie.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblSerie.setBounds(195, 83, 53, 14);
		carPane.add(lblSerie);
		
		lblMotor = new JLabel("NUM. DE MOTOR");
		lblMotor.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblMotor.setBounds(195, 108, 64, 14);
		carPane.add(lblMotor);
		
		lblNrpv = new JLabel("N.R.P.V.");
		lblNrpv.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblNrpv.setBounds(195, 133, 40, 14);
		carPane.add(lblNrpv);
		
		txtColor1 = new JTextField();
		txtColor1.setColumns(10);
		txtColor1.setBounds(231, 34, 166, 16);
		carPane.add(txtColor1);
		s.mdTxt(txtColor1, Color.WHITE, Color.black);
		
		txtColor2 = new JTextField();
		txtColor2.setColumns(10);
		txtColor2.setBounds(231, 55, 166, 16);
		carPane.add(txtColor2);
		s.mdTxt(txtColor2, Color.WHITE, Color.black);
		
		txtSerie = new JTextField();
		txtSerie.setColumns(10);
		txtSerie.setBounds(251, 80, 146, 16);
		carPane.add(txtSerie);
		s.mdTxt(txtSerie, Color.WHITE, Color.black);
		
		txtMotor = new JTextField();
		txtMotor.setColumns(10);
		txtMotor.setBounds(261, 105, 136, 16);
		carPane.add(txtMotor);
		s.mdTxt(txtMotor, Color.WHITE, Color.black);
		
		txtNRPV = new JTextField();
		txtNRPV.setColumns(10);
		txtNRPV.setBounds(231, 130, 166, 16);
		carPane.add(txtNRPV);
		s.mdTxt(txtNRPV, Color.WHITE, Color.black);
		
		lblMov = new JLabel("MOV.");
		lblMov.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblMov.setBounds(407, 33, 40, 14);
		carPane.add(lblMov);
		
		lblProced = new JLabel("PROCED.");
		lblProced.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblProced.setBounds(407, 58, 40, 14);
		carPane.add(lblProced);
		
		lblComb = new JLabel("COMB.");
		lblComb.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblComb.setBounds(407, 83, 40, 14);
		carPane.add(lblComb);
		
		lblServicio = new JLabel("SERVICIO");
		lblServicio.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblServicio.setBounds(407, 108, 40, 14);
		carPane.add(lblServicio);
		
		lblUso = new JLabel("USO");
		lblUso.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblUso.setBounds(407, 133, 40, 14);
		carPane.add(lblUso);
		
		lblClase = new JLabel("CLASE");
		lblClase.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblClase.setBounds(517, 34, 33, 14);
		carPane.add(lblClase);
		
		
		lblTipo = new JLabel("TIPO");
		lblTipo.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblTipo.setBounds(517, 59, 24, 14);
		carPane.add(lblTipo);
		
		lblCilindros = new JLabel("CILINDROS");
		lblCilindros.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblCilindros.setBounds(517, 84, 45, 14);
		carPane.add(lblCilindros);
		
		lblPuertas = new JLabel("PUERTAS");
		lblPuertas.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblPuertas.setBounds(517, 109, 40, 14);
		carPane.add(lblPuertas);
		
		lblPasaj = new JLabel("PASAJ./LG");
		lblPasaj.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblPasaj.setBounds(517, 134, 41, 14);
		carPane.add(lblPasaj);
		
		lblCc = new JLabel("CC");
		lblCc.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblCc.setBounds(595, 59, 18, 14);
		carPane.add(lblCc);
		
		txtCC = new JTextField();
		txtCC.setColumns(10);
		txtCC.setBounds(614, 57, 24, 16);
		carPane.add(txtCC);
		s.mdTxt(txtCC, Color.WHITE, Color.black);
		
		txtCilindros = new JTextField();
		txtCilindros.setColumns(10);
		txtCilindros.setBounds(572, 82, 67, 16);
		carPane.add(txtCilindros);
		s.mdTxt(txtCilindros, Color.WHITE, Color.black);
		
		txtPuertas = new JTextField();
		txtPuertas.setColumns(10);
		txtPuertas.setBounds(567, 107, 71, 16);
		carPane.add(txtPuertas);
		s.mdTxt(txtPuertas, Color.WHITE, Color.black);
		
		txtPasaj = new JTextField();
		txtPasaj.setColumns(10);
		txtPasaj.setBounds(568, 132, 70, 16);
		carPane.add(txtPasaj);
		s.mdTxt(txtPasaj, Color.WHITE, Color.black);
		s.mdPanel(carPane,Color.decode("#C8E6C9"));
		s.mdPanel(mainPanel,Color.WHITE);
		lblDatosVe.setOpaque(true);
		lblDatosVe.setBackground(Color.decode("#2E7D32"));
		lblDatosVe.setForeground(Color.WHITE);
		
		cbMov = new JComboBox<Integer>();
		cbMov.setModel(new DefaultComboBoxModel(new String[] {"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbMov.setBounds(447, 34, 53, 16);
		carPane.add(cbMov);
		
		cbProced = new JComboBox<Integer>();
		cbProced.setModel(new DefaultComboBoxModel(new String[] {"","1", "2", "3"}));
		cbProced.setBounds(447, 55, 53, 16);
		carPane.add(cbProced);
		
		cbComb = new JComboBox<Integer>();
		cbComb.setModel(new DefaultComboBoxModel(new String[] {"","1", "2", "3", "4", "5", "10", "11"}));
		cbComb.setBounds(447, 80, 53, 16);
		carPane.add(cbComb);
		
		cbServ = new JComboBox<Integer>();
		cbServ.setModel(new DefaultComboBoxModel(new String[] {"","1", "2", "3", "4", "5"}));
		cbServ.setBounds(447, 105, 53, 16);
		carPane.add(cbServ);
		
		cbUso = new JComboBox<Integer>();
		cbUso.setModel(new DefaultComboBoxModel(new String[] {"","1", "2", "3", "4", "5", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51"}));
		cbUso.setBounds(447, 130, 53, 16);
		carPane.add(cbUso);
		
		cbClase = new JComboBox<Integer>();
		cbClase.setModel(new DefaultComboBoxModel(new String[] {"","1", "2", "3", "4"}));
		cbClase.setBounds(585, 34, 53, 16);
		carPane.add(cbClase);
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[]{"","11", "12", "13", "14", "15", "16", "17", "18", "51", "52", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "4", "48", "49", "50", "80", "81", "61", "62", "63", "64", "65", "66", "67", "68", "69", "71", "72", "73", "74", "75", "76"}));
		cbTipo.setBounds(538, 57, 53, 16);
		carPane.add(cbTipo);
		
		cbRecaudadora = new JComboBox<Integer>();
		cbRecaudadora.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "94", "97", "114", "125", "133", "135"}));
		cbRecaudadora.setBounds(75, 47, 172, 16);
		userPanel.add(cbRecaudadora);
		
		lblAp1 = new JLabel("APELLIDO P");
		lblAp1.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblAp1.setBounds(148, 10, 58, 14);
		userPanel.add(lblAp1);
		
		txtAp1 = new JTextField();
		txtAp1.setColumns(10);
		txtAp1.setBounds(200, 7, 73, 16);
		userPanel.add(txtAp1);
		
		lblAp2 = new JLabel("APELLIDO M");
		lblAp2.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblAp2.setBounds(282, 7, 58, 14);
		userPanel.add(lblAp2);
		
		txtAp2 = new JTextField();
		txtAp2.setBounds(330, 9, 73, 16);
		userPanel.add(txtAp2);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(307, 11, 53, 56);
		mainPanel.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("views/logoVial.png"));
		
		btnSave = new JButton("");
		btnSave.setBounds(586, 24, 20, 20);
		mainPanel.add(btnSave);
		btnSave.addActionListener(this);
		btnSave.setBorder(null);
		btnSave.setIcon(new ImageIcon("views/save2.png"));
		btnSave.setContentAreaFilled(false);
		s.btnPointer(btnSave);
		
		lblDataComplete = new JLabel("");
		lblDataComplete.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 10));
		lblDataComplete.setBounds(485, 70, 151, 14);
		mainPanel.add(lblDataComplete);
		lblDataComplete.setForeground(Color.decode("#F44336"));
		
		lblSave = new JLabel("Guardar");
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblSave.setBounds(574, 49, 46, 14);
		mainPanel.add(lblSave);
		cbClase.setOpaque(true);
		cbClase.setBackground(Color.WHITE);
		cbClase.setBorder(null);
		cr.btnContinue.addActionListener(this);
		war.lblWarning.setText("Se actualizaran los datos de la tarjeta");
		war.btnAceptar.addActionListener(this);
		war.btnCancelar.addActionListener(this);
		txtSerie.setEditable(false);
	}

	public boolean dataComplete() {
		if(	txtPropietario.getText().length() < 1 || txtLugar.getText().length() < 1 ||
				txtFolio.getText().length() < 1 || txtFecha.getText().length() < 1 ||
				cbRecaudadora.getSelectedItem().toString().length() < 1 && txtClave.getText().length() < 1 ||
				txtPlacas.getText().length() < 1 || txtMarca.getText().length() < 1 ||
				txtLinea.getText().length() < 1 || txtVersion.getText().length() < 1 ||
				txtModelo.getText().length() < 1 || txtColor1.getText().length() < 1 ||
				txtSerie.getText().length() < 1 || txtMotor.getText().length() < 1 ||
				txtNRPV.getText().length() < 1 || cbMov.getSelectedItem().toString().length() < 1 ||
				cbProced.getSelectedItem().toString().length() < 1 || cbComb.getSelectedItem().toString().length() < 1 ||
				cbServ.getSelectedItem().toString().length() < 1 || cbUso.getSelectedItem().toString().length() < 1 ||
				cbClase.getSelectedItem().toString().length() < 1 || txtCC.getText().length() < 1 ||
				txtCilindros.getText().length() < 1 && txtPuertas.getText().length() < 1 ||
				txtPasaj.getText().length() < 1 || cbTipo.getSelectedItem().toString().length() < 1) {
			lblDataComplete.setText("Datos Incompletos");
			return false;
		}else {
			return true;
		}
	}
	
	public void saveCard() throws SQLException {
			
			int clase = Integer.parseInt(cbClase.getSelectedItem().toString());
			int rec = Integer.parseInt(cbRecaudadora.getSelectedItem().toString());
			int mov = Integer.parseInt(cbMov.getSelectedItem().toString());
			int proc = Integer.parseInt(cbProced.getSelectedItem().toString());
			int comb = Integer.parseInt(cbComb.getSelectedItem().toString());
			int serv = Integer.parseInt(cbServ.getSelectedItem().toString());
			int uso = Integer.parseInt(cbUso.getSelectedItem().toString());
			int nrpv = Integer.parseInt(txtNRPV.getText());
			int puertas = Integer.parseInt(txtPuertas.getText());
			int cil= Integer.parseInt(txtCilindros.getText());
			int pas = Integer.parseInt(txtPasaj.getText());
			int mod = Integer.parseInt(txtModelo.getText());
			int cc = Integer.parseInt(txtCC.getText());
			int tipo = Integer.parseInt(cbTipo.getSelectedItem().toString());
				c.update("update tarjetas set placas = '"+txtPlacas.getText()+"',marca ='"+txtMarca.getText()+"',submarca = '"+txtLinea.getText()+"',"
						+ "vers = '"+txtVersion.getText()+"',modelo = "+mod+" ,color1 = '"+txtColor1.getText()+"',color2='"+txtColor2.getText()+"'"
								+ ",numSerie='"+txtSerie.getText()+"',numMotor='"+txtMotor.getText()+"',nrpv="+nrpv+",cc="+cc+","
						+ "cilindros="+cil+",puertas="+puertas+",pasajeros="+pas+",idclaseVehiculo="+clase+",idClaseTipo="+tipo+","
								+ "idCombustible="+comb+",idMovimiento="+mov+",idProcedencia="+proc+","
						+ "idRecaudadora="+rec+",idServicio="+serv+",idUsoVehiculo="+uso+",lugar='"+txtLugar.getText()+"',fecha='"+txtFecha.getText()+"',"
								+ "folio='"+txtFolio.getText()+"',claveVehicular='"+txtClave.getText()+"' where numSerie = '"+txtSerie.getText()+"'");
				
				
				
		}	
			
		
	
	public void clearAll(JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5,
			JTextField t6,JTextField t7,JTextField t8,JTextField t9,JTextField t10,JTextField t11,JTextField t12,JTextField t13,
			JTextField t14,JTextField t15,JTextField t16,JTextField t17,JTextField t18,JTextField t19,JTextField t20,JTextField t21){
		t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");t7.setText("");t8.setText("");t9.setText("");t10.setText("");t11.setText("");
		t12.setText("");t12.setText("");t13.setText("");t14.setText("");t15.setText("");t16.setText("");t17.setText("");t18.setText("");t19.setText("");t20.setText("");t21.setText("");
		cbMov.setSelectedIndex(0);cbProced.setSelectedIndex(0);cbComb.setSelectedIndex(0);cbServ.setSelectedIndex(0);
		cbUso.setSelectedIndex(0);cbClase.setSelectedIndex(0);cbTipo.setSelectedIndex(0);cbRecaudadora.setSelectedIndex(0);lblDataComplete.setText("");
		}
		
	public void setFields(ResultSet res) {
		try {	
			txtPropietario.setText(res.getString("Nombre"));txtAp1.setText(res.getString("ApellidoP"));txtAp2.setText(res.getString("ApellidoM"));
			txtLugar.setText(res.getString("lugar"));txtFolio.setText(res.getString("folio"));
			txtFecha.setText(res.getString("fecha"));txtClave.setText(res.getString("claveVehicular"));txtPlacas.setText(res.getString("placas"));
			txtMarca.setText(res.getString("marca"));txtLinea.setText(res.getString("submarca"));txtVersion.setText(res.getString("vers"));
			txtModelo.setText(res.getString("modelo"));txtColor1.setText(res.getString("color1"));txtColor2.setText(res.getString("color2"));
			txtSerie.setText(res.getString("numSerie"));txtMotor.setText(res.getString("numMotor"));txtNRPV.setText(res.getString("nrpv"));
			txtCC.setText(res.getString("cc"));txtCilindros.setText(res.getString("cilindros"));txtPuertas.setText(res.getString("puertas"));
			txtPasaj.setText(res.getString("pasajeros"));selectItem(cbProced,res.getString("idProcedencia"));selectItem(cbComb,res.getString("idCombustible"));
			selectItem(cbMov,res.getString("idMovimiento"));selectItem(cbServ,res.getString("idServicio"));selectItem(cbUso,res.getString("idUsoVehiculo"));
			selectItem(cbClase,res.getString("idclaseVehiculo"));selectItem(cbTipo,res.getString("idClaseTipo"));selectItem(cbRecaudadora,res.getString("idRecaudadora"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		
	}
	
	public void selectItem(JComboBox cb,String txt) {
		cb.setSelectedItem(txt);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnSave) {
			war.setVisible(true);
		}		
		if(e.getSource() == war.btnAceptar) {
			try {
				saveCard();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			war.setVisible(false);
			
		}
		if(e.getSource() == war.btnCancelar) {
			war.setVisible(false);
		}
		
		
	}
}
