public class Solution {
    public void nextPermutation(int[] nums) {
        int paNumIndex = -1;
        for (int i = nums.length - 1; i >0; i --){
            if (nums[i-1] < nums[i]){ 
                paNumIndex = i-1; 
                break; 
            } 
        } 
        if (paNumIndex != -1){ 
            int chNumIndex = -1;
            for (int i = nums.length - 1; i > paNumIndex; i --){
                if (nums[i] > nums[paNumIndex]){
                    chNumIndex = i;
                    break;
                }
            }
            int tmp = nums[paNumIndex];
            nums[paNumIndex] = nums[chNumIndex];
            nums[chNumIndex] = tmp;
        }
        int start = paNumIndex + 1, end = nums.length -1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }

    }//nextPermutation
}//Solution