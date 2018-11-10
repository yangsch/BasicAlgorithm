package ArraySolutions;
import java.util.*;

public class MaxAreaBetter {
    public int maxArea(int[] height) {
        int i,j,n,l;
        n = height.length;
        int temp = height[0];
        int[] area = new int[n-1];
        int t=0;
        for(i=1;i<=n-1;i++){                       //固定x轴两点之间的距离为1到n-1,分别在每种距离里求取最大的高，以此得到这个距离里最大的面积，赋值给t
            l=0;
            for(j=0;j<n-i;j++){                    //在两点间距离为i 时，求取最大的高度(取决于两条里更短的那条)
                if(height[j]<height[j+i])
                    temp=height[j];
                else
                    temp=height[j+i];

                if(temp>l)
                    l=temp;
            }
            area[i-1]=l*i;                           //在每种距离里最大面积里得到所有组合里最大的面积并返回
            if(area[i-1]>t)
                t=area[i-1];
        }
        return t;
    }



    public static void main(String[] args) {
        int m,s,n,i;
        MaxAreaBetter max = new MaxAreaBetter();
        Scanner sb = new Scanner(System.in);
        List list = new ArrayList();
        while (!sb.hasNext("end")) {
            m = sb.nextInt();
            if (m >= 0)                  //把大于0的整数a依次放进list，长度可变，可放任意多的数
                list.add(m);
        }
        sb.close();
        s = list.size();
        int[] height = new int[s];     //把list中的数放入数组height中
        for(i=0;i<s;i++){
            height[i] = (int)list.get(i);
        }
        n = max.maxArea(height);          //计算最大的面积并返回
        System.out.println(n);
    }
}

