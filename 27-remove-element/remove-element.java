class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length ;
        int k = 0;
        for(int i = 0 ; i<n ; i++){
            if (nums[i] != val ){
                nums[k] = nums[i];
                k += 1;
                
            }
        }
        return k;
    }
}