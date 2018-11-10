package Collections;

import java.util.*;

public class Random {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            int n = s.nextInt();
            Set<Integer> set = new TreeSet<>();
            for(int i=0;i<n;i++){
                set.add(s.nextInt());
            }
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            for(int nn:list)
                System.out.println(nn);
        }
    }
}
