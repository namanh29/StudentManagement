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
public class Result {
    private int id;
    private String sid, fullname, sname;
    private float midterm, finalterm, courseGrade, grade4;
    
    public Result(int id, String fullname, String sid, String sname, float midterm, float finalterm, float coursegrade, float grade4) {
        this.id = id;
        this.sid = sid;
        this.fullname = fullname;
        this.sname = sname;
        this.midterm = midterm;
        this.finalterm = finalterm;
        this.courseGrade = coursegrade;
        this.grade4 = grade4;
    }

    public Result(int id, String sid, float midterm, float finalterm) {
        this.id = id;
        this.sid = sid;
        this.midterm = midterm;
        this.finalterm = finalterm;
        this.courseGrade =  midterm * 0.3f + finalterm * 0.7f;
        if(midterm < 3 || finalterm < 3) this.grade4 = 0;
        else{
            if(this.courseGrade < 4) this.grade4 = 0;
            else if(this.courseGrade < 5) this.grade4 = 1;
            else if(this.courseGrade < 5.5f) this.grade4 = 1.5f;
            else if(this.courseGrade < 6.5f) this.grade4 = 2;
            else if(this.courseGrade < 7) this.grade4 = 2.5f;
            else if(this.courseGrade < 8) this.grade4 = 3;
            else if(this.courseGrade < 8.5f) this.grade4 = 3.5f;
            else this.grade4 = 4;
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public float getMidterm() {
        return midterm;
    }

    public void setMidterm(float midterm) {
        this.midterm = midterm;
    }

    public float getFinalterm() {
        return finalterm;
    }

    public void setFinalterm(float finalterm) {
        this.finalterm = finalterm;
    }

    public float getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(float courseGrade) {
        this.courseGrade = courseGrade;
    }
    
    public void setCourseGrade(){
        this.courseGrade = this.midterm*0.3f + this.finalterm*0.7f;
    }
    
     public float getGrade4() {
        return grade4;
    }

    public void setGrade4(float grade4) {
        this.grade4 = grade4;
    }
    
    public void setGrade4(){
        if(midterm < 3 || finalterm < 3) this.grade4 = 0;
        else{
            if(this.courseGrade < 4) this.grade4 = 0;
            else if(this.courseGrade < 5) this.grade4 = 1;
            else if(this.courseGrade < 5.5f) this.grade4 = 1.5f;
            else if(this.courseGrade < 6.5f) this.grade4 = 2;
            else if(this.courseGrade < 7) this.grade4 = 2.5f;
            else if(this.courseGrade < 8) this.grade4 = 3;
            else if(this.courseGrade < 8.5f) this.grade4 = 3.5f;
            else this.grade4 = 4;
        }
    }
//    public static void main(String[] args) {
//        Result rs = new Result(1,"a",2,8);       
//        System.out.println(rs.getGrade4());
//    }

   
    
}
