//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


class Solution {
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int lastVisitedVertex = 0; // Initialize with the first vertex
        
        // Perform a Depth-First Search starting from an arbitrary vertex
        dfs(0, adj, visited);
        
        // Find the last visited vertex during the DFS
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                lastVisitedVertex = i;
                dfs(i, adj, visited);
            }
        }
        
        // Check if the lastVisitedVertex is a mother vertex by doing DFS again
        Arrays.fill(visited, false);
        dfs(lastVisitedVertex, adj, visited);
        
        // If all vertices are visited in the second DFS, the lastVisitedVertex is a mother vertex
        for (boolean visit : visited) {
            if (!visit) {
                return -1; // There is no mother vertex
            }
        }
        
        return lastVisitedVertex;
    }

    private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
