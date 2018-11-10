package ArraySolutions;
import java.util.*;

public class MaxAreaBest {
    public int maxArea(int[] height) {
        int l,r,t,n,area;
        n = height.length;
        l = 0;
        r = n-1;
        t=0;
        while(l!=r){                         //设置两个指针l,r 分别指向数组的两端，如果height[l]<height[r]，想获得更大的面积
                                             // 则需l 右移，因为如果r左移，两点横轴距离减小，而高度被l 限制，面积只会更小
                                             // 同理，如果height[l]>height[r] ，则需r左移,直至l = r（每次比较完只会移动一个指针，所以一定可以到达l = r）
            if(height[l]<height[r]){
                area = height[l]*(r-l);
                if(area>t){
                    t = area;
                }
                l++;

            }else{
                area = height[r]*(r-l);
                if(area>t){
                    t = area;
                }
                r--;

            }

        }
        return t;

    }


    public static void main(String[] args) {
        int m,s,n,i;
        MaxAreaBest max = new MaxAreaBest();
        Scanner sb = new Scanner(System.in);
        List list = new ArrayList();
        while (!sb.hasNext("end")) {
            m = sb.nextInt();
            if (m >= 0)                  //把大于0的整数a依次放进list
                list.add(m);
        }
        sb.close();
        s = list.size();
        int[] height = new int[s];
        for(i=0;i<s;i++){
            height[i] = (int)list.get(i);
        }
        n = max.maxArea(height);                //计算最大的面积并返回
        System.out.println(n);
    }
}

