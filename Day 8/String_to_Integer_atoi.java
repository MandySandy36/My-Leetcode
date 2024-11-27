//Referred by https://medium.com/@ChrisBader/code-conquer-leetcode-8-string-to-integer-atoi-34746c0f32ad
//Simple one as algorithm was already given in problem statement
class Solution {
    public int myAtoi(String s) {
        s = s.trim();//(Something new) To remove whitespace
        if(s.isEmpty())return 0;

        int pos=0;
        long result=0;
        int sign=1;
        if(s.charAt(pos)=='+'||s.charAt(pos)=='-'){
            sign = (s.charAt(pos++)=='-')?-1:1;
        }
        while(pos<s.length() && Character.isDigit(s.charAt(pos))){
            int currentDigit = s.charAt(pos++)-'0';
            result = result*10 + currentDigit;
            if(result<Integer.MIN_VALUE||result>Integer.MAX_VALUE){
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }
        return(int)(sign*result);
    }
}