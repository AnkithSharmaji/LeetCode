//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][])
    {
        int N = grid.length;
        int[] rowUsed = new int[N];
        int[] colUsed = new int[N];
        int[][] boxUsed = new int[3][3];

        // Initialize the row, column, and box usage arrays
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    int num = grid[i][j];
                    int boxIndex = (i / 3) * 3 + j / 3;
                    rowUsed[i] |= (1 << num);
                    colUsed[j] |= (1 << num);
                    boxUsed[i / 3][j / 3] |= (1 << num);
                }
            }
        }

        return solveSudokuUtil(grid, 0, 0, rowUsed, colUsed, boxUsed);
    }

    // Helper function to recursively solve the Sudoku puzzle
    static boolean solveSudokuUtil(int[][] grid, int row, int col, int[] rowUsed, int[] colUsed, int[][] boxUsed) {
        int N = grid.length;
        if (row == N) {
            return true; // Reached the end, puzzle solved
        }

        if (col == N) {
            return solveSudokuUtil(grid, row + 1, 0, rowUsed, colUsed, boxUsed); // Move to the next row
        }

        if (grid[row][col] != 0) {
            return solveSudokuUtil(grid, row, col + 1, rowUsed, colUsed, boxUsed); // Cell is already filled, move to next cell
        }

        int boxIndex = (row / 3) * 3 + col / 3;
        for (int num = 1; num <= 9; num++) {
            if (((rowUsed[row] & (1 << num)) == 0) &&
                ((colUsed[col] & (1 << num)) == 0) &&
                ((boxUsed[row / 3][col / 3] & (1 << num)) == 0)) {
                
                // Try assigning the current number to the cell
                grid[row][col] = num;
                rowUsed[row] |= (1 << num);
                colUsed[col] |= (1 << num);
                boxUsed[row / 3][col / 3] |= (1 << num);

                // Recur to the next cell
                if (solveSudokuUtil(grid, row, col + 1, rowUsed, colUsed, boxUsed)) {
                    return true;
                }

                // Backtrack if the current assignment doesn't lead to a solution
                grid[row][col] = 0;
                rowUsed[row] &= ~(1 << num);
                colUsed[col] &= ~(1 << num);
                boxUsed[row / 3][col / 3] &= ~(1 << num);
            }
        }

        // No valid number found for the current cell, backtrack to the previous cell
        return false;
    }

    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        int N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
