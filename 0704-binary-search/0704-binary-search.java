class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
           int result=start+(end-start)/2;
           if(nums[result]==target){
            return result;
           }
           else if(target<nums[result]){
            end=result-1;
           }
           else{
            start=result+1;
           }
        }
        return -1;
        }
    }
