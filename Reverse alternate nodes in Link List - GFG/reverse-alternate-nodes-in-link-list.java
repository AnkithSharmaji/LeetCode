//{ Driver Code Starts
import java.util.*;
import java.lang.*;

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

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node head)
    {
        if (head == null || head.next == null || head.next.next == null)
        {
            return;
        }

        Node evenHead = head.next;
        Node odd = head;
        Node even = evenHead;

        while (true)
        {
            if (even == null || even.next == null)
            {
                odd.next = evenHead;
                break;
            }

            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }

        Node prev = null;
        Node current = evenHead;

        while (current != null)
        {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        evenHead = prev;

        odd.next = evenHead;
    }
}
