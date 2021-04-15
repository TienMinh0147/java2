/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_lab03_minhvtpd02930;


public class Student {
    public String name;
    public double marks;
    public String major;

    public Student() {
    }
    
    

    public Student(String name, double marks, String major) {
        this.name = name;
        this.marks = marks;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    
    public String getGrade(){
        if(this.marks <3 ){
            return "Kém";
        }
        if(this.marks <6.5){
            return "Trung Bình";
        }
        if (this.marks < 7.5) {
            return "Khá";
        }
        if(this.marks <9){
            return "Giỏi";
        }
        return "Xuất Sắc";
    }
    public boolean isBonus(){
        return this.marks >= 7.5;
    }
    
}
