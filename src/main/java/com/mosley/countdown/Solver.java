package com.mosley.countdown;

import java.util.ArrayList;
import java.util.Arrays;

public class Solver {


	public static void testSolve() 
	{
       print("hello world");
       
       // 1 = addition
       // 2 = substraction
       // 3 = multiplication
       // 4 = division
       
       ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(75,8,10,2,1));
       ArrayList<Integer> operations = new ArrayList<Integer>(Arrays.asList(1,3,1,1));
       
       testThisShit(nums, operations, true);
       
	}
	
	
	public static void print(String x)
	{
		System.out.println(x);
	}

	public static Integer testThisShit(ArrayList<Integer> numbers, ArrayList<Integer> operations, boolean print)
	{
		if(numbers.size() - operations.size() != 1)
		{
			print("not valid input");
			 System.exit(0);
		}
		
		int value = numbers.get(0);
		
		for(int i = 1; i < numbers.size(); i++)
		{
			int next = numbers.get(i);
			int nextOperation = operations.get(i - 1).intValue();
			//print(" next op = " + nextOperation);
			
			if(nextOperation == 1) // add
			{
				if(print)
				{
				  print(value + " + " + next + " = " + ( value + next));
				}
				  value += next; 
				
			}
			else if(nextOperation == 2) // sub
			{				
				if(print)
				{
				  print(value + " - " + next + " = " +  (value - next));
				}
				 value -= next; 
			}
			else if(nextOperation == 3) // mult
			{
				if(print)
				{
					print(value + " * " + next + " = " +  (value * next));
				}
				value *= next; 
			}
			else if(nextOperation == 4) // div
			{
				if(print)
				{
					print(value + " / " + next + " = " +  (value / next));
				}
				value /= next; 
				float x = value / next;
				if(("" + x).contains("."))
				{
					//print("bullshit decimals " + Integer.MAX_VALUE);
					return Integer.MAX_VALUE;
				}
			}
			else
			{
			   	 print("fatal error " + nextOperation + " is not an option");
		    	 System.exit(0);
			}
			
			
			//print("" + value);
		}
		
		return value;
	}
}
