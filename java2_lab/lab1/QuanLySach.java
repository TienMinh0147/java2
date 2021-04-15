/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_lab.lab1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Junofex
 */
public class QuanLySach extends javax.swing.JFrame {

    Sach s = null;
    List<Sach> list = new ArrayList<>();
    DefaultTableModel model;
    FileInputStream fis;
    int index;     
    
    public boolean kt(String ma) {
      boolean add = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).MaS.equalsIgnoreCase(ma) == true) {
                add = true;
            }
        }
        return add;
    }

    void fillToTable() {
        try {            
            model = (DefaultTableModel) tblTable.getModel();
            model.setRowCount(0);
            for (Sach s : list) {
                Object[] row = new Object[]{s.MaS, s.TenSach, s.GiaBan};
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }
    void showData(){
     s = list.get(index);
     txtMaSach.setText(s.MaS);
     txtTenSach.setText(s.TenSach);
     txtGiaBan.setText(String.valueOf(s.TenSach));   
    }
    
    void Moi() {
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtGiaBan.setText("");
    }

    void Them(){
        s = new Sach();
        try {
            s.MaS = txtMaSach.getText();
            if (kt(txtMaSach.getText()) == true) {
                JOptionPane.showMessageDialog(this, "trùng mã sách, nhập mã sách khác");
                return;
            }
            if (s.MaS.length() == 0) {
                JOptionPane.showMessageDialog(this, "mời nhập lại mã sách");
                return;
            }
        } catch (Exception e) {
        }
        
        try {
            boolean a = true;
            s.TenSach = txtMaSach.getText();
            if (s.TenSach.length() == 0) {
                JOptionPane.showConfirmDialog(this, "Mời bạn nhập lại tên sách");
                return;
            }
        } catch (Exception e) {
        }
        
           try {
            s.GiaBan = Integer.parseInt(txtGiaBan.getText());
            if (s.GiaBan > 0) {
            } else {
                txtGiaBan.setText("");
                JOptionPane.showMessageDialog(this, "lương phải trên 0 đồng ");
                return;
            }
        } catch (Exception e) {
        }
        list.add(s);
    }
    
    void Luu(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\User\\data.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (Exception e) {
        }}
    
    void Thoat(){
           bntThoat.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
            System.exit(0);
             }
            });
    }

    public QuanLySach() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblMaS = new javax.swing.JLabel();
        lblTenS = new javax.swing.JLabel();
        lblGiaB = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        bntThem = new javax.swing.JButton();
        bntMoi = new javax.swing.JButton();
        bntLuu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        bntThoat = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("QUẢN LÝ SÁCH");

        lblMaS.setText("Mã sách");

        lblTenS.setText("Tên sách");

        lblGiaB.setText("Giá bán");

        bntThem.setText("Thêm ");
        bntThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntThemActionPerformed(evt);
            }
        });

        bntMoi.setText("Mới");
        bntMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntMoiActionPerformed(evt);
            }
        });

        bntLuu.setText("Lưu");
        bntLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLuuActionPerformed(evt);
            }
        });

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Giá Bán"
            }
        ));
        jScrollPane2.setViewportView(tblTable);

        bntThoat.setText("Thoát");
        bntThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGiaB)
                            .addComponent(lblTenS)
                            .addComponent(lblMaS))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSach))
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(bntThoat))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaS)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntThem)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenS)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntMoi))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiaB)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntLuu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(bntThoat)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntThemActionPerformed
        this.Them();
        this.fillToTable();
    }//GEN-LAST:event_bntThemActionPerformed

    private void bntMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntMoiActionPerformed
        this.Moi();
    }//GEN-LAST:event_bntMoiActionPerformed

    private void bntLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLuuActionPerformed
       this.Luu();
    }//GEN-LAST:event_bntLuuActionPerformed

    private void bntThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntThoatActionPerformed
       this.Thoat();
    }//GEN-LAST:event_bntThoatActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLuu;
    private javax.swing.JButton bntMoi;
    private javax.swing.JButton bntThem;
    private javax.swing.JButton bntThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblGiaB;
    private javax.swing.JLabel lblMaS;
    private javax.swing.JLabel lblTenS;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
