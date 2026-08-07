class Solution {
    public int removeElement(int[] nums, int value) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != value) {
                nums[k] = nums[i];
                k++;
            }

        }

        return k;
    }
}