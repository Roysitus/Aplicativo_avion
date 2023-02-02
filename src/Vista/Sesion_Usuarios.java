
package Vista;

import Controllador.Administrador;
import Controllador.Usuario;
import Controllador.Auxiliar;
import Arreglos.Lista_cuentas;
import dao_clases.administradorCAD;
import dao_clases.usuarioCAD;
import javax.swing.JOptionPane;

public class Sesion_Usuarios extends javax.swing.JFrame {
    
    Lista_cuentas lista = new Lista_cuentas();
    administradorCAD cad_administrador = new administradorCAD();
    usuarioCAD cad_usuario = new usuarioCAD();
    public Sesion_Usuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese el Usuario"));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 227, 270, 50));

        txtContraseña.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese la Contraseña"));
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 270, 50));

        btnIniciarSesion.setText("Ingresar");
        btnIniciarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 190, 60));

        btnRegistrar.setText("Registrarse");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 110, 30));

        btnVolver.setText("<-");
        btnVolver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sign in (610 × 535 px).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        String usuario = txtUsuario.getText(), contraseña = txtContraseña.getText();
        Administrador admin = cad_administrador.buscar(usuario);
        Usuario user = cad_usuario.buscar(usuario);
        if(admin == null && user == null){
            JOptionPane.showMessageDialog(null, "Cuenta erronea");
        }else{
            if(admin!=null){
                if(admin.getEstado().equals("HABILITADO")){
                    if(admin.getContraseña().equals(contraseña)){
                        admin.setIntentos(3);
                        JOptionPane.showMessageDialog(null, "Bienvenido : "+admin.getNombre() + " " + admin.getApellido());
                        Panel_reservas_avion panel_reservas_avion = new Panel_reservas_avion();
                        panel_reservas_avion.setVisible(true);
                        this.dispose();
                    }else{
                        admin.setIntentos(admin.getIntentos()-1);
                        JOptionPane.showMessageDialog(null, "Contraseña erronea intentos restantes: " + admin.getIntentos());
                        if(admin.getIntentos()==0){
                            admin.setEstado("DESABILITADO");
                            JOptionPane.showMessageDialog(null, "Su cuenta ha sido bloqueada");
                        }
                        cad_administrador.actualizar(admin);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Su cuenta se encuentra bloqueada");
                }
            }
            if(user!=null){
                if(user.getEstado().equals("HABILITADO")){
                    if(user.getContraseña().equals(contraseña)){
                        user.setIntentos(3);
                        JOptionPane.showMessageDialog(null, "Bienvenido : "+user.getNombre() + " " + user.getApellido());
                        Auxiliar aux = new Auxiliar(user);
                        Panel_reservas_avion panel_reservas_avion = new Panel_reservas_avion();
                        panel_reservas_avion.setVisible(true);
                        this.dispose();
                    }else{
                        user.setIntentos(user.getIntentos()-1);
                        JOptionPane.showMessageDialog(null, "Contraseña erronea intentos restantes: " + user.getIntentos());
                        if(user.getIntentos()==0){
                            user.setEstado("DESABILITADO");
                            JOptionPane.showMessageDialog(null, "Su cuenta ha sido bloqueada");
                        }
                        cad_usuario.actualizar(user);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Su cuenta se encuentra bloqueada");
                }
            }
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Registro_usuarios registro_usuarios = new Registro_usuarios();
        registro_usuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sesion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sesion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sesion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sesion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sesion_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
