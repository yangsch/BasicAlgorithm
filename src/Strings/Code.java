package Strings;
import java.util.*;

public class Code {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String string = s.next();
        char[] cha = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        int number = 0;
        int count = 0;
        boolean error = true;
        if(string==null||string.length()==0){        //如果输入字符串为空，输出error
            error = false;
        }else if(cha[cha.length-1]<='9'&&cha[cha.length-1]>='0'){//如果字符串最后一位是数字，输出error
            error = false;
        }else{
            for(int i = 0;i<cha.length;i++){//开始遍历每一个字符
                if(cha[i]<='9'&&cha[i]>='0'){//如果cha[i]为数字，count+1
                    count++;
                }else{                       //如果cha[i]不为数字，判断count的值
                    if(count!=0){            //如果count不等于0，证明字符前面是数字，此字符要多次输出
                        if((i<cha.length-1)&&(cha[i]==cha[i+1])){//如果字符后面还有字符与其相等，输出error
                            error = false;
                            break;
                        }else{               //字符满足条件
                            StringBuilder num = new StringBuilder();//注意，建在循环内才能每次得到一个新的StringBuilder
                            while(count!=0){//通过count计数得到前面的数字占几个字符，连接起来换算成相应int
                                num.append(cha[i-count]);
                                count--;     //此次数字算出来后count清零为下次准备
                                number = Integer.parseInt(num.toString());
                            }
                            if(number<=2) {//如果换算出来的数字小于2，输出error
                                error = false;
                                break;
                            }else {        //数字符合条件，根据数字的大小输出后面的字符cha[i]
                                while(number!=0){
                                    sb.append(cha[i]);
                                    number--;    //此次cha[i]连续输出后次数number清零为下次准备
                                }
                            }
                        }
                    }else{   //count为0，证明字符前面不是数字，且通过前面的判断不是与其相等的字符
                        if((i<cha.length-2)&&(cha[i]==cha[i+1])&&(cha[i+1]==cha[i+2])){//判断是否有相同的三个连续字符
                            error = false;
                            break;
                        }else{//字符符合条件，连接输出
                            sb.append(cha[i]);
                        }
                    }
                }
            }
        }
        if(error)
            System.out.println(sb.toString());
        else
            System.out.println("!error");
    }
}
