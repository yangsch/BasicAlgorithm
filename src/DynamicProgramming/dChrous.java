package DynamicProgramming;
import java.util.*;

public class dChrous {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int num[] = new int[n];
            for(int i=0; i<n; i++){
                num[i] = in.nextInt();
            }
            //从左到右记录最长递增子序列长度值
            int ltr[] = new int[n];
            ltr[0] = 1;
            for(int i=1; i<n; i++){
                ltr[i] = 1;
                for(int j=0; j<i; j++){
                    if(num[i] > num[j]){
                        ltr[i] = Math.max(ltr[i],ltr[j]+1);
                    }
                }
            }
            //从右到左记录最长递增子序列长度值
            int rtl[] = new int[n];
            rtl[n-1] = 1;
            for(int i=n-2; i>=0; i--){
                rtl[i] = 1;
                for(int j=n-1; j>i; j--){
                    if(num[i] >num[j])
                        rtl[i] = Math.max(rtl[i],rtl[j]+1);
                }
            }
            //注意，temp为剩余的个数，最终值要n-temp
            int temp = 0;
            for(int i=0; i<n; i++){
                if(ltr[i]+rtl[i]-1 > temp)
                    temp = ltr[i]+rtl[i]-1;
            }
            System.out.println(n-temp);
        }
    }
}
