/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_cliente;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel
 */
public class Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Clientes");
        
        Controlador_cliente cc=new Controlador_cliente();    
                ArrayList<String> lista=cc.cargarClientes();
                for (int i=0;i<lista.size();i++){
                    act_cli_select.addItem(lista.get(i));//select cliente actualizar
                    bor_cli_select.addItem(lista.get(i));//select cliente borrar
                    con_dni.addItem(lista.get(i));//select cliente consultar
                }   
        
        
    }
    
    
    public void RecargarClientes(){
        act_cli_select.removeAllItems();
        bor_cli_select.removeAllItems();
        con_dni.removeAllItems();
        //Para cargar los clientes
        Controlador_cliente cc=new Controlador_cliente();    
                ArrayList<String> lista=cc.cargarClientes();
                for (int i=0;i<lista.size();i++){
                    act_cli_select.addItem(lista.get(i));//select cliente actualizar
                    bor_cli_select.addItem(lista.get(i));//select cliente borrar
                    con_dni.addItem(lista.get(i));//select cliente consultar
                }   
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        insertar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ins_dni = new javax.swing.JTextField();
        ins_nombre = new javax.swing.JTextField();
        ins_ape1 = new javax.swing.JTextField();
        ins_ape2 = new javax.swing.JTextField();
        ins_dir = new javax.swing.JTextField();
        ins_tlf = new javax.swing.JTextField();
        btn_insertar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ins_log = new javax.swing.JTextArea();
        borrar = new javax.swing.JPanel();
        bor_cli_select = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        btn_borrar = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        bor_log = new javax.swing.JTextArea();
        consultar = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        btn_consultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_consultas = new javax.swing.JTable();
        con_dni = new javax.swing.JComboBox();
        actualizar = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        act_cli_select = new javax.swing.JComboBox();
        act_dni = new javax.swing.JTextField();
        act_nombre = new javax.swing.JTextField();
        act_ape1 = new javax.swing.JTextField();
        act_ape2 = new javax.swing.JTextField();
        act_tlf = new javax.swing.JTextField();
        act_dir = new javax.swing.JTextField();
        btn_actualizar = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        act_log = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        navegador = new javax.swing.JMenu();
        automoviles = new javax.swing.JMenuItem();
        clientes = new javax.swing.JMenuItem();
        reparaciones = new javax.swing.JMenuItem();
        mecanicos = new javax.swing.JMenuItem();
        concesionarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel13.setText("Dni propietario");

        jLabel14.setText("Nombre");

        jLabel15.setText("Primer apellido");

        jLabel16.setText("Segundo apellido");

        jLabel17.setText("Telefono");

        jLabel18.setText("Direccion");

        ins_dir.setPreferredSize(new java.awt.Dimension(80, 20));

        btn_insertar.setText("Insertar");
        btn_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertarActionPerformed(evt);
            }
        });

        jLabel19.setText("Log : ");

        ins_log.setColumns(20);
        ins_log.setRows(5);
        jScrollPane2.setViewportView(ins_log);

        javax.swing.GroupLayout insertarLayout = new javax.swing.GroupLayout(insertar);
        insertar.setLayout(insertarLayout);
        insertarLayout.setHorizontalGroup(
            insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(insertarLayout.createSequentialGroup()
                        .addGroup(insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(insertarLayout.createSequentialGroup()
                                .addGroup(insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(insertarLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ins_ape2))
                                    .addGroup(insertarLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(22, 22, 22)
                                        .addComponent(ins_ape1))
                                    .addGroup(insertarLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(54, 54, 54)
                                        .addComponent(ins_nombre))
                                    .addGroup(insertarLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(21, 21, 21)
                                        .addComponent(ins_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(187, 187, 187)
                                .addGroup(insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(30, 30, 30)
                                .addGroup(insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ins_dir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ins_tlf)))
                            .addComponent(btn_insertar)
                            .addComponent(jLabel19))
                        .addGap(0, 167, Short.MAX_VALUE)))
                .addContainerGap())
        );
        insertarLayout.setVerticalGroup(
            insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel18)
                    .addComponent(ins_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ins_dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(ins_tlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ins_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(ins_ape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(insertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(ins_ape2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btn_insertar)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Insertar", insertar);

        jLabel24.setText("Elige un cliente");

        btn_borrar.setText("Borrar");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        jLabel25.setText("Log : ");

        bor_log.setColumns(20);
        bor_log.setRows(5);
        jScrollPane6.setViewportView(bor_log);

        javax.swing.GroupLayout borrarLayout = new javax.swing.GroupLayout(borrar);
        borrar.setLayout(borrarLayout);
        borrarLayout.setHorizontalGroup(
            borrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(borrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(borrarLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(bor_cli_select, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_borrar)
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        borrarLayout.setVerticalGroup(
            borrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrarLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(borrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(bor_cli_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btn_borrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("Borrar", borrar);

        jLabel36.setText("Dni");

        btn_consultar.setText("Consultar");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });

        tabla_consultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Dni", "Nombre", "Apellido1", "Apellido2", "Direccion", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tabla_consultas);

        javax.swing.GroupLayout consultarLayout = new javax.swing.GroupLayout(consultar);
        consultar.setLayout(consultarLayout);
        consultarLayout.setHorizontalGroup(
            consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
            .addGroup(consultarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultarLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(con_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_consultar))
                .addContainerGap(549, Short.MAX_VALUE))
        );
        consultarLayout.setVerticalGroup(
            consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultarLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(con_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_consultar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar", consultar);

        jLabel12.setText("Elige un cliente");

        jLabel26.setText("Dni propietario");

        jLabel27.setText("Nombre");

        jLabel28.setText("Primer apellido");

        jLabel29.setText("Segundo apellido");

        jLabel30.setText("Telefono");

        jLabel31.setText("Direccion");

        act_cli_select.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                act_cli_selectItemStateChanged(evt);
            }
        });

        act_dni.setMinimumSize(new java.awt.Dimension(80, 20));
        act_dni.setPreferredSize(new java.awt.Dimension(80, 20));

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        jLabel32.setText("Log : ");

        act_log.setColumns(20);
        act_log.setRows(5);
        jScrollPane7.setViewportView(act_log);

        javax.swing.GroupLayout actualizarLayout = new javax.swing.GroupLayout(actualizar);
        actualizar.setLayout(actualizarLayout);
        actualizarLayout.setHorizontalGroup(
            actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(actualizarLayout.createSequentialGroup()
                        .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addGroup(actualizarLayout.createSequentialGroup()
                                .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(actualizarLayout.createSequentialGroup()
                                        .addGap(328, 328, 328)
                                        .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel30)))
                                    .addComponent(btn_actualizar)
                                    .addGroup(actualizarLayout.createSequentialGroup()
                                        .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel29))
                                        .addGap(18, 18, 18)
                                        .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(act_ape2)
                                            .addComponent(act_ape1)
                                            .addComponent(act_nombre)
                                            .addComponent(act_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(act_dir, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(act_tlf, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
                        .addGap(219, 219, 219))
                    .addGroup(actualizarLayout.createSequentialGroup()
                        .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(actualizarLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(30, 30, 30)
                                .addComponent(act_cli_select, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane7))
                        .addContainerGap())))
        );
        actualizarLayout.setVerticalGroup(
            actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(act_cli_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 29, Short.MAX_VALUE)
                .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(act_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(act_dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(act_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(act_tlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel30))
                .addGap(10, 10, 10)
                .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(act_ape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(act_ape2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addComponent(btn_actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Actualizar", actualizar);

        navegador.setText("Navegador");
        navegador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navegadorActionPerformed(evt);
            }
        });

        automoviles.setText("Automoviles");
        automoviles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automovilesActionPerformed(evt);
            }
        });
        navegador.add(automoviles);

        clientes.setText("Clientes");
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });
        navegador.add(clientes);

        reparaciones.setText("Reparaciones");
        reparaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reparacionesActionPerformed(evt);
            }
        });
        navegador.add(reparaciones);

        mecanicos.setText("Mecanicos");
        mecanicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mecanicosActionPerformed(evt);
            }
        });
        navegador.add(mecanicos);

        concesionarios.setText("Concesionarios");
        concesionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concesionariosActionPerformed(evt);
            }
        });
        navegador.add(concesionarios);

        jMenuBar1.add(navegador);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void automovilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_automovilesActionPerformed
        Automovil obj=new Automovil();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_automovilesActionPerformed
        
    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        

    }//GEN-LAST:event_clientesActionPerformed

    private void navegadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navegadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navegadorActionPerformed

    private void reparacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reparacionesActionPerformed
        Reparaciones obj=new Reparaciones();
       obj.setVisible(true);
       dispose();
    }//GEN-LAST:event_reparacionesActionPerformed

    private void mecanicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mecanicosActionPerformed
        Mecanico obj=new Mecanico();
       obj.setVisible(true);
       dispose();
    }//GEN-LAST:event_mecanicosActionPerformed

    private void concesionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concesionariosActionPerformed
        Concesionarios obj=new Concesionarios();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_concesionariosActionPerformed

    private void btn_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertarActionPerformed
        Controlador_cliente cc=new Controlador_cliente(ins_dni.getText(),ins_nombre.getText(),
            ins_ape1.getText(),ins_ape2.getText(),ins_dir.getText(),new Integer(ins_tlf.getText()));
        ins_log.setText(cc.getLog());
        RecargarClientes();
    }//GEN-LAST:event_btn_insertarActionPerformed

    
    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        Controlador_cliente cc=new Controlador_cliente();
        cc.actualizar_Cliente(act_cli_select.getSelectedItem().toString(),act_dni.getText(), 
                act_nombre.getText(), act_ape1.getText(), 
                act_ape2.getText(), act_dir.getText(), 
                new Integer(act_tlf.getText()));

        act_log.setText(cc.getLog());
        RecargarClientes();
    }//GEN-LAST:event_btn_actualizarActionPerformed
    
    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        // TODO add your handling code here:
        Controlador_cliente cc=new Controlador_cliente();
        cc.borrarCliente(bor_cli_select.getSelectedItem().toString());
        bor_log.setText(cc.getLog());
        RecargarClientes();
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        // TODO add your handling code here:
        Controlador_cliente ca=new  Controlador_cliente();

        ArrayList<ArrayList<String>>listaClientes=ca.consultaCliente(con_dni.getSelectedItem().toString());
        DefaultTableModel modelo;
        modelo=(DefaultTableModel) tabla_consultas.getModel();
        for(int i=0;i<listaClientes.size();i++){
            modelo.insertRow(i, listaClientes.get(i).toArray());
        }
        tabla_consultas.setModel(modelo);

    }//GEN-LAST:event_btn_consultarActionPerformed

    private void act_cli_selectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_act_cli_selectItemStateChanged
        // TODO add your handling code here:
        
        Controlador_cliente ca=new  Controlador_cliente();
        if(evt.getStateChange()==ItemEvent.SELECTED){
            ca.recogerDatosCliente(act_cli_select.getSelectedItem().toString());

            act_dni.setText(ca.getDni());
            act_nombre.setText(ca.getNombre());
            act_ape1.setText(ca.getApellido1());
            act_ape2.setText(ca.getApellido2());
            act_dir.setText(ca.getDireccion());
            act_tlf.setText(Integer.toString(ca.getTlf()));
        }       
                
    }//GEN-LAST:event_act_cli_selectItemStateChanged

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField act_ape1;
    private javax.swing.JTextField act_ape2;
    private javax.swing.JComboBox act_cli_select;
    private javax.swing.JTextField act_dir;
    private javax.swing.JTextField act_dni;
    private javax.swing.JTextArea act_log;
    private javax.swing.JTextField act_nombre;
    private javax.swing.JTextField act_tlf;
    private javax.swing.JPanel actualizar;
    private javax.swing.JMenuItem automoviles;
    private javax.swing.JComboBox bor_cli_select;
    private javax.swing.JTextArea bor_log;
    private javax.swing.JPanel borrar;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_insertar;
    private javax.swing.JMenuItem clientes;
    private javax.swing.JComboBox con_dni;
    private javax.swing.JMenuItem concesionarios;
    private javax.swing.JPanel consultar;
    private javax.swing.JTextField ins_ape1;
    private javax.swing.JTextField ins_ape2;
    private javax.swing.JTextField ins_dir;
    private javax.swing.JTextField ins_dni;
    private javax.swing.JTextArea ins_log;
    private javax.swing.JTextField ins_nombre;
    private javax.swing.JTextField ins_tlf;
    private javax.swing.JPanel insertar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem mecanicos;
    private javax.swing.JMenu navegador;
    private javax.swing.JMenuItem reparaciones;
    private javax.swing.JTable tabla_consultas;
    // End of variables declaration//GEN-END:variables
}