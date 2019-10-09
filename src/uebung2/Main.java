/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung2;

import java.util.Scanner;

/**
 *
 * @author matth
 */
public class Main {
    static final int SIZE_OF_PACKETS = 100;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        console.useDelimiter("\n");
        
        System.out.println("Bis zu welcher Zahl soll es Addiert werden: ");
        int maxNums = console.nextInt();
        
        int numsOfThreads = Math.round(maxNums/ SIZE_OF_PACKETS);
        
        
        
        int tempNums = 0;
        for(int i = 0; i <= numsOfThreads; i++){
            
        }
    }
    
}
