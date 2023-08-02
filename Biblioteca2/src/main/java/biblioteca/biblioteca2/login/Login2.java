/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package biblioteca.biblioteca2.login;

import biblioteca.biblioteca2.biblioteca;
import biblioteca.biblioteca2.biblioteca2;
import biblioteca.biblioteca2.menuSupervisor;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author USUARIO
 */
public class Login2 extends javax.swing.JFrame {

    /**
     * Creates new form Login2
     */
    public Login2() {
        initComponents();
        salir.setVisible(false);
        //InitStyles();
   }
    
    private void InitStyles(){
        //titulo.putClientProperty( "FlatLaf.style", "font: bold $h3.regular.font" );
        //titulo.setForeground(Color.black); 
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        FlatMaterialLighterIJTheme.setup();
        
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login2().setVisible(true);
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bc = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoContra = new javax.swing.JPasswordField();
        campoNombre = new javax.swing.JTextField();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bc.setBackground(new java.awt.Color(13, 171, 161));

        jButton1.setBackground(new java.awt.Color(18, 90, 173));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Iniciar Sesion");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Contreseña");

        campoContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoContraActionPerformed(evt);
            }
        });

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(18, 90, 173));
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.setBorderPainted(false);

        javax.swing.GroupLayout bcLayout = new javax.swing.GroupLayout(bc);
        bc.setLayout(bcLayout);
        bcLayout.setHorizontalGroup(
            bcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bcLayout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addGroup(bcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bcLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addComponent(campoNombre)
                    .addGroup(bcLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addComponent(campoContra)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                .addGap(617, 617, 617))
            .addGroup(bcLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bcLayout.setVerticalGroup(
            bcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bcLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(campoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(campoContra, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(153, 153, 153)
                .addComponent(salir)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = campoNombre.getText();
        String contra = campoContra.getText();
        
        if(nombre.isEmpty()||contra.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar los campos \n","AVISO",javax.swing.JOptionPane.ERROR_MESSAGE);
            campoNombre.requestFocus();
            return;
        }
        
        if(nombre.length()<=1 ||nombre.length()>20){
            javax.swing.JOptionPane.showMessageDialog(this, "Nombre debe ser de una longitud especifica \n","AVISO",javax.swing.JOptionPane.ERROR_MESSAGE);
            campoNombre.requestFocus();
            campoNombre.setText("");
            campoContra.setText("");
            return;
        }
        
        if(contra.length()<=1 ||contra.length()>20){
            javax.swing.JOptionPane.showMessageDialog(this, "Contraseña debe ser de una longitud especifica \n","AVISO",javax.swing.JOptionPane.ERROR_MESSAGE);
            campoContra.requestFocus();
            campoNombre.setText("");
            campoContra.setText("");
                
            return;
        }
    
         try {
            DAOLoginImpl dao = new DAOLoginImpl();
            
             
            if(dao.iniciarSesionEmpleado(nombre, contra)){
                ShowJPanel(new biblioteca2());
                
            }else if(dao.iniciarSesionSupervisor(nombre, contra)){
                ShowPanelSupervisor(new menuSupervisor(nombre,contra));
                
            }else{
            campoNombre.requestFocus();
            campoNombre.setText("");
            campoContra.setText("");
            javax.swing.JOptionPane.showMessageDialog(this, "Credenciales NO validas\n","AVISO",javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoContraActionPerformed
    
    public void removeSupervisor(){
        bc.removeAll();
    }
    
    
    
    
    private void ShowPanelSupervisor(JPanel p){
        p.setSize(500, 500);
        p.setLocation(0,0);
        
        
        salir.setVisible(true);
        // [1237, 1523]
        bc.removeAll();
        bc.setLayout(new BorderLayout());
        bc.add(p, BorderLayout.CENTER);
        bc.add(salir, BorderLayout.PAGE_END);

        bc.revalidate();
        bc.repaint();
    }
    
    
    private  void ShowJPanel(JPanel p) {
        p.setSize(700, 700);
        p.setLocation(0,0);
        // [1237, 1523]
        bc.removeAll();
        bc.setLayout(new BorderLayout());
        bc.add(p, BorderLayout.CENTER);
        bc.revalidate();
        bc.repaint();
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bc;
    private javax.swing.JPasswordField campoContra;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
