import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewTarjeta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane,mainPanel = new JPanel();
	JLabel lblSecetaria,lblFolio,lblServicioPart,lblPlacas,lblPuertas,lblPasaj,lblCilindros,lblComb,lblColor2,lblUso,lblClase,lblTipo,lblServicio,lblProced,lblNrpv,lblMotor,lblSerie,lblMov,lblColor1,lblVersion,lblModelo,lblMarca,lblRecaudadora,lblLinea,lblDatosVe,lblClave,lblFecha,lblNewLabel,lblPropietario,lblPlaneacion,lblCc,lblAdmon;
	private JTextField txtPropietario,txtLugar,txtFolio,txtFecha,txtRecaudadora,txtClave,txtPlacas,txtMarca,txtLinea,
	txtVersion,txtModelo,txtColor1,txtColor2,txtSerie,txtMotor,txtNRPV,txtMov,txtProced,txtComb,txtServicio,txtUso,txtTipo,
	txtCC,txtCilindros,txtPuertas,txtPasaj,txtClase;

	public ViewTarjeta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainPanel.setBounds(0, 0, 812, 452);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		
		lblSecetaria = new JLabel("Secretar\u00EDa de Movilidad");
		lblSecetaria.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		lblSecetaria.setBounds(10, 11, 165, 14);
		mainPanel.add(lblSecetaria);
		
		lblPlaneacion = new JLabel("Secretar\u00EDa de Planeaci\u00F3n");
		lblPlaneacion.setBounds(10, 36, 125, 14);
		mainPanel.add(lblPlaneacion);
		
		lblAdmon = new JLabel("Administraci\u00F3n y Finanzas");
		lblAdmon.setBounds(10, 50, 125, 14);
		mainPanel.add(lblAdmon);
		
		 lblServicioPart = new JLabel("Servicio Part\u00EDcular");
		lblServicioPart.setEnabled(false);
		lblServicioPart.setBounds(269, 0, 101, 14);
		mainPanel.add(lblServicioPart);
		
		lblNewLabel = new JLabel("Tarjeta de Circulaci\u00F3n");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 70, 165, 14);
		mainPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 87, 626, 233);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		lblPropietario = new JLabel("PROPIETARIO");
		lblPropietario.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblPropietario.setBounds(10, 11, 58, 14);
		panel.add(lblPropietario);
		
		txtPropietario = new JTextField();
		txtPropietario.setBounds(65, 11, 182, 16);
		panel.add(txtPropietario);
		txtPropietario.setColumns(10);
		
		lblFecha = new JLabel("LUGAR Y FECHA DE EXPEDICION");
		lblFecha.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblFecha.setBounds(10, 30, 121, 14);
		panel.add(lblFecha);
		
		txtLugar = new JTextField();
		txtLugar.setBounds(127, 28, 120, 16);
		panel.add(txtLugar);
		txtLugar.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(257, 28, 120, 16);
		panel.add(txtFecha);
		
		txtFolio = new JTextField();
		txtFolio.setColumns(10);
		txtFolio.setBounds(492, 28, 120, 16);
		panel.add(txtFolio);
		
		lblFolio = new JLabel("FOLIO");
		lblFolio.setEnabled(false);
		lblFolio.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblFolio.setBounds(461, 30, 29, 14);
		panel.add(lblFolio);
		
		lblRecaudadora = new JLabel("RECAUDADORA");
		lblRecaudadora.setEnabled(false);
		lblRecaudadora.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblRecaudadora.setBounds(10, 52, 58, 14);
		panel.add(lblRecaudadora);
		
		txtRecaudadora = new JTextField();
		txtRecaudadora.setColumns(10);
		txtRecaudadora.setBounds(75, 48, 120, 16);
		panel.add(txtRecaudadora);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(492, 50, 120, 16);
		panel.add(txtClave);
		
		lblClave = new JLabel("CLAVE VEH\u00CDCULAR");
		lblClave.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblClave.setEnabled(false);
		lblClave.setBounds(417, 52, 73, 14);
		panel.add(lblClave);
		
		JPanel carPane = new JPanel();
		carPane.setBounds(0, 74, 626, 160);
		panel.add(carPane);
		carPane.setLayout(null);
		
		lblDatosVe = new JLabel("DATOS DEL VEH\u00CDCULO");
		lblDatosVe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosVe.setBounds(0, 0, 626, 23);
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
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(59, 55, 126, 16);
		carPane.add(txtMarca);
		
		txtLinea = new JTextField();
		txtLinea.setColumns(10);
		txtLinea.setBounds(99, 80, 86, 16);
		carPane.add(txtLinea);
		
		txtVersion = new JTextField();
		txtVersion.setColumns(10);
		txtVersion.setBounds(59, 105, 126, 16);
		carPane.add(txtVersion);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(59, 130, 126, 16);
		carPane.add(txtModelo);
		
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
		
		txtColor2 = new JTextField();
		txtColor2.setColumns(10);
		txtColor2.setBounds(231, 55, 166, 16);
		carPane.add(txtColor2);
		
		txtSerie = new JTextField();
		txtSerie.setColumns(10);
		txtSerie.setBounds(251, 80, 146, 16);
		carPane.add(txtSerie);
		
		txtMotor = new JTextField();
		txtMotor.setColumns(10);
		txtMotor.setBounds(261, 105, 136, 16);
		carPane.add(txtMotor);
		
		txtNRPV = new JTextField();
		txtNRPV.setColumns(10);
		txtNRPV.setBounds(231, 130, 166, 16);
		carPane.add(txtNRPV);
		
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
		
		txtMov = new JTextField();
		txtMov.setColumns(10);
		txtMov.setBounds(447, 34, 53, 16);
		carPane.add(txtMov);
		
		txtProced = new JTextField();
		txtProced.setColumns(10);
		txtProced.setBounds(447, 55, 53, 16);
		carPane.add(txtProced);
		
		txtComb = new JTextField();
		txtComb.setColumns(10);
		txtComb.setBounds(447, 80, 53, 16);
		carPane.add(txtComb);
		
		txtServicio = new JTextField();
		txtServicio.setColumns(10);
		txtServicio.setBounds(447, 105, 53, 16);
		carPane.add(txtServicio);
		
		txtUso = new JTextField();
		txtUso.setColumns(10);
		txtUso.setBounds(447, 130, 53, 16);
		carPane.add(txtUso);
		
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
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(538, 57, 24, 16);
		carPane.add(txtTipo);
		
		lblCc = new JLabel("CC");
		lblCc.setFont(new Font("Verdana", Font.PLAIN, 7));
		lblCc.setBounds(572, 59, 15, 14);
		carPane.add(lblCc);
		
		txtCC = new JTextField();
		txtCC.setColumns(10);
		txtCC.setBounds(592, 57, 24, 16);
		carPane.add(txtCC);
		
		txtCilindros = new JTextField();
		txtCilindros.setColumns(10);
		txtCilindros.setBounds(560, 82, 54, 16);
		carPane.add(txtCilindros);
		
		txtPuertas = new JTextField();
		txtPuertas.setColumns(10);
		txtPuertas.setBounds(560, 107, 56, 16);
		carPane.add(txtPuertas);
		
		txtPasaj = new JTextField();
		txtPasaj.setColumns(10);
		txtPasaj.setBounds(560, 132, 56, 16);
		carPane.add(txtPasaj);
		
		txtClase = new JTextField();
		txtClase.setColumns(10);
		txtClase.setBounds(560, 34, 56, 16);
		carPane.add(txtClase);
		
		txtPropietario.setEditable(false);
		txtLugar.setEditable(false);
		txtFolio.setEditable(false);
		txtFecha.setEditable(false);
		txtRecaudadora.setEditable(false);
		txtClave.setEditable(false);
		txtPlacas.setEditable(false);
		txtMarca.setEditable(false);
		txtLinea.setEditable(false);
		txtVersion.setEditable(false);
		txtModelo.setEditable(false);
		txtColor1.setEditable(false);
		txtColor2.setEditable(false);
		txtSerie.setEditable(false);
		txtMotor.setEditable(false);
		txtNRPV.setEditable(false);
		txtMov.setEditable(false);
		txtProced.setEditable(false);
		txtComb.setEditable(false);
		txtServicio.setEditable(false);
		txtUso.setEditable(false);
		txtTipo.setEditable(false);
		txtCC.setEditable(false);
		txtCilindros.setEditable(false);
		txtPuertas.setEditable(false);
		txtPasaj.setEditable(false);
		txtClase.setEditable(false);
		
		
	}
}


