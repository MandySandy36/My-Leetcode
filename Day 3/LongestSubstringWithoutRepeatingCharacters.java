/* Naive Approach with O(n^3) Time Complexity
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            for ( int j=i+1;j<s.length();j++){
                maxLength = Math.max(isUniqueSubstring(s.substring(i,j)),maxLength);
            }
        }
        return maxLength;
    }

    public int isUniqueSubstring(String substring){
        List<Character>foundChars = new LinkedList<Character>();
        for(int i=0;i<substring.length();i++){
            for ( Character foundChar:foundChars){
                if(substring.charAt(i)==foundChar) return -1;
            }
            foundChars.add(substring.charAt(i));
        }
        return substring.length();
    }
}*/
//Good solution by having time complexity O(n) and can be optimized further
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Handle special cases
        if(s.length()<=1) return s.length();

        // Initialize pointers for sliding window and create visited array
        int maxLength = 0;
        boolean[] visited = new boolean[256];
        int left=0,right=0;
        while(right<s.length()){
            while(visited[s.charAt(right)]){
                // Move left pointer and mark visited as false
                //until repeating character is outside the window
                visited[s.charAt(left)]=false;
                left++;
            }
            visited[s.charAt(right)]=true;
            maxLength=Math.max(maxLength,(right-left+1)); //Length of window
            right++;
        }
        return maxLength;
    }
}