package com.mosley.countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JimmyCarr
{
    /**
     * All of the permutations of the provided user values.
     */
    //public List<ArrayList<Integer>> valuePermutations = new ArrayList<>();

    /**
     * All the permutations of operations.
     *
     * 1 - add
     * 2 - subtract
     * 3 - multiply
     * 4 - division
     */
    public List<ArrayList<Integer>> numberPermutationsOfSize6 = new ArrayList<ArrayList<Integer>>();
    public List<ArrayList<Integer>> numberPermutationsOfSize5 = new ArrayList<ArrayList<Integer>>();
    public List<ArrayList<Integer>> numberPermutationsOfSize4 = new ArrayList<ArrayList<Integer>>();
    public List<ArrayList<Integer>> numberPermutationsOfSize3 = new ArrayList<ArrayList<Integer>>();
    public List<ArrayList<Integer>> numberPermutationsOfSize2 = new ArrayList<ArrayList<Integer>>();
    
    public List<ArrayList<Integer>> operationCombinationsOfSize5 = new ArrayList<ArrayList<Integer>>();
    public List<ArrayList<Integer>> operationCombinationsOfSize4 = new ArrayList<ArrayList<Integer>>();
    public List<ArrayList<Integer>> operationCombinationsOfSize3 = new ArrayList<ArrayList<Integer>>();
    public List<ArrayList<Integer>> operationCombinationsOfSize2 = new ArrayList<ArrayList<Integer>>();
    public List<ArrayList<Integer>> operationCombinationsOfSize1 = new ArrayList<ArrayList<Integer>>();

    public void beginCountdown()
    {
        // Have Rachel Riley ask the contestant how many big and little numbers they want.
        final RachelRiley rachelRiley = new RachelRiley();
        final List<Integer> userValues = rachelRiley.selectNumbers();//= new ArrayList<Integer>(); //= 
//        userValues.add(50);
//        userValues.add(75);
//        userValues.add(8);
//        userValues.add(10);
//        userValues.add(2);
//        userValues.add(1);
        
        Random random = new Random();
        int answer = random.nextInt(900);
        answer += 100;
        int targetValue = answer;

        // temp userValues
        System.out.println("Jimmy Carr " + userValues.toString());
        System.out.println("Target value : " + targetValue);

        // Permute the operations and the user values
        numberPermutationsOfSize6 = permute(userValues, 6);
        numberPermutationsOfSize5 = calculatePermuationSubset(numberPermutationsOfSize6);
        numberPermutationsOfSize4 = calculatePermuationSubset(numberPermutationsOfSize5);
        numberPermutationsOfSize3 = calculatePermuationSubset(numberPermutationsOfSize4);
        numberPermutationsOfSize2 = calculatePermuationSubset(numberPermutationsOfSize3);
        
        
        // Get all of the combinations
        int arr[] = {1, 2, 3, 4};
        int n = arr.length;
        final SusieDent susieDent = new SusieDent();
        
        // Operations size 5
        susieDent.combinationRepetition(arr, n, 5, operationCombinationsOfSize5);
        {
            List<ArrayList<Integer>> permutationCopy = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> itr : operationCombinationsOfSize5)
            {
                permutationCopy.addAll(permute(itr, 5));
            }
            operationCombinationsOfSize5.addAll(permutationCopy);
        }
        
        // Operations size 4
        susieDent.combinationRepetition(arr, n, 4, operationCombinationsOfSize4);
        {
            List<ArrayList<Integer>> permutationCopy = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> itr : operationCombinationsOfSize4)
            {
                permutationCopy.addAll(permute(itr, 4));
            }
            operationCombinationsOfSize4.addAll(permutationCopy);
        }
        
        // Operations size 3
        susieDent.combinationRepetition(arr, n, 3, operationCombinationsOfSize3);
        {
            List<ArrayList<Integer>> permutationCopy = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> itr : operationCombinationsOfSize3)
            {
                permutationCopy.addAll(permute(itr, 3));
            }
            operationCombinationsOfSize3.addAll(permutationCopy);
        }
        
      // Operations size 2
        susieDent.combinationRepetition(arr, n, 2, operationCombinationsOfSize2);
        {
            List<ArrayList<Integer>> permutationCopy = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> itr : operationCombinationsOfSize2)
            {
                permutationCopy.addAll(permute(itr, 2));
            }
            operationCombinationsOfSize2.addAll(permutationCopy);
        }
        
      // Operations size 1
        susieDent.combinationRepetition(arr, n, 1, operationCombinationsOfSize1);
        {
            List<ArrayList<Integer>> permutationCopy = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> itr : operationCombinationsOfSize1)
            {
                permutationCopy.addAll(permute(itr, 1));
            }
            operationCombinationsOfSize1.addAll(permutationCopy);
        }

        
        
        int currentBestValue = 0;
        ArrayList<Integer> bestNumberPermutation = new ArrayList<Integer>();
        ArrayList<Integer> bestOperationCombination = new ArrayList<Integer>();
        
        
        for (ArrayList<Integer> numItr : numberPermutationsOfSize2)
        {
            if (currentBestValue == targetValue)
            {
                break;
            }
            
            for (ArrayList<Integer> opItr : operationCombinationsOfSize1)
            {
                if (currentBestValue == targetValue)
                {
                    break;
                }
                
                int foo = Solver.testThisShit(numItr, opItr, false);
                
                if (Math.abs(targetValue - currentBestValue) > Math.abs(targetValue - foo))
                {
                    System.out.println("Updating current best from " + currentBestValue
                            + " numbers " + bestNumberPermutation.toString() 
                            + " bestOp " + bestOperationCombination.toString());
                    
                    currentBestValue = foo;
                    bestNumberPermutation = numItr;
                    bestOperationCombination = opItr;
                }
            }
        }
        
        if (currentBestValue == targetValue)
        {
            System.out.println("We won!");
            System.out.println("Best numbers " + bestNumberPermutation);
            System.out.println("Best operations "  + bestOperationCombination);
        }
        System.out.println("Starting round 3!");
        
        // Size 3
        for (ArrayList<Integer> numItr : numberPermutationsOfSize3)
        {
            if (currentBestValue == targetValue)
            {
                break;
            }
            
            for (ArrayList<Integer> opItr : operationCombinationsOfSize2)
            {
                if (currentBestValue == targetValue)
                {
                    break;
                }
                
                int foo = Solver.testThisShit(numItr, opItr, false);
                
                if (Math.abs(targetValue - currentBestValue) > Math.abs(targetValue - foo))
                {
                    System.out.println("Updating current best from " + currentBestValue
                            + " numbers " + bestNumberPermutation.toString() 
                            + " bestOp " + bestOperationCombination.toString());
                    
                    currentBestValue = foo;
                    bestNumberPermutation = numItr;
                    bestOperationCombination = opItr;
                }
            }
        }
        
        if (currentBestValue == targetValue)
        {
            System.out.println("We won!");
            System.out.println("Best numbers " + bestNumberPermutation);
            System.out.println("Best operations "  + bestOperationCombination);
        }
        else
        {
            System.out.println("Close " + currentBestValue);
        }
        
        // Size 4
        for (ArrayList<Integer> numItr : numberPermutationsOfSize4)
        {
            if (currentBestValue == targetValue)
            {
                break;
            }
            
            for (ArrayList<Integer> opItr : operationCombinationsOfSize3)
            {
                if (currentBestValue == targetValue)
                {
                    break;
                }
                
                int foo = Solver.testThisShit(numItr, opItr, false);
                
                if (Math.abs(targetValue - currentBestValue) > Math.abs(targetValue - foo))
                {
                    System.out.println("Updating current best from " + currentBestValue
                            + " numbers " + bestNumberPermutation.toString() 
                            + " bestOp " + bestOperationCombination.toString());
                    
                    currentBestValue = foo;
                    bestNumberPermutation = numItr;
                    bestOperationCombination = opItr;
                }
            }
        }
        
        if (currentBestValue == targetValue)
        {
            System.out.println("We won!");
            System.out.println("Best numbers " + bestNumberPermutation);
            System.out.println("Best operations "  + bestOperationCombination);
        }
        else
        {
            System.out.println("Close " + currentBestValue);
        }
        
        // Size 5
        for (ArrayList<Integer> numItr : numberPermutationsOfSize5)
        {
            if (currentBestValue == targetValue)
            {
                break;
            }
            
            for (ArrayList<Integer> opItr : operationCombinationsOfSize4)
            {
                if (currentBestValue == targetValue)
                {
                    break;
                }
                
                int foo = Solver.testThisShit(numItr, opItr, false);
                
                if (Math.abs(targetValue - currentBestValue) > Math.abs(targetValue - foo))
                {
                    System.out.println("Updating current best from " + currentBestValue
                            + " numbers " + bestNumberPermutation.toString() 
                            + " bestOp " + bestOperationCombination.toString());
                    
                    currentBestValue = foo;
                    bestNumberPermutation = numItr;
                    bestOperationCombination = opItr;
                }
            }
        }
        
        if (currentBestValue == targetValue)
        {
            System.out.println("We won!");
            System.out.println("Best numbers " + bestNumberPermutation);
            System.out.println("Best operations "  + bestOperationCombination);
        }
        else
        {
            System.out.println("Close " + currentBestValue);
        }
        
        // Size 6
        for (ArrayList<Integer> numItr : numberPermutationsOfSize6)
        {
            if (currentBestValue == targetValue)
            {
                break;
            }
            
            for (ArrayList<Integer> opItr : operationCombinationsOfSize5)
            {
                if (currentBestValue == targetValue)
                {
                    break;
                }
                
                int foo = Solver.testThisShit(numItr, opItr, false);
                
                if (Math.abs(targetValue - currentBestValue) > Math.abs(targetValue - foo))
                {
                    System.out.println("Updating current best from " + currentBestValue
                            + " numbers " + bestNumberPermutation.toString() 
                            + " bestOp " + bestOperationCombination.toString());
                    
                    currentBestValue = foo;
                    bestNumberPermutation = numItr;
                    bestOperationCombination = opItr;
                }
            }
        }
        
        if (currentBestValue == targetValue)
        {
            System.out.println("We won!");
            System.out.println("Best numbers " + bestNumberPermutation);
            System.out.println("Best operations "  + bestOperationCombination);
        }
        else
        {
            System.out.println("Close " + currentBestValue);
        }
        // TODO: need to permute differently
