/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_Lab01_minhvtpd02930;


public abstract class StudentPoly {
    //1.tao 1 thuoc tinh
    private String hoTen, nganh;
    //2.1 tao ham dung khong co tham so
    public StudentPoly(){}
    
    //2.2 tao ham dung co tham so
    public StudentPoly(String hoTen, String nganh){
        this.hoTen = hoTen;
        this.nganh = nganh;
    }
    //3. tao cac thuoc tinh getter setter
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
    //4. tao ham abstract
    public abstract double getDiem();
    //5. tao phuong thuc tinh hoc luc
    public String getHocLuc(double  diem){
        String strHocLuc ="";
        if(diem >=9){
            strHocLuc = "Xuat Sac";
        }else if (diem >=8){
            strHocLuc = "Gioi";
        }
        return strHocLuc;
    }
    //6 xuat ra man hinh
    public void xuat(){
        System.out.println("ho ten: "+ getHoTen());
        System.out.println("nganh: "+ getNganh());
        System.out.println("Diem: "+getDiem());
        System.out.println("Hoc Luc: "+ getHocLuc(getDiem()));
    }
    
}
