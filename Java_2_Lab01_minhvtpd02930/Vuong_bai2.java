/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_Lab01;


public class Vuong_bai2 extends ChuNhat_bai2{
    private double canh;

    public Vuong_bai2() {
    }

    public Vuong_bai2(double dai, double rong) {
        super(dai, rong);
    }

    public double getCanh() {
        return canh;
    }

    public void setCanh(double canh) {
        this.canh = canh;
    }
    @Override
    public double getChuVi(){
        return (canh*4);
    }
    @Override
    public double getDienTich(){
        return (canh*canh);
    }
    //xuat
    @Override
    public void Xuat(){
        System.out.println("Hinh Vuong");
        System.out.println("Canh = "+canh+"Chu vi = "+getChuVi()+"Dien tich = "+getDienTich());
    }
    
}
