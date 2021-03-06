/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StudentModify;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Student;

/**
 *
 * @author Nam Anh
 */
public class SinhVienManagePanel extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    List<Student> studentList = new ArrayList <>();
    static Student s;
    private JFrame parentJFrame;
    /**
     * Creates new form SinhVienManagePanel
     * @param parentFrame
     */
    public SinhVienManagePanel(JFrame parentFrame) {
        this.parentJFrame = parentFrame;
        initComponents();
        
        tableModel = (DefaultTableModel) tblStudent.getModel(); 
        showStudent();
    }
    
    public void refresh(){
        showStudent();
    }
    
    public void showStudent() {
        studentList = StudentModify.findAll();
        
        tableModel.setRowCount(0);
        
        studentList.forEach(student -> {
            tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, student.getId(),student.getFullname(),
                student.getGender(), student.getBirth(), student.getEmail(), student.getPhone_number()});
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnFindByName = new javax.swing.JButton();
        btnFindByID = new javax.swing.JButton();
        btnFindGender = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Quản lý sinh viên");

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Chỉnh sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã số sinh viên", "Họ tên", "Giới tính", "Ngày sinh", "Email", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        btnFindByName.setText("Theo tên");
        btnFindByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindByNameActionPerformed(evt);
            }
        });

        btnFindByID.setText("Theo MSSV");
        btnFindByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindByIDActionPerformed(evt);
            }
        });

        btnFindGender.setText("Theo giới tính");
        btnFindGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindGenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btnFindByName, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btnFindByID)
                .addGap(78, 78, 78)
                .addComponent(btnFindGender)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFindByName)
                    .addComponent(btnFindByID)
                    .addComponent(btnFindGender))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(btnEdit)
                        .addGap(80, 80, 80)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd)
                    .addComponent(btnRefresh))
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
//        JFrame jFramee = new JFrame();
//        Container con = jFramee.getContentPane();
//        AddFrame addFrame = new AddFrame(this.parentJFrame);
//        con.add(addFrame);
        //dispose();
        AddFrame addFrame = new AddFrame(this.parentJFrame, this);
        addFrame.setVisible(true);
        addFrame.setLocationRelativeTo(null);
        addFrame.setResizable(false);
        
        //stdFrame.setVisible(true);
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblStudent.getSelectedRow();
        if(selectedIndex >= 0) {
            s = studentList.get(selectedIndex);
            //dispose();
            EditFrame editFrame= new EditFrame(this.parentJFrame, this);
            editFrame.setVisible(true);
            editFrame.setLocationRelativeTo(null);
            editFrame.setResizable(false);
        }
        else {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một sinh viên...");
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblStudent.getSelectedRow();
        if (selectedIndex >=0) {
            Student std = studentList.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa sinh viên này?");

            if (option ==0) {
                StudentModify.delete(std.getId());
                showStudent();
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một sinh viên...");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFindByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindByNameActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this, "Nhập tên sinh viên cần tìm");
        if(input != null && input.length() > 0) {
            studentList = StudentModify.findByFullName(input);
            tableModel.setRowCount(0);
            studentList.forEach(student -> {
                tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, student.getId(),student.getFullname(),
                    student.getGender(), student.getBirth(), student.getEmail(), student.getPhone_number()});
        });
        }
        else {
            //tableModel = null;
            JOptionPane.showMessageDialog(this, "Tên sinh viên trống...");
        }
        //        dispose();
        //        FindFrame findFrame = new FindFrame();
        //        findFrame.setVisible(true);
    }//GEN-LAST:event_btnFindByNameActionPerformed

    private void btnFindByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindByIDActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this, "Nhập mã số sinh viên cần tìm");
        if(input != null && input.length() > 0) {
            try {
                int id = Integer.parseInt(input);
                studentList = StudentModify.findByID(id);

                tableModel.setRowCount(0);

                studentList.forEach((student) -> {
                    tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, student.getId(), student.getFullname(),
                        student.getGender(), student.getBirth(), student.getEmail(), student.getPhone_number()});
            });
        } catch(Exception e){
            //showStudent();
            JOptionPane.showMessageDialog(this, "Mã số sinh viên phải là số...");
        }

        } else {
            //showStudent();
            JOptionPane.showMessageDialog(this, "Mã số sinh viên trống...");
        }
    }//GEN-LAST:event_btnFindByIDActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        showStudent();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnFindGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindGenderActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this, "Nhập giới tính: ");
        if(input != null && input.length() > 0) {
            studentList = StudentModify.findByGender(input);
            tableModel.setRowCount(0);
            studentList.forEach(student -> {
                tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, student.getId(),student.getFullname(),
                    student.getGender(), student.getBirth(), student.getEmail(), student.getPhone_number()});
        });
        }
        else {
            //tableModel = null;
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giới tính...");
        }
    }//GEN-LAST:event_btnFindGenderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFindByID;
    private javax.swing.JButton btnFindByName;
    private javax.swing.JButton btnFindGender;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudent;
    // End of variables declaration//GEN-END:variables
}
