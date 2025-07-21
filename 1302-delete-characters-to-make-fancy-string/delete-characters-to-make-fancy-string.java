class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
    
        for(int i=0;i<s.length();i++){
           
            int s2=ans.length();
                        if (s2 >= 2 && s.charAt(i) == ans.charAt(s2 - 1) && s.charAt(i) == ans.charAt(s2 - 2)) {
                continue;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}