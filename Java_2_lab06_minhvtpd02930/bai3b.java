/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab06_minhvtpd02930;

public class bai3b {
    public static void main(String[] args) {
        try{
        bai3 b3 = new bai3();
        bai3a b3a = new bai3a();
        b3.start();
        b3.join();
        b3a.start();
    }catch(Exception ex){
            System.out.println("Error:"+ex.toString()); 
    }
    }
}
