//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findCatalan(int n) {
        // code here
        long[] c = new long[n+1];

        int mod = 1000000007;
        c[0] = 1;

        for(int i = 1; i<=n; i++){
            for(int j =0; j<i; j++){
                c[i] = (c[i] %mod + ((c[j] % mod) * (c[i-1-j] % mod))%mod) % mod;
            }
        }

        return (int)c[n];
    }
}
        
