//Referred From https://medium.com/@ChrisBader/code-conquer-leetcode-6-zigzag-conversion-5b4246b6117c

/*Naive (Bruteforce) Approach run at O(n*m) complexity as n =s.length() & m = numRows
class Solution {
    public String convert(String s, int numRows) {
        // Edge Cases
        if(numRows==1||numRows>=s.length()){
            return s;
        }

        // Fill the array
        boolean travelDown = false;
        int height = 0;
        Character[][] zigzagField = new Character[numRows][s.length()];
        for(int i=0;i<s.length();i++){
            zigzagField[height][i]=s.charAt(i);
            if(height==0||height==numRows-1){
                travelDown=!travelDown; //Switch direction
            }
            height += travelDown ? 1: -1;
        }

        // Rebuild String
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<s.length();j++){
                if(zigzagField[i][j]!=null){
                    builder.append(zigzagField[i][j]);
                }
            }
        }
        return builder.toString();
    }
}*/

//Better Solution using StingBuilder class with rows array as we know height of rows already
class Solution {
    public String convert(String s, int numRows) {
        // Edge Cases
        if(numRows==1||numRows>=s.length()){
            return s;
        }

        // Create Builders
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i]=new StringBuilder();
        }

        // Fill the rows
        int height = 0;
        boolean travelDown = false;
        for(int i=0;i<s.length();i++){
            if(height==0||height==numRows-1)travelDown=!travelDown;
            rows[height].append(s.charAt(i));
            height+=travelDown?1:-1;
        }

        // Build Solution
        StringBuilder solutionBuilder=new StringBuilder();
        for(StringBuilder builder: rows){
            solutionBuilder.append(builder);
        }
        return solutionBuilder.toString();
    }
}
