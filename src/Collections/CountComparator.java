package Collections;
import java.util.*;
/*输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASII码由小到大排序输出*/
/*解决如何比较两个对象大小的问题，JDK提供了两个接口 java.lang.Comparable 和 java.util.Comparator
/* Comparable 接口中只提供了一个方法： compareTo(Object obj) ，该方法的返回值是 int 。
   如果返回值为正数，则表示当前对象(调用该方法的对象)比 obj 对象“大”；反之“小”；如果为零的话，则表示两对象相等。
   Student 实现 Comparable 接口,Arrays.sort(students) 方法会将待比较的那个对象强制类型转换成 Comparable ，
   并调用 compareTo 方法，根据其返回值来判断这两个对象的“大小”从小到大排列，若没有实现Comparable，按自然序排列*/
/*Comparator 接口中定义了两个方法:compare(T o1, T o2)原理同o1.compareTo(o2)和equals方法(注意,不重写equals(T)方法总是安全的)
  Arrays.sort(T[] a, Comparator<? super T> c) ，按照比较器Comparator c 给出的比较排序算法，对T[] a数组进行排序。*/
/*Arrays提供了一系列用于对数组操作的静态方法，查找排序等等。
/*Collections也提供了一系列用于对容器类操作的静态方法，不只能处理Collection接口以及子接口的实现类，也可以处理Map接口的实现类。*/
public class CountComparator{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){
            String string = s.nextLine();
            char[] cha = string.toCharArray();
            HashMap<Character,Integer> hm= new HashMap<Character,Integer>();
            int value  = 0;
            for(int i = 0;i<cha.length;i++){
                if(hm.containsKey(cha[i])){
                    value = hm.get(cha[i]);
                    value++;
                    hm.put(cha[i],value);
                }else{
                    hm.put(cha[i],1);
                }
            }
            //将所有的键值对转换成Map.Entry进行比较，用hm.entrySet()返回的set(也是Collection集合)构造ArrayList
            List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(hm.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){//匿名内部类Comparator
                @Override//重写compare方法，参数类型与Comparator中放置的一样
                public int compare(Map.Entry<Character,Integer> c1,Map.Entry<Character,Integer> c2){
                    //compare中前者大于后者返回正整数，反之返回负整数，排序时小的在前，我们想要大的在前，所以前者大于后者返回负整数
                    if(c1.getValue()<c2.getValue())
                        return 1;
                    else if(c1.getValue()==c2.getValue()){//value相同时按照key从小到大排序吗，符合compare原来顺序
                        if(c1.getKey()<c2.getKey())
                            return -1;
                        else if(c1.getKey()<c2.getKey())
                            return 0 ;
                        else
                            return 1;
                    }
                    else
                        return -1;
                }
            });
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<Character,Integer> me:list){
                sb.append(me.getKey().toString());
            }
            System.out.println(sb.toString());
        }
    }
}
