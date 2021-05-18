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
public class Cpa {
    private int id;
    private String fullname;
    private int tongsotc, tctichluy;
    private float cpa;

    public Cpa(int id, String fullname, int tongsotc, int tctichluy, float cpa) {
        this.id = id;
        this.fullname = fullname;
        this.tongsotc = tongsotc;
        this.tctichluy = tctichluy;
        this.cpa = cpa;
    }
    
    public void cpa(){
         
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

    public int getTongsotc() {
        return tongsotc;
    }

    public void setTongsotc(int tongsotc) {
        this.tongsotc = tongsotc;
    }

    public int getTctichluy() {
        return tctichluy;
    }

    public void setTctichluy(int tctichluy) {
        this.tctichluy = tctichluy;
    }

    

    public float getCpa() {
        return cpa;
    }

    public void setCpa(float cpa) {
        this.cpa = cpa;
    }
    
}
