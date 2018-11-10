package DynamicProgramming;
import java.util.*;

public class Similar {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){
            char[] str1 = s.nextLine().toCharArray();
            char[] str2 = s.nextLine().toCharArray();
            int[][] dp = new int[str1.length+1][str2.length+1];
            dp[0][0] = 0;
            for(int i = 1;i<str2.length+1;i++){
                dp[0][i] = i;
            }
            for(int i = 1;i<str1.length+1;i++){
                dp[i][0] = i;
            }
            for(int i = 1;i<str1.length+1;i++){
                for(int j = 1;j<str2.length+1;j++){
                    int x = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                    if(str1[i-1]==str2[j-1])
                        dp[i][j] = Math.min(x,dp[i-1][j-1]);
                    else
                        dp[i][j] = Math.min(x,dp[i-1][j-1]+1);
                }
            }
            int n = dp[str1.length][str2.length]+1;
            System.out.println("1/"+n);
        }
    }
}
