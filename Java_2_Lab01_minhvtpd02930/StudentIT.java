/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_Lab01_minhvtpd02930;


public class StudentIT extends StudentPoly {
    //khai bao thuoc tinh
    private double java, html, css;
    //tao ham dung

    public StudentIT() {
    }
    
    public StudentIT(double java, double html, double css, String hoTen, String nganh) {
        super(hoTen, nganh);
        this.java = java;
        this.html = html;
        this.css = css;
    }
    // tao get setter getter

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getHtml() {
        return html;
    }

    public void setHtml(double html) {
        this.html = html;
    }

    public double getCss() {
        return css;
    }

    public void setCss(double css) {
        this.css = css;
    }
    //viet lai ham getDiem
    @Override
    public double getDiem(){
        return (html + css + java)/3;
    }
    
    
    
}
