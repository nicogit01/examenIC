package com.petSmile.ReservaHora;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Owner extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField rutField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField direccionField;
    private JTextField correoField;
    private JTextField telefonoField;
    private JTextField nombreMascotaField;
    private JButton btnNewButton;
    private JButton btnNewButton1;
    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Owner() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("crear");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);

        rutField = new JTextField();
        rutField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        rutField.setBounds(481, 100, 281, 45);
        contentPane.add(rutField);
        rutField.setColumns(10);
               
        nombreField = new JTextField();
        nombreField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        nombreField.setBounds(481, 150, 281, 45);
        contentPane.add(nombreField);
        nombreField.setColumns(10);
        
        apellidoField = new JTextField();
        apellidoField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        apellidoField.setBounds(481, 200, 281, 45);
        contentPane.add(apellidoField);
        apellidoField.setColumns(10);
        
        direccionField = new JTextField();
        direccionField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        direccionField.setBounds(481, 250, 281, 45);
        contentPane.add(direccionField);
        direccionField.setColumns(10);
        
        correoField = new JTextField();
        correoField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        correoField.setBounds(481, 300, 281, 45);
        contentPane.add(correoField);
        correoField.setColumns(10);
        
        telefonoField = new JTextField();
        telefonoField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        telefonoField.setBounds(481, 350, 281, 45);
        contentPane.add(telefonoField);
        telefonoField.setColumns(10);
        
        nombreMascotaField = new JTextField();
        nombreMascotaField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        nombreMascotaField.setBounds(481, 400, 281, 45);
        contentPane.add(nombreMascotaField);
        nombreMascotaField.setColumns(10);


        JLabel lblRut = new JLabel("Rut");
        lblRut.setBackground(Color.BLACK);
        lblRut.setForeground(Color.BLACK);
        lblRut.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblRut.setBounds(250, 100, 193, 45);
        contentPane.add(lblRut);

        JLabel lblNombre = new JLabel("nombre");
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setBackground(Color.CYAN);
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblNombre.setBounds(250, 150, 193, 45);
        contentPane.add(lblNombre);
        
        JLabel lblApellido = new JLabel("apellido");
        lblApellido.setForeground(Color.BLACK);
        lblApellido.setBackground(Color.CYAN);
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblApellido.setBounds(250, 200, 193, 45);
        contentPane.add(lblApellido);
        
        JLabel lblDireccion = new JLabel("direccion");
        lblDireccion.setForeground(Color.BLACK);
        lblDireccion.setBackground(Color.CYAN);
        lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblDireccion.setBounds(250, 250, 193, 45);
        contentPane.add(lblDireccion);
        
        JLabel lblCorreo = new JLabel("correo");
        lblCorreo.setForeground(Color.BLACK);
        lblCorreo.setBackground(Color.CYAN);
        lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblCorreo.setBounds(250, 300, 193, 45);
        contentPane.add(lblCorreo);

        JLabel lblTelefono = new JLabel("telefono");
        lblTelefono.setForeground(Color.BLACK);
        lblTelefono.setBackground(Color.CYAN);
        lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblTelefono.setBounds(250, 350, 193, 45);
        contentPane.add(lblTelefono);
        
        JLabel lblNombreMascota = new JLabel("nombre mascota");
        lblNombreMascota.setForeground(Color.BLACK);
        lblNombreMascota.setBackground(Color.CYAN);
        lblNombreMascota.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblNombreMascota.setBounds(250, 400, 193, 45);
        contentPane.add(lblNombreMascota);

        btnNewButton = new JButton("Crear");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 450, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String rut = rutField.getText();
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String direccion = direccionField.getText();
                String correo = correoField.getText();
                String telefono = telefonoField.getText();
                String mascota = nombreMascotaField.getText();
                
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exaic",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("INSERT INTO dueño (Rut, nombre, apellido, direccion, correo, telefono, nombreMascota) VALUES (?,?,?,?,?,?,?)");

                    st.setString(1, rut);
                    st.setString(2, nombre);
                    st.setString(3, apellido);
                    st.setString(4, direccion);
                    st.setString(5, correo);
                    st.setString(6, telefono);
                    st.setString(7, mascota);
                    
                    st.executeUpdate();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btnNewButton1 = new JButton("ir al login");
        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton1.setBounds(250, 450, 162, 73);
        btnNewButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		UserLogin ow = new UserLogin();
        		ow.setTitle("creacion de dueño");
        		ow.setVisible(true);
        	}
        });
        
        contentPane.add(btnNewButton);
        contentPane.add(btnNewButton1);
        
        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}
