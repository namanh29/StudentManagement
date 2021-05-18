/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Subject;
/**
 *
 * @author Nam Anh
 */
public class SubjectModify {
    public static List<Subject> findAll(){
        List<Subject> subjectList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "select * from subject";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Subject sbj;
                sbj = new Subject(resultSet.getString("sid"),
                        resultSet.getString("sname"),
                        resultSet.getString("school"),
                        resultSet.getString("lecturer"),
                        resultSet.getInt("credit"),
                        resultSet.getFloat("weight"));
                        
                subjectList.add(sbj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return subjectList;
    }
    
    public static void insert(Subject sbj) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "insert into subject(sid, sname, school, lecturer, credit, weight) values(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, sbj.getSid());
            statement.setString(2, sbj.getSname());
            statement.setString(3, sbj.getSchool());    
            statement.setString(4, sbj.getLecturer());
            statement.setInt(5, sbj.getCredit());
            statement.setFloat(6, sbj.getWeight());
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(Subject sbj) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "update subject set sname=?,school=?,lecturer=?, credit=?, weight=? where sid = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, sbj.getSname());
            statement.setString(2, sbj.getSchool());
            statement.setString(3, sbj.getLecturer());
            statement.setInt(4, sbj.getCredit());
            statement.setFloat(5, sbj.getWeight());
            statement.setString(6, sbj.getSid());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void delete(String sid) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql1 = "delete from result where sid = ?";
            statement1 = connection.prepareCall(sql1);
            statement1.setString(1, sid);
            statement1.execute();
            
            String sql = "delete from subject where sid = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, sid);
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<Subject> findBySName (String sname) {
        List<Subject> subjectList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "select * from subject where sname like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+sname+"%");
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Subject sbj;
                sbj = new Subject(resultSet.getString("sid"),
                        resultSet.getString("sname"),
                        resultSet.getString("school"),
                        resultSet.getString("lecturer"),
                        resultSet.getInt("credit"),
                        resultSet.getFloat("weight"));
                       
                subjectList.add(sbj);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return subjectList;
    }
    
    public static List<Subject> findBySID (String sid) {
        List<Subject> subjectList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach mon hoc
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "select * from subject where sid like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+sid+"%");
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Subject sbj;
                sbj = new Subject(resultSet.getString("sid"),
                        resultSet.getString("sname"),
                        resultSet.getString("school"),
                        resultSet.getString("lecturer"),
                        resultSet.getInt("credit"),
                        resultSet.getFloat("weight"));
                        
                subjectList.add(sbj);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return subjectList;
    }
}
