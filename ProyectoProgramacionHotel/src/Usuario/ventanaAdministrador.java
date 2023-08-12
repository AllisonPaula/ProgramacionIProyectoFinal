package Usuario;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class ventanaAdministrador extends JFrame {


	private static final long serialVersionUID = 1L;
	private JTextField textFieldNom;
	private JTextField textFieldApe;
	private JTextField textFieldCorreo;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaAdministrador frame = new ventanaAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ventanaAdministrador() {
		setTitle("Hotel ABC");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagen\\IconoPrincipal.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 573);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(0, 0, 0));
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(208, 51, 976, 483);
		getContentPane().add(tabbedPane);
		
		JPanel panel_1Empleados = new JPanel();
		panel_1Empleados.setBackground(new Color(71, 169, 146));
		panel_1Empleados.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_1Empleados, null);
		panel_1Empleados.setLayout(null);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setForeground(new Color(0, 0, 0));
		lblEmpleados.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleados.setBounds(41, 11, 123, 37);
		panel_1Empleados.add(lblEmpleados);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registro de Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(31, 70, 275, 282);
		panel_1Empleados.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contraseña:");
		lblNewLabel.setBounds(10, 190, 74, 15);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(83, 56, 171, 20);
		panel.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(94, 188, 163, 20);
		panel.add(passwordField);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario:");
		lblTipoDeUsuario.setBounds(10, 152, 98, 14);
		panel.add(lblTipoDeUsuario);
		lblTipoDeUsuario.setForeground(Color.BLACK);
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox<String> comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setBounds(120, 149, 134, 22);
		panel.add(comboBoxTipo);
		comboBoxTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Corriente", "Administrador"}));
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(10, 120, 47, 14);
		panel.add(lblCorreo);
		lblCorreo.setForeground(new Color(0, 0, 0));
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(83, 118, 171, 20);
		panel.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JLabel lblApe = new JLabel("Apellido:");
		lblApe.setBounds(10, 89, 57, 14);
		panel.add(lblApe);
		lblApe.setHorizontalAlignment(SwingConstants.CENTER);
		lblApe.setForeground(Color.BLACK);
		lblApe.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textFieldApe = new JTextField();
		textFieldApe.setBounds(83, 87, 171, 20);
		panel.add(textFieldApe);
		textFieldApe.setColumns(10);
		
		JLabel lblNom = new JLabel("Nombre:");
		lblNom.setBounds(10, 58, 57, 14);
		panel.add(lblNom);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNom.setForeground(new Color(0, 0, 0));
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setForeground(Color.BLACK);
		lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSueldo.setBounds(10, 231, 74, 15);
		panel.add(lblSueldo);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(91, 229, 163, 20);
		panel.add(passwordField_1);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(new Color(122, 62, 62));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setForeground(new Color(0, 0, 0));
		btnAgregar.setBounds(31, 363, 115, 23);
		panel_1Empleados.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(122, 62, 62));
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(110, 397, 115, 23);
		panel_1Empleados.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBackground(new Color(122, 62, 62));
		btnEditar.setBounds(191, 363, 115, 23);
		panel_1Empleados.add(btnEditar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 64));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Reports");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(214, 26, 63, 22);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 192));
		tabbedPane.addTab("New tab", null, panel_3, null);
		
		JPanel panelMene = new JPanel();
		panelMene.setBackground(new Color(192, 192, 192));
		panelMene.setBounds(0, 0, 209, 534);
		getContentPane().add(panelMene);
		panelMene.setLayout(null);
		
		JLabel lblHotel = new JLabel("Hotel ABC");
		lblHotel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotel.setBounds(38, 131, 125, 25);
		panelMene.add(lblHotel);
		
		JButton btnAlgo = new JButton("Algo");
		btnAlgo.setBackground(new Color(122, 33, 33));
		btnAlgo.setBounds(54, 332, 89, 23);
		panelMene.add(btnAlgo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(122, 33, 33));
		btnSalir.setBounds(54, 369, 89, 23);
		panelMene.add(btnSalir);
	}
}
