/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dal.DanhSach_DAL;
import dto.Sach_DTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmAdmin extends javax.swing.JFrame {

    DefaultTableModel model;
    Sach_DTO selectSach = null;

    /**
     * Creates new form FrmAdmin
     */
    //public FrmAdmin(String nameAdmin)
    public FrmAdmin() {
        initComponents();
        //labTenAdmin.setText(nameAdmin);
        model = (DefaultTableModel) tblSach.getModel();

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        cmbTheLoai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtTenTacGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNhaXuatBan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dteNgayXuatBan = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        labTenAdmin = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtGiaThanh = new javax.swing.JTextField();
        btnFrmUser = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        cmbTimKiem = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmbLoc = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbSapXep = new javax.swing.JComboBox<>();
        btnTTDatSach = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        btnDSSachXoa = new javax.swing.JButton();

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

        jLabel1.setText("Mã Sách : ");

        jLabel2.setText("Tên Sách : ");

        cmbTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Van Hoc", "IT", "Khoa Hoc", "Toan Hoc", "Ly Hoc", "Thien Van Hoc", "Co Ngu Hoc" }));

        jLabel3.setText("Tác Giả : ");

        jLabel4.setText("Nhà Xuất Bản : ");

        jLabel5.setText("Ngày Xuất Bản : ");

        jLabel6.setText("Thể Loại : ");

        jLabel7.setText("Số Lượng : ");

        jLabel8.setFont(new java.awt.Font("Magneto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 204, 255));
        jLabel8.setText("WELCOME ADMIN : ");

        labTenAdmin.setFont(new java.awt.Font("Magneto", 1, 18)); // NOI18N
        labTenAdmin.setForeground(new java.awt.Color(255, 51, 51));
        labTenAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTenAdmin.setText("-----");

        jLabel9.setText("Giá Thành : ");

        btnFrmUser.setText("Hiển thị giao diện User");
        btnFrmUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFrmUserActionPerformed(evt);
            }
        });

        cmbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn mục tìm kiếm", "Mã", "Tác giả", "Tên sách" }));

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        btnTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTimKiemKeyPressed(evt);
            }
        });

        btnThem.setText("Thêm Sách");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        btnThem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnThemKeyPressed(evt);
            }
        });

        btnXoa.setText("Xóa Sách");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        btnXoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnXoaKeyPressed(evt);
            }
        });

        btnSua.setText("Sửa Sách");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        btnSua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSuaKeyPressed(evt);
            }
        });

        jLabel10.setText("Lọc : ");

        cmbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lọc sách theo", "Van Hoc", "IT", "Khoa Hoc", "Toan Hoc" }));
        cmbLoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLocItemStateChanged(evt);
            }
        });

        jLabel11.setText("Sắp xếp :");

        cmbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp theo", "Giá tăng", "Giá giảm" }));
        cmbSapXep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSapXepItemStateChanged(evt);
            }
        });

        btnTTDatSach.setText("Xem thông tin đặt sách");
        btnTTDatSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTDatSachActionPerformed(evt);
            }
        });

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Thể Loại", "Tác Giả", "Nhà Xuất Bản", "Ngày Xuất Bản", "Số Lượng", "Giá Thành"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSach);

        btnDSSachXoa.setText("Danh Sách Sách Đã Xóa");
        btnDSSachXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDSSachXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuong))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtGiaThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNhaXuatBan)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTenTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dteNgayXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 16, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTTDatSach, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDSSachXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labTenAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFrmUser, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(labTenAdmin))
                        .addComponent(btnDSSachXoa, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnTTDatSach, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(cmbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtTenTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(dteNgayXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtGiaThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(cmbLoc)
                        .addComponent(jLabel11)
                        .addComponent(cmbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFrmUser))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFrmUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFrmUserActionPerformed
        new FrmUser().setVisible(true);
    }//GEN-LAST:event_btnFrmUserActionPerformed

    private void btnTTDatSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTDatSachActionPerformed
        new FrmDatSach().setVisible(true);
    }//GEN-LAST:event_btnTTDatSachActionPerformed

    private void btnDSSachXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDSSachXoaActionPerformed
        new FrmSachDaXoa().setVisible(true);
    }//GEN-LAST:event_btnDSSachXoaActionPerformed

    private void themSach() {

        java.util.Date date = dteNgayXuatBan.getDate();
        java.sql.Date date1 = new Date(date.getTime());

        Sach_DTO sach;
        sach = new Sach_DTO(
                txtMaSach.getText(),
                txtTenSach.getText(),
                cmbTheLoai.getSelectedItem().toString(),
                txtTenTacGia.getText(),
                txtNhaXuatBan.getText(),
                date1,
                Integer.parseInt(txtSoLuong.getText()),
                Integer.parseInt(txtSoLuong.getText())
        );

        if (DanhSach_DAL.themSach(sach)) {
            JOptionPane.showMessageDialog(null, "Thêm sách thành công");
            hienThi(DanhSach_DAL.getGetDS_SACH_DTOs());
        } else {
            JOptionPane.showMessageDialog(null, "Thêm sách thất bại");
        }
        txtMaSach.setVisible(true);
        selectSach = null;
    }

    // sự kiện click chuột
    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        themSach();
    }//GEN-LAST:event_btnThemMouseClicked

    // sự kiện cho nút enter
    private void btnThemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnThemKeyPressed
        if (evt.getKeyChar() == '\n') {
            themSach();
        }
    }//GEN-LAST:event_btnThemKeyPressed

    private void xoaSach() {
        if (selectSach == null) {
            return;
        }
        DanhSach_DAL.xoaSach(selectSach.getMaSach());
        hienThi(DanhSach_DAL.getGetDS_SACH_DTOs());
        txtMaSach.setVisible(true);
        selectSach = null;
    }

    // sự kiện cho nút enter
    private void btnXoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnXoaKeyPressed
        if (evt.getKeyChar() == '\n') {
            xoaSach();
        }
    }//GEN-LAST:event_btnXoaKeyPressed

    // sự kiện click chuột
    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        xoaSach();
    }//GEN-LAST:event_btnXoaMouseClicked

    private void suaSach() {
        java.util.Date date = dteNgayXuatBan.getDate();
        java.sql.Date date1 = new Date(date.getTime());

        Sach_DTO sach = new Sach_DTO(
                txtMaSach.getText(),
                txtTenSach.getText(),
                cmbTheLoai.getSelectedItem().toString(),
                txtTenTacGia.getText(),
                txtNhaXuatBan.getText(),
                date1,
                Integer.parseInt(txtSoLuong.getText()),
                Integer.parseInt(txtGiaThanh.getText())
        );
        if (!DanhSach_DAL.kiemTraTTSach(sach)) {        //
            JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ");
        } else {
            DanhSach_DAL.suaSach(sach);
            hienThi(DanhSach_DAL.getGetDS_SACH_DTOs());
        }
        txtMaSach.setText("");
        txtTenSach.setText("");
        cmbTheLoai.setSelectedIndex(0);
        txtTenTacGia.setText("");
        txtNhaXuatBan.setText("");
        dteNgayXuatBan.setDate(null);
        txtSoLuong.setText("");
        txtGiaThanh.setText("");
        txtMaSach.setVisible(true);
        selectSach = null;
    }

    // sự kiện click chuột
    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        suaSach();
    }//GEN-LAST:event_btnSuaMouseClicked

    // sự kiện cho nút enter
    private void btnSuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSuaKeyPressed
        if (evt.getKeyChar() == '\n') {
            suaSach();
        }
    }//GEN-LAST:event_btnSuaKeyPressed

    private void timKiem() {
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
    }

    // sự kiện click chuột
    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        timKiem();
    }//GEN-LAST:event_btnTimKiemMouseClicked

    // sự kiện cho nút enter
    private void btnTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTimKiemKeyPressed
        if (evt.getKeyChar() == '\n') {
            timKiem();
        }
    }//GEN-LAST:event_btnTimKiemKeyPressed

    // sự kiện chọn giá trị
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

    // sự kiện chọn giá trị
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

    // sự kiện click chuột
    // không thể lấy được giá trị khi đang sắp xếp
    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        int index = tblSach.getSelectedRow();
        selectSach = DanhSach_DAL.getSach_MaSach(tblSach.getValueAt(index, 0).toString());
        txtMaSach.setText(selectSach.getMaSach());
        txtMaSach.setEnabled(false);
        txtTenSach.setText(selectSach.getTenSach());
        cmbTheLoai.setSelectedItem(selectSach.getTheLoai());
        txtTenTacGia.setText(selectSach.getTacGia());
        txtNhaXuatBan.setText(selectSach.getNhaXuatBan());
        dteNgayXuatBan.setDate(selectSach.getNgayXuatBan());
        txtSoLuong.setText(selectSach.getSoLuong() + "");
        txtGiaThanh.setText(selectSach.getGiaThanh() + "");
    }//GEN-LAST:event_tblSachMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        java.util.Date date = dteNgayXuatBan.getDate();
        java.sql.Date date1 = new Date(date.getTime());

        Sach_DTO sach;
        sach = new Sach_DTO(
                txtMaSach.getText(),
                txtTenSach.getText(),
                cmbTheLoai.getSelectedItem().toString(),
                txtTenTacGia.getText(),
                txtNhaXuatBan.getText(),
                date1,
                Integer.parseInt(txtSoLuong.getText()),
                Integer.parseInt(txtSoLuong.getText())
        );

        if (DanhSach_DAL.themSach(sach)) {
            JOptionPane.showMessageDialog(null, "Thêm sách thành công");
            hienThi(DanhSach_DAL.getGetDS_SACH_DTOs());
        } else {
            JOptionPane.showMessageDialog(null, "Thêm sách thất bại");
        }
        txtMaSach.setVisible(true);
        selectSach = null;

    }//GEN-LAST:event_btnThemActionPerformed

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
                //new FrmAdmin(nameAdmin).setVisible(true);
                new FrmAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDSSachXoa;
    private javax.swing.JButton btnFrmUser;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTTDatSach;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbLoc;
    private javax.swing.JComboBox<String> cmbSapXep;
    private javax.swing.JComboBox<String> cmbTheLoai;
    private javax.swing.JComboBox<String> cmbTimKiem;
    private com.toedter.calendar.JDateChooser dteNgayXuatBan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labTenAdmin;
    private javax.swing.JTable tblSach;
    private javax.swing.JTextField txtGiaThanh;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTenTacGia;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
