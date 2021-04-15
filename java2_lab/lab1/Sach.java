
package java2_lab.lab1;

import java.io.Serializable;


public class Sach implements Serializable{
    String MaS;
    String TenSach;
    double GiaBan;

    public Sach() {
    }

    public String getMaS() {
        return MaS;
    }

    public void setManv(String MaS) {
        this.MaS = MaS;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Sach(String MaS, String TenSach, double GiaBan) {
        this.MaS = MaS;
        this.TenSach = TenSach;
        this.GiaBan = GiaBan;
    }
    
}
