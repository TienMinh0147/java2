/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class QLNV implements Serializable{
    
    private String Manv,hoten,email;
    private int tuoi;
    private double luong;

    public QLNV() {
       this.Manv = "";
        this.hoten = "";
        this.email = "";
        this.tuoi = 19;
        this.luong = 650000;
    }

    public QLNV(String Manv, String hoten, String email, int tuoi, double luong) {
        this.Manv = Manv;
        this.hoten = hoten;
        this.email = email;
        this.tuoi = tuoi;
        this.luong = luong;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
       return this.Manv + "\t" + this.hoten + "\t" + this.tuoi + "\t" + this.email + "\t" + this.luong;
    }
    

}
