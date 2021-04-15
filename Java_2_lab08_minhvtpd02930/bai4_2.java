package Java_2_lab08_minhvtpd02930;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class bai4_2 {
    public static void main(String[] args) {
        Product p1 = new Product("iPhone9", 1000.0);
        Product p2 = new Product("Samsung Start", 3000.0);
        bai4_1 dao = new bai4_1();
        dao.add(p1);
        dao.add(p2);
        dao.store("e:\\lab8bai4.txt");
        bai4_1 dao2 = new bai4_1();
        dao2.load("e:\\lab8bai4.txt");
        Product p = dao2.find("iPhone9");
        System.out.println(">Name: " + p.name);
        System.out.println(">Price: " + p.price);
    }
}
