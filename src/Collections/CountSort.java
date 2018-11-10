package Collections;
import java.util.*;
/*输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASII码由小到大排序输出*/
public class CountSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()) {
            String string = s.nextLine();
            char[] cha = string.toCharArray();
            HashMap<Character,Integer> hm= new HashMap<Character,Integer>();
            for(int i=0;i<cha.length;i++) {
                if(hm.containsKey(cha[i])) {
                    int value = hm.get(cha[i]);
                    value++;
                    hm.put(cha[i], value);
                }else
                    hm.put(cha[i], 1);
            }
            ArrayList<Integer> al = new ArrayList<Integer>(hm.values());//map.values()返回Collection集合，不能直接转为ArrayList,但可以在构造器中用来创建ArrayList
            al.sort(null);//若没有Comparator,就默认自然序排列,字符就是以ASCII码从小到大
		    /*如果要把一个List直接转化为Object数组，则可以直接使用Object[] o = list.toArray();
              如果要转化为Integer数组，则有以下两种方式：
              1.Integer[] integ = new Integer[al.size];  al.toArray(integ);//此时integ就有了al中的值了
              2.Integer[] integ = (Integer[])al.toArray(new Integer[0]);*/
            Integer[] integ =(Integer[])al.toArray(new Integer[0]);
            ArrayList<ArrayList<Character>> keys = new ArrayList<ArrayList<Character>>();
            for(int i=integ.length-1;i>=0;i--) {
                if(((i<integ.length-1)&&(integ[i]!=integ[i+1]))||(i==integ.length-1)) {
                    ArrayList<Character> key = new ArrayList<Character>();
                    for(Map.Entry<Character,Integer> entry :hm.entrySet()) {
                        if(entry.getValue().equals(integ[i])) {
                            key.add(entry.getKey());
                        }
                    }
                    key.sort(null);
                    keys.add(key);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(ArrayList<Character> key:keys) {//输出ArrayList<ArrayList<Character>>
                for(Character c:key) {
                    sb.append(c.toString());
                }
            }
            System.out.println(sb.toString());
        }
    }
}