//        operationPermutations = permute(operationsAsNumbers);

        // evaluations method

        // Show your work!
        rachelRiley.presentAnswer(bestNumberPermutation, bestOperationCombination);
    }
    
    private List<ArrayList<Integer>> calculatePermuationSubset(final List<ArrayList<Integer>> input)
    {
    	ArrayList<ArrayList<Integer>> operationPermutations = new ArrayList<ArrayList<Integer>>();
    	
    	for(ArrayList<Integer> itr : input)
    	{
    	    ArrayList<Integer> copy = new ArrayList<Integer>(itr);
    	    
    	copy.remove(copy.size() - 1);
    		operationPermutations.add(new ArrayList<>(copy));
    		//printArray(itr);
    	}
    	
    	return operationPermutations;
    	
    }

    private List<ArrayList<Integer>> permute(final List<Integer> elementsToPermute, int sizeOfCollection)
    {
    	ArrayList<ArrayList<Integer>> operationPermutations = new ArrayList<ArrayList<Integer>>();
        final int n = sizeOfCollection;
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int[] elements = new int[elementsToPermute.size()];
        for (int i = 0; i < elementsToPermute.size(); i++)
        {
            elements[i] = elementsToPermute.get(i);
            temp.add(elementsToPermute.get(i));
        }

        int[] indexes = new int[sizeOfCollection];
        for (int i = 0; i < sizeOfCollection; i++) {
            indexes[i] = 0;
        }

        
        //printArray(elements);
        operationPermutations.add(new ArrayList<>(temp));
        //printArray(temp);

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(temp, i % 2 == 0 ?  0: indexes[i], i);
                //printArray(temp);
                operationPermutations.add(new ArrayList<>(temp));
                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }

        // fix this
        return  operationPermutations;
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
    
    private static void swap(ArrayList<Integer> input, int a, int b) {
        int tmp = input.get(a);
        input.set(a, input.get(b));
        input.set(b, tmp);
    }

    private static void printArray(List<Integer> input) {
        System.out.print('\n');
        for(int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i) + " ");
        }
    }
}
