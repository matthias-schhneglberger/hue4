/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author matth
 */
public class Main {
    static final int SIZE_OF_PACKETS = 100;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        List<Worker> workers = new ArrayList<>();
        
        Scanner console = new Scanner(System.in);
        console.useDelimiter("\n");
        
        
        
        
        System.out.println("Bis zu welcher Zahl soll es Addiert werden: ");
        int maxNums = console.nextInt();
        
        int numsOfThreads = Math.round(maxNums/ SIZE_OF_PACKETS);
        
        ExecutorService executor = Executors.newFixedThreadPool(numsOfThreads);
        
        int tempNums = 0;
        for(int i = 0; i <= numsOfThreads; i++){
            if(tempNums+SIZE_OF_PACKETS > maxNums){
                Worker tempW = new Worker(tempNums, maxNums);
                //executor.execute(new Worker(tempNums, maxNums));
                executor.execute(tempW);
                workers.add(tempW);
            }
            else{
                Worker tempW = new Worker(tempNums, tempNums+SIZE_OF_PACKETS);
                executor.execute(tempW);
                workers.add(tempW);
            }
            
            
            tempNums += SIZE_OF_PACKETS;
        }
        
        
        
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Sum: " + workers.stream()
            .mapToInt(n -> n.getSum())
            .sum());
        
    }
    
}
