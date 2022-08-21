class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        int maxreach =nums[0],fuel=nums[0],jumps=1;
        for(int i=1;i<n;i++){
            if(i==n-1){
                return jumps;
            }
            fuel--;
            maxreach=Math.max(maxreach,i+nums[i]);
            if(fuel==0){
                jumps++;
                if(i>=maxreach){
                    return -1;
                }
                fuel=maxreach-i;
            }
        }
        return jumps;
    }
}