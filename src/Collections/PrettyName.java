package Collections;
import java.util.*;

public class PrettyName {
    private static int prettyname(String name){
        char[] letters = name.toCharArray();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i =0;i<letters.length;i++){
            int value = 0;
            if(!hm.containsKey(letters[i])){
                hm.put(letters[i],1);
            }else{
                value = hm.get(letters[i])+1;
                hm.put(letters[i],value);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if(o1.getValue()>o2.getValue())
                    return 1;
                else if(o1.getValue()==o2.getValue())
                    return 0;
                else
                    return -1;
            }
        });
        int sum = 0;
        for (int i=list.size()-1;i>=0;i--){
            int pretty = list.get(i).getValue();
            sum = pretty*(26+i-list.size()+1)+sum;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            String[] strs = new String[n];
            int[] pretty = new int[n];
            for(int i =0;i<n;i++){
                strs[i] = s.next();
                pretty[i] = prettyname(strs[i]);
            }
            for(int ss:pretty)
                System.out.println(ss);
        }
    }
}
