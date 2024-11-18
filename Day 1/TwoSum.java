/* BruteForce Approach TC=O(n^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] solution=new int[2];
        for(int i=0;i<nums.length;i++){
            solution[0]=i;
            for(int j=0;j<nums.length;j++){
                if(i==j)
                    continue;
                if((nums[i]+nums[j])==target){
                    solution[1]=j;
                    return solution;
                }
            }
        }return null;
    }
}*/

/* Better Approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    return new int[]{i,j};
                }
            }
        }return null;
    }
}*/
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int difference=target-nums[i];
            if(numMap.containsKey(difference)){
                return new int[]{numMap.get(difference),i};
            }
            numMap.put(nums[i],i);
        }
        return null;
    }    
}