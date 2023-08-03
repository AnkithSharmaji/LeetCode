//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		 // Initialize adjacency list to represent the DAG
        // Each element in the adjacency list is a pair (destination, weight)
        @SuppressWarnings("unchecked")
        java.util.List<int[]>[] graph = new java.util.List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new java.util.ArrayList<>();
        }

        // Create the DAG from the input edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[] {to, weight});
        }

        // Initialize the distance array to store the shortest distance from source to each vertex
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Distance from source to itself is 0

        // Priority queue to implement Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {0, 0}); // Pair (vertex, distance) - Start from source vertex with distance 0

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int distance = curr[1];

            if (dist[u] < distance) {
                // Skip if the distance to the current vertex is already smaller
                continue;
            }

            // Explore all neighbors of the current vertex
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (dist[u] + weight < dist[v]) {
                    // Relaxation step - update the shortest distance if a shorter path is found
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[] {v, dist[v]});
                }
            }
        }

        // Convert -1 to unreachable vertices
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
	}
}