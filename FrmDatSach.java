/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mysql.fabric.xmlrpc.base.Data;
import com.toedter.calendar.demo.TestDateEvaluator;
import dal.DanhSach_DAL;
import dal.Sach_DAL;
import dto.DatSach_DTO;
import dto.Sach_DTO;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmDatSach extends javax.swing.JFrame {// khai báo danh sách sách
    ArrayList<DatSach_DTO> DS_DatSach = null;
    ArrayList<Sach_DTO> DS_Sach = null;
    DefaultListModel modelLst = null;
    DefaultTableModel modelTbl = null;
    DatSach_DTO selectDatSach= null;
    private int dem=0; // khai báo hàm dem dể có thể tìm danh sách của Sách

    
    public FrmDatSach() {// khai báo hàm model và hàm hiển thị thông tin dịch vụ trong ArrayList lên ListView
        initComponents();
        modelLst = new DefaultListModel();
        modelTbl=(DefaultTableModel) tblDatSach.getModel();
        
        
        if(DS_DatSach != null){
            hienthiDatSach();
        }
        
        if(DS_Sach!=null){
            hienthisach();
        }
        
        
        
    }
    
    
    
    void hienthisach(){// hàm hiển thị thông tin sách đã xóa qua form sách đã xóa
        // hàm này đang nghiên cứu
        
    }
    
    void hienthiDatSach(){
        modelTbl.setRowCount(0);
        for(DatSach_DTO DS:DS_DatSach){
            modelTbl.addRow(new Object[]{//khai báo từng biến có trong giao diện
                DS.getHoTen(),
                DS.getSdt(),
                DS.getEmail(),
                DS.getMaSach(),
                DS.getTenSach(),
                DS.getSoLuong(),
            
            });
        }    
            
    }
    private void format_TruongDuLieu() {
        selectDatSach=null;
    }//hàm dùng để phục vụ chuyển chuỗi dịch vụ trên table sang danh sách dịch
    //* vụ vì list trả về 1 danh sách String dịch vụ nên phải chuyển về danh sách
     //* dịch vụ
     //*
     //* @return ArrayList<DDatSach_DTO>
    public boolean delete() {
    int i;
    for(i=0; i<dem; i++)// cho biến i vào vòng lập, nếu i bé hơn biến dem thì nó sẽ xuất ra danh sách sách đã đặt 
        if(selectDatSach==null) { //tìm vị trị của sách trong mảng
            break;
        }
    if(i==dem) //không tìm thấy mã sinh viên cần xoá
        return false;
    for(int j=i; j<dem-1; j++) //cập nhật lại mảng
        j=j+1;
    dem--;
    return true;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnXoaAll = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatSach = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Magneto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ordered Book List");

        btnXoaAll.setText("Xóa Tất Cả");
        btnXoaAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaAllMouseClicked(evt);
            }
        });
        btnXoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAllActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblDatSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Người Đặt", "Số Điện Thoại", "Email", "Mã Sách", "Tên Sách", "Số Lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDatSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaAll)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
         if(selectDatSach==null){// nếu hàm select = null thì nó sẽ trả về return
            return;
        }
        DanhSach_DAL.xoaDatSach(selectDatSach);
        int index = tblDatSach.getSelectedRow();// khai báo phần giao diện để khi click chuột vào
        if (index == -1) {// nếu phần index bằng 0 thì nó sẽ return đi vì trong bảng giao diện ko dc bằng 0
            return;
        }
        selectDatSach= null;// sách hiện tại = null
        // đưa toàn bộ giá trị của thằng được chọn lên trên các trường dữ liệu
        int[] dsSDDSelect = new int[7]; // danh sách Sách Đã Đặt
        int j = 0;
        for (DatSach_DTO i : DS_DatSach) { // lặp lại phần các danh sách đã đặt lên giao diện
            dsSDDSelect[j] = i.getSoLuong() - 1;
            j++;
        }
        
        //hàm này ko biết, làm đại
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnXoaAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaAllMouseClicked
        if (selectDatSach!=null) {
            Sach_DAL.deleteDatSach(toString());
            selectDatSach = null;
            hienthiDatSach();//hàm xóa tất cả sách trong thư mục
            
        }
        int index = tblDatSach.getSelectedRow();// khai báo phần giao diện để khi click chuột vào
        if (index == -1) {// nếu phần index bằng 0 thì nó sẽ return đi vì trong bảng giao diện ko dc bằng 0
            return;
        }
        selectDatSach= null;// sách hiện tại = null
        // đưa toàn bộ giá trị của thằng được chọn lên trên các trường dữ liệu
        int[] dsSDDSelect = new int[7]; // danh sách Sách Đã Đặt
        int j = 0;
        for (DatSach_DTO i : DS_DatSach) { // lặp lại phần các danh sách đã đặt lên giao diện
            dsSDDSelect[j] = i.getSoLuong() - 1;
            j++;
        }
        // hàm khi click vào 1 quyển sách thì nó sẽ xóa
        //hàm này ko biết, làm đại
    }//GEN-LAST:event_btnXoaAllMouseClicked

    private void tblDatSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatSachMouseClicked
        int index = tblDatSach.getSelectedRow();// khai báo phần giao diện để khi click chuột vào
        if (index == -1) {// nếu phần index bằng 0 thì nó sẽ return đi vì trong bảng giao diện ko dc bằng 0
            return;
        }
        selectDatSach= null;// sách hiện tại = null
        // đưa toàn bộ giá trị của thằng được chọn lên trên các trường dữ liệu
        int[] dsSDDSelect = new int[7]; // danh sách Sách Đã Đặt
        int j = 0;
        for (DatSach_DTO i : DS_DatSach) { // lặp lại phần các danh sách đã đặt lên giao diện
            dsSDDSelect[j] = i.getSoLuong() - 1;
            j++;
        }
        // hàm khi click vào 1 quyển sách thì nó sẽ xóa
    }//GEN-LAST:event_tblDatSachMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if(selectDatSach==null){// nếu hàm select = null thì nó sẽ trả về return
            return;
        }
        DanhSach_DAL.xoaDatSach(selectDatSach);//
        hienthiDatSach();// khi xóa 1 quyển sách thì nó sẽ hiển thị lên màn hình giao diện
        
        selectDatSach=null;// tại đây selectDatSach=null
        //hàm xóa 1 quyển sách đã đặt
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAllActionPerformed
        if (selectDatSach!=null) {
            Sach_DAL.deleteDatSach(toString());
            selectDatSach = null;
            hienthiDatSach();//hàm xóa tất cả sách trong thư mục
        }
    }//GEN-LAST:event_btnXoaAllActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatSach;
    // End of variables declaration//GEN-END:variables
}
