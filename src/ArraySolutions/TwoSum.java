package ArraySolutions;
import java.util.*;

public class TwoSum {

    public int compare(int[] arr,int first,int tar){//将第一个加数和数组传入，此加数分别与其后面的每一个数相加判断
        int temp = 0;
        int i = 0;
        int target = tar;
        for(i=first+1;i<arr.length;i++){
            if(arr[first]+arr[i] == target){     //找到第二个加数，返回此加数的下角标
                temp = i;
                return temp;
            }
        }
        return 0;                                //以此第一个加数，与它后面所有数分别相加都不满足条件时返回0，因为满足情况的加数下角标不可能为0
    }

    public int[] twoSum(int[] arr,int tar){    //找出数组中两个相加为target的元素下标，放入数组b[2]
        int k = 0;
        int i = 0;
        int target = tar;
        int[] b= {0,0};
        for(i=0;i<arr.length-1;i++){            //从arr[0]开始至倒数第二个元素，分别作为第一个加数，调用compare(arr,i,target)
            b[0] = i;                            //将第一个加数的下角标放入b[0]
            k = compare(arr,i,target);
            if(k != 0){                          //若返回不为0，证明找到了满足条件的第二个加数，将下角标放入b[1]
                b[1] = k;
                return b;
            }
        }
        return b;
    }

    public static void main(String[] args){
        Scanner sb = new Scanner(System.in);       //扫描键盘输入
        int j;
        int target;
        TwoSum solution = new TwoSum();
        List nums = new ArrayList();               //输入数组长度不定，不能使用数组，使用容器ArrayList
        System.out.println("Your Numbers:");
        while(!sb.hasNext("end")){       //hasNext(String pattern)遇到字符串“end”之后，停止阻塞，跳出while
            nums.add(sb.nextInt());
        }
        sb.close();
        int size = nums.size();
        int[] num = new int[size-1];
        if(size>1){
            for(j=0;j<size-1;j++){                  //将AarryList的前size-1个值赋值给数组
                num[j] = (int)nums.get(j);
            }
            target = (int)nums.get(size-1);          //将AarryList的最后一个值赋值给target
            int[] out = solution.twoSum(num,target);
            System.out.println(Arrays.toString(out));//不能直接输出数组out,打印是的是数组的首地址，可以循环输出每一个数组元素
        }else{
            System.out.println("error");
        }
    }
}

