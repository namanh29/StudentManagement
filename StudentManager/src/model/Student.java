/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nam Anh
 */
public class Student {
    private int id;
    private String fullname, gender, birth, email, phone_number;

    public Student(int id) {
        this.id = id;
    }
    
    public Student(int id, String fullname, String gender, String birth, String email, String phone_number) {
        super();
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.phone_number = phone_number;
        
    }

    public Student(String fullname, String gender, String birth, String email, String phone_number) {
        super();
        this.fullname = fullname;
        this.gender = gender;
        
        this.birth = birth;
        this.email = email;
        this.phone_number = phone_number;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
