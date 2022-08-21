public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = searchR(nums, 0, nums.length - 1, target, 0);
        return result;
    }
    private int[] searchR(int[] nums, int start, int end, int target, int direction) {
        int[] result = new int[]{-1, -1};
        if (start > end) {
            return result;
        }
        int mid = (start + end) /2;
        if (nums[mid] < target) {
            return searchR(nums, mid + 1, end, target, 0);            
        }
        if (nums[mid] > target) {
            return searchR(nums, start, mid - 1, target, 0);
        }
        // nums[mid] == targe
        if (direction != 1) {
            int[] left = searchR(nums, start, mid-1, target, -1);
            result[0] = left[0] == -1?mid:left[0];
        }
        if (direction != -1) {
            int[] right = searchR(nums, mid+1, end, target, 1);
            result[1] = right[1] == -1?mid:right[1];
        }

        return result;

    }
}