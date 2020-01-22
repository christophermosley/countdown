package com.mosley.countdown;

import java.util.ArrayList;
import java.util.List;

public class SusieDent
{
    void combinationRepetitionUtil(int chosen[], int arr[], 
            int index, int r, int start, int end, List<ArrayList<Integer>> listOfOperators) 
    { 
        // Since index has become r, current combination is  
        // ready to be printed, print  
        if (index == r) 
        {
            List<Integer> operatorEntry = new ArrayList<Integer>();
            for (int i = 0; i < r; i++) 
            {
                operatorEntry.add(arr[chosen[i]]);
                
               // System.out.printf("%d ", arr[chosen[i]]); 
            }
            listOfOperators.add((ArrayList<Integer>) operatorEntry);
            
            //System.out.printf("\n"); 
            return; 
        } 
  
        // One by one choose all elements (without considering  
        // the fact whether element is already chosen or not)  
        // and recur  
        for (int i = start; i <= end; i++) { 
            chosen[index] = i; 
            combinationRepetitionUtil(chosen, arr, index + 1, 
                    r, i, end, listOfOperators); 
        } 
        return; 
    } 
    
    void combinationRepetition(int arr[], int n, int r, List<ArrayList<Integer>> listOfOperators) { 
        // Allocate memory  
        int chosen[] = new int[r + 1]; 
  
        // Call the recursice function  
        combinationRepetitionUtil(chosen, arr, 0, r, 0, n - 1, listOfOperators); 
    } 
}
