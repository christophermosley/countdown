package com.mosley.countdown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RachelRiley
{


    public List<Integer> selectNumbers()
    {
        // Prompt the user to select how many big numbers and how many little numbers.
        Scanner Bigs = new Scanner(System.in);
        System.out.println("Enter number of big numbers to use ");
        
        int numOfBigs = Bigs.nextInt();
        int numOfLittles;
        Bigs.close();
        ArrayList<Integer> listOfNums = new ArrayList<>();
        
        int bigCounter = 0;
        do 
        {
            Random rnd = new Random();
            
            int n = rnd.nextInt(75) + 25;
            
            listOfNums.add(n);
            
            bigCounter++;
            
        }
        while (bigCounter < numOfBigs );
        
        numOfLittles = 6 - bigCounter;
        do
        {
            Random rndL = new Random();
            
            int little = rndL.nextInt(10);
            
            listOfNums.add(little);
            
            numOfLittles--;
            
        }
        while(numOfLittles > 0);
        
        System.out.println("This is the list " + listOfNums);
        return listOfNums;
        
        
    }

    public static void presentAnswer(ArrayList<Integer> nums, ArrayList<Integer> ops)
    {                                
        int value = nums.get(0);
        
        String end = "" + nums.get(0);
        
        for(int i = 1; i < nums.size(); i++)
        {
                int next = nums.get(i);
                int nextOperation = ops.get(i - 1).intValue();
                
                if(nextOperation == 1) // add
                {
                        
                    String addString = ("(" + nums.get(i) + " + " + ")"); 
                    
                    end = "(" + end + " + " + nums.get(i) + ")"; 
                        
                }
                else if(nextOperation == 2) // sub
                {                               
                        
                    String subString = ("(" + nums.get(i) + " - " + ")");   
                    
                    end = "(" + end + " - " + nums.get(i) + ")"; 
                         
                }
                else if(nextOperation == 3) // mult
                {
                        
                    String multString = ("(" + nums.get(i) + " * " + ")"); 
                    
                    end = "(" + end + " * " + nums.get(i) + ")"; 
                        
                }
                else if(nextOperation == 4) // div
                {
                        
                    String multString = ("(" + nums.get(i) + " / " + ")"); 
                    
                    end = "(" + end + " / " + nums.get(i) + ")"; 
                    
                       
                }      
        }
        
        System.out.println("This is the answer " + end);
    }

}
