package DivideSolutions;

public class SearchMatrixBest {
/*最优解答*/
/*思路与自己的加法相同，通过一些技巧减少了代码量增快了速度
* 1.在循环中加入判断m >= 0，减少了外部专门判断数组长度是否为0的情况
* 2.将两个数组下标的判断放进了一个循环里，减少了代码量，提高了效率*/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int i = 0;
        while(m >= 0 && i < matrix[0].length){
            if(matrix[m][i] > target) {
                m--;
            }
            else if(matrix[m][i] < target) {
                i++;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
