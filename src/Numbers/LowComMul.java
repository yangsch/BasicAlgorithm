package Numbers;
import java.util.*;

public class LowComMul {
    private static int bigfactor(int max,int min){
        int res = max%min;
        if(min ==1)
            return 1;
        if(res!=0){
            int div1 = min;
            int div2 = res;
            return bigfactor(div1,div2);
        }else
            return min;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            int num1 = s.nextInt();
            int num2 = s.nextInt();
            int max = 0;
            int min = 0;
            if(num1>num2){
                max = num1;
                min = num2;
            }else{
                max = num2;
                min = num1;
            }
            int factor = bigfactor(max,min);
            System.out.println(max*min/factor);
        }
    }
}
