/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        console.useDelimiter("\n");
        
        List<Integer> inputNumbers = readCSV();
       
       //inputNumbers.stream().forEach(System.out::println);
        System.out.println("Wie oft soll die Liste fuer Threads geteilt werden? ");
        int dividerForThreads = console.nextInt();
       
        System.out.println("Gib einen Teiler fuer die Zahlen ein: ");
        int teiler = console.nextInt();
        
        int diffOfParts = inputNumbers.size()/dividerForThreads;
        System.out.println("Jeder Thread muss " + diffOfParts + " Zahlen absuchen");
        
        
        ExecutorService executor = Executors.newFixedThreadPool(dividerForThreads);
        
        
       
    }
    
    public static List<Integer> readCSV(){
        
        List<Integer> numbers = new ArrayList<>();
        
        try (
                FileReader reader = new FileReader("numbers.csv");
                BufferedReader br = new BufferedReader(reader)
                ){
            
                 String line = br.readLine();
                 while(line != null){
                     String[] parts = line.split(":");
                     for(String s : parts){
                         try{ numbers.add(Integer.valueOf(s)); }
                         catch(NumberFormatException e){}
                     }
                     line = br.readLine();
                 } 
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numbers;
        
    }
        
    
}
