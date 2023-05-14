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

public class Patient extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField rutField;
    private JTextField nombreField;
    private JTextField tipoField;
    private JTextField edadField;
    private JButton btnNewButton;
    private JButton btnNewButton1;
    private JLabel label;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Patient(final String name) {
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
        
        tipoField = new JTextField();
        tipoField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        tipoField.setBounds(481, 200, 281, 45);
        contentPane.add(tipoField);
        tipoField.setColumns(10);
        
        edadField = new JTextField();
        edadField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        edadField.setBounds(481, 250, 281, 45);
        contentPane.add(edadField);
        edadField.setColumns(10);
        
        
        JLabel lblRut = new JLabel("Rut dueño");
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
        
        JLabel lblTipo = new JLabel("tipo");
        lblTipo.setForeground(Color.BLACK);
        lblTipo.setBackground(Color.CYAN);
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblTipo.setBounds(250, 200, 193, 45);
        contentPane.add(lblTipo);
        
        JLabel lblEdad = new JLabel("edad");
        lblEdad.setForeground(Color.BLACK);
        lblEdad.setBackground(Color.CYAN);
        lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblEdad.setBounds(250, 250, 193, 45);
        contentPane.add(lblEdad);
        
        btnNewButton = new JButton("Crear");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 450, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String rut = rutField.getText();
                String nombre = nombreField.getText();
                String tipo = tipoField.getText();
                String edad = edadField.getText();
                
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exaic",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("INSERT INTO `mascota`(`rutDueño`, `tipoMascota`, `edad`, `nombreMascota`) VALUES (?,?,?,?)");

                    st.setString(1, rut);
                    st.setString(2, tipo);
                    st.setString(3, edad);
                    st.setString(4, nombre);
                    st.setString(5, nombre);

                    
                    st.executeUpdate();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btnNewButton1 = new JButton("ir al home");
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
