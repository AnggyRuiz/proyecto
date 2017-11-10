/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtlMultiple;
import Controlador.CtlUnica;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Yo
 */
public class FrmBuscarPreguntas extends javax.swing.JFrame {

    /**
     * Creates new form FrmBuscarPreguntas
     */
    CtlMultiple controladorMultiple = new CtlMultiple();
    CtlUnica controladorUnica = new CtlUnica();
    String cadena = "";
    public static ArrayList<String> datos = new ArrayList<>();
    String tipo;

    //  FrmRegistrar.JTabbedPane4
    public FrmBuscarPreguntas(String tipoPregunta) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        System.out.println(this.getSize());
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Imagenes/bb.png"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        jTableBuscar.getTableHeader().setFont(new Font("Gill Sans Ultra Bold Condensed", 0, 16));
        txtPregunta.setEnabled(false);
        tipo = tipoPregunta;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPregunta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBuscar = new javax.swing.JTable();
        txtTemaBuscar = new javax.swing.JTextField();
        txtEnunciadoBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPregunta = new javax.swing.JTextArea();

        lblPregunta.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jLabel1.setText("Enunciado:");

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jLabel2.setText("Código:");

        jTableBuscar.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 14)); // NOI18N
        jTableBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "TEMA", "ENUNCIADO"
            }
        ));
        jTableBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBuscarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBuscar);

        txtTemaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemaBuscarActionPerformed(evt);
            }
        });
        txtTemaBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTemaBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTemaBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTemaBuscarKeyTyped(evt);
            }
        });

        txtEnunciadoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEnunciadoBuscarKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jLabel3.setText("Escribe el código o el enunciado de la pregunta que quieres buscar:");

        btnCancelar.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSeleccionar.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jLabel4.setText("Pregunta:");

        txtPregunta.setColumns(20);
        txtPregunta.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        txtPregunta.setRows(5);
        jScrollPane2.setViewportView(txtPregunta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEnunciadoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTemaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2)
                            .addGap(18, 18, 18)
                            .addComponent(btnSeleccionar))
                        .addComponent(jLabel3)))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTemaBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnunciadoBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnSeleccionar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTemaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemaBuscarActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtTemaBuscarActionPerformed

    private void txtTemaBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTemaBuscarKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTemaBuscarKeyPressed

    private void txtTemaBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTemaBuscarKeyTyped

    }//GEN-LAST:event_txtTemaBuscarKeyTyped

    private void txtTemaBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTemaBuscarKeyReleased
        ArrayList<String> buscar = new ArrayList<>();
        if (tipo.equals("Unica")) {
            buscar = controladorUnica.solicitudBuscarFiltrado(txtTemaBuscar.getText(), "tema_idtema");
        } else if (tipo.equals("Multiple")) {
            buscar = controladorMultiple.solicitudBuscarFiltrado(txtTemaBuscar.getText(), "tema_idtema");
        }
        listar(buscar);
    }//GEN-LAST:event_txtTemaBuscarKeyReleased

    private void txtEnunciadoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnunciadoBuscarKeyReleased
        ArrayList<String> buscar = new ArrayList<>();
        buscar = controladorMultiple.solicitudBuscarFiltrado(txtEnunciadoBuscar.getText(), "enunciado");
        buscar = controladorUnica.solicitudBuscarFiltrado(txtEnunciadoBuscar.getText(), "enunciado");

        listar(buscar);
    }//GEN-LAST:event_txtEnunciadoBuscarKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        new FrmRegistrar().setVisible(true);
        //  JTabbedPane4;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        String pregunta;
        pregunta = txtPregunta.getText();
        datos = controladorUnica.solicitudPreguntas(pregunta);
        System.out.println(datos);
        dispose();
        new FrmRegistrar().setVisible(true);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void jTableBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBuscarMouseClicked
        txtPregunta.setText(jTableBuscar.getValueAt(jTableBuscar.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_jTableBuscarMouseClicked

    private void listar(ArrayList<String> buscar) {
        jTableBuscar.setModel(controladorMultiple.listarM(buscar));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBuscar;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JTextField txtEnunciadoBuscar;
    private javax.swing.JTextArea txtPregunta;
    private javax.swing.JTextField txtTemaBuscar;
    // End of variables declaration//GEN-END:variables
}
