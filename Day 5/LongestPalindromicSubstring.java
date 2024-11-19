//Referred to https://medium.com/@ChrisBader/code-conquer-leetcode-5-longest-palindromic-substring-6ed45c257139
/* //Naive Bruteforce approach with O(n^3) time complexity 
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2)return s;
        int maxLength=0;
        String longestPalindrome ="";
        for(int i=0;i<s.length()-1;i++){
            for(int j=s.length()-1;j>=i;j--){
                if(j-i+1>maxLength && isPalindrome(s.toCharArray(),i,j)){
                    longestPalindrome = s.substring(i,j+1);
                    maxLength=j-i+1;
                }
            }
        }return longestPalindrome;
    }

    // Checks if string is palindrome
    public boolean isPalindrome(char[] cs, int begin, int end){
        for(int i=0;i<=(end-begin)/2;i++){
            if(cs[begin +i] != cs[end-i]){
                return false;
            }
        }
        return true;
    }
}*/

// Better approach with O(n^2) Time Complexity and interesting one
class Solution {
    public String longestPalindrome(String s) {
        int maxLength=0;
        String maxPalindrome ="";
        for(int i=0;i<s.length()-1;i++){
            String oddWord = expand(s,i,i); //Check for Odd Palindromes
            String evenWord = expand(s,i,i+1);  //Check for even Palindromes
            if(oddWord.length()>maxLength){ //Assign Oddword if applicable
                maxPalindrome = oddWord;
                maxLength= oddWord.length();
            }            
            if(evenWord.length()>maxLength){ //Assign Evenword if applicable
                maxPalindrome = evenWord;
                maxLength= evenWord.length();
            }
        }return maxPalindrome;
    }
    public String expand(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}