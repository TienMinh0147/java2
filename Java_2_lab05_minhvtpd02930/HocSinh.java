/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab05_minhvtpd02930;

import java.io.Serializable;

/**
 *
 * @author VoT
 */
public class HocSinh implements Serializable {

    public String ten;
    public double diem;
    public String nganh;

    public HocSinh(String ten, double diem, String xeploai) {
        this.ten = ten;
        this.diem = diem;
        this.nganh = xeploai;
    }

    public String xeploai() {

        if (this.diem < 3 & this.diem > 0) {
            return "Kem";
        }
        if (this.diem < 5) {
            return "TrungBinh";
        }
        if (this.diem < 6.5) {
            return "Kha";
        }
        if (this.diem < 7.5) {
            return "Gioi";
        }
        if (this.diem < 9) {
            return "Gioi";
        }
        if (this.diem <= 10) {
            return "XuatSac";
        }
        return "Diem phai tu 0 dem 10";
    }

    public boolean isBonus() {
        return this.diem >= 7.5;
    }
}
