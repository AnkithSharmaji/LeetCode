//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int row [] = {-1,0,1,0};
    static int col[] = {0,1,0,-1};
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length, m = grid[0].length, count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && grid[i][j]==1){
                    makeZero(i,j,n,m,grid);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1) count++;
            }
        }

        return count;
    }

    static void makeZero(int i, int j, int n, int m, int[][] grid){
        grid[i][j]=0;

        for(int k=0; k<4; k++){
            int r = i+row[k];
            int c = j+col[k];

            if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                makeZero(r,c,n,m,grid);
            }
        }

    }
}