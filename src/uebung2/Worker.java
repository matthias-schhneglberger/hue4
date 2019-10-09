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
    List<Integer> doneNums = new ArrayList<>();
    
    public Worker(int from, int to) {
        this.from = from;
        this.to = to;
    }
    
    @Override
    public void run() {
        int diff = to-from;
        
        int tempNum;
        for(int i = 0; i <= diff; i++){
            tempNum = ((i*i) + i)/2;
            tempNum += from;
            doneNums.add(tempNum);
        }
    }
    
    public List<Integer> getDoneNums(){
        return doneNums;
    }
    
}
