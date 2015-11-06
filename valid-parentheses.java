public class Solution {
    public boolean isValid(String s) {
        if(s==null){
            return false;
        }
        char[] charArray = s.toCharArray();
        Stack st = new Stack();
        for(char c : charArray){
            if(c=='[' || c=='(' || c=='{'){
                st.push(c);
            }else{
                if(st.empty()){
                    return false;
                }
                char pre = (char)st.pop();
                if(c=='}' && pre!='{'){
                    return false;
                }
                if(c==')' && pre!='('){
                    return false;
                }
                if(c==']' && pre!='['){
                    return false;
                }
            }
            
        }
        if(st.empty()){
            return true;
        }else{
            return false;
        }
    }
}