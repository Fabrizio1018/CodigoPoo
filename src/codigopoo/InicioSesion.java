
package codigopoo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

class InicioSesion extends JFrame implements ActionListener {
    JLabel labelUsuario, labelContrasena;
    JTextField txtUsuario;
    JPasswordField txtContrasena;
    JButton btnIniciarSesion;

    InicioSesion() {
        setTitle("Inicio de Sesión");
        setSize(300, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setBackground(new Color(70, 130, 180)); 
        add(panel, BorderLayout.CENTER);

        labelUsuario = new JLabel("Usuario:");
        labelUsuario.setForeground(Color.WHITE);
        panel.add(labelUsuario);

        txtUsuario = new JTextField();
        panel.add(txtUsuario);

        labelContrasena = new JLabel("Contraseña:");
        labelContrasena.setForeground(Color.WHITE);
        panel.add(labelContrasena);

        txtContrasena = new JPasswordField();
        panel.add(txtContrasena);

        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.addActionListener(this);
        add(btnIniciarSesion, BorderLayout.SOUTH);

        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIniciarSesion) {
            String usuario = txtUsuario.getText();
            String contrasena = new String(txtContrasena.getPassword());

            if (validarCredenciales(usuario, contrasena)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
                new InventarioFormulario();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validarCredenciales(String usuario, String contrasena) {
        return usuario.equals("Grupo 8") && contrasena.equals("1234");
    }
}
