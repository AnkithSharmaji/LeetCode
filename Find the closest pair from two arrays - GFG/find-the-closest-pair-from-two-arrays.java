//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function for finding the pair of elements from two arrays whose sum is closest to x
    public static ArrayList<Integer> printClosest(int arr[], int brr[], int n, int m, int x) {
        // Create an ArrayList to store the result
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Initialize two pointers, one for each array
        int i = 0; 
        int j = m - 1; 
        
        // Initialize variables to store the elements of the closest pair and their distance to x
        int a = arr[i]; 
        int b = brr[j]; 
        int dist = Integer.MAX_VALUE; 
        
        // Iterate through both arrays to find the closest pair
        while (i < n && j >= 0) {
            int sum = arr[i] + brr[j]; 
            int currDist = Math.abs(x - sum); 
            
            // If the current pair has a smaller distance to x, update the closest pair
            if (currDist < dist) {
                dist = currDist;
                a = arr[i];
                b = brr[j];
            }
            
            // Move the pointers based on the sum
            if (sum > x) {
                j--; 
            } else {
                i++; 
            }
        }
        
        
        ans.add(a);
        ans.add(b);
        
        return ans;
    }
}
