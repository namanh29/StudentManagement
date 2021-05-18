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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Result;

/**
 *
 * @author Nam Anh
 */
public class ResultModify {
    public static List<Result> findAll(){
        List<Result> resultList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "select student.id, fullname, subject.sid, sname, midterm, finalterm, coursegrade, grade4 "
                    + "from student, subject, result "
                    + "where student.id = result.id and subject.sid = result.sid";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Result rs;
                rs = new Result(resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("sid"),
                        resultSet.getString("sname"),
                        resultSet.getFloat("midterm"),
                        resultSet.getFloat("finalterm"),
                        resultSet.getFloat("coursegrade"),
                        resultSet.getFloat("grade4"));
                        
                resultList.add(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }
    
    public static void insert(Result rs) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "insert into result(id, sid, midterm, finalterm, coursegrade, grade4) values(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, rs.getId());
            statement.setString(2, rs.getSid());          
            statement.setFloat(3, rs.getMidterm());
            statement.setFloat(4, rs.getFinalterm());
            statement.setFloat(5, rs.getCourseGrade());
            statement.setFloat(6, rs.getGrade4());
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(Result rs) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "update result set midterm=?, finalterm=?, coursegrade=?, grade4=? where id = ? and sid = ?";
            statement = connection.prepareCall(sql);
            statement.setFloat(1, rs.getMidterm());
            statement.setFloat(2, rs.getFinalterm());
            statement.setFloat(3, rs.getCourseGrade());
            statement.setFloat(4, rs.getGrade4());
            statement.setInt(5, rs.getId());
            statement.setString(6, rs.getSid());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void delete(int id, String sid) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "delete from result where id = ? and sid = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.setString(2, sid);
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<Result> findBySID (String sid) {
        List<Result> resultList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "select student.id, fullname, subject.sid, sname, midterm, finalterm, coursegrade, grade4 "
                    + "from student, subject, result "
                    + "where student.id = result.id and subject.sid = result.sid and subject.sid like ?";
                    
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+sid+"%");
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Result rs;
                rs = new Result(resultSet.getInt("student.id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("subject.sid"),
                        resultSet.getString("sname"),
                        resultSet.getFloat("midterm"),
                        resultSet.getFloat("finalterm"),
                        resultSet.getFloat("coursegrade"),
                        resultSet.getFloat("grade4"));
                resultList.add(rs);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }
    
    public static List<Result> findByID (int id) {
        List<Result> resultList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "select student.id, fullname, subject.sid, sname, midterm, finalterm, coursegrade, grade4 "
                    + "from student, subject, result "
                    + "where student.id = result.id and subject.sid = result.sid and student.id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Result rs;
                rs = new Result(resultSet.getInt("student.id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("subject.sid"),
                        resultSet.getString("sname"),
                        resultSet.getFloat("midterm"),
                        resultSet.getFloat("finalterm"),
                        resultSet.getFloat("coursegrade"),
                        resultSet.getFloat("grade4"));
                resultList.add(rs);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }

}
