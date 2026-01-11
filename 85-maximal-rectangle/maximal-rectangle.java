class Solution {
    public int maximalRectangle(char[][] matrix) {
       
int ans = 0;

        int m=matrix.length;
        int n=matrix[0].length;
        Stack<Integer> s=new Stack<>();
        int[] arr=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    arr[j]=0;
                }else{
                    arr[j]+=1;
                }
            }
            ans = Math.max(ans,helper(arr,s));
        }
        return ans;
    }
          public int helper(int[] arr, Stack<Integer> s) {
    s.clear();
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
        while (!s.isEmpty() && arr[i] < arr[s.peek()]) {
            int value = arr[s.pop()];
            int pse = s.isEmpty() ? -1 : s.peek();
            max = Math.max(max, (i - pse - 1) * value);
        }
        s.push(i);
    }

    while (!s.isEmpty()) {
        int value = arr[s.pop()];
        int pse = s.isEmpty() ? -1 : s.peek();
        max = Math.max(max, (arr.length - pse - 1) * value);
    }

    return max;
}

        }
    