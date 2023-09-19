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
        
        // Initialize a position variable to track the bit position.
        int position = 1;
        
        // Use bitwise AND to find the first set bit.
        while ((n & 1) == 0) {
            n >>= 1; // Right shift to check the next bit.
            position++;
        }
        
        return position;
    }
}
