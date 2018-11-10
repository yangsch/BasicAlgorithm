package HeapSolutions;
/*最优解法*/
/*首先设置一个数组包含k个丑数，在arr[0]放入1，设置三个下标i2,i3,i5从0开始
  分别求arr[i2]*2,arr[i3]*3,arr[i5]*5，将里面最小的值放入arr[1]，
  判断是arr[i2]*2,arr[i3]*3,arr[i5]*5中的哪一个放入了arr[1]，将其响应的下标加1，另外两个稍大点的值还没有放进数组，
  所以那两个值和新值，再求arr[i2]*2,arr[i3]*3,arr[i5]*5，将里面最小的值放入arr[1]，循环直至数组arr被填满，
  这时每个arr[i]跟2,3,5的乘积都按照大小顺序放入了数组,找到最后一个返回即可*/
public class NthUglyNumberBest {
    public int nthUglyNumber(int k) {
        int[] arr = new int[k];
        int index=1;
        int i2=0;
        int i3=0;
        int i5=0;
        arr[0]=1;
        while (index < k) {
            int nextNumber = Math.min(Math.min(arr[i2]*2,arr[i3]*3),arr[i5]*5 );
            arr[index++]=nextNumber;
            if (arr[i2] * 2 <= arr[index - 1]) {
                i2++;
            }
            if (arr[i3] * 3 <= arr[index - 1]) {
                i3++;
            }
            if (arr[i5] * 5 <= arr[index - 1]) {
                i5++;
            }
        }
        return arr[index - 1];
    }
}
