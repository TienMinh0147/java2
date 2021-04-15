/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_Lab02_minhvtpd02930;


public abstract class NhanVien_bai2 {
    
        private final String fullname;
        public NhanVien_bai2(String fullname){
            this.fullname = fullname;
        }
        public abstract double getSalary();
        public void print(){
            System.out.println("Fullname: Tien Minh"+this.fullname);
            System.out.println("Salary: "+this.getSalary());
        }
    
    
}
