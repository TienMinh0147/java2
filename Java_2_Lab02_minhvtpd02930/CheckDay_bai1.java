/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_Lab02_minhvtpd02930;

import java.util.Scanner;

public class CheckDay_bai1 {
    public static void main(String[] args) {
        int day;
        // tạo hàm nhập
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ 0 đến 6 : ");
        day = sc.nextInt();
        //điều kiện xuất
        if(day == Weekday.Sunday || day == Weekday.Saturday){
            System.out.println("Ngày cuối tuần !");
        }else{
            System.out.println("Ngày trong tuần");
        }
    }
    
}
