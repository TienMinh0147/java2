/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_Lab01;


public class ChuNhat_bai2 {
    private double dai, rong;

    public ChuNhat_bai2() {
    }

    public ChuNhat_bai2(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public double getDai() {
        return dai;
    }

    public void setDai(double dai) {
        this.dai = dai;
    }

    public double getRong() {
        return rong;
    }

    public void setRong(double rong) {
        this.rong = rong;
    }
    //tinh
    public double getChuVi(){
        return (dai+rong)*2;
    }
    public double getDienTich(){
        return (dai*rong);
    }
    //xuat
    public void Xuat(){
        System.out.println("Hinh chu nhat");
        System.out.println("chieu dai = "+dai+"chieu rong = "+rong+"Chu vi = "+getChuVi()+"Dien tich = "+getDienTich());
    }

   
}
