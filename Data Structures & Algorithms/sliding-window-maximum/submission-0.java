class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        int j = 0;

        while (j <= nums.length - k) {

            int max = Integer.MIN_VALUE;

            // traverse current window
            for (int q = j; q < j + k; q++) {
                max = Math.max(max, nums[q]);
            }

            ans[j] = max;

            j++;
        }

        return ans;
        
    }
}
