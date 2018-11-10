package ArraySolutions;
import java.util.*;

public class MaxArea {
    public int maxArea(List area) {                     //求出最大的面积值，并获得此值在面积list里的位置并返回
        int j,temp;
        int key = 0;
        int size = area.size();
        int[] a = new int[size];
        for(j=0;j<size;j++){
            a[j] = (int)area.get(j);
        }
        temp = a[0];
        for(j=0;j<size;j++){
            if(temp<a[j]){
                temp = a[j];
                key = j;
            }
        }
        return key;
    }


    public int Area(int[] x1,int[] x2){              //根据两个点的坐标求出两条垂直线与X轴之间的面积
        int area;
        if(x1[1]<x2[1]){
            return area = x1[1]*(x2[0]-x1[0]);
        }else
            return area = x2[1]*(x2[0]-x1[0]);
    }



    public static void main(String[] args) {
        int i,j,m,n;
        MaxArea max = new  MaxArea();
        Scanner sb = new Scanner(System.in);
        List list = new ArrayList();
        while (!sb.hasNext("end")) {
            m = sb.nextInt();
            if (m >= 0)                  //把大于0的整数a依次放进list
                list.add(m);
        }
        sb.close();
        int size = list.size();
        int[][] dot= new int[size][2];
        for(j = 0;j< size;j++) {                    //把横坐标i=j+1放进两维数组第一列
            dot[j][0] = j+1;
        }
        for(j = 0;j< size;j++){                     //把纵坐标i处的a放进两维数组第二列
            dot[j][1] = (int)list.get(j);
        }
        int[] x1 = new int[2];
        int[] x2 = new int[2];
        List area = new ArrayList();
        List link = new ArrayList();
        for(j=0;j<size-1;j++){                      //遍历dot数组每两个
            for(i=j+1;i<size;i++){
                int[] x = new int[2];
                // 注意！把数组存入List时，存的是数组的首地址，如果想要存入不同的数据，就要不同地址的数组，所以不能复用同一个数组，每次进入循环重新创建，分配地址
                x1[0] = dot[j][0];                  //把第一个点的横坐标放进x1第一个位置
                x1[1] = dot[j][1];                  //把第一个点的纵坐标放进x1第二个位置
                x2[0] = dot[i][0];                  //把第二个点的横坐标放进x2第一个位置
                x2[1] = dot[i][1];                  //把第二个点的纵坐标放进x2第二个位置
                int a = max.Area(x1,x2);           //两重for循环计算所有组合的面积，返回面积值
                area.add(a);                        //将面积值放入area中
                x[0] = dot[j][0];                   //把第一个点的横坐标值放入x第一个位置
                x[1] = dot[i][0];                   //把第二个点的横坐标值放入x第二个位置
                link.add(x);                        //把记录两个点横坐标值得数组放入link中
            }
        }
        int key = max.maxArea(area);                //计算最大的面积，返回面积在area中的位置
        n = (int)area.get(key);                     //根据位置key获得aera中的面积
        //x1 =  (int[])link.get(key);                 //根据位置key获得link中的两个点横坐标
        //System.out.println(Arrays.toString(x1));    //以数组形式输出这两个点的横坐标
        System.out.println(n);
    }
}

