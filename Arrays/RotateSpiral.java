package Arrays;

import java.util.*;

public class RotateSpiral {

    // Function to print the matrix in spiral order
    public static void printSpiral(int mat[][]){
        List<Integer> ans = new ArrayList<>();
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns
        int top = 0;           // Initialize top boundary
        int left = 0;          // Initialize left boundary
        int right = m - 1;     // Initialize right boundary
        int bottom = n - 1;    // Initialize bottom boundary

        // Traverse the matrix in spiral order
        while(top <= bottom && left <= right){
            // Traverse from left to right along the top row
            for(int i = left; i <= right; i++){
                ans.add(mat[top][i]);
            }
            top++; // Move the top boundary down

            // Traverse from top to bottom along the right column
            for(int i = top; i <= bottom; i++){
                ans.add(mat[i][right]);
            }
            right--; // Move the right boundary left

            // Traverse from right to left along the bottom row, if still within bounds
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    ans.add(mat[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            // Traverse from bottom to top along the left column, if still within bounds
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    ans.add(mat[i][left]);
                }
                left++; // Move the left boundary right
            }
        }
        // Print the spiral order as a list
        System.out.print(ans);
    }

    public static void main(String[] args) {
        int mat[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        printSpiral(mat);
    }   
}