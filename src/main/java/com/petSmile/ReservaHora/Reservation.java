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

public class Reservation extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idMascota;
    private JTextField rutDueño;
    private JTextField nombreMascota;
    private JTextField hora;
    private JTextField fecha;
    
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
    public Reservation (final String name) {
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

        idMascota = new JTextField();
        idMascota.setFont(new Font("Tahoma", Font.PLAIN, 26));
        idMascota.setBounds(481, 100, 281, 45);
        contentPane.add(idMascota);
        idMascota.setColumns(10);
               
        rutDueño = new JTextField();
        rutDueño.setFont(new Font("Tahoma", Font.PLAIN, 26));
        rutDueño.setBounds(481, 150, 281, 45);
        contentPane.add(rutDueño);
        rutDueño.setColumns(10);
        
        nombreMascota = new JTextField();
        nombreMascota.setFont(new Font("Tahoma", Font.PLAIN, 26));
        nombreMascota.setBounds(481, 200, 281, 45);
        contentPane.add(nombreMascota);
        nombreMascota.setColumns(10);
        
        hora = new JTextField();
        hora.setFont(new Font("Tahoma", Font.PLAIN, 26));
        hora.setBounds(481, 250, 281, 45);
        contentPane.add(hora);
        hora.setColumns(10);
        
        fecha = new JTextField();
        fecha.setFont(new Font("Tahoma", Font.PLAIN, 26));
        fecha.setBounds(481, 250, 281, 45);
        contentPane.add(fecha);
        fecha.setColumns(10);
        
        
        JLabel lblIdMascota = new JLabel("id mascota");
        lblIdMascota.setBackground(Color.BLACK);
        lblIdMascota.setForeground(Color.BLACK);
        lblIdMascota.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblIdMascota.setBounds(250, 100, 193, 45);
        contentPane.add(lblIdMascota);

        JLabel lblRutDueño = new JLabel("rut dueño");
        lblRutDueño.setForeground(Color.BLACK);
        lblRutDueño.setBackground(Color.CYAN);
        lblRutDueño.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblRutDueño.setBounds(250, 150, 193, 45);
        contentPane.add(lblRutDueño);
        
        JLabel lblNombreMascota = new JLabel("mascota");
        lblNombreMascota.setForeground(Color.BLACK);
        lblNombreMascota.setBackground(Color.CYAN);
        lblNombreMascota.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblNombreMascota.setBounds(250, 200, 193, 45);
        contentPane.add(lblNombreMascota);
        
        JLabel lblFecha = new JLabel("fecha");
        lblFecha.setForeground(Color.BLACK);
        lblFecha.setBackground(Color.CYAN);
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblFecha.setBounds(250, 250, 193, 45);
        contentPane.add(lblFecha);
        
        JLabel lblHora = new JLabel("hora");
        lblHora.setForeground(Color.BLACK);
        lblHora.setBackground(Color.CYAN);
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblHora.setBounds(250, 250, 193, 45);
        contentPane.add(lblHora);
        
        btnNewButton = new JButton("Crear");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 450, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String idPet = idMascota.getText();
                String rutOwner = rutDueño.getText();
                String nombre = nombreMascota.getText();
                String date = fecha.getText();
                String hour = hora.getText();
                
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exaic",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("INSERT INTO `agenda`(`id`, `idMascota`, `rutDueño`, `nombreMascota`, `hora`, `fecha`) VALUES (?,?,?,?,?)");

                    st.setString(1, idPet);
                    st.setString(2, rutOwner);
                    st.setString(3, nombre);
                    st.setString(4, date);
                    st.setString(4, hour);

                    
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