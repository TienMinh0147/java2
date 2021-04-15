/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_Lab01_minhvtpd02930;

/**
 *
 * @author MINH
 */
public class test {

    public static void main(String[] args) {
          
        StudentIT st = new StudentIT( 7, 8, 10, "Minh", "IT");
        st.xuat();
        SinhVienIT_bai4 sv1 = new SinhVienIT_bai4("Tien Minh", 10, 10, 9);
        sv1.xuat();
        
        
        SinhVienBiz_bai4 sv2 = new SinhVienBiz_bai4("Tien Minh", 10, 9);
        sv2.xuat();
    }
    
}

    
    
    


