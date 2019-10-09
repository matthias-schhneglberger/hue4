/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matth
 */
public class Worker implements Runnable{
    int from;
    int to;
    int sum;
    
    public Worker(int from, int to) {
        this.from = from;
        this.to = to;
    }
    
    @Override
    public void run() {
        
//        System.out.println("from: " + from);
//        System.out.println("to: " + to);
        
        
        int diff = to-from;
        
        int tempNum;
        
        tempNum = ((diff*diff) + diff)/2;
        
        tempNum += from*diff;
        sum = tempNum;
        
        //System.out.println("sum: " + sum);
    }
    
    public int getSum(){
        return sum;
    }
    
}
