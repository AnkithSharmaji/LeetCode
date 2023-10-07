//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        	int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            HashMap<Node, Integer> mp = new HashMap<Node, Integer>();
            mp.put(head, head.data); 
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
                mp.put(tail, tail.data); 
            }
            
            Node failure = new Node(-1);
            
            Solution g = new Solution();
            head = g.pairwiseSwap(head);
            
            Node temp = head;
            int f = 0;
            while (temp != null) 
    		{ 
    			if(mp.get(temp) != temp.data){
    			    f = 1;
    			}
    			temp = temp.next; 
    		} 
            
            if(f==1){
                printList(failure); 
            }
            else{
                printList(head); 
            }
            t--;
        }
    } 
} 
   

// } Driver Code Ends


/* node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/



class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node start)
    {
        // code here
        if(start.next == null){
           return start;
       }
        //for first 2 node
        Node p = start;
        Node q = p.next;
        p.next = q.next;
        q.next = p;

        start = q;
        p = null;
        q = null;

        //for rest of the node.
        p = start;
        if(p.next.next!=null){
            p = p.next.next;
        }else{
            return start;
        }
        if(p.next == null){
            return start;
        }
        Node prev = start.next;
        q = p.next;

        while(q!=null){
            p.next = q.next;
            q.next = p;
            prev.next = q;
            prev = p;
            if(p.next == null){
                break;
            }
            p=p.next;
            q = p.next;
        }

        return start;
    }
}