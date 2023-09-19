//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int getFirstSetBit(int n){
        // If n is 0, return 0 as there is no set bit.
        if (n == 0) {
            return 0;
        }
        
        // Find the rightmost set bit using n & -n.
        int rightmostSetBit = n & -n;
        
        // Count the number of trailing zeros to get the position.
        int position = Integer.bitCount(rightmostSetBit - 1);
        
        return position + 1; // Adding 1 to get the 1-based position.
    }
}
