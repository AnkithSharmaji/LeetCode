//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
        
        // Count the occurrence of each character in the string.
        for (char c : S.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Find the first non-repeating character.
        for (char c : charCount.keySet()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }
        
        return '$'; // If no non-repeating character found, return '$'.
    }
}

