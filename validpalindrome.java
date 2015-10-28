public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0 || s==null){
            return true;
        }
        String str = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int length = str.length();
        for(int i=0; i<length; i++){
            if(str.charAt(i) != str.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }
}