class Solution {
    public int minimumDeleteSum(String s1, String s2) {
       int n=s1.length(), m=s2.length();
       int[][] temp=new int[n+1][m+1];
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(s1.charAt(i)==s2.charAt(j)){
                temp[i+1][j+1]=temp[i][j]+s1.charAt(i);
            }
            else{
                temp[i+1][j+1]=Math.max(temp[i][j+1],temp[i+1][j]);
            }
        }
       } 
       int total=0;
       for(int i=0;i<n;i++){
        total+=s1.charAt(i);
       }
        for(int j=0;j<m;j++){
        total+=s2.charAt(j);
       }
return total-2*temp[n][m];
    }
}