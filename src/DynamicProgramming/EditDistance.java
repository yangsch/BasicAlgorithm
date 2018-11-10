package DynamicProgramming;
import java.util.*;
/*给定两个字符串str1，str2，在给定三个整数ic,dc,rc，分别代表插入，删除和替换一个字符的代价。返回将str1
  编辑成str2的代价，比如，str1="abc",str2="adc",ic=5,dc=3,rc=2,从str1到str2，将'b'换成'd'代价最小，所以返回2.
/*在构建出动态规划表的时候，关键是搞清楚每个位置上数值的来源。
  首先我们生成dp[M+1][N+1]的动态规划表，M代表str1的长度，N代表str2的长度，
  那么dp[i][j]就是str1[0..i-1]变成str2[0...j-1]的最小代价，则dp[i][j]的来源分别来自以下四种情况：
   a、首先将str1[i-1]删除，变成str1[0...i-2],然后将str1[0...i-2]变成str2[0...j-1],
   那么dp[i-1][j]就代表从str1[0..i-2]到str2[0...j-1]的最小代价，所以：DynamicProgramming[i][j] = DynamicProgramming[i-1][j]+dc;
   b、同理也可以是从str1[0...i-1]变成str2[0...j-2]，然后在插入str2[j-1],
   DynamicProgramming[i][j-1]就代表从str1[0...i-1]变成str2[0...j-2]的最小代价，所以：DynamicProgramming[i][j] = DynamicProgramming[i][j-1]+ic;
   c、如果str[i-1] == str2[j-1],则只需要将str1[0...i-2]变成str2[0...j-2]，此时dp[i][j] = DynamicProgramming[i-1][j-1];
   d、如果str1[i-1]!=str2[j-1],则我们只需要将str1[i-1]替换成str2[j-1],此时dp[i][j] = DynamicProgramming[i-1][j-1]+rc;
   在这四种情况当中，我们选取最小的一个，即为最小代价。*/
public class EditDistance {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){
            char[] str1 = s.nextLine().toCharArray();
            char[] str2 = s.nextLine().toCharArray();
            int M = str1.length;
            int N = str2.length;
            int[][] dp = new int[M+1][N+1];
            int ic=5,dc=3,rc=2;

            dp[0][0] = 0;//str1,str2都为空
            for (int i = 1;i<N+1;i++) {//str1为空，变为str2需要插入N次
                dp[0][i] = ic * i;
            }
            for (int i = 1;i<M+1;i++) {//str2为空，变成str2需要删除M次
                dp[i][0] = dc * i;
            }
            for (int i=0;i<M;i++){
                for (int j = 0;j<N;j++){
                    int x = Math.min(dc+dp[i+1][j],dp[i][j+1]+ic);
                    if (str1[i]!=str2[j])
                        dp[i+1][j+1] = Math.min(dp[i][j] + rc,x);
                    else
                        dp[i+1][j+1] = Math.min(dp[i][j],x);
                }
            }
            System.out.println(dp[M][N]);
        }
    }
}
