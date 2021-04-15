/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_2_Lab01;

/**
 *
 * @author MINH
 */
public class A {
    protected int x,y;
    public  A( int x, int y){
        this.x =x;
        this.y=y;
    }
    public  A( int x){
        this(x,x);
    }
    public void print(){
        System.out.printf("x%d, y%d",x,y);
    }
    
}
