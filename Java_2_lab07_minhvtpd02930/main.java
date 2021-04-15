/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab07_minhvtpd02930;

/**
 *
 * @author MINH
 */
public class main {
    public static void main(String[] args) {
PolyStudent sv = new PolyStudent();
sv.fullname = "Văn Tiến Minh";
//sv.career = Career.UDPM;
sv.career = Career.valueOf("UDPM");
sv.print();
}
}
