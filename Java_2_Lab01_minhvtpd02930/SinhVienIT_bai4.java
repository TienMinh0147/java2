/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_Lab01_minhvtpd02930;


public class SinhVienIT_bai4 extends SinhVienPoly_bai4{
     public double java;
    public double html;
    public double css;

    public SinhVienIT_bai4(String hoTen,double diemJava, double diemHtml, double diemCss){
        super(hoTen, "IT");
        this.java= diemJava;
        this.html = diemHtml;
        this.css = diemCss;
    }
    
     @Override
    public double getDiem(){
        return(2*java +html +css)/4;
    }

     @Override
    public void xuat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
