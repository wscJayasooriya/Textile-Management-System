/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.view_panel;

import java.awt.Color;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import lk.ijse.LOOPER_gentsWear.common.Validation;
import lk.ijse.LOOPER_gentsWear.controller.ManageGRNController;
import lk.ijse.LOOPER_gentsWear.controller.ManageGRNPaymentController;
import lk.ijse.LOOPER_gentsWear.controller.ManageItemController;
import lk.ijse.LOOPER_gentsWear.controller.ManageSupplierController;
import lk.ijse.LOOPER_gentsWear.dto.GRNDTO;
import lk.ijse.LOOPER_gentsWear.dto.GRNDetailsDTO;
import lk.ijse.LOOPER_gentsWear.dto.GRNPaymentDTO;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;
import lk.ijse.LOOPER_gentsWear.dto.SupplierDTO;
import lk.ijse.LOOPER_gentsWear.observer.Observer;
import lk.ijse.LOOPER_gentsWear.view.HomePage;
import lk.ijse.LOOPER_gentsWear.view.POS_Main_Cashier;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Sandun_CJ
 */
public class GRNPanel extends javax.swing.JPanel implements Observer {

    private List<ItemDTO> itemList;
    DefaultTableModel dtm;

    /**
     * Creates new form NewJPanel
     */
    public GRNPanel() {
        initComponents();
        loadAllItems();
        loadAllSuppliers();
        dtm = (DefaultTableModel) tblGRN.getModel();
        AutoCompleteDecorator.decorate(cmbItemDesc);
        AutoCompleteDecorator.decorate(cmbSupplier);
        setDate();

        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageItemController.getSubject().registerObserver(this);
            ManageSupplierController.getSubject().registerObserver(this);
        } catch (Exception ex) {
            Logger.getLogger(POS_Main_Cashier.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel2 = new javax.swing.JLabel();
        btnNewItem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        txtBatchID = new javax.swing.JTextField();
        cmbItemDesc = new javax.swing.JComboBox<>();
        txtICode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtBuyingPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtGRNID = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        btnNewGRN = new javax.swing.JButton();
        btnAddToTable = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSupplierCompany = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGRN = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1070, 570));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/grn.png"))); // NOI18N
        jLabel2.setText("GRN..");
        add(jLabel2);
        jLabel2.setBounds(0, 10, 190, 50);

