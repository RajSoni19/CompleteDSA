package Graph;

import java.util.*;

/**
 * Flood Fill Algorithm:
 * Given an image represented by 2D array, a starting pixel (sr, sc), and a new color,
 * replace the color of the starting pixel and all connected pixels of the same color
 * with the new color (similar to paint bucket tool in image editors).
 */
public class Floodfill {

    /**
     * DFS helper method to recursively fill connected pixels with the new color.
     * 
     * @param row - Current row position
     * @param col - Current column position
     * @param ans - Result array being filled with new color
     * @param image - Original image array (for dimension reference)
     * @param newcolor - New color to fill with
     * @param delrow - Row direction array for 4-directional movement
     * @param delcol - Column direction array for 4-directional movement
     * @param inicolor - Original color of the starting pixel (to identify connected pixels)
     */
    public static void dfs(int row,int col,int ans[][],int image[][],int newcolor,int[] delrow,int[] delcol,int inicolor){
        // Fill current pixel with new color
        ans[row][col]=newcolor;
        int n=image.length;      // Number of rows
        int m=image[0].length;   // Number of columns

        // Explore all 4 adjacent directions (right, left, down, up)
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];  // Next row position
            int ncol=col+delcol[i];  // Next column position
            
            // Check if next position is valid AND has the same initial color
            // Only fill pixels that are within bounds and match the original color
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]==inicolor){
                // Recursively fill the connected pixel
                dfs(nrow,ncol,ans,image,newcolor,delrow,delcol,inicolor);
            }
        }
    }

    /**
     * Main flood fill method that initiates the fill operation.
     * 
     * @param image - 2D array representing the image (each cell is a pixel color)
     * @param sr - Starting row coordinate
     * @param sc - Starting column coordinate
     * @param newcolor - New color to fill with
     * @return - New 2D array with flood fill applied
     */
    public static int[][] getfloodFill(int image[][],int sr,int sc,int newcolor){
         // Store the initial color of the starting pixel
         int inicolor=image[sr][sc];
         
         // Create a result array (copy of original image)
         int ans[][]=new int[image.length][image[0].length];
         for(int i=0;i<image.length;i++){
           ans[i]=Arrays.copyOf(image[i],image[i].length);
         }
         
         // Direction arrays to move in 4 directions: right, left, down, up
         int[] delrow={0,0,1,-1};
         int[] delcol={1,-1,0,0};
         
         // Start DFS from the starting pixel
         dfs(sr,sc,ans,image,newcolor,delrow,delcol,inicolor);
         
         return ans;
    }
    
    /**
     * Test method demonstrating flood fill on a sample image.
     * Starting at position (1,1) with color 1, fill with new color 2.
     */
    public static void main(String[] args) {
         // Sample image grid
         int[][] image = {
            {1, 1, 1},  // All 1's in this row
            {1, 1, 0},  // Two 1's and one 0
            {1, 0, 1}   // One 1, one 0, one 1
        };
        
        // Perform flood fill starting at (1,1) with new color 2
        int[][] ans = getfloodFill(image, 1, 1, 2);
        
        // Print the result
         for (int[] row : ans) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
