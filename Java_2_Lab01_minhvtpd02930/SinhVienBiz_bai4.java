/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_Lab01_minhvtpd02930;


public class SinhVienBiz_bai4 extends SinhVienPoly_bai4{
    public double marketting;
    public double sales;

    public SinhVienBiz_bai4(String hoTen, double diemMarketting, double diemSales){
        super(hoTen, "Biz");
        this.marketting =  diemMarketting;
        this.sales = diemSales;
    }

    
    @Override
    public double getDiem(){
        return(2*marketting +sales)/3;
    }
    
}
