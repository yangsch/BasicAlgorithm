package Numbers;

import java.util.*;

public class LowComMulitiple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int A=sc.nextInt();
            int B=sc.nextInt();
            int result=A*B;
            result=result/getYinShu(A,B);
            System.out.println(result);
        }
    }
    public static int getYinShu(int m,int n){
        int i=m;
        while((m%i!=0)||(n%i!=0)){
            i--;
        }
        return i;
    }
}
