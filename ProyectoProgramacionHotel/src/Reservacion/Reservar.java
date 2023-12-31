package Reservacion;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Evento.GestionEventosApp;
import Usuario.LoginWindow;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;

public class Reservar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelCliente, panelMenu, panelFecha, panelInfoReserva, panelPago;
	private JTextField fieldNombre, fieldTelefono, fieldApellido, textFieldNumTarjeta, fieldEmail;
	private JDateChooser dateChooserCheckIn, dateChooserCheckOut;
	private JMenuBar menuBarBotones ;
	private JComboBox<String>comboBoxAñoVenci, comboBoxNiños,comboBoxMesVenci,comboBoxPreferencias, 
	comboBoxAdultos, comboBoxTipoHabitacion;
	private JButton btnCancelar,btnEventos,btnSal, btneventos, btnSalir, reserveButton ;
    private JLabel lblVisa,lblReservacion,lblMasCard, nameLabel,lblAdulto,lblFechaDeVencimiento , 
    lblEmail,  lblNmeroDeTarjeta ,lblTelfono, lblNombre, lblApellido,lblPreferenciasEspeciales, lblHotel,
    lblCheckIn, lblCheckOut, lblCantidadDePersonas, lblNios, lblTipoDeHabitacin ;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservar frame = new Reservar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Reservar() {
		setTitle("Hotel ABC");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagen\\IconoPrincipal.png"));
		setBounds(100, 100, 919, 669);
		
		menuBarBotones = new JMenuBar();
		menuBarBotones.setBackground(new Color(72, 33, 33));
		setJMenuBar(menuBarBotones);
		
		btnEventos = new JButton("");
		btnEventos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
		        dispose(); // Cierra la ventana actual
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		            	GestionEventosApp frame = new GestionEventosApp();
						frame.setVisible(true);
		            }
		        });
		    }
		});
		btnEventos.setBackground(new Color(122, 62, 62));
		btnEventos.setIcon(new ImageIcon("Imagen\\eventos.png"));
		menuBarBotones.add(btnEventos);
		
		btnSal = new JButton("");
		btnSal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
		        dispose(); // Cierra la ventana actual
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		            	LoginWindow window = new LoginWindow();
						window.frmHotel.setVisible(true);
		            }
		        });
		    }
		});
		btnSal.setBackground(new Color(122, 62, 62));
		btnSal.setIcon(new ImageIcon("Imagen\\Salir.png"));
		menuBarBotones.add(btnSal);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(71, 169, 146));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		panelCliente = new JPanel();
		panelCliente.setForeground(new Color(72, 33, 33));
		panelCliente.setBackground(new Color(122, 62, 62));
		panelCliente.setBorder(new LineBorder(new Color(72, 33, 33), 0, true));
		panelCliente.setBounds(286, 111, 373, 164);

		nameLabel = new JLabel("Nombre:");
		nameLabel.setBounds(0, 32, 166, -9);
		fieldNombre = new JTextField(20);
		fieldNombre.setFont(new Font("Arial", Font.BOLD, 11));
		fieldNombre.setBounds(76, 25, 226, 23);
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 89, 43, 23);
		fieldEmail = new JTextField(20);
		fieldEmail.setFont(new Font("Arial", Font.BOLD, 11));
		fieldEmail.setBounds(76, 90, 226, 23);
		contentPane.setLayout(null);
		panelCliente.setLayout(null);

		panelCliente.add(nameLabel);
		panelCliente.add(fieldNombre);
		panelCliente.add(lblEmail);
		panelCliente.add(fieldEmail);
		lblTelfono = new JLabel();
		lblTelfono.setForeground(new Color(255, 255, 255));
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelfono.setText("Teléfono:");
		lblTelfono.setBounds(10, 124, 58, 23);
		panelCliente.add(lblTelfono);

		contentPane.add(panelCliente);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBackground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 24, 58, 23);
		panelCliente.add(lblNombre);
		
		fieldTelefono = new JTextField(20);
		fieldTelefono.setFont(new Font("Arial", Font.BOLD, 11));
		fieldTelefono.setBounds(76, 125, 226, 23);
		panelCliente.add(fieldTelefono);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(10, 59, 58, 23);
		panelCliente.add(lblApellido);
		
		fieldApellido = new JTextField(20);
		fieldApellido.setFont(new Font("Arial", Font.BOLD, 11));
		fieldApellido.setBounds(76, 56, 226, 23);
		panelCliente.add(fieldApellido);
		
		JLabel lblInfoHuesped = new JLabel("Información Huésped");
		lblInfoHuesped.setForeground(new Color(0, 0, 0));
		lblInfoHuesped.setBounds(10, 7, 142, 14);
		panelCliente.add(lblInfoHuesped);
		lblInfoHuesped.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(72, 33, 33));
		panelMenu.setBounds(0, 0, 228, 595);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		lblHotel = new JLabel("Hotel ABC");
		lblHotel.setForeground(new Color(238, 238, 238));
		lblHotel.setBackground(new Color(240, 240, 240));
		lblHotel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotel.setBounds(52, 128, 128, 31);
		panelMenu.add(lblHotel);
		
		btneventos = new JButton("       Eventos");
		btneventos.setForeground(new Color(255, 255, 255));
		btneventos.setBackground(new Color(122, 62, 62));
		btneventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose(); // Cierra la ventana actual
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		            	GestionEventosApp frame = new GestionEventosApp();
						frame.setVisible(true);
		            }
		        });
		    }
		});
		btneventos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btneventos.setIcon(new ImageIcon("Imagen\\eventos.png"));
		btneventos.setBounds(40, 374, 151, 31);
		panelMenu.add(btneventos);
		
		btnSalir = new JButton("Cerrar Sección");
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(122, 62, 62));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose(); // Cierra la ventana actual
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		            	LoginWindow window = new LoginWindow();
						window.frmHotel.setVisible(true);
		            }
		        });
		    }
		});		
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setIcon(new ImageIcon("Imagen//Salir.png"));
		btnSalir.setBounds(40, 416, 151, 31);
		panelMenu.add(btnSalir);
		
		panelFecha = new JPanel();
		panelFecha.setForeground(new Color(255, 255, 255));
		panelFecha.setBorder(new LineBorder(new Color(72, 33, 33), 0, true));
		panelFecha.setBackground(new Color(122, 62, 62));
		panelFecha.setBounds(669, 221, 193, 138);
		contentPane.add(panelFecha);
				panelFecha.setLayout(null);
				
						lblCheckIn = new JLabel("Check-In:");
						lblCheckIn.setBounds(20, 21, 60, 23);
						panelFecha.add(lblCheckIn);
						lblCheckIn.setForeground(new Color(255, 255, 255));
						lblCheckIn.setFont(new Font("Tahoma", Font.BOLD, 12));
						dateChooserCheckIn = new JDateChooser();
						dateChooserCheckIn.setBounds(20, 41, 156, 23);
						panelFecha.add(dateChooserCheckIn);
						lblCheckOut = new JLabel("Check-Out:");
						lblCheckOut.setBounds(20, 75, 70, 23);
						panelFecha.add(lblCheckOut);
						lblCheckOut.setFont(new Font("Tahoma", Font.BOLD, 12));
						lblCheckOut.setForeground(new Color(255, 255, 255));
						dateChooserCheckOut = new JDateChooser();
						dateChooserCheckOut.setBounds(20, 97, 156, 23);
						panelFecha.add(dateChooserCheckOut);
						
						JLabel lblFecha = new JLabel("Fecha");
						lblFecha.setForeground(new Color(0, 0, 0));
						lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
						lblFecha.setBounds(20, 11, 52, 14);
						panelFecha.add(lblFecha);
						
								reserveButton = new JButton("Reservar");
								reserveButton.setForeground(new Color(255, 255, 255));
								reserveButton.setBackground(new Color(72, 33, 33));
								reserveButton.setFont(new Font("Tahoma", Font.BOLD, 11));
								reserveButton.setBounds(722, 429, 107, 36);
								contentPane.add(reserveButton);
								
								panelInfoReserva = new JPanel();
								panelInfoReserva.setBackground(new Color(122, 62, 62));
								panelInfoReserva.setBorder(new LineBorder(new Color(72, 33, 33), 0, true));
								panelInfoReserva.setBounds(286, 291, 373, 138);
								contentPane.add(panelInfoReserva);
								panelInfoReserva.setLayout(null);
								
								lblCantidadDePersonas = new JLabel("Cantidad de Personas:");
								lblCantidadDePersonas.setBounds(10, 33, 137, 23);
								panelInfoReserva.add(lblCantidadDePersonas);
								lblCantidadDePersonas.setForeground(new Color(255, 255, 255));
								lblCantidadDePersonas.setFont(new Font("Tahoma", Font.BOLD, 12));
								
								lblNios = new JLabel("Niños:");
								lblNios.setBounds(157, 34, 39, 23);
								panelInfoReserva.add(lblNios);
								lblNios.setForeground(new Color(255, 255, 255));
								lblNios.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
								
								comboBoxNiños = new JComboBox<String>();
								comboBoxNiños.setFont(new Font("Arial", Font.BOLD, 11));
								comboBoxNiños.setBounds(195, 34, 48, 22);
								panelInfoReserva.add(comboBoxNiños);
								comboBoxNiños.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
								
								lblAdulto = new JLabel("Adultos:");
								lblAdulto.setBounds(258, 34, 48, 23);
								panelInfoReserva.add(lblAdulto);
								lblAdulto.setForeground(new Color(255, 255, 255));
								lblAdulto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
								
								comboBoxAdultos = new JComboBox<String>();
								comboBoxAdultos.setFont(new Font("Arial", Font.BOLD, 11));
								comboBoxAdultos.setBounds(310, 34, 48, 22);
								panelInfoReserva.add(comboBoxAdultos);
								comboBoxAdultos.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
								
								lblTipoDeHabitacin = new JLabel("Tipo de Habitación:");
								lblTipoDeHabitacin.setForeground(new Color(255, 255, 255));
								lblTipoDeHabitacin.setFont(new Font("Tahoma", Font.BOLD, 12));
								lblTipoDeHabitacin.setBounds(10, 68, 128, 23);
								panelInfoReserva.add(lblTipoDeHabitacin);
								
								comboBoxTipoHabitacion = new JComboBox<String>();
								comboBoxTipoHabitacion.setFont(new Font("Arial", Font.BOLD, 11));
								comboBoxTipoHabitacion.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Individual", "Doble", "Suite", "Familiar"}));
								comboBoxTipoHabitacion.setBounds(135, 69, 142, 22);
								panelInfoReserva.add(comboBoxTipoHabitacion);
								
								lblPreferenciasEspeciales = new JLabel("Preferencias Especiales\r\n:");
								lblPreferenciasEspeciales.setForeground(new Color(255, 255, 255));
								lblPreferenciasEspeciales.setFont(new Font("Tahoma", Font.BOLD, 12));
								lblPreferenciasEspeciales.setBounds(10, 102, 151, 23);
								panelInfoReserva.add(lblPreferenciasEspeciales);
								
								comboBoxPreferencias = new JComboBox<String>();
								comboBoxPreferencias.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Vista al mar", "Piso Alto", "Cama King"}));
								comboBoxPreferencias.setFont(new Font("Arial", Font.BOLD, 11));
								comboBoxPreferencias.setBounds(157, 102, 142, 22);
								panelInfoReserva.add(comboBoxPreferencias);
								
								JLabel lblInfoReserva = new JLabel("Información Habitación");
								lblInfoReserva.setForeground(new Color(0, 0, 0));
								lblInfoReserva.setFont(new Font("Tahoma", Font.BOLD, 12));
								lblInfoReserva.setBounds(10, 8, 151, 14);
								panelInfoReserva.add(lblInfoReserva);
								
								panelPago = new JPanel();
								panelPago.setBackground(new Color(122, 62, 62));
								panelPago.setBorder(new LineBorder(new Color(72, 33, 33), 0, true));
								panelPago.setBounds(286, 451, 373, 111);
								contentPane.add(panelPago);
								panelPago.setLayout(null);
								
								lblNmeroDeTarjeta = new JLabel("Número de Tarjeta:");
								lblNmeroDeTarjeta.setBounds(19, 31, 127, 15);
								lblNmeroDeTarjeta.setForeground(new Color(255, 255, 255));
								lblNmeroDeTarjeta.setFont(new Font("Tahoma", Font.BOLD, 12));
								panelPago.add(lblNmeroDeTarjeta);
								
								textFieldNumTarjeta = new JTextField(20);
								textFieldNumTarjeta.setText("1234 5678 9012 3456");
								textFieldNumTarjeta.setFont(new Font("Arial", Font.BOLD, 11));
								textFieldNumTarjeta.setBounds(141, 28, 127, 23);
								panelPago.add(textFieldNumTarjeta);
								
								lblFechaDeVencimiento = new JLabel("Fecha de Vencimiento:");
								lblFechaDeVencimiento.setForeground(new Color(255, 255, 255));
								lblFechaDeVencimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
								lblFechaDeVencimiento.setBounds(19, 73, 136, 15);
								panelPago.add(lblFechaDeVencimiento);
								
								comboBoxMesVenci = new JComboBox<String>();
								comboBoxMesVenci.setFont(new Font("Arial", Font.BOLD, 11));
								comboBoxMesVenci.setModel(new DefaultComboBoxModel<String>(new String[] {"Mes", "01-Enero", "02-Febrero", "03-Marzo", "04-Abril", "05-Mayo", "06-Junio", "07-Julio", "08-Agosto", "09-Septiembre", "10-Octubre", "11-Noviembre", "12-Diciembre"}));
								comboBoxMesVenci.setBounds(166, 70, 102, 22);
								panelPago.add(comboBoxMesVenci);
								
								comboBoxAñoVenci = new JComboBox<String>();
								comboBoxAñoVenci.setFont(new Font("Arial", Font.BOLD, 11));
								comboBoxAñoVenci.setModel(new DefaultComboBoxModel<String>(new String[] {"Año", "23", "24", "25", "26", "27", "28", "29", "30"}));
								comboBoxAñoVenci.setBounds(281, 70, 56, 22);
								panelPago.add(comboBoxAñoVenci);
								
								lblVisa = new JLabel("");
								lblVisa.setIcon(new ImageIcon("Imagen\\visaT.png"));
								lblVisa.setBounds(271, 28, 46, 23);
								panelPago.add(lblVisa);
								
								lblMasCard = new JLabel("");
								lblMasCard.setIcon(new ImageIcon("Imagen\\Master.png"));
								lblMasCard.setBounds(317, 28, 46, 23);
								panelPago.add(lblMasCard);
								
								JLabel lblInformacinPago = new JLabel("Pago");
								lblInformacinPago.setForeground(new Color(0, 0, 0));
								lblInformacinPago.setFont(new Font("Tahoma", Font.BOLD, 12));
								lblInformacinPago.setBounds(10, 6, 151, 14);
								panelPago.add(lblInformacinPago);
								
								lblReservacion = new JLabel("Reservación");
								lblReservacion.setForeground(new Color(0, 0, 0));
								lblReservacion.setFont(new Font("Tahoma", Font.BOLD, 20));
								lblReservacion.setHorizontalAlignment(SwingConstants.CENTER);
								lblReservacion.setBounds(489, 46, 135, 36);
								contentPane.add(lblReservacion);
								
								btnCancelar = new JButton("Cancelar");
								btnCancelar.setForeground(new Color(255, 255, 255));
								btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
								btnCancelar.setBackground(new Color(72, 33, 33));
								btnCancelar.setBounds(722, 476, 107, 36);
								contentPane.add(btnCancelar);
								//Conectar con la base de Datos
								reserveButton.addActionListener(new ActionListener() {
								    @Override
								    public void actionPerformed(ActionEvent e) {
								        String name = fieldNombre.getText();
								        String lastName = fieldApellido.getText();
								        String email = fieldEmail.getText();
								        String phone = fieldTelefono.getText();
								        java.util.Date checkInDate = dateChooserCheckIn.getDate();
								        java.util.Date checkOutDate = dateChooserCheckOut.getDate();
								        int cantidadAdultos = Integer.parseInt(comboBoxAdultos.getSelectedItem().toString());
								        int cantidadNinos = Integer.parseInt(comboBoxNiños.getSelectedItem().toString());
								        String tipoHabitacion = comboBoxTipoHabitacion.getSelectedItem().toString();
								        String preferenciasEspeciales = comboBoxPreferencias.getSelectedItem().toString();

								        try {
								        	DatabaseConnection dbConnection = DatabaseConnection.getInstance1();
								            Connection connection = dbConnection.getConnection();
								            Statement statement = connection.createStatement();


								            // Insertar datos en la tabla Huesped
								            String insertHuespedQuery = "INSERT INTO Huesped (Nombre, Apellido, Email, Telefono) VALUES (?, ?, ?, ?)";
								            PreparedStatement insertHuespedStatement = connection.prepareStatement(insertHuespedQuery);
								            insertHuespedStatement.setString(1, name);
								            insertHuespedStatement.setString(2, lastName);
								            insertHuespedStatement.setString(3, email);
								            insertHuespedStatement.setString(4, phone);
								            insertHuespedStatement.executeUpdate();
								            insertHuespedStatement.close();

								            // Obtener el ID del huésped recién insertado
								            int huespedID = -1;
								            String getLastInsertIdQuery = "SELECT LAST_INSERT_ID()";
								            PreparedStatement getLastInsertIdStatement = connection.prepareStatement(getLastInsertIdQuery);
								            ResultSet lastInsertIdResult = getLastInsertIdStatement.executeQuery();
								            if (lastInsertIdResult.next()) {
								                huespedID = lastInsertIdResult.getInt(1);
								            }
								            getLastInsertIdStatement.close();

								            // Insertar datos en la tabla Reserva
								            String insertReservaQuery = "INSERT INTO Reserva (HuespedID, CantidadAdultos, CantidadNinos, TipoHabitacion, PreferenciasEspeciales, CheckIn, CheckOut) VALUES (?, ?, ?, ?, ?, ?, ?)";
								            PreparedStatement insertReservaStatement = connection.prepareStatement(insertReservaQuery);
								            insertReservaStatement.setInt(1, huespedID);
								            insertReservaStatement.setInt(2, cantidadAdultos);
								            insertReservaStatement.setInt(3, cantidadNinos);
								            insertReservaStatement.setString(4, tipoHabitacion);
								            insertReservaStatement.setString(5, preferenciasEspeciales);
								            insertReservaStatement.setDate(6, new java.sql.Date(checkInDate.getTime()));
								            insertReservaStatement.setDate(7, new java.sql.Date(checkOutDate.getTime()));
								            insertReservaStatement.executeUpdate();
								            insertReservaStatement.close();
								            
								         // Obtener el ID de la reserva recién insertada
								            int reservaID = -1;
								            String getLastInsertIdReservaQuery = "SELECT LAST_INSERT_ID()";
								            PreparedStatement getLastInsertIdReservaStatement = connection.prepareStatement(getLastInsertIdReservaQuery);
								            ResultSet lastInsertIdReservaResult = getLastInsertIdReservaStatement.executeQuery();
								            if (lastInsertIdReservaResult.next()) {
								                reservaID = lastInsertIdReservaResult.getInt(1);
								            }
								            getLastInsertIdReservaStatement.close();

								            // Insertar datos en la tabla Pago
								            String insertPagoQuery = "INSERT INTO Pago (ReservaID, NumeroTarjeta, MesVencimiento, AnioVencimiento) VALUES (?, ?, ?, ?)";
								            PreparedStatement insertPagoStatement = connection.prepareStatement(insertPagoQuery);
								            insertPagoStatement.setInt(1, reservaID);
								            insertPagoStatement.setString(2, textFieldNumTarjeta.getText());
								            insertPagoStatement.setString(3, comboBoxMesVenci.getSelectedItem().toString());
								            insertPagoStatement.setString(4, comboBoxAñoVenci.getSelectedItem().toString());
								            insertPagoStatement.executeUpdate();
								            insertPagoStatement.close();

								            statement.close();
								            connection.close();

								            JOptionPane.showMessageDialog(contentPane,
								                    "Reserva realizada para:\nNombre: " + name + "\nEmail: " + email + "\nFecha de ingreso: "
								                            + checkInDate + "\nFecha de salida: " + checkOutDate);
								        } catch (SQLException ex) {
								            ex.printStackTrace();
								            JOptionPane.showMessageDialog(contentPane, "Error al realizar la reserva. Por favor, inténtelo nuevamente.");
								        }
								    }
								});

	}
}