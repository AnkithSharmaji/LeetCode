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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static int[] rowDir = {0, 0, -1, 1};
    static int[] colDir = {-1, 1, 0, 0};
    
    static boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    static void dfs(int x, int y, int n, int m, char[][] mat) {
        mat[x][y] = '-';
        
        for (int i = 0; i < 4; i++) {
            int newX = x + rowDir[i];
            int newY = y + colDir[i];
            
            if (isValid(newX, newY, n, m) && mat[newX][newY] == 'O') {
                dfs(newX, newY, n, m, mat);
            }
        }
    }
    
    static char[][] fill(int n, int m, char a[][]) {
        // Check top and bottom rows
        for (int j = 0; j < m; j++) {
            if (a[0][j] == 'O') {
                dfs(0, j, n, m, a);
            }
            if (a[n - 1][j] == 'O') {
                dfs(n - 1, j, n, m, a);
            }
        }
        
        // Check left and right columns
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O') {
                dfs(i, 0, n, m, a);
            }
            if (a[i][m - 1] == 'O') {
                dfs(i, m - 1, n, m, a);
            }
        }
        
        // Replace 'O' with 'X' and '-' with 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                } else if (a[i][j] == '-') {
                    a[i][j] = 'O';
                }
            }
        }
        
        return a;
    }
}
