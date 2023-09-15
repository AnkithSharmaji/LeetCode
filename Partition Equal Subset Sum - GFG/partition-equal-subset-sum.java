//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        // If the sum is odd, we cannot partition into two equal parts
        if (sum % 2 != 0) {
            return 0;
        }
        
        int target = sum / 2;
        boolean[][] dp = new boolean[N + 1][target + 1];
        
        // Initialize the first column to true, as we can achieve sum 0 with an empty subset
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        
        // Fill the DP table
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= target; j++) {
                // If the current element is greater than the target sum, we cannot include it
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Either we include the current element or exclude it
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        
        // If dp[N][target] is true, it means there exists a partition
        return dp[N][target] ? 1 : 0;
    }
}
