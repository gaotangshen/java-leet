//8MS Check Is PALINDROME every time. make it slow. and did a lot dup
public class Solution {
    List<List<String>> result = new ArrayList<>();
    ArrayList<String> output = new ArrayList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n = s.length();
        if(n<=1){
            output.add(s);
            result.add(output);
            return result;
        }
        DFS(s,0);
        return result;
    }
        public void DFS(String s,int start){
        if(start==s.length()){
            result.add((ArrayList<String> )output.clone());
            return;
        }
        for(int i=start; i<s.length(); i++){

            if(isPalindrome(s.substring(start,i+1))){
                output.add(s.substring(start,i+1));
                DFS(s,i+1);
                output.remove(output.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        if(s.length()==1){
            return true;
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}

//5ms Much better use DP(Dynamic programing) 
public class Solution {
    List<List<String>> result = new ArrayList<>();
    ArrayList<String> output = new ArrayList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n = s.length();
        if(n<=1){
            output.add(s);
            result.add(output);
            return result;
        }
        dp = new boolean[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1){
                        dp[i][j]=true;
                    }else if((dp[i+1][j-1]==true || i+1>=j-1)){
                        dp[i][j]=true;
                    }
                }
            }
        }
        DFS(s,0);
        return result;
    }
    public void DFS(String s,int start){
        if(start==s.length()){
            result.add((ArrayList<String> )output.clone());
            return;
        }
        for(int i=start; i<s.length(); i++){

            if(dp[start][i]){
                output.add(s.substring(start,i+1));
                DFS(s,i+1);
                output.remove(output.size()-1);
            }
        }
    }


}