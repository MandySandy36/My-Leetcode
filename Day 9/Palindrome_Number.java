//Referred by https://medium.com/@ChrisBader/code-conquer-leetcode-9-palindrome-number-1baf6d0614cf

/* Naive approach by converting integer to string
class Solution {
    public boolean isPalindrome(int x) {
        String s=Integer.toString(x);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}*/

//By using mathematical formula
class Solution {
    public boolean isPalindrome(int x) {
        int z = x;  //To check original number
        int reversed = 0;   //To create reversed integer
        while(x>0){
            int lastDigit = x % 10;
            reversed = reversed*10+lastDigit;   //Formula
            x/=10;
        }
        return reversed == z;   //checking both original and reversed no. are same to be a palindrome
    }
}