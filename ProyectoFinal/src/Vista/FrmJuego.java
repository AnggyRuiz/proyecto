/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtlMultiple;
import Controlador.CtlPartida;
import Controlador.CtlRespuestaMultiple;
import Controlador.CtlRespuestaUnica;
import Controlador.CtlResultado;
import Controlador.CtlUnica;
import Modelo.Partida;
import Modelo.RespuestaMultiple;
import Modelo.RespuestaUnica;
import Modelo.Resultado;
import static Vista.FrmIngresarJuego.idUsu;
import static Vista.FrmInicioJuego.idj;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gabriela Machado
 */
public class FrmJuego extends javax.swing.JFrame {

    /**
     * Creates new form FrmJuego
     */
    CtlUnica controladorUnica = new CtlUnica();
    CtlMultiple controladorMultiple = new CtlMultiple();
    CtlRespuestaUnica controladorRespuestaUnica = new CtlRespuestaUnica();
    CtlRespuestaMultiple controladorRespuestaMultiple = new CtlRespuestaMultiple();
    CtlResultado controladorResultado;
    CtlPartida controladorPartida;
    ArrayList<JPanel> paneles;
    int cont = 0;
    ArrayList<Integer> cargarTodo = new ArrayList<Integer>();
    ArrayList<RespuestaUnica> respuestaU = new ArrayList<>();
    ArrayList<RespuestaMultiple> respuestaM = new ArrayList<>();
    ArrayList<String> pregunta = null;
    ArrayList<Integer> resU;
    ArrayList<Integer> resM;

    public FrmJuego() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        System.out.println(this.getSize());
//        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Imagenes/12.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        paneles = new ArrayList<JPanel>();
        buttonGroup1.add(rdb1);
        buttonGroup1.add(rdb2);
        buttonGroup1.add(rdb3);
        buttonGroup1.add(rdb4);
        controladorResultado = new CtlResultado();
        controladorPartida = new CtlPartida();
        ArrayList<Integer> cargarU = controladorUnica.solicitudCargarPreguntas();
        System.out.println(cargarU);
        ArrayList<Integer> cargarM = controladorMultiple.solicitudCargarPreguntas();
        System.out.println(cargarM);
        for (int i = 0; i < cargarU.size(); i++) {
            cargarTodo.add(cargarU.get(i));
            cargarTodo.add(cargarM.get(i));
        }
        System.out.println(cargarTodo);
        cargarPreguntas(cargarTodo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        btnTerminarJuego = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblEnunciado = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        rdb1 = new javax.swing.JRadioButton();
        rdb3 = new javax.swing.JRadioButton();
        rdb4 = new javax.swing.JRadioButton();
        rdb2 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        btnSiguiente1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTerminarJuego.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        btnTerminarJuego.setText("Terminar");
        btnTerminarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarJuegoActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pregunta.gif"))); // NOI18N

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel11.setOpaque(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jLabel2.setText("Pregunta: ");

        lblEnunciado.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        lblEnunciado.setText("Enunciado");

        lbl1.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        lbl1.setText("Opción 1");

        lbl2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        lbl2.setText("Opción 2");

        lbl3.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        lbl3.setText("Opción 3");

        lbl4.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        lbl4.setText("Opción 4");

        rdb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb2ActionPerformed(evt);
            }
        });

        btnSiguiente1.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        btnSiguiente1.setText("siguiente");
        btnSiguiente1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnSiguiente1ItemStateChanged(evt);
            }
        });
        btnSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEnunciado, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdb1)
                                    .addComponent(rdb2)
                                    .addComponent(rdb3)
                                    .addComponent(rdb4))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox4)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                                    .addComponent(lbl3)
                                    .addComponent(lbl4, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)))
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSiguiente1)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblEnunciado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdb4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl1)
                                            .addComponent(rdb1)
                                            .addComponent(jCheckBox1))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(rdb2))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(rdb3))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente1)
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("ANSWER ME", jPanel1);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnTerminarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTerminarJuego)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente1ActionPerformed

        int n = 0;
        boolean a, b, c, d;
        String enunciado = lblEnunciado.getText();
        String respuesta = null, correctaU, correctaM;
        int idRespuesta, idUsuario, idPreguntaU, idPreguntaM, idJuego;
        idUsuario = idUsu;
        idJuego = idj;
        String esta = "";

        if (pregunta.get(8).equals("1")) {
            idPreguntaU = Integer.parseInt(controladorUnica.solicitudBuscarId(enunciado));
            correctaU = controladorUnica.solicitudBuscarCorrecta(idPreguntaU);
            resU = controladorRespuestaUnica.solicitarBuscarIdu();
            idRespuesta = resU.get(0) + 1;
            RespuestaUnica respuest = new RespuestaUnica(idRespuesta, idUsuario, idPreguntaU, idJuego, respuesta, correctaU);

            a = rdb1.isSelected();
            b = rdb2.isSelected();
            c = rdb3.isSelected();
            d = rdb4.isSelected();
            if (a) {
                respuesta = "1";
                respuest.setRespuesta(respuesta);
                controladorRespuestaUnica.SolicitudGuardar(respuest);
                respuestaU.add(respuest);
            } else if (b) {
                respuesta = "2";
                respuest.setRespuesta(respuesta);
                controladorRespuestaUnica.SolicitudGuardar(respuest);
                respuestaU.add(respuest);
            } else if (c) {
                respuesta = "3";
                respuest.setRespuesta(respuesta);
                controladorRespuestaUnica.SolicitudGuardar(respuest);
                respuestaU.add(respuest);
            } else if (d) {
                respuesta = "4";
                respuest.setRespuesta(respuesta);
                controladorRespuestaUnica.SolicitudGuardar(respuest);
                respuestaU.add(respuest);
            }
            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
        } else if (pregunta.get(8).equals("2")) {
            idPreguntaM = Integer.parseInt(controladorMultiple.solicitudBuscarId(enunciado));
            correctaM = controladorMultiple.solicitudBuscarCorrecta(idPreguntaM);
            System.out.println("res es= " + correctaM);
            resM = controladorRespuestaMultiple.solicitarBuscarIdu();
            idRespuesta = resM.get(0) + 1;
            RespuestaMultiple respuestM = new RespuestaMultiple(idRespuesta, idUsuario, idPreguntaM, idJuego, respuesta, correctaM);
            a = jCheckBox1.isSelected();
            b = jCheckBox2.isSelected();
            c = jCheckBox3.isSelected();
            d = jCheckBox4.isSelected();
            if (a) {
                if (b) {
                    if (c) {
                        if (d) {
                            esta = "1;2;3;4";
                        } else {
                            esta = "1;2;3";
                        }
                    } else if (d) {
                        esta = "1;2;4";
                    } else {
                        esta = "1;2";
                    }
                } else if (c) {
                    if (d) {
                        esta = "1;3;4";
                    } else {
                        esta = "1;3";
                    }
                } else if (d) {
                    esta = "1;4";
                }
            } else if (b) {
                if (c) {
                    if (d) {
                        esta = "2;3;4";
                    } else {
                        esta = "2;3";
                    }
                } else if (d) {
                    esta = "2;4";
                } else {
                    System.out.println("maluco");
                }
            } else if (c) {
                if (d) {
                    esta = "3;4";
                } else {
                    System.out.println("maluco");
                }
            } else if (d) {
                System.out.println("maluco");
            } else {
                System.out.println("omaigaaaaa");
            }

            if (a) {
                respuesta = esta;
                respuestM.setRespuesta(respuesta);
                controladorRespuestaMultiple.SolicitudGuardar(respuestM);
                respuestaM.add(respuestM);
            } else if (b) {
                respuesta = esta;
                respuestM.setRespuesta(respuesta);
                controladorRespuestaMultiple.SolicitudGuardar(respuestM);
                respuestaM.add(respuestM);
            } else if (c) {
                respuesta = esta;
                respuestM.setRespuesta(respuesta);
                controladorRespuestaMultiple.SolicitudGuardar(respuestM);
                respuestaM.add(respuestM);
            } else if (d) {
                respuesta = esta;
                respuestM.setRespuesta(respuesta);
                controladorRespuestaMultiple.SolicitudGuardar(respuestM);
                respuestaM.add(respuestM);
            }
        }
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        cargarPreguntas(cargarTodo);

    }//GEN-LAST:event_btnSiguiente1ActionPerformed

    private void btnSiguiente1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnSiguiente1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguiente1ItemStateChanged

    private void rdb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb2ActionPerformed

    private void btnTerminarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarJuegoActionPerformed

        String campo1 = controladorRespuestaUnica.solicitudRespuestas(respuestaU.get(0).getIdRespuesta() + "");
        String campo2 = controladorRespuestaMultiple.solicitudRespuestas(respuestaM.get(0).getIdRespuesta() + "");
        String campo3 = controladorRespuestaUnica.solicitudRespuestas(respuestaU.get(1).getIdRespuesta() + "");
        String campo4 = controladorRespuestaMultiple.solicitudRespuestas(respuestaM.get(1).getIdRespuesta() + "");
        String campo5 = controladorRespuestaUnica.solicitudRespuestas(respuestaU.get(2).getIdRespuesta() + "");
        String campo6 = controladorRespuestaMultiple.solicitudRespuestas(respuestaM.get(2).getIdRespuesta() + "");
        String campo7 = controladorRespuestaUnica.solicitudRespuestas(respuestaU.get(3).getIdRespuesta() + "");
        String campo8 = controladorRespuestaMultiple.solicitudRespuestas(respuestaM.get(3).getIdRespuesta() + "");
        String campo9 = controladorRespuestaUnica.solicitudRespuestas(respuestaU.get(4).getIdRespuesta() + "");
        String campo10 = controladorRespuestaMultiple.solicitudRespuestas(respuestaM.get(4).getIdRespuesta() + "");
        Resultado resultado = new Resultado(0, idj, idUsu, campo1, campo2, campo3, campo4, campo5,
                campo6, campo7, campo8, campo9, campo10);

        controladorResultado.solicitudGuardarR(resultado);
        int buscarId = Integer.parseInt(controladorResultado.buscaValor(idj));

        Partida partida = new Partida(0, buscarId, respuestaU.get(0).getIdRespuesta() + "", respuestaM.get(0).getIdRespuesta() + "",
                respuestaU.get(1).getIdRespuesta() + "", respuestaM.get(1).getIdRespuesta() + "",
                respuestaU.get(2).getIdRespuesta() + "", respuestaM.get(2).getIdRespuesta() + "",
                respuestaU.get(3).getIdRespuesta() + "", respuestaM.get(3).getIdRespuesta() + "",
                respuestaU.get(4).getIdRespuesta() + "", respuestaM.get(4).getIdRespuesta() + "");

        controladorPartida.solicitudGuardar(partida);
        System.out.println(partida.getIdPartida());
        System.out.println(partida.getIdResultado());
        System.out.println(partida.getPregunta1());
        System.out.println(partida.getPregunta2());
        System.out.println(partida.getPregunta3());
        System.out.println(partida.getPregunta4());
        System.out.println(partida.getPregunta5());
        System.out.println(partida.getPregunta6());
        System.out.println(partida.getPregunta7());
        System.out.println(partida.getPregunta8());
        System.out.println(partida.getPregunta9());
        System.out.println(partida.getPregunta10());


    }//GEN-LAST:event_btnTerminarJuegoActionPerformed

    /**
     * @param args the command line arguments
     */
    public void cargarPreguntas(ArrayList<Integer> cargarT) {
        System.out.println("entra");
        if (cont < 10) {
            int calc = cont % 2;

            if (calc == 0) {
                pregunta = controladorUnica.SolicitudBuscarU(cargarT.get(cont));
            } else {
                pregunta = controladorMultiple.SolicitudBuscarM(cargarT.get(cont));

            }
            cont++;
            if (pregunta.get(8).equals("1")) {
                System.out.println("aca es unica");
                jCheckBox1.setVisible(false);
                jCheckBox2.setVisible(false);
                jCheckBox3.setVisible(false);
                jCheckBox4.setVisible(false);
                rdb1.setVisible(true);
                rdb2.setVisible(true);
                rdb3.setVisible(true);
                rdb4.setVisible(true);
                lblEnunciado.setText(pregunta.get(6));
                lbl1.setText(pregunta.get(1));
                lbl2.setText(pregunta.get(2));
                lbl3.setText(pregunta.get(3));
                lbl4.setText(pregunta.get(4));

            } else if (pregunta.get(8).equals("2")) {
                jCheckBox1.setVisible(true);
                jCheckBox2.setVisible(true);
                jCheckBox3.setVisible(true);
                jCheckBox4.setVisible(true);
                rdb1.setVisible(false);
                rdb2.setVisible(false);
                rdb3.setVisible(false);
                rdb4.setVisible(false);
                lblEnunciado.setText(pregunta.get(6));
                lbl1.setText(pregunta.get(1));
                lbl2.setText(pregunta.get(2));
                lbl3.setText(pregunta.get(3));
                lbl4.setText(pregunta.get(4));

            }
        } else {
            btnSiguiente1.setVisible(false);
            JOptionPane.showMessageDialog(null, "ya ha completado sus 10 preguntas, termine el juego");
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente1;
    private javax.swing.JButton btnTerminarJuego;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lblEnunciado;
    private javax.swing.JRadioButton rdb1;
    private javax.swing.JRadioButton rdb2;
    private javax.swing.JRadioButton rdb3;
    private javax.swing.JRadioButton rdb4;
    // End of variables declaration//GEN-END:variables
}
