//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends

class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        return Tabulation(arr, n);
        // Your code here
    }
    public int Tabulation(int arr[], int n){
        int[] dp = new int[n+1];
        int prev1 = arr[0]; 
        int prev2 = Math.max(arr[0], arr[1]);
        for(int idx=2; idx<n; idx++) {
            int curr=Math.max(prev2, arr[idx]+prev1);
            prev1=prev2;
            prev2=curr;
        }

        return prev2;
    }
}