/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cpa;

/**
 *
 * @author Nam Anh
 */
public class CpaModify {
    public static List<Cpa> findAll(){
        List<Cpa> cpaList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            
            String sql= "select rs.id, st.fullname, sum(sb.credit) as tongsotc, sum(sb.credit*rs.grade4)/sum(sb.credit) as cpa, "
                    + " (select sum(IFNull(credit,0)) from result rs1, subject sb1 where rs1.sid = sb1.sid and rs1.id = rs.id and rs1.grade4 > 0 group by rs1.id) as tctichluy "
                    + " from result rs, subject sb, student st" 
                    + " where rs.id = st.id and rs.sid = sb.sid" 
                    + " GROUP BY rs.id";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Cpa cpa;
                cpa = new Cpa(resultSet.getInt("rs.id"),
                        resultSet.getString("st.fullname"),
                        resultSet.getInt("tongsotc"),
                        resultSet.getInt("tctichluy"),
                        resultSet.getFloat("cpa"));
                        
                cpaList.add(cpa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cpaList;
    }
}
