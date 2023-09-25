//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        PriorityQueue<Integer>p=new PriorityQueue<>();
        List<Integer>list=new ArrayList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=N-1;i>N-K-1;i--){
            for(int j=N-1;j>N-K-1;j--){

                int sum=A[i]+B[j];

                if(p.size()<K){
                    p.add(sum);
                }

                else{
                    if(p.peek()<sum){
                        p.remove();
                        p.add(sum);
                    }
                    else{
                        break;
                    }

                }
            }
        }

        while(p.size()>0){
            list.add(0,p.poll());
        }

        return list;
    }
}