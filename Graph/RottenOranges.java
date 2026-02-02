package Graph;

import java.util.*;

/**
 * Rotten Oranges Problem:
 * Given a m x n grid where:
 *   0 = empty cell
 *   1 = fresh orange
 *   2 = rotten orange
 * 
 * Every minute, a rotten orange makes adjacent fresh oranges (up, down, left, right) rotten.
 * Find the minimum time (in minutes) until all oranges rot, or -1 if impossible.
 */
public class RottenOranges {

    /**
     * Main method to find the minimum time for all oranges to rot.
     * Uses BFS (Breadth-First Search) to simulate the rotting process level by level.
     * 
     * @param grid - 2D array representing the grid (0=empty, 1=fresh, 2=rotten)
     * @return - Minimum days needed to rot all oranges, or -1 if impossible
     */
    public static int orangerot(int[][] grid){
        // Edge case: empty grid
        if(grid.length==0) return 0;
        
        int m=grid.length;      // Number of rows
        int n=grid[0].length;   // Number of columns
        int total=0;            // Total count of non-empty cells (fresh + rotten oranges)
        int count=0;            // Count of rotten oranges processed
        Queue<int[]> rotten=new LinkedList<>();  // Queue to store positions of rotten oranges

        // First pass: Count total non-empty cells and add initial rotten oranges to queue
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0) total++;           // Count all fresh (1) and rotten (2) oranges
                if(grid[i][j]==2){
                    rotten.add(new int[]{i,j});     // Add all initially rotten oranges to queue
                }
            }
        }

        // Direction arrays to explore 4 adjacent cells (right, left, down, up)
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        int days=0;

        // BFS: Process oranges level by level (each level represents one day)
        while(!rotten.isEmpty()){
            int k=rotten.size();        // Number of rotten oranges at current level
            count+=k;                   // Add current level's rotten oranges to count

            // Process all rotten oranges at current level
            for(int i=0;i<k;i++){
                int pos[]=rotten.poll();  // Dequeue a rotten orange position
                int x=pos[0],y=pos[1];    // Extract row and column

                // Check all 4 adjacent cells
                for(int d=0;d<4;d++){
                    int nx=x+dx[d];       // Next row position
                    int ny=y+dy[d];       // Next column position
                    
                    // Validate bounds and check if it's a fresh orange (1)
                    // Skip if out of bounds or not a fresh orange
                    if(nx<0 || ny<0 || nx>=m || ny>=n || grid[nx][ny]!=1 ) continue;
                    
                    grid[nx][ny]=2;                     // Mark as rotten
                    rotten.add(new int[]{nx,ny});      // Add to queue for next level
                }
            }
            
            // Increment days only if there are more oranges to process in next iteration
            if(!rotten.isEmpty()) days++;
        }

        // If total == count, all oranges were rotten (success), return days. Otherwise, return -1
        return total==count?days:-1;
    }
    
    /**
     * Test method with example grid
     * Grid:
     *   2 1 1
     *   1 1 0
     *   0 1 1
     * Expected output: 4 (minutes needed to rot all oranges)
     */
    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},  // Row 0: One rotten, two fresh oranges
            {1, 1, 0},  // Row 1: Two fresh oranges, one empty cell
            {0, 1, 1}   // Row 2: One empty cell, two fresh oranges
        };
        int res=orangerot(grid);
        System.out.println(res);
    }
}
