//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isPerfectNumber(long N) {
        if (N <= 1) {
            return 0; // Perfect numbers are always greater than 1
        }
        
        long sum = 1; // Initialize the sum with 1 (since 1 is a factor of all numbers)
        
        for (long i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                sum += i;
                if (i != N / i) {
                    sum += N / i;
                }
            }
        }
        
        if (sum == N) {
            return 1; // It's a perfect number
        }
        
        return 0; // It's not a perfect number
    }
}
