/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.view_panel;

import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.LOOPER_gentsWear.controller.ManageCashierController;
import lk.ijse.LOOPER_gentsWear.dto.CashierDTO;

/**
 *
 * @author Sandun_CJ
 */
public class CashierSettingPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public CashierSettingPanel() {
        initComponents();
        loadAllCashiers();

        tblCashier.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (tblCashier.getSelectedRow() == -1) {
                    return;
                }

                String id = tblCashier.getValueAt(tblCashier.getSelectedRow(), 0).toString();
                String name = tblCashier.getValueAt(tblCashier.getSelectedRow(), 1).toString();

                txtCashi_ID.setText(id);
                txtCashi_Name.setText(name);
                btnSave.setEnabled(false);
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

        jLabel2 = new javax.swing.JLabel();
        btnNewCashier = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCashi_Name = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCashi_ID = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCashier = new javax.swing.JTable();
        txtConffirm = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(970, 570));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/user-laptop-512.png"))); // NOI18N
        jLabel2.setText("Cashier..");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 50));

        btnNewCashier.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnNewCashier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/add.png"))); // NOI18N
        btnNewCashier.setMnemonic('N');
        btnNewCashier.setText("New Cashier");
        btnNewCashier.setToolTipText("Click to add new subject");
        btnNewCashier.setFocusPainted(false);
        btnNewCashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCashierActionPerformed(evt);
            }
        });
        add(btnNewCashier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Cashier Name");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 80, 30));

        txtCashi_Name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtCashi_Name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCashi_Name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCashi_Name.setDragEnabled(true);
        txtCashi_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashi_NameActionPerformed(evt);
            }
        });
        add(txtCashi_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 150, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("New Password");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 110, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Confirm Password");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 120, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Cashier ID");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 80, 30));

        txtCashi_ID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtCashi_ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCashi_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCashi_ID.setDragEnabled(true);
        txtCashi_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashi_IDActionPerformed(evt);
            }
        });
        add(txtCashi_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 110, 30));

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setToolTipText("Clikc to save changes");
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, 30));

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 110, 30));

        tblCashier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCashier);
        if (tblCashier.getColumnModel().getColumnCount() > 0) {
            tblCashier.getColumnModel().getColumn(0).setResizable(false);
            tblCashier.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 360, 240));

        txtConffirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtConffirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConffirmActionPerformed(evt);
            }
        });
        add(txtConffirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 150, 30));

        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 150, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));
        jLabel1.setOpaque(true);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewCashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCashierActionPerformed
        clearAll();
        txtCashi_ID.requestFocusInWindow();
    }//GEN-LAST:event_btnNewCashierActionPerformed

    private void txtCashi_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashi_NameActionPerformed
        txtPassword.requestFocusInWindow();
    }//GEN-LAST:event_txtCashi_NameActionPerformed

    private void txtCashi_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashi_IDActionPerformed
        txtCashi_Name.requestFocusInWindow();
    }//GEN-LAST:event_txtCashi_IDActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            CashierDTO admin = new CashierDTO(
                    Integer.parseInt(txtCashi_ID.getText()),
                    txtCashi_Name.getText(),
                    new String(txtPassword.getPassword()));
            boolean result = ManageCashierController.addCashier(admin);

            if (result) {
                JOptionPane.showMessageDialog(this, "Cashier has been successfully Saved.");
                loadAllCashiers();
                clearAll();
                txtCashi_ID.requestFocusInWindow();
            } else {
                JOptionPane.showMessageDialog(this, "Cashier hasn't been Saved due to some error");
            }
        } catch (Exception ex) {
            Logger.getLogger(CashierSettingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            CashierDTO searchCashier = ManageCashierController.searchCashier(txtCashi_ID.getText());
            
            if (searchCashier.getC_password().equals(new String(txtPassword.getPassword()))) {
                
                boolean result = ManageCashierController.deleteCashier(txtCashi_ID.getText());

                if (result) {

                    JOptionPane.showMessageDialog(this, "Cashier has been Deleted Successfull..");
                    loadAllCashiers();
                    btnSave.setEnabled(true);

                } else {
                    JOptionPane.showMessageDialog(this, "Cashier Deleted Fail..");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Fill Correct Password");
            }

            clearAll();
            txtCashi_ID.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(CashierSettingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        txtConffirm.requestFocusInWindow();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtConffirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConffirmActionPerformed
        String pss = new String(txtPassword.getPassword());
        String con = new String(txtConffirm.getPassword());
        if (pss.equals(con)) {
            btnSave.requestFocusInWindow();
            txtConffirm.setBorder(new LineBorder(new Color(204, 204, 204)));
        } else {
            JOptionPane.showMessageDialog(this, "Password is not match..");
            txtConffirm.setBorder(new LineBorder(Color.RED));
        }

    }//GEN-LAST:event_txtConffirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewCashier;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCashier;
    private javax.swing.JTextField txtCashi_ID;
    private javax.swing.JTextField txtCashi_Name;
    private javax.swing.JPasswordField txtConffirm;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    private void clearAll() {
        txtCashi_Name.setText("");
        txtPassword.setText("");
        txtConffirm.setText("");
    }

    private void loadAllCashiers() {
        try {
            List<CashierDTO> allCashier = ManageCashierController.getAllCashiers();

            DefaultTableModel dtm = (DefaultTableModel) tblCashier.getModel();

            dtm.setRowCount(0);

            if (allCashier != null) {

                for (CashierDTO admin : allCashier) {

                    Object[] rowData = {
                        admin.getC_id(),
                        admin.getC_name()
                    };

                    dtm.addRow(rowData);

                }

            }
        } catch (Exception ex) {
            Logger.getLogger(CashierSettingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
