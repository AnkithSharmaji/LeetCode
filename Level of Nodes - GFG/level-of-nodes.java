//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
           Queue<Integer> queue = new LinkedList<>();

        // Create an array to keep track of visited nodes.
        boolean[] visited = new boolean[V];

        // Initialize the queue with the first node (node 0) and mark it as visited.
        queue.add(0);
        visited[0] = true;

        // Initialize the level to 0.
        int level = 0;

        // Iterate while the queue is not empty.
        while (!queue.isEmpty()) {
            int size = queue.size(); // Get the number of nodes at the current level.

            // Process all nodes at the current level.
            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();

                // If the current node is the target node X, return the level.
                if (currentNode == X) {
                    return level;
                }

                // Explore adjacent nodes.
                for (int neighbor : adj.get(currentNode)) {
                    // If the neighbor is not visited, mark it as visited and add it to the queue.
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }

            // Increment the level for the next level of nodes.
            level++;
        }

        // If the target node X is not found, return -1 to indicate it's not in the graph.
        return -1;
    }
}