package ArraySolutions;
import java.util.*;

class NextBig {
    public int[] nextPermutation(int[] n) {
        int[] nums = n;
        int i = nums.length-1;
        int temp;
        int j = 0;
        int m;
        /* 得到一个n个元素的随机序列，把序列看成从高位到低位的数字，
        如果要得到只大一点点的序列，就要在最靠近n的地方把大一点的元素换到高位。*/
        while(i>0){
        /*从最后两位开始比较，如果高位i-1大于右边相邻低位i 就不需要转换，
        因为不会有更大的序列（这个两个元素构成一个降序），以此类推从后往前依次比较相邻的两个元素，
        若是没有出现另一种情况,就一直往前比较直至产生i-1小于i的情况，
        可以发现此时i及之后元素构成的序列是一个降序序列。*/
            if(nums[i-1]>=nums[i]){
                i--;
            }else{
         /*当某一个高位元素i-1小于右边低位i 时，这时可以产生更大的序列，
         所以需要转换，此时i及之后元素组成的降序序列不可能更大，
         要得到更大的序列，高位i-1就需要从低位里换一个比自己更大的数过来，
         而要只大一点点，就要找比自己只大一点点的数，
         而因为此时低位及之后元素组成的的序列是降序，就往后一个一个比较，
         直到找到小于或等于自己的那个元素，这个元素的左边相邻高位就是比i-1大的最少的数，
         把他跟i-1互换，i-1及之后的序列就变大了，最高位i-1比之前大，则整个序列比之前大。
         注意，此时i及之后的元素组成的序列仍然保持降序，又因为要新序列只大一点点，
         所以就要得到最高位为i-1的最小序列，那就把i及之后的元素组成的降序序列变成升序就行了（小的数在高位）*/
                m = i;
                while((nums[i-1]<nums[m])&&(m<(nums.length-1))){    //i-1 以此跟后面的数比较，为防止m 超出数组边界，只能比较到倒数第二个元素
                    m++;
                }
                if((nums[i-1]<nums[m])&&(m>=(nums.length-1)))        //i-1 单独再跟最后一个元素比较，最终确定要跟i-1互换的m
                    m = nums.length;

                temp = nums[i-1];                                     //i-1 元素跟降序序列只比自己大一点的元素互换
                nums[i-1] = nums[m-1];
                nums[m-1] = temp;

                return reverse(nums,i);                              //大一点的数换到i-1 位置后，将i 及之后的序列变为升序序列
            }
        }
        return reverse(nums,i); //从最后两位一直比到第一位都是左边大于右边证明整个序列是一个降序序列，不能更大，按题目要求将其转换成升序序列
    }

    public int[] reverse(int[] n,int x) {                 //将降序序列转换成升序序列
        int[] nums = n;
        int temp;
        int l = x;
        int r = nums.length-1;
        while(r>l){                                        //设置两个指针l,r 分别指向数组的两端，互换两端元素，并将两个指针向中间移动，重复互换移动，直至l>=r
            temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int m,s,i;
        NextBig so = new NextBig();
        Scanner sb = new Scanner(System.in);
        List list = new ArrayList();
        while (!sb.hasNext("end")) {
            m = sb.nextInt();
            if (m >= 0)                  //把非负整数m依次放进list
                list.add(m);
        }
        sb.close();
        s = list.size();
        int[] nums = new int[s];
        for(i=0;i<s;i++){                //把list中的数放入数组nums中
            nums[i] = (int)list.get(i);
        }
        int[] n = new int[s];
        n = so.nextPermutation(nums);    //传入数组nums求其下一组更大序列，并返回排好序的序列
        System.out.println(Arrays.toString(n));
    }
}

