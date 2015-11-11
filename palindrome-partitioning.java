public class Solution {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> output = new LinkedList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n = s.length();

        dp = new boolean[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                
                if(s.charAt(i)==s.charAt(j)&&(dp[i+1][j-1]==true || i+1>=j-1)&& i+1<n &&j-1>=0){
                    dp[i][j]=true;
                }
            }
        }
        DFS(s,0);
        return result;
    }
    public void DFS(String s,int start){
        if(start==s.length()){
            result.add(output);
            return;
        }
        for(int i=start; i<s.length(); i++){

            if(dp[start][i]){
                output.push(s.substring(start,i+1));
                DFS(s,i);
                output.pop();
            }
        }
    }
    // public isPalindrome(String s){
    //     if(s.length()==1){
    //         return true;
    //     }
    //     for(int i=0; i<s.length(); i++){
    //         if(s.charAt(i)!=s.charAt(s.length()-i-1)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}