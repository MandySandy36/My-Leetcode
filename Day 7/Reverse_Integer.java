//Referred by https://medium.com/@ChrisBader/code-conquer-leetcode-7-reverse-integer-6d540c975e03

/* Naive Approach done by turning 32 bit integer into string
class Solution {
    public int reverse(int x) {
        String xString = String.valueOf(x);
        String yString = "";
        for(int i=0;i<xString.length();i++){
            yString+= xString.charAt(xString.length()-1-i);
        }
        if(x<0){
            yString = yString.substring(0,yString.length()-1);
            yString = "-" + yString;
        }
        int y=0;
        try{
            y=Integer.parseInt(yString);
        }catch(NumberFormatException e){
            return 0;
        }
        return y;
    }
}*/

// Mathematical Approach with shifting digits one by one
class Solution {
    public int reverse(int x) {
        int y=0;
        while(x!=0){
            int lastDigit = x%10;
            int newResult = y*10+lastDigit;
            if((newResult-lastDigit)/10 != y){
                return 0; //Overflow occured, therefore leaving 32 bit
            }
            y = newResult;
            x/=10;
        }
        return y;
    }
}