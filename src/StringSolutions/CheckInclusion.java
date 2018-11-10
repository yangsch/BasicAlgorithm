package StringSolutions;
import java.util.*;
public class CheckInclusion {
    public boolean checkInclusion(String s1,String s2){
        int[] abc = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        Stack<Integer> stack = new Stack();
        for(int i=0;i<len2;i++){
            int a = (int)s2.charAt(i)-97;
            abc[a] = abc[a]+1;
        }
        for(int j=0;j<len1;j++){
            int b = (int)s1.charAt(j)-97;
            abc[b] = abc[b]-1;
            if(abc[b]>=0)
                stack.push(j);
            else
                stack.clear();
        }
        if(stack.isEmpty())
            return false;
        else {
            int min = 0;
            int max = 0;
            int temp = 0;
            int n = 0;
            while (!stack.isEmpty()) {
                temp = stack.pop();
                n++;
                if (temp < min)
                    min = temp;
                if (temp > max)
                    max = temp;
            }
            if(n!=(max-min+1))
                return false;
            else
                return true;
        }
    }

    public void main(String[] args){
        CheckInclusion c = new CheckInclusion();
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        System.out.println(c.checkInclusion(s1,s2));
    }
}
