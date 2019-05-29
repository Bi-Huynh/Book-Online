/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dal.DanhSach_DAL;
import dto.DatSach_DTO;
import dto.Sach_DTO;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmUser extends javax.swing.JFrame {

    DefaultTableModel model = null;

    /**
     * Creates new form FrmUser
     */
    public FrmUser() {
        initComponents();
        model = (DefaultTableModel) tblSachUser.getModel();
        hienThi(DanhSach_DAL.getGetDS_SACH_DTOs());
    }

    private void hienThi(ArrayList<Sach_DTO> dsArrayList) {
        model.setRowCount(0);
        for (Sach_DTO sach : dsArrayList) {
            model.addRow(new Object[]{
                sach.getMaSach(),
                sach.getTenSach(),
                sach.getTheLoai(),
                sach.getTacGia(),
                sach.getNhaXuatBan(),
                sach.getNgayXuatBan().toString(),
                sach.getSoLuong(),
                sach.getGiaThanh()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbLoc = new javax.swing.JComboBox<>();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        cmbSapXep = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        btnDatSach = new javax.swing.JButton();
        cmbTimKiem = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSachUser = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lọc sách theo", "Van Hoc", "IT", "Khoa Hoc", "Toan Hoc" }));
        cmbLoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLocItemStateChanged(evt);
            }
        });

        jLabel2.setText("Sắp xếp :");

        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        cmbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp theo", "Giá tăng", "Giá giảm" }));
        cmbSapXep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSapXepItemStateChanged(evt);
            }
        });

        txtTimKiem.setText("Tìm kiếm");
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });

        btnDatSach.setText("Đặt");
        btnDatSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatSachActionPerformed(evt);
            }
        });

        cmbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn mục tìm kiếm", "Mã", "Tác giả", "Tên sách" }));

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblSachUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên sách", "Thể loại", "Tác giả", "Nhà xuất bản", "Ngày xuất bản", "Số lượng", "Giá thành"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSachUser);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ĐẶT SÁCH");

        jLabel4.setText("Họ tên :");

        jLabel5.setText("Số điện thoại : ");

        jLabel6.setText("Email : ");

        jLabel7.setText("Mã Sách : ");

        jLabel8.setText("Tên sách : ");

        jLabel9.setText("Số lượng : ");

        jLabel1.setText("Lọc : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDatSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTenSach)
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtMaSach, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cmbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLoc)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnDatSach))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
        hàm dùng để cho Admin đăng nhập
        Mô tả: hàm sẽ gọi hàm kiểm tra thông tin tài khoản nếu trả về true thì
        hiển thị giao diện người của Admin
     */
    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed

//        String userName = txtUserName.getText();
//        String passWord = txtPass.getText();
//
//        if (DanhSach_DAL.kiemTraTaiKhoan(userName, passWord)) {
//            new FrmAdmin(userName).setVisible(true);
//            this.hide();
//        } else {
//            JOptionPane.showMessageDialog(null, "Thông tin tài khoản không hợp lệ");
//            txtUserName.setText("");
//            txtPass.setText("");
//        }
        new FrmAdmin("huynhtrungduc@gmail.com").setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    /*
        hàm thêm thông tin sách vào
        Mô tả: hàm sẽ lấy thông tin sách được nhập trên các trường dữ liệu
        và đưa vào datsach rồi thêm cái datsach đó vào trong danh sách đặt sách
     */
    private void btnDatSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatSachActionPerformed
        DatSach_DTO datSach = new DatSach_DTO(
                txtHoTen.getText(),
                txtSDT.getText(),
                txtEmail.getText(),
                txtMaSach.getText(),
                txtTenSach.getText(),
                Integer.parseInt(txtSoLuong.getText())
        );

        DanhSach_DAL.themDatSach(datSach);

        txtHoTen.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtSoLuong.setText("");
    }//GEN-LAST:event_btnDatSachActionPerformed

    /*
        hàm sẽ tìm kiếm theo thông tin mà người dùng đã lựa chọn
        Mô tả: người dùng chọn thông tin nào thì nó sẽ tìm kiếm theo giá trị
        người dùng chọn trên cmbTimKiem, lấy giá trị của txtTimKiem để tìm quyển
        sách có giá trị mà người dùng muốn tìm
     */
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        Sach_DTO sach = null;
        switch (cmbTimKiem.getSelectedItem().toString()) {
            case "Mã":
                sach = DanhSach_DAL.getSach_MaSach(txtTimKiem.getText());
                if (sach == null) {
                    JOptionPane.showMessageDialog(null, "Không tồn tại sách");
                } else {
                    JOptionPane.showMessageDialog(null, sach.toString());
                }
                break;
            case "Tác giả":
                sach = DanhSach_DAL.getSach_TacGia(txtTimKiem.getText());
                if (sach == null) {
                    JOptionPane.showMessageDialog(null, "Không tồn tại sách");
                } else {
                    JOptionPane.showMessageDialog(null, sach.toString());       // tại sao chỗ này không toString được
                }
                break;
            case "Tên sách":
                sach = DanhSach_DAL.getSach_TenSach(txtTimKiem.getText());
                if (sach == null) {
                    JOptionPane.showMessageDialog(null, "Không tồn tại sách");
                } else {
                    JOptionPane.showMessageDialog(null, sach.toString());
                }
                break;
            default:
                throw new AssertionError();
        }
        txtTimKiem.setText("");
        cmbTimKiem.setSelectedIndex(0);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cmbSapXepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSapXepItemStateChanged
        ArrayList<Sach_DTO> temp = (ArrayList<Sach_DTO>) DanhSach_DAL.getGetDS_SACH_DTOs().clone();
        Collections.sort(temp);

        switch (cmbSapXep.getSelectedItem().toString()) {
            case "Giá tăng":
                hienThi(temp);
                break;
            case "Giá giảm":
                Collections.reverse(temp);
                hienThi(temp);
                break;
            default:
                hienThi(DanhSach_DAL.getGetDS_SACH_DTOs());
        }
    }//GEN-LAST:event_cmbSapXepItemStateChanged

    private void cmbLocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLocItemStateChanged
        ArrayList<Sach_DTO> temp = new ArrayList<>();
        String theLoai = cmbLoc.getSelectedItem().toString();

        if (!theLoai.equals("Lọc sách theo")) {
            for (Sach_DTO sach : DanhSach_DAL.getGetDS_SACH_DTOs()) {
                if (sach.getTheLoai().equals(theLoai)) {
                    temp.add(sach);
                }
            }
        } else {
            temp = DanhSach_DAL.getGetDS_SACH_DTOs();
        }
        hienThi(temp);
    }//GEN-LAST:event_cmbLocItemStateChanged

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnDatSach;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cmbLoc;
    private javax.swing.JComboBox<String> cmbSapXep;
    private javax.swing.JComboBox<String> cmbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSachUser;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
