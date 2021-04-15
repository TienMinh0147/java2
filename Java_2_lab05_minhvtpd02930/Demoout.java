/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab05_minhvtpd02930;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author VoT
 */
public class Demoout {
    public static void main(String[] args) {
        try {
            FileOutputStream out=new FileOutputStream("E:/data.txt",true);
            String s="hello";
            out.write(s.getBytes());
            out.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File ko ton tai");
        }catch(IOException ex){
            System.out.println("Luu that bai");
        }
    }
}
