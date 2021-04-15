/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab05_minhvtpd02930;

/**
 *
 * @author VoT
 */
public class XFiledemo {

    public static void main(String[] args) {
        byte[] data = XFile.read("E:/dulieu.txt");
        XFile.write("E:/dulieu.txt", data);
    }
}
