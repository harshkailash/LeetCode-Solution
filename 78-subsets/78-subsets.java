public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null)
            return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        List<List<Integer>> toAddAll = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            toAddAll.clear();
            //get sets that are already in result
            for (List<Integer> a : result) {
                List<Integer> toAdd = new ArrayList<Integer>(a);
                toAdd.add(nums[i]);
                toAddAll.add(toAdd);
            }
            result.addAll(toAddAll);
        }
        //add empty set
        return result;
    }
}