public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0){
            return 0;
        }
        int curr = A[0];
        int toFill = 1;
        for (int i = 1; i < A.length; i ++){
            if (A[i] != curr){
                curr = A[i];
                A[toFill] = curr;
                toFill ++;
            }
        }//for i
        return toFill;
    }//removeDuplicates
}//Solution