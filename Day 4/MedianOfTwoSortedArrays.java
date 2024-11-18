//Referred from https://medium.com/@ChrisBader/code-conquer-leetcode-4-median-of-two-sorted-arrays-250dfdff21bb

/*  Naive Approach with Time complexity O(k*log(k)) as k=n+m as 
    Collection.sort() uses variation of Merge sort
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums =  new LinkedList<>();
        for(int i = 0; i<nums1.length; i++){
            // Add nums1
            nums.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            // Add nums2
            nums.add(nums2[i]);
        }
        Collections.sort(nums);
        if(nums.size()%2==0){
            // Even amount of data
            return (double)(nums.get(nums.size()/2)+nums.get((nums.size()/2)-1))/2;
        }
        else{
            // uneven amount of data
            return nums.get(nums.size()/2);
        }
    }
}*/
/* Better Approach with Time complexity O(k/2) but we need O(k)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        int sumLength=n+m;
        int nPointer=0,mPointer=0;
        // Variables to keep track of last and 2nd last element seen
        int last=0,secondLast=0;
        for(int i=0;i<=sumLength/2;i++){
            secondLast=last;//Keep track of 2nd last element
            // Decide to move n and m pointer
            if(nPointer<n &&(mPointer>=m||nums1[nPointer]<nums2[mPointer])){
                last=nums1[nPointer];
                nPointer++;
            }
            else{
                last=nums2[mPointer];
                mPointer++;
            }
        }
        // Calculate median
        if(sumLength%2==0){
            // Even amount of data
            return(last+secondLast)/2.0;
        }
        else{
            // Uneven amount of data
            return last;
        }
    }
}*/
// Best and Most hard approach using Binary Search
//It leads to Time Complexity of O(log(k)) which is better than others
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length, m=nums2.length;
        if(n>m){
            // Ensure that binary search is on smaller array
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0, high=n;
        while(low<=high){
            // Partition nums arrays
            int partitionNums1=(low+high)/2;
            int partitionNums2=(n+m+1)/2-partitionNums1;

            // Handle edge cases for nums1
            int maxLeftNums1=(partitionNums1==0)?Integer.MIN_VALUE:nums1[partitionNums1-1];
            int minRightNums1=(partitionNums1==n)?Integer.MAX_VALUE:nums1[partitionNums1];
            // Handle edge cases for nums2
            int maxLeftNums2=(partitionNums2==0)?Integer.MIN_VALUE:nums2[partitionNums2-1];
            int minRightNums2=(partitionNums2==m)?Integer.MAX_VALUE:nums2[partitionNums2];

            // Check if we found correct partition
            if(maxLeftNums1<=minRightNums2 && maxLeftNums2<=minRightNums1){
                if((n+m)%2==0){
                    // Even total length, median is avg of two middle no.
                    return((double)Math.max(maxLeftNums1,maxLeftNums2)+Math.min(minRightNums1,minRightNums2))/2;
                }else{
                    // odd total length,median is max of left side no.
                    return (double)Math.max(maxLeftNums1,maxLeftNums2);
                }
            }else if(maxLeftNums1>minRightNums2){
                // Need to move towards left in nums1
                high=partitionNums1-1;
            }else{
                // Need to move towards right in nums1
                low=partitionNums1+1;
            }
        }
        return 0;
    }
}