package DivideSolutions;

public class SearchMatrix {
/*先从多维数组的第一个子数组里开始搜索，因为子数组内部是升序排列，从最后一个开始找起，直到找到某一位matrix[0][j]小于target,
再从第二个子数组里找，因为子数组之间也是升序排列，所以直接从matrix[1][j]开始往小的找，因为matrix[1][j+1]肯定大于matrix[0][j+1]，
遇到相等的就返回true，如果在某一个子数组，直至j=0时matrix[i][j]都大于target,则直接返回false，因为下一个子数组肯定更大
注意，判断多维数据为[]和为[[]]的情况（数组长度为0或数组为空），否则会出现数组下标越界异常或空值异常*/
    public boolean searchMatrix(int[][] matrix, int target) {
        int j = 0;
        if((matrix != null)&&(matrix.length != 0)){
            if((matrix[0] != null)&&(matrix[0].length!= 0))
                j = matrix[0].length-1;
            else
                return false;
        }
        else
            return false;
        for(int i = 0;i<matrix.length;i++){
            while(matrix[i][j]>=target){
                if(matrix[i][j]==target)
                    return true;
                else{
                    if(j>0)
                        j--;
                    else
                        return false;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        SearchMatrix sm = new SearchMatrix();
        int[][] matrix = null;
        boolean x = sm.searchMatrix(matrix,0);
        System.out.println(x);
    }
}
