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
public class PolyStudent {

    public String fullname;
    public Career career;

    public void print() {
        System.out.println(">Fullname: " + this.fullname);
        switch (this.career) {
            case UDPM:
                System.out.println(">Career: Ứng dụng phần mềm");
                break;
            case TKTW:
                System.out.println(">Career: Thiết kế trang web");
                break;
            case LTDĐ:
                System.out.println(">Career: Lập trình di động");
                break;
            case TKĐH:
                System.out.println(">Career: Thiết kế đồ họa");
                break;
        }
    }
}
