package Strings;
import java.util.*;
public class IfSafe {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            String word = s.next();
            int sum = 0;
            if(word.length()<=4)
                sum = 5;
            else if(word.length()>4&&word.length()<8)
                sum = 10;
            else
                sum = 25;

            int les = 0;
            int leb = 0;
            int num = 0;
            int sym = 0;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(c<='z'&&c>='a')
                    les++;
                else if(c<='Z'&&c>='A')
                    leb++;
                else if(c<='9'&&c>='0')
                    num++;
                else
                    sym++;
            }
            if(les+leb==0)
                sum = sum+0;
            else if((les==0)||(leb==0))
                sum = sum+10;
            else
                sum = sum+20;

            if(num==0)
                sum += 0;
            else if(num ==1)
                sum += 10;
            else
                sum +=20;

            if(sym==0)
                sum += 0;
            else if(sym ==1)
                sum += 10;
            else
                sum +=25;

            if(((num!=0&&les!=0)&&leb!=0)&&sym!=0)
                sum +=5;
            else if((num!=0&&sym!=0)&&(les+leb!=0))
                sum +=3;
            else if((les+leb!=0)&&num!=0)
                sum +=2;

            if(sum>=90)
                System.out.println("VERY_SECURE");
            else if(sum>=80&&sum<90)
                System.out.println("SECURE");
            else if(sum>=70&&sum<80)
                System.out.println("VERY_STRONG");
            else if(sum>=60&&sum<70)
                System.out.println("STRONG");
            else if(sum>=50&&sum<60)
                System.out.println("AVERAGE");
            else if(sum>=25&&sum<50)
                System.out.println("WEAK");
            else
                System.out.println("VERY_WEAK");
        }
    }
}
