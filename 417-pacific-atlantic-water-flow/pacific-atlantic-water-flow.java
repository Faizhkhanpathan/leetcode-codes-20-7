 import java.util.*;
class Solution {
   
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
       
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];


      for (int j = 0; j < n; j++) {
            mark(0, j, pacific, -1, -1, heights);              
            mark(m - 1, j, atlantic, -1, -1, heights);         
        }

        for (int i = 0; i < m; i++) {
            mark(i, 0, pacific, -1, -1, heights);              
            mark(i, n - 1, atlantic, -1, -1, heights);         
        }
      
      List<List<Integer>> list = new ArrayList<>();

       for (int i = 0; i <m; i++) {

        for(int j=0;j<n;j++){
            if(pacific[i][j] && atlantic[i][j]){
                List<Integer> temp =new ArrayList<>();
                temp.add(i);
                temp.add(j);
                list.add(temp);
            }
        }
      }
      
return list;
    }
   private void mark(int i, int j, boolean[][] arr, int oi, int oj, int[][] heights) {

        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] ||
    (oi >= 0 && oj >= 0 && heights[oi][oj] > heights[i][j])) return;

        arr[i][j]=true;
        mark(i+1,j,arr,i,j,heights);
        mark(i,j+1,arr,i,j,heights);
        mark(i-1,j,arr,i,j,heights);
        mark(i,j-1,arr,i,j,heights);

    }
}