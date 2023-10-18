//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> safeNodes = new ArrayList<>();
        int[] color = new int[V];

        for (int i = 0; i < V; i++) {
            if (dfs(i, adj, color))
                safeNodes.add(i);
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    private boolean dfs(int node, List<List<Integer>> adj, int[] color) {
        if (color[node] > 0)
            return color[node] == 2;

        color[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == 2)
                continue;
            if (color[neighbor] == 1 || !dfs(neighbor, adj, color))
                return false;
        }

        color[node] = 2;
        return true;
    }
}
