/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab08_minhvtpd02930;

import java.util.ArrayList;

/**
 *
 * @author MINH
 */
public class bai2 {
      public static void main(String[] args) {
          ArrayList<Integer> myarr = new ArrayList<Integer>();
        for(int i = 0; i<11;i++) {
            myarr.add(i);
            
        }
        for(int i = 0 ; i<11;i++) {
            int a= myarr.get(i);
            System.out.println(a);
        }
    }
}


