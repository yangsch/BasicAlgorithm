package Strings;
import java.util.*;

public class CheckInclusion {
    public boolean checkInclusion(String s1,String s2){
        int[] abc = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len1;i++){
            int a = (int)s1.charAt(i)-97;
            abc[a] = abc[a]+1;
        }
        for(int j=0;j<len2;j++){
            int b = (int)s2.charAt(j)-97;
            abc[b] = abc[b]-1;
            if(abc[b]>=0)
                stack.push(b);
            else{
                stack.clear();
                return false;
            }

        }
        if(stack.isEmpty())
            return false;
        else
            return true;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String str1 = s.nextLine().toLowerCase();
            String str2 = s.nextLine().toLowerCase();
            CheckInclusion ci = new CheckInclusion();
            System.out.println(ci.checkInclusion(str1,str2));
        }
        s.close();
    }
}
