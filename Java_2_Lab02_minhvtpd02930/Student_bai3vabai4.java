package Java_2_Lab02_minhvtpd02930;

public class Student_bai3vabai4 {
    public String name;
    public double marks;    
    public String getGrade(){
        if(this.marks <3){
            return "Kém";
        }
        if(this.marks <5){
            return "Yếu";
        }
        if(this.marks < 6.5){
            return "Trung bình";
        }
        if(this.marks < 7.5){
            return "Khá";
        }
        if(this.marks < 9){
            return "Giỏi";
        }
        return "Xuất sắt";
    }
    public boolean isBonus(){
        return this.marks >=7.5;
    }
}
