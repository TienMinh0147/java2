/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab06_minhvtpd02930;


public class bai3a extends Thread{

    @Override
    public void run() {
        for(int i=1; i <= 10; i++){
            if(i%2==0){
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(i);
            }
        }
    }
}
