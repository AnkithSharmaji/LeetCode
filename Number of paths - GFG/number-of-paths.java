//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int M = Integer.parseInt(inputLine[0]);
		    int N = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(M, N));
		}
	}
}




// } Driver Code Ends


class Solution{
    
    long numberOfPaths(int M, int N) {
        // Code Here
        final int mod = 1000000007;

        int n = M + N - 2;
        int r = M - 1;
        long ans = 1;

        // Calculate (n choose r) % mod
        for (int i = 1; i <= r; i++) {
            ans = (ans * (n - i + 1)) % mod;
            ans = (ans * modInverse(i, mod)) % mod;
        }

        return (int) ans;
    }

    private long modInverse(long a, int m) {
        return modPow(a, m - 2, m);
    }

    private long modPow(long base, int exp, int mod) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }

        return result;
    }
    
}