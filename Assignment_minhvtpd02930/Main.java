package Assignment_minhvtpd02930;



import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Assignment_minhvtpd02930.QuanLyNhanVien;
import Assignment_minhvtpd02930.NhanVien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ast
 */
public class Main extends javax.swing.JFrame implements Runnable{
    private int List=0;
     int qlnhanvien=1;
    private JFileChooser rc = new JFileChooser();
    QuanLyNhanVien quanly;
    /**
     * Creates new form Main
     */
    public Main() {
        quanly= new QuanLyNhanVien();
        initComponents();
        List=0;
        Thread t1 = new Thread((Runnable) this);
        t1.start();
        bntclock.setEnabled(false);
    }
    @Override
    public void run() {
        while (true) {            
            try {
                Date now = new Date();
                SimpleDateFormat formater = new SimpleDateFormat();
                formater.applyPattern("hh:mm:ss aa");
                String time = formater.format(now);
                bntclock.setText(time);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Lỗi");
            }
        }
    }
    
    void hienthi(NhanVien obj){
        TxtMaNV.setText(obj.getMaNV());
        TxtHoTen.setText(obj.getHoTen());
        TxtTuoi.setText(String.valueOf(obj.getTuoi()));
        TxtEmail.setText(obj.getEmail());
        TxtLuong.setText(String.valueOf(obj.getLuong()));
        
    }
    public void themmoikiemtra(){
          boolean kt = true;
          if(TxtMaNV.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Mã Nhân Viên");
            TxtMaNV.setBackground(Color.yellow);
            kt=false;
        }else{
              TxtMaNV.setBackground(Color.white);
          }
          if(quanly.timKiemById(TxtMaNV.getText()) != -1){
                            JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại!");
                            TxtMaNV.setBackground(Color.yellow);
                            kt = false;
                        }else{
              TxtMaNV.setBackground(Color.white);
          }
        String fullname = TxtHoTen.getText();
        try{
            double so = Double.parseDouble(fullname);
              JOptionPane.showMessageDialog(this, "Bạn nhập sai định dạng tên");
               TxtHoTen.setBackground(Color.yellow);
               kt=false;
        }catch(Exception x){
            if(fullname.length()==0){
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên");
                 TxtHoTen.setBackground(Color.yellow);
                 kt=false;
            }else{
                TxtHoTen.setBackground(Color.white);
            }
             try { int tuoi = Integer.parseInt(TxtTuoi.getText());
             TxtTuoi.setBackground(Color.white); 
            if(tuoi<=16 || tuoi>=55){
                JOptionPane.showMessageDialog(this, "Bạn phải nhập tuổi từ 16 đến 55");
                TxtTuoi.setBackground(Color.yellow);
                kt=false;
            }else{
              TxtTuoi.setBackground(Color.white);  
            }
        } catch (Exception e) {
             if(TxtTuoi.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Bạn phải nhập số tuổi");
            TxtTuoi.setBackground(Color.yellow);
            kt=false;
             }else{
                 TxtTuoi.setBackground(Color.white);
             }
              JOptionPane.showMessageDialog(this, "Tuổi không đúng định dạng số");
            TxtTuoi.setBackground(Color.yellow);
            kt=false;
        }
              if(TxtEmail.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Email ");
            TxtEmail.setBackground(Color.yellow);
            kt=false;
        }else{
                   TxtEmail.setBackground(Color.white);
              }
        if(!TxtEmail.getText().contains("@")){
            JOptionPane.showMessageDialog(this, "Bạn nhập sai dạng Email");
            TxtEmail.setBackground(Color.yellow);
            kt=false;
        }else{
            TxtEmail.setBackground(Color.white);
        }
        try {
            double luong = Double.parseDouble(TxtLuong.getText());
            if(luong < 5000000){
                JOptionPane.showMessageDialog(this, "Lương phải trên 5 triệu");
                 TxtLuong.setBackground(Color.yellow);
                 kt=false;
            }else{
                 TxtLuong.setBackground(Color.white);
            }
        } catch (Exception e) {
             if(TxtLuong.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập lương");
                 TxtLuong.setBackground(Color.yellow);
                 kt=false;
            }else{
                TxtLuong.setBackground(Color.white);
            }
              JOptionPane.showMessageDialog(this, "Lương không đúng định dạng số");
              TxtLuong.setBackground(Color.yellow);
              kt=false;
        }
        if(kt==true){
             NhanVien nv= new NhanVien();
            nv.setMaNV(TxtMaNV.getText());
            nv.setHoTen(TxtHoTen.getText());
            nv.setTuoi(Integer.parseInt(TxtTuoi.getText()));
            nv.setEmail(TxtEmail.getText());
            nv.setLuong(Double.parseDouble(TxtLuong.getText()));
            quanly.themMoi(nv);
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
            TxtMaNV.setText("");
            TxtHoTen.setText("");
            TxtTuoi.setText("");
            TxtEmail.setText("");
            TxtLuong.setText("");
            labeltong.setText(""+quanly.danhsach.size()+"");
            
        }
        }
    }
        public void fillToTable(){
        DefaultTableModel model = (DefaultTableModel) tbHienThi.getModel();
        model.setRowCount(0);
        for(int i = 0; i <quanly.danhsach.size();i++){
            Object[] row = new Object[]{quanly.danhsach.get(i).getMaNV(),quanly.danhsach.get(i).getHoTen(),
            quanly.danhsach.get(i).getTuoi(),quanly.danhsach.get(i).getEmail(),quanly.danhsach.get(i).getLuong()};
            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        TxtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtTuoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtLuong = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHienThi = new javax.swing.JTable();
        bntNew = new javax.swing.JButton();
        bntSave = new javax.swing.JButton();
        bntdetele = new javax.swing.JButton();
        bntfind = new javax.swing.JButton();
        bntOpen = new javax.swing.JButton();
        bntExit = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        bntFist = new javax.swing.JButton();
        bntPre = new javax.swing.JButton();
        bntNext = new javax.swing.JButton();
        bntLast = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        Reconde = new javax.swing.JLabel();
        bntclock = new javax.swing.JButton();
        labeltong = new javax.swing.JLabel();
        labelrecon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setText("MÃ NHÂN VIÊN");

        jLabel3.setText("HỌ TÊN NHÂN VIÊN");

        jLabel4.setText("TUỔI NHÂN VIÊN");

        jLabel5.setText("EMAIL NHÂN VIÊN");

        jLabel6.setText("LƯƠNG NHÂN VIÊN");

        tbHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ NV", "HỌ TÊN NV", "TUÔI NV", "EMAIL NV", "LƯƠNG NV"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHienThiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHienThi);

        bntNew.setText("MỚI");
        bntNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNewActionPerformed(evt);
            }
        });

        bntSave.setText("LƯU");
        bntSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSaveActionPerformed(evt);
            }
        });

        bntdetele.setText("XÓA");
        bntdetele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntdeteleActionPerformed(evt);
            }
        });

        bntfind.setText("TÌM");
        bntfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntfindActionPerformed(evt);
            }
        });

        bntOpen.setText("MỞ");
        bntOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntOpenActionPerformed(evt);
            }
        });

        bntExit.setText("THOÁT");
        bntExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntExitActionPerformed(evt);
            }
        });

        bntFist.setText("ĐẦU TIÊN");
        bntFist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFistActionPerformed(evt);
            }
        });

        bntPre.setText("LÙI");
        bntPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPreActionPerformed(evt);
            }
        });

        bntNext.setText("TIẾN");
        bntNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNextActionPerformed(evt);
            }
        });

        bntLast.setText("CUỐI CÙNG");
        bntLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLastActionPerformed(evt);
            }
        });

        Reconde.setText("NHÂN VIÊN ");

        bntclock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bntclock.setForeground(new java.awt.Color(0, 0, 255));
        bntclock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntclock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntclockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(Reconde))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bntclock, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(labeltong)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bntclock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Reconde)
                .addGap(38, 38, 38)
                .addComponent(labeltong)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        labelrecon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelrecon.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntfind, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(bntNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntSave, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntdetele, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(bntFist)
                .addGap(18, 18, 18)
                .addComponent(bntPre, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntNext, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntLast)
                .addGap(45, 45, 45)
                .addComponent(labelrecon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TxtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntNew)
                    .addComponent(bntSave)
                    .addComponent(bntdetele))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntfind)
                    .addComponent(bntOpen)
                    .addComponent(bntExit))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntFist)
                    .addComponent(bntPre)
                    .addComponent(bntNext)
                    .addComponent(bntLast)
                    .addComponent(labelrecon, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHienThiMouseClicked
        // TODO add your handling code here:
        // bảng hiển thị danh sách nhân viên
        
    }//GEN-LAST:event_tbHienThiMouseClicked

    private void bntNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNewActionPerformed
        // TODO add your handling code here:
        //tạo mới dữ liệu
        bntNew.setMnemonic(KeyEvent.VK_T);
        this.themmoikiemtra();
        this.fillToTable();
    }//GEN-LAST:event_bntNewActionPerformed

    private void bntSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSaveActionPerformed
        // TODO add your handling code here:
        // lưu dữ liệu
        bntSave.setMnemonic(KeyEvent.VK_S);
               JFileChooser saveDig = new JFileChooser();
                saveDig.showSaveDialog(this);
                quanly.ghiFile(saveDig.getSelectedFile());
    }//GEN-LAST:event_bntSaveActionPerformed

    private void bntdeteleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntdeteleActionPerformed
        // TODO add your handling code here:
        // Xóa
        bntdetele.setMnemonic(KeyEvent.VK_X);
        String xoa=JOptionPane.showInputDialog(this, "Nhập Mã NV cần xóa");
        JOptionPane.showMessageDialog(this, xoa);
      
        quanly.xoaById(xoa);

      this.fillToTable();
    }//GEN-LAST:event_bntdeteleActionPerformed

    private void bntfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntfindActionPerformed
        // TODO add your handling code here:
        // Tìm
         bntfind.setMnemonic(KeyEvent.VK_Q);
        String vao=JOptionPane.showInputDialog(this,"Nhập ID nhân viên cần tìm");
        int vt=quanly.timKiemById(vao);
        if(vt!=-1){
            TxtMaNV.setText(quanly.danhsach.get(vt).getMaNV());
            TxtHoTen.setText(quanly.danhsach.get(vt).getHoTen());
            TxtTuoi.setText(""+ quanly.danhsach.get(vt).getTuoi()+"");
            TxtEmail.setText(quanly.danhsach.get(vt).getEmail());
             TxtLuong.setText("" +quanly.danhsach.get(vt).getLuong()+"");
        }else{
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
        }
    }//GEN-LAST:event_bntfindActionPerformed

    private void bntOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntOpenActionPerformed
        // TODO add your handling code here:
        // Mở
        bntOpen.setMnemonic(KeyEvent.VK_O);
        JFileChooser openDig= new JFileChooser();
       openDig.showOpenDialog(this);
       quanly.docFile(openDig.getSelectedFile());
       if(quanly.getDanhsach().size()!=0){
        List=0;
        TxtMaNV.setText(quanly.danhsach.get(List).getMaNV());
        TxtHoTen.setText(quanly.danhsach.get(List).getHoTen());
        TxtTuoi.setText(String.valueOf(quanly.danhsach.get(List).getTuoi()));
        TxtEmail.setText(quanly.danhsach.get(List).getEmail());
        TxtLuong.setText(String.valueOf(quanly.danhsach.get(List).getLuong()));
        quanly.setVitrihienhanh(ICONIFIED);
        JOptionPane.showMessageDialog(null, "Mở dữ liệu trong file  thành công");
        }else{
            JOptionPane.showMessageDialog(null, "File Trống");
       }
        labeltong.setText(""+quanly.danhsach.size()+"");
        this.fillToTable();
    }//GEN-LAST:event_bntOpenActionPerformed

    private void bntExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntExitActionPerformed
        // TODO add your handling code here:
        // Thoát
         bntExit.setMnemonic(KeyEvent.VK_Z);
        int chon= JOptionPane.showConfirmDialog(this,"Bạn có muốn lưu dư liệu không?");
                switch(chon){
                    case 0://yes
                        int select = rc.showSaveDialog(this);
                        if (select == JFileChooser.APPROVE_OPTION)
                        {
            
                            quanly.ghiFile(rc.getSelectedFile());
                        } 
                    case 1:
                        System.exit(0);
                    case 2:
                        break;
                }
    }//GEN-LAST:event_bntExitActionPerformed

    private void bntFistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFistActionPerformed
        // TODO add your handling code here:
        //dautien
        hienthi(quanly.first());
       qlnhanvien=1;
       labelrecon.setText("" +1+ "");
    }//GEN-LAST:event_bntFistActionPerformed

    private void bntPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPreActionPerformed
        // TODO add your handling code here:
        labelrecon.setText("" +(quanly.getVitrihienhanh() +1)+ "");
        hienthi(quanly.previous());  
        
    }//GEN-LAST:event_bntPreActionPerformed

    private void bntNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNextActionPerformed
        // TODO add your handling code here:
        qlnhanvien= qlnhanvien>=quanly.danhsach.size()-1?quanly.danhsach.size():++qlnhanvien;
       hienthi(quanly.next());
       labelrecon.setText(""+qlnhanvien+"");
    }//GEN-LAST:event_bntNextActionPerformed

    private void bntLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLastActionPerformed
        // TODO add your handling code here:
        hienthi(quanly.last());
       labelrecon.setText("" +quanly.danhsach.size()+ "");
    }//GEN-LAST:event_bntLastActionPerformed

    private void bntclockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntclockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntclockActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Reconde;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtHoTen;
    private javax.swing.JTextField TxtLuong;
    private javax.swing.JTextField TxtMaNV;
    private javax.swing.JTextField TxtTuoi;
    private javax.swing.JButton bntExit;
    private javax.swing.JButton bntFist;
    private javax.swing.JButton bntLast;
    private javax.swing.JButton bntNew;
    private javax.swing.JButton bntNext;
    private javax.swing.JButton bntOpen;
    private javax.swing.JButton bntPre;
    private javax.swing.JButton bntSave;
    private javax.swing.JButton bntclock;
    private javax.swing.JButton bntdetele;
    private javax.swing.JButton bntfind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelrecon;
    private javax.swing.JLabel labeltong;
    private javax.swing.JTable tbHienThi;
    // End of variables declaration//GEN-END:variables
}
