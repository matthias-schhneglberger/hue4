/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung1;

import java.util.List;

/**
 *
 * @author matth
 */
public class Worker implements Runnable{
    List<Integer> numbers;
    int divider;
    int from;
    int to;
    

    public Worker(int from, int to, List<Integer> numbers, int divider) {
        this.from = from;
        this.to = to;
        this.numbers = numbers;
        this.divider = divider;
    }
    
    
    
    @Override
    public void run() {
        for(int i = from; i < to; i++){
            if(numbers.get(i) % divider == 0){
                System.out.println(numbers.get(i));
            }
        }
    }
    
}
