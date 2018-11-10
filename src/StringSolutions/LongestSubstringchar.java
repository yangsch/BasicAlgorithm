package StringSolutions;
import java.util.*;
//适用于所有可以转成char字符（16位，只能最多表示65536个字符），超出char范围（32位的unicode字符）的字符串不在此次讨论范围内
public class LongestSubstringchar {
    public int lengthOfLongestSubstring(String s) {
        int i,j,x,mark,sum,l,temp;
        int length = 0;
        int n = 0;
        char[] c=s.toCharArray();         //leetcode默认输入字符串c带引号，需要把引号之间的字符串b取出来，
                                          // leetcode会自动执行这一步，粘过去时把这一段删了
        l = c.length-2;
        char[] b = new char[l];
        while(n<l){
            b[n]=c[n+1];
            n++;
        }
        j = 0;
        mark = 0;
        sum = 0;
        temp = 0;
        /*从j=0开始一轮无重复子序列，将b[j]作为子序列首元素，用一个有序无重复元素的LinkedHashSet维护子序列，依次将元素放入sub，将sum++。
          若放入成功，证明Set内部的元素没有重复，若放入失败，证明Set内部已经有这个元素了，记下此时的sum，若大于length，赋值给length，
          为了得到这个元素跟Set内部第几个元素重复了，遍历Set，找到相同元素的位置i,将这个i与子序列首元素的位置j相加，
          就得到了这个重复元素的第一个版本在原始数组b中的位置，之后就以这个位置元素的后一位（若使用这个位置之前的元素作为首元素，
          同样会碰到相同的重复情况，序列比j作为首元素的序列更短了，不用考虑）作为新一轮的子序列首元素，开始新一轮无重复子序列查找，向新的LinkedHashSet插入元素*/
        while(j<l){
            Set sub = new LinkedHashSet();
            for(x=j;x<l;x++){
                int cc = (int)b[x];
                if(sub.add(cc)){
                    sum++;
                }else{
                    if(sum>length){                           //出现了重复元素，若此时子序列的长度大于length，就赋值给length
                        length = sum;
                    }
                    i = 0;
                    for(Object y:sub){                        //遍历sub，找到重复元素的位置
                        if(cc==(int)y){
                            temp = j+i;
                            break;                            //若已经找到了重复的元素位置，就不需要再遍历Set了，跳出for循环
                        }
                        i++;
                    }
                    mark = temp;
                    break;                                   //插入失败（出现重复）后，记录下重复元素在b中的位置，更新length为目前最大值后，
                                                              // 就break结束此j 元素作为序列首元素的这一轮子序列插入计数
                }
            }
            if(x>=l){                                         //j 元素作为序列首元素的这一轮子序列插入计数结束，有两种情况导致其结束
                                                              //如果x>=l，证明这个子序列一直运行到数组b最后一个元素都无重复，记录下目前位置最大的length后返回
                                                              //不需要再j++进行新一轮的子序列查找了，因为不能比现在这个子序列更长了
                if(sum>length)
                    length = sum;
                return length;
            }else{                                           //如果不是x>=l这种情况，那证明是子序列出现了重复，跳出了循环，这时将j = mark+1，
                                                              //下一次就从重复元素第一个版本在原始数组b中的位置之后的一位作为首元素开始新的一轮子序列，
                                                              //同时sum = 0，因为sum记录的是同一个子序列的最大长度
                j = mark+1;
                sum = 0;
            }
        }
        return length;
    }

    public static void main(String[] args){
        int length = 0;
        LongestSubstringchar l = new LongestSubstringchar();

        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();//接受键盘字符串

        length = l.lengthOfLongestSubstring(s);

        System.out.println(length);
    }
}



