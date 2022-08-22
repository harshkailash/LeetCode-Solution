public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int up = 0, left = 0, right = n - 1, down = n - 1;
        int deltaI = 0, deltaJ = 1;
        int count = 1;
        int i = 0, j = 0;
        while ( left <= right && up <= down) {
            if (j > right) {
                deltaI = 1; 
                deltaJ = 0;
                j = right;
                up ++;
            }
            else if (i > down) {
                deltaI = 0;
                deltaJ = -1;
                i = down;
                right --;
            }
            else if (j < left) {
                deltaI = -1;
                deltaJ = 0;
                j = left;
                down --;
            }
            else if (i < up) {
                deltaI = 0;
                deltaJ = 1;
                i = up;
                left ++;
            }
            else {
                result[i][j] = count;
                count ++;
            }
            i = i + deltaI;
            j = j + deltaJ;
        }
        return result;
    }

}