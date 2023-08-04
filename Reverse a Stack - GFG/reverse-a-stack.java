//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         }
         out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if (s.isEmpty()) {
            return; // Base case: stack is empty, nothing to reverse
        }

        // Remove the top element
        int temp = s.pop();

        // Reverse the rest of the stack using recursion
        reverse(s);

        // Insert the top element at the bottom of the reversed stack
        insertAtBottom(s, temp);
    }

    // Helper function to insert an element at the bottom of the stack using recursion
    private static void insertAtBottom(Stack<Integer> s, int x) {
        if (s.isEmpty()) {
            s.push(x);
            return; // Base case: stack is empty, insert the element
        }

        // Remove the top element
        int temp = s.pop();

        // Insert the element at the bottom of the rest of the stack using recursion
        insertAtBottom(s, x);

        // Insert the removed top element back to the stack
        s.push(temp);
    }
}