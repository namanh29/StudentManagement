/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;

/**
 *
 * @author Nam Anh
 */
public class HomeController {
    private JLabel tongSinhVienLb;
    private JLabel tongHocPhanLb;
    private JLabel tongsvGioi;
    private JLabel tongsvKha;
    private JLabel tongsvTB;
    private JLabel tongsvKem;

    public HomeController(JLabel tongSinhVienLb, JLabel tongHocPhan, JLabel tongsvGioi, JLabel tongsvKha, JLabel tongsvTB, JLabel tongsvKem) {
        this.tongSinhVienLb = tongSinhVienLb;
        this.tongHocPhanLb = tongHocPhan;
        this.tongsvGioi = tongsvGioi;
        this.tongsvKha = tongsvKha;
        this.tongsvTB = tongsvTB;
        this.tongsvKem = tongsvKem;
    }
    
    public void setData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            String query = "SELECT COUNT(*) AS tong FROM student";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongSinhVienLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM subject";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongHocPhanLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT count(*) as tong from (select sum(sb.credit*rs.grade4)/sum(sb.credit) as cpa\n" +
                    "from result rs, subject sb\n" +
                    "where rs.sid = sb.sid \n" +
                    "group by rs.id\n" +
                    "having cpa >= 3.2) as a";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongsvGioi.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT count(*) as tong from (select sum(sb.credit*rs.grade4)/sum(sb.credit) as cpa\n" +
                    "from result rs, subject sb\n" +
                    "where rs.sid = sb.sid \n" +
                    "group by rs.id\n" +
                    "having cpa < 3.2 and cpa >= 2.5) as a";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongsvKha.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT count(*) as tong from (select sum(sb.credit*rs.grade4)/sum(sb.credit) as cpa\n" +
                    "from result rs, subject sb\n" +
                    "where rs.sid = sb.sid \n" +
                    "group by rs.id\n" +
                    "having cpa < 2.5 and cpa >= 1.5) as a";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongsvTB.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT count(*) as tong from (select sum(sb.credit*rs.grade4)/sum(sb.credit) as cpa\n" +
                    "from result rs, subject sb\n" +
                    "where rs.sid = sb.sid \n" +
                    "group by rs.id\n" +
                    "having cpa < 1.5) as a";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongsvKem.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
    }

    public JLabel getTongSinhVienLb() {
        return tongSinhVienLb;
    }

    public void setTongSinhVienLb(JLabel tongSinhVienLb) {
        this.tongSinhVienLb = tongSinhVienLb;
    }

    public JLabel getTongHocPhanLb() {
        return tongHocPhanLb;
    }

    public void setTongHocPhanLb(JLabel tongHocPhanLb) {
        this.tongHocPhanLb = tongHocPhanLb;
    }

    public JLabel getTongsvGioi() {
        return tongsvGioi;
    }

    public void setTongsvGioi(JLabel tongsvGioi) {
        this.tongsvGioi = tongsvGioi;
    }

    public JLabel getTongsvKha() {
        return tongsvKha;
    }

    public void setTongsvKha(JLabel tongsvKha) {
        this.tongsvKha = tongsvKha;
    }

    public JLabel getTongsvTB() {
        return tongsvTB;
    }

    public void setTongsvTB(JLabel tongsvTB) {
        this.tongsvTB = tongsvTB;
    }
    
    
}
