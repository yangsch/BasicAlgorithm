package Numbers;

import java.util.*;
public class MAIN{
    private static int factorial(int i){
        if(i==1)
            return 1;
        else
            return i*factorial(i-1);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            int num = s.nextInt();
            int sum = factorial(num);
            int count = 0;
            while(sum/10!=0){
                if (sum%10==0){
                    count++;
                    sum = sum/10;
                }else
                    break;
            }
            System.out.println(String.valueOf(count));
        }
    }
}

