/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab05_minhvtpd02930;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author VoT
 */
public class XFile {

    public static byte[] read(String path) {
        try {
            FileInputStream vao = new FileInputStream(path);
            int n = vao.available();
            byte[] data = new byte[n];
            vao.read(data);
            String s = new String(data);
            System.out.println(s);
            vao.close();
            return data;
        } catch (Exception ex) {
            System.out.println("Ban da nhap sai");

        }
        return null;
    }

    public static void write(String path, byte[] data) {
        try {
            FileOutputStream ra = new FileOutputStream(path);
            ra.write(data);
            ra.close();
        } catch (Exception ex) {
            System.out.println("ban da nhap sai");
        }
    }

    public static Object readObject(String path) {
        try {
            ObjectInputStream in
                    = new ObjectInputStream(new FileInputStream(path));
            Object obj = in.readObject();
            in.close();
            return obj;
        } catch (Exception ex) {
            System.out.println("Ban da nhap sai hoac file ko ton tai");
        }
        return null;
    }

    public static void writeObject(String path, Object obj) {
        try {
            ObjectOutputStream out
                    = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(obj);
            out.close();
        } catch (Exception ex) {
            System.out.println("ban da  nhap sai hoac file ko ton tai");
        }
    }
}
