public class Solution {
    List<String> l = new ArrayList<String>();
    Map<String,Integer> visited = new HashMap<String,Integer>();
    public List<String> removeInvalidParentheses(String s) {
        int m = isValid(s);
        if(isValid(s)==0){
            l.add(s);
            visited.put(s,1);
            return l;
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='(' && s.charAt(i)!=')'){
                continue;
            }
            String ns = s.substring(0,i)+s.substring(i+1);
            if(visited.get(ns)==null&isValid(ns)<m){
                visited.put(ns,1);
                removeInvalidParentheses(ns);
            }
        }
        return l;
    }
    public int isValid(String s){
        int a=0 ,b = 0;
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            if(c == '('){
                a++;
            }else if(c == ')'){
                a--;
            }
            if(a<0) b ++;
            a = Math.max(a,0);
            
        }
        return a+b;
    }
}