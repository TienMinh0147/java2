package Assignment_minhvtpd02930;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ast
 */
public class NhanVien {
    public String MaNV;
    public String HoTen;
    public int Tuoi;
    public String Email;
    public double Luong;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String HoTen, int Tuoi, String Email, double Luong) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.Tuoi = Tuoi;
        this.Email = Email;
        this.Luong = Luong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public double getLuong() {
        return Luong;
    }

    public void setLuong(double Luong) {
        this.Luong = Luong;
    }

    @Override
    public String toString() {
        return MaNV +";" + HoTen +";" + Tuoi +";" + Email + ";"+ Luong +"\n";
    }

    
    
    
}
