package DynamicProgramming;
/* if xi == yj， c[i][j] = c[i-1][j-1]+1
   if xi != yj, c[i][j] = 0
   最后求Longest Common Substring的长度等于max{ c[i][j],  1<=i<=n， 1<=j<=m}*/
import java.util.*;
public class cLongSubStr {

    public static void LCP_String(char[] str1,char[] str2){
        int[][] c = new int[str1.length][str2.length];
        Stack<Character> stack = new Stack<Character>();
        int max = 0; // store the max length of the LCP String
        int x = 0;
        int y = 0;

        for(int i=1;i<str1.length;i++){
            for(int j=1;j<str2.length;j++){
                if(str1[i] == str2[j]){
                    c[i][j] = c[i-1][j-1]+1;
                }else{
                    c[i][j] = 0;
                }
                if(c[i][j] > max){
                    max = c[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);

        for(int i=x, j=y;c[i][j] != 0;i--,j--){
            stack.add(str1[i]);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