        btnNewItem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnNewItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/add.png"))); // NOI18N
        btnNewItem.setMnemonic('N');
        btnNewItem.setText("Add New Item");
        btnNewItem.setToolTipText("Click to add new subject");
        btnNewItem.setFocusPainted(false);
        btnNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewItemActionPerformed(evt);
            }
        });
        add(btnNewItem);
        btnNewItem.setBounds(30, 530, 150, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Supplier");
        add(jLabel5);
        jLabel5.setBounds(40, 190, 60, 30);

        cmbSupplier.setEditable(true);
        cmbSupplier.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbSupplier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSupplierItemStateChanged(evt);
            }
        });
        add(cmbSupplier);
        cmbSupplier.setBounds(120, 190, 120, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Total Amount");
        add(jLabel14);
        jLabel14.setBounds(860, 370, 90, 30);

        txtAmount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtAmount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtAmount.setDragEnabled(true);
        add(txtAmount);
        txtAmount.setBounds(950, 370, 100, 30);

        txtBatchID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtBatchID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBatchID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtBatchID.setDragEnabled(true);
        add(txtBatchID);
        txtBatchID.setBounds(120, 400, 100, 30);

        cmbItemDesc.setEditable(true);
        cmbItemDesc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbItemDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItemDescItemStateChanged(evt);
            }
        });
        cmbItemDesc.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbItemDescPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        add(cmbItemDesc);
        cmbItemDesc.setBounds(120, 280, 120, 30);

        txtICode.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtICode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtICode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtICode.setDragEnabled(true);
        txtICode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtICodeActionPerformed(evt);
            }
        });
        add(txtICode);
        txtICode.setBounds(120, 320, 100, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Description");
        add(jLabel11);
        jLabel11.setBounds(40, 280, 70, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Quantity");
        add(jLabel9);
        jLabel9.setBounds(40, 360, 60, 30);

        txtBuyingPrice.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtBuyingPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuyingPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtBuyingPrice.setDragEnabled(true);
        txtBuyingPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuyingPriceActionPerformed(evt);
            }
        });
        add(txtBuyingPrice);
        txtBuyingPrice.setBounds(120, 440, 130, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Unit Price");
        add(jLabel12);
        jLabel12.setBounds(40, 440, 80, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Batch ID");
        add(jLabel13);
        jLabel13.setBounds(40, 400, 70, 30);

        txtGRNID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtGRNID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGRNID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtGRNID.setDragEnabled(true);
        add(txtGRNID);
        txtGRNID.setBounds(120, 150, 100, 30);

        txtQty.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtQty.setDragEnabled(true);
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        add(txtQty);
        txtQty.setBounds(120, 360, 40, 30);

        btnNewGRN.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnNewGRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/add.png"))); // NOI18N
        btnNewGRN.setMnemonic('N');
        btnNewGRN.setText("New GRN");
        btnNewGRN.setToolTipText("Click to add new subject");
        btnNewGRN.setFocusPainted(false);
        btnNewGRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGRNActionPerformed(evt);
            }
        });
        add(btnNewGRN);
        btnNewGRN.setBounds(50, 100, 112, 30);

        btnAddToTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAddToTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/Entypo_e70c(0)_32.png"))); // NOI18N
        btnAddToTable.setText("Add to Table");
        btnAddToTable.setToolTipText("Add details to table");
        btnAddToTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToTableActionPerformed(evt);
            }
        });
        add(btnAddToTable);
        btnAddToTable.setBounds(190, 480, 150, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Item Code");
        add(jLabel10);
        jLabel10.setBounds(40, 320, 60, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("GRN ID");
        add(jLabel6);
        jLabel6.setBounds(40, 150, 70, 30);

        lblDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("GRN Date");
        add(lblDate);
        lblDate.setBounds(940, 20, 110, 30);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Supplier Company");
        add(jLabel15);
        jLabel15.setBounds(40, 230, 140, 30);

        txtSupplierCompany.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSupplierCompany.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSupplierCompany.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtSupplierCompany.setDragEnabled(true);
        txtSupplierCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierCompanyActionPerformed(evt);
            }
        });
        add(txtSupplierCompany);
        txtSupplierCompany.setBounds(160, 230, 160, 30);

        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "GRN Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        add(jLabel7);
        jLabel7.setBounds(20, 70, 340, 450);

        tblGRN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "GRN Id", "Batch Id", "Price", "Qty", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGRN);
        if (tblGRN.getColumnModel().getColumnCount() > 0) {
            tblGRN.getColumnModel().getColumn(0).setResizable(false);
            tblGRN.getColumnModel().getColumn(1).setResizable(false);
            tblGRN.getColumnModel().getColumn(2).setResizable(false);
            tblGRN.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(370, 80, 680, 270);

        btnPrint.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/FontAwesome_f02f(0)_32.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setBorder(null);
        add(btnPrint);
        btnPrint.setBounds(850, 450, 90, 30);

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setBorder(null);
        add(btnDelete);
        btnDelete.setBounds(740, 450, 90, 30);

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/LOOPER_gentsWear/images/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setBorder(null);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave);
        btnSave.setBounds(960, 450, 90, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));
        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1070, 570);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewItemActionPerformed

        ItemPanel itemPanel = new ItemPanel();
        JPanel panel = HomePage.getMainPanel();
        panel.removeAll();
        itemPanel.setSize(panel.getSize());
        panel.add(itemPanel);
        panel.revalidate();
        panel.repaint();


    }//GEN-LAST:event_btnNewItemActionPerformed

    private void btnNewGRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGRNActionPerformed
        cmbSupplier.requestFocusInWindow();
    }//GEN-LAST:event_btnNewGRNActionPerformed

    private void btnAddToTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToTableActionPerformed
        int x = Integer.parseInt(txtQty.getText());
        Double amount = x * Double.parseDouble(txtBuyingPrice.getText());

        if (cmbItemDesc.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Dress is not Selected");
        } else {
            Object[] rowData = {txtICode.getText(), txtGRNID.getText(), txtBatchID.getText(), txtBuyingPrice.getText(), txtQty.getText(), amount};
            dtm.addRow(rowData);
            setAmount();

        }

    }//GEN-LAST:event_btnAddToTableActionPerformed

    private void txtICodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtICodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtICodeActionPerformed

    private void cmbSupplierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSupplierItemStateChanged
        try {
            SupplierDTO supplierDTO = ManageSupplierController.searchSupplierbyId((String) cmbSupplier.getSelectedItem());
        } catch (Exception ex) {
            Logger.getLogger(GRNPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        searchSupplier();
    }//GEN-LAST:event_cmbSupplierItemStateChanged

    private void cmbItemDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItemDescItemStateChanged
        searchItem();
    }//GEN-LAST:event_cmbItemDescItemStateChanged

    private void cmbItemDescPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbItemDescPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_cmbItemDescPopupMenuWillBecomeInvisible

    private void txtSupplierCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierCompanyActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        if (Validation.numberOnly(txtQty)) {
            txtBatchID.requestFocus();
            txtQty.setBorder(new LineBorder(new Color(204, 204, 204)));
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Input");
            txtQty.setBorder(new LineBorder(Color.RED));
        }

    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtBuyingPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuyingPriceActionPerformed
        int x = Integer.parseInt(txtQty.getText());
        Double amount = x * Double.parseDouble(txtBuyingPrice.getText());

        if (Validation.numberOnly(txtBuyingPrice)) {
            txtBuyingPrice.setBorder(new LineBorder(new Color(204, 204, 204)));

            if (cmbItemDesc.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Dress is not Selected");
            } else {
                Object[] rowData = {txtICode.getText(), txtGRNID.getText(), txtBatchID.getText(), txtBuyingPrice.getText(), txtQty.getText(), amount};
                dtm.addRow(rowData);
                setAmount();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Input");
            txtBuyingPrice.setBorder(new LineBorder(Color.RED));
        }
    }//GEN-LAST:event_txtBuyingPriceActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ManageItemController itemController = new ManageItemController();
        ManageGRNPaymentController gRNPaymentController = new ManageGRNPaymentController();
        ManageGRNController gRNController = new ManageGRNController();

        if (cmbSupplier.getSelectedIndex() != -1) {
            try {

                GRNDTO grn = new GRNDTO();
                grn.setGRNID(Integer.parseInt(txtGRNID.getText()));
                grn.setDate(lblDate.getText());
                grn.setBatch_Id(txtBatchID.getText());
                grn.setSup_id(cmbSupplier.getSelectedItem().toString());
                grn.setQty(Integer.parseInt(txtQty.getText()));
                grn.setBuyingPrice(Double.parseDouble(txtBuyingPrice.getText()));

                GRNPaymentDTO paymentDTO = new GRNPaymentDTO();
                paymentDTO.setAmount(Double.parseDouble(txtAmount.getText()));

                grn.setgRNPaymentDTO(paymentDTO);

                List<GRNDetailsDTO> list = new ArrayList<>();
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    ItemDTO searchItem = itemController.searchItem((String) dtm.getValueAt(i, 0));
                    searchItem.setQty(searchItem.getQty() + Integer.parseInt(dtm.getValueAt(i, 4).toString()));

                    GRNDetailsDTO detailsDTO = new GRNDetailsDTO();
                    detailsDTO.setItemDTO(searchItem);
                    detailsDTO.setGrndto(grn);

                    list.add(detailsDTO);
                }
                grn.setList(list);
                boolean result = gRNController.addGRN(grn);

                if (result) {
                    JOptionPane.showMessageDialog(this, "Added New");
                    clearAlltextField();
                    txtGRNID.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed");
                }

            } catch (Exception ex) {
                Logger.getLogger(GRNPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToTable;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewGRN;
    private javax.swing.JButton btnNewItem;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbItemDesc;
    private javax.swing.JComboBox<String> cmbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JTable tblGRN;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtBuyingPrice;
    private javax.swing.JTextField txtGRNID;
    private javax.swing.JTextField txtICode;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSupplierCompany;
    // End of variables declaration//GEN-END:variables

    private void searchItem() {
        String desc = (String) cmbItemDesc.getSelectedItem();
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getDescription() == desc) {
                txtICode.setText(itemList.get(i).getiCode());
            }
        }
    }

    private void loadAllItems() {  
        try {
            itemList = ManageItemController.getAllItems();
            if (itemList != null) {
                for (ItemDTO itemDTO : itemList) {
                    cmbItemDesc.addItem(itemDTO.getDescription());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(GRNPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllSuppliers() {
        try {
            List<SupplierDTO> supplier = ManageSupplierController.getAllSuppliers();
            if (supplier != null) {
                for (SupplierDTO supplierDTO : supplier) {
                    cmbSupplier.addItem(supplierDTO.getSup_id());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(GRNPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchSupplier() {
        String desc = (String) cmbSupplier.getSelectedItem();
        //SupplierDTO dto=new SupplierDTO();
        try {
            SupplierDTO supplierDTO = ManageSupplierController.searchSupplierbyId(desc);
            if (supplierDTO != null) {
                txtSupplierCompany.setText(supplierDTO.getCompany_name());
            }

        } catch (Exception ex) {
            Logger.getLogger(GRNPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setAmount() {
        double total = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            total += Double.parseDouble(dtm.getValueAt(i, 5).toString());
        }
        txtAmount.setText(Double.toString(total));
    }

    private void clearAlltextField() {
        cmbSupplier.setSelectedItem("Select");
        txtSupplierCompany.setText("");
        cmbItemDesc.setSelectedItem("Select");
        txtICode.setText("");
        txtQty.setText("");
        txtBatchID.setText("");
        txtBuyingPrice.setText("");
        dtm.setRowCount(0);
        txtGRNID.setText("");
        txtAmount.setText("");
    }

    private void setDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("E dd-MM-yyyy");
        lblDate.setText(s.format(d));
    }

    @Override
    public void updateObservers() throws Exception {
        loadAllItems();
        loadAllSuppliers();
    }
}
