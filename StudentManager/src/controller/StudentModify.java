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
import model.Student;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nam Anh
 */
public class StudentModify {
    public static List<Student> findAll(){
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "select * from student";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Student std;
                std = new Student(resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        
                        resultSet.getString("birth"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"));
                studentList.add(std);
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
        return studentList;
    }
    
    public static void insert(Student std) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "insert into student(id, fullname, gender, birth, email, phone_number) values(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, std.getId());
            statement.setString(2, std.getFullname());
            statement.setString(3, std.getGender());
            
            statement.setString(4, std.getBirth());
            statement.setString(5, std.getEmail());
            statement.setString(6, std.getPhone_number());
            
            statement.execute();
            
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
    }
    
    public static void update(Student std) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "update student set fullname=?,gender=?,birth=?,email=?,phone_number=? where id = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, std.getFullname());
            statement.setString(2, std.getGender());
            statement.setString(3, std.getBirth());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhone_number());
            statement.setInt(6, std.getId());
            
            statement.execute();
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
    }
    
    public static void delete(int id) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql1 = "delete from result where id = ?";
            statement1 = connection.prepareCall(sql1);
            statement1.setInt(1, id);
            statement1.execute();
            
            String sql = "delete from student where id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
                       
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
    }
    
    public static List<Student> findByFullName (String fullname) {
        List<Student> studentList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "select * from student where fullname like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Student std;
                std = new Student(resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        
                        resultSet.getString("birth"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"));
                studentList.add(std);
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
        return studentList;
    }
    
    public static List<Student> findByID (int id) {
        List<Student> studentList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "select * from student where id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Student std;
                std = new Student(resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        
                        resultSet.getString("birth"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"));
                studentList.add(std);
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
        return studentList;
    }
    
    public static List<Student> findByGender (String gender) {
        List<Student> studentList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //query
            String sql = "select * from student where gender like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, gender);
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Student std;
                std = new Student(resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        
                        resultSet.getString("birth"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"));
                studentList.add(std);
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
        return studentList;
    }
}
