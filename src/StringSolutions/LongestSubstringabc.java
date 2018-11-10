package StringSolutions;
import java.util.*;
//适用于a~z小写字符（26个）
public class LongestSubstringabc {
    public int lengthOfLongestSubstring(String s) {
        int i,j,x,mark,sum;
        int length = 0;

        char aa = 'a';                                 //以字符a作为标准，获得26个字母在二位数组int[26][2]中对应的行数
        char[] c=s.toCharArray();

        j = 0;
        mark = 0;
        sum = 0;
          /*从j=0开始一轮无重复子序列，将b[j]作为子序列首元素，创建一个新的二位数组int[26][2]维护子序列，以字符a作为标准，获得26个字母在数组中对应的行数，
          a对应0行的两个元素，z对应25行的两个元素，没判断一个字符，找到其对应的行数，取出第二列的数，若为0，证明这个字符在子序列中没有出现过，
          将这一行第二列置1，这一行第一列记录这个字符在c中的位置，若第二列的数为1，则证明这个字符已经在子序列里出现过了，记下此时的sum，若大于length，赋值给length，
          通过这个字符对应的那一行第一列得到这个重复元素的第一个版本在原始数组b中的位置，之后就以这个位置元素的后一位（若使用这个位置之前的元素作为首元素，
          同样会碰到相同的重复情况，序列比j作为首元素的序列更短了，不用考虑）作为新一轮的子序列首元素，开始新一轮无重复子序列查找，用新的二位数组int[26][2]维护*/
        while(j<c.length){
            int[][] a = new int[26][2];
            for(x=j;x<c.length;x++){
                char cc = c[x];
                i = cc-aa;
                if(a[i][1]==0){
                    a[i][1]++;
                    a[i][0] = x;
                    sum++;
                }else{
                    if(sum>length)
                        length = sum;
                    mark = a[i][0];
                    break;
                }
            }
            if(x>=c.length){
                if(sum>length)
                    length = sum;
                return length;

            }else{
                j = mark+1;
                sum = 0;
            }
        }
        return length;
    }

    public static void main(String[] args){
        int length = 0;
        LongestSubstringabc l = new LongestSubstringabc();

        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();//接受键盘字符串

        length = l.lengthOfLongestSubstring(s);

        System.out.println(length);
    }
}

