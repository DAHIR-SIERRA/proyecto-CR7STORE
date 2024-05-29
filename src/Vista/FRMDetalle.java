/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.ConectarBD;
import Modelo.Usuario;
import Modelo.Productos;
import Modelo.DetalleFactura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author User
 */
public class FRMDetalle extends javax.swing.JInternalFrame {
    public FRMDetalle() {
        initComponents();
        TXTIdDetalle.setValue(0);
        TXTIdDetalle.setVisible(false);
       
        limpiarFormulario();
        
    }
    private void limpiarFormulario() {
        ComboUsuarios();
        ComboProdutos();        
        Cantidad.setText("Cantidad");
        JCUsuario.setSelectedIndex(0);
        JCProductos.setSelectedIndex(0);
        BTNModificar.setEnabled(false);
        BTNEliminar.setEnabled(false);

        llenarTabla();
        
    }
    public void llenarTabla() {
        DetalleFactura unDetalle = new DetalleFactura();
        DefaultTableModel tabla = (DefaultTableModel) TablaFactura.getModel();
        Iterator<DetalleFactura> itDetalle = unDetalle.Listar();
        Object[] filaDetalle = new Object[TablaFactura.getColumnCount()];
        tabla.setRowCount(0);
        while (itDetalle.hasNext()) {
            unDetalle = itDetalle.next();
            filaDetalle[0] = unDetalle.getCantidad();
            
            tabla.addRow(filaDetalle);
        }
    }
     private void ComboUsuarios() {
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement("SELECT * FROM Usuario ");

            ResultSet rs = sql.executeQuery();
            JCUsuario.removeAllItems();
            Usuario miU = new Usuario();
            miU.setUsuarioNombre("Seleccione un cliente");
            JCUsuario.addItem(miU);
            while (rs.next()) {
                miU = new Usuario();
                miU.setIdUSuario(rs.getInt("idUsuario"));
                miU.setUsuarioNombre(rs.getString("UsuarioNombre"));
                miU.setUsuarioDocumento(rs.getString("UsuarioDocumento"));
                JCUsuario.addItem(miU);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar " + e.toString());
        }
        }
     
      private void ComboProdutos() {
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement("SELECT * FROM Producto ");

            ResultSet rs = sql.executeQuery();
            JCProductos.removeAllItems();
            Productos miP = new Productos();
            miP.setProductoCategoria("Seleccione un Producto");
            JCProductos.addItem(miP);
            while (rs.next()) {
                miP = new Productos();
                miP.setIdProducto(rs.getInt("idProducto"));
                miP.setProductoCategoria(rs.getString("ProductoCategoria"));
                miP.setProductoPrecio(rs.getInt("ProductoPrecio"));
                miP.setProductoTalla(rs.getString("ProductoTalla"));
                miP.setProductoStock(rs.getInt("ProductoStock"));
                JCProductos.addItem(miP);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar " + e.toString());
        }
     }
      
      
      
      



         
        
        
    
 
    


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ProductoPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCProductos = new javax.swing.JComboBox<>();
        JCUsuario = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaFactura = new javax.swing.JTable();
        Cantidad = new javax.swing.JTextField();
        AgregarP = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        TXTIdDetalle = new javax.swing.JFormattedTextField();
        BTNModificar = new javax.swing.JButton();
        BTNEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Bernard MT Condensed", 0, 24)); // NOI18N
        jLabel1.setText("CR7STORE");

        ProductoPanel.setBackground(new java.awt.Color(255, 51, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 16)); // NOI18N
        jLabel3.setText("real madrid 2014");

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 0, 16)); // NOI18N
        jLabel4.setText("Machester  2008");

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 16)); // NOI18N
        jLabel5.setText("Real madrid 2017");

        JCProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCProductosActionPerformed(evt);
            }
        });

        JCUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCUsuarioActionPerformed(evt);
            }
        });

        jLabel8.setText("Producto");

        TablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idFactura", "idProducto", "Categoria", "Talla", "Cantidad", "id", "ClienteNombre", "Documento", "Precio", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaFactura);

        Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadActionPerformed(evt);
            }
        });

        AgregarP.setText("AgregarP");
        AgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPActionPerformed(evt);
            }
        });

        jLabel2.setText("Cantida Compra");

        jLabel6.setText("Total pagar");

        jButton2.setText("New Venta");

        jLabel9.setText("Usuario");

        TXTIdDetalle.setText("0");
        TXTIdDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTIdDetalleActionPerformed(evt);
            }
        });

        BTNModificar.setText("Modificar");
        BTNModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNModificarActionPerformed(evt);
            }
        });

        BTNEliminar.setText("Eliminar");
        BTNEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProductoPanelLayout = new javax.swing.GroupLayout(ProductoPanel);
        ProductoPanel.setLayout(ProductoPanelLayout);
        ProductoPanelLayout.setHorizontalGroup(
            ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductoPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TXTIdDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductoPanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))
                    .addGroup(ProductoPanelLayout.createSequentialGroup()
                        .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(ProductoPanelLayout.createSequentialGroup()
                                .addComponent(JCUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(JCProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AgregarP)
                            .addComponent(BTNModificar)
                            .addComponent(BTNEliminar))
                        .addGap(67, 67, 67))))
            .addGroup(ProductoPanelLayout.createSequentialGroup()
                .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductoPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ProductoPanelLayout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(178, 178, 178))
                            .addGroup(ProductoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel5)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel3))))
                    .addGroup(ProductoPanelLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel9)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel8))
                    .addGroup(ProductoPanelLayout.createSequentialGroup()
                        .addGap(513, 513, 513)
                        .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(169, 169, 169))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductoPanelLayout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130))))
                    .addGroup(ProductoPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ProductoPanelLayout.setVerticalGroup(
            ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductoPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ProductoPanelLayout.createSequentialGroup()
                        .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNModificar)
                .addGap(10, 10, 10)
                .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(AgregarP))
                    .addComponent(jLabel9))
                .addGap(10, 10, 10)
                .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTIdDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNEliminar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(ProductoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(ProductoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCUsuarioActionPerformed
       
    }//GEN-LAST:event_JCUsuarioActionPerformed

    private void CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadActionPerformed

    private void AgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPActionPerformed
     
    }//GEN-LAST:event_AgregarPActionPerformed

    private void JCProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCProductosActionPerformed

    private void TXTIdDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTIdDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTIdDetalleActionPerformed

    private void BTNModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNModificarActionPerformed

    private void BTNEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarP;
    private javax.swing.JButton BTNEliminar;
    private javax.swing.JButton BTNModificar;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JComboBox<Productos> JCProductos;
    private javax.swing.JComboBox<Usuario > JCUsuario;
    private javax.swing.JPanel ProductoPanel;
    private javax.swing.JFormattedTextField TXTIdDetalle;
    private javax.swing.JTable TablaFactura;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables


}