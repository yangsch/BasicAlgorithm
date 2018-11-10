package DynamicProgramming;
import java.util.*;
/*转化成求最长递增子序列，DynamicProgramming[i]是前i+1个字符离最长递增子序列的个数
   j<i if arr[j]<arr[i], DynamicProgramming[i] = max(DynamicProgramming[j])+1,j离i越近，DynamicProgramming[j]越大，遍历j，找到最大的dp[j]*/
public class dRedraiment {
    public static int getMaxSteps(int [] arr ,int n) {
        int [] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {//从i=0开始找前i+1个字符串里的最大递增子序列
            dp[i] = 1;//DynamicProgramming[i]为前i+1个字符里最大递增子序列的个数，初始化为1，因为至少包括自己
            for (int j = 0; j < i; j++) {//循环查询i之前的i个字符串[0],[0,1],[0,1,2]...[0,1,...i-1]
                   //找到一个字符串满足 arr[j]<arr[i], DynamicProgramming[i] = DynamicProgramming[j]+1，再继续往后，
                   //在更接近i的地方找到一个字符串满足 arr[j]<arr[i]，用Math.max(DynamicProgramming[i], DynamicProgramming[j]+1)替换小的dp[i]
                if (arr[j]<arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if(dp[i]>max)           //找出最大的dp[i]
                max = dp[i];
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int n = input.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = input.nextInt();
            System.out.println(getMaxSteps(a, n));
        }
    }
}

