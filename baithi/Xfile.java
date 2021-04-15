package baithi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Xfile {

    static byte[] read(String path) {
        byte[] b;
        try {
            FileInputStream fin = new FileInputStream(path);
            b = new byte[fin.available()];
            fin.read(b);
            String s = new String(b);
            fin.close();
            return b;
        } catch (FileNotFoundException ex) {
            System.out.println("File Không Tồn Tại");
            return null;
        } catch (IOException ex) {
            System.out.println("Lỗi Đọc File");
            return null;
        }
    }

    static void write(String temFile, byte[] b) {

        try {
            FileOutputStream fout = new FileOutputStream(temFile, true);
            fout.write(b);
            fout.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Không Tồn Tại");
        } catch (IOException ex) {
            System.out.println("Lưu dữ liệu thất bại");
        }
    }
    static void coppyFile(String fileNguon,String fileDich){
        byte []tg=read(fileNguon);
        write(fileDich, tg);
    }
    //Hàm đọc đối tượng 
    static void writeObject (String tenFile, Object obj) {
        try{
            FileOutputStream fout = new FileOutputStream(tenFile);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(obj);
            oos.flush();oos.close();fout.close();
        }catch(FileNotFoundException ex) {
            System.out.println("Lỗi không tìm thấy File");
        }catch(IOException ex1) {
            System.out.println("Lỗi ghi File");
        }
    }
    //Hàm đọc đối tượng
    static Object readObject(String tenFile){
        Object kq = new Object();
        try{
            FileInputStream fin = new FileInputStream(tenFile);
            ObjectInputStream ois = new ObjectInputStream(fin);
            kq = ois.readObject();
            ois.close();fin.close();
        }catch (FileNotFoundException ex){
            System.out.println("Lỗi không tìm thấy File");
        }catch (IOException ex1){
            System.out.println("Lỗi đọc File");
        }catch (ClassNotFoundException ex2){
            System.out.println("Lỗi không tìm thấy Class");
        }
        return kq;
    }   
}
