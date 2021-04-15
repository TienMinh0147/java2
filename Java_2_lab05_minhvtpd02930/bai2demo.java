/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab05_minhvtpd02930;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class bai2demo implements Serializable{
    public static void main(String[] args) {
        List<HocSinh> list;
        list = new ArrayList<>();
        list.add(new HocSinh("Minh",8,"CNTT"));
        list.add(new HocSinh("ten)",7,"TKTW"));
        XFile.writeObject("E:/dulieu2.txt",list);
        List<HocSinh>list2=
                (List<HocSinh>) XFile.readObject("E:/dulieu2.txt");
        for(HocSinh sv:list){
            System.out.println(">Ho va ten: "+sv.ten);
        }
    }
}
