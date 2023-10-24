//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int palindromicPartition(String str) {
        int n = str.length();
        
        // Create a table to store minimum cut counts for each substring
        int[] minCuts = new int[n];
        
        // Create a table to store if a substring is a palindrome
        boolean[][] isPalindrome = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    min = (j == 0) ? 0 : Math.min(min, minCuts[j - 1] + 1);
                }
            }
            minCuts[i] = min;
        }
        
        return minCuts[n - 1];
    }
}
