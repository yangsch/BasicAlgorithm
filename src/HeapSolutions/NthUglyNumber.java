package HeapSolutions;
/*从1开始每个数测试是否为丑数，是的话m+1,直至m=n。
 计算量大，超时*/
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int m = 1;
        int i = 1;
        while(m!=n){
            i++;
            if(UglyNumber(i)==true)
                m++;
        }
        return i;
    }
/*如果数x可以被2,3,5中任何一个除尽，得到结果仍旧可以被2,3,5中任何一个除尽直至为1，x就为丑数*/
    public boolean UglyNumber(int x){
        while((x%2 == 0)||(x%3 == 0)||(x%5 == 0)){
            if(x%2 == 0)
                x = x/2;
            if(x%3 == 0)
                x = x/3;
            if(x%5 == 0)
                x = x/5;
        }
        if(x==1)
            return true;
        else
            return false;
    }
}
