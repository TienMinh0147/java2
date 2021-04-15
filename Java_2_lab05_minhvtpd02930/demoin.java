/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab05_minhvtpd02930;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author VoT
 */
public class demoin {
    public static void main(String[] args) {
        try{
            FileInputStream in=new FileInputStream("E:/data.txt");
            byte[]b=new byte[in.available()];
            in.read(b);String s=new String(b);
            System.out.println(s);
            in.close();
        }catch (FileNotFoundException ex){
            System.out.println("File ko ton tai");
        }catch(IOException ex){
            System.out.println("Loi doc file");
        }
    }
}
