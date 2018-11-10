package HashSolutions;
import java.util.*;
/*1.排序。排序可以让数据变得有序，在许多算法中都有使用。
2.定义三个指针i,left,right，i用来遍历数据，从下下标为0一直到sz-3。对于每一个i，令left=i+1，right=sz-1，
然后检查三个指针所指数据的和，如果为0，说明找到一个符合条件的组合，把三个数放入ArrayList result中，接着把left++,right--。
在HashSet threesum中进行除重，如果不在set中，就放入set和最后结果ArrayList sum中。
如果>0,则说明当前的right偏大，则把right--,因为是排序的，所以整体和会变小。
如果<0,说明当前的left偏小，则把left++,因为是排序的，所以整体的和会变大。（这里变大变小不是一定的，因为可能存在重复的数据，不影响）
这里主要要理解的是如果为0的话为什么left和right同时可以变化，这是因为要求去重，如果只改变一个还符合条件的话一定是重复的，
即使两个都改变还是可能会出现重复的组合，所以放在set中进行暴力去重。
*/
/*最优解法*/
/*set除重比较浪费时间，可以增加一个判断，left++或right- -，直至找到不一样的nums[left]和nums[left-1]*/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int i,left,right;
        int target = 0;
        Set<ArrayList<Integer>> threesum = new HashSet<ArrayList<Integer>>();
        List<List<Integer>> sum = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        for(i=0;i<nums.length-2;i++){
            left = i+1;
            right = nums.length-1;
            while(left<right){
                target = nums[i] + nums[left] + nums[right];
                if(target ==0){
                    ArrayList result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    left++;
                    right--;
                    //while (left<right && nums[left]==nums[left-1])left++;
                    //while (left<right && nums[right]==nums[right+1])right--;
                    if(!threesum.contains(result)){
                        threesum.add(result);
                        sum.add(result);
                    }
                }else{
                    if(target<0)
                        left++;
                    else
                        right--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args){
        ThreeSum ts = new ThreeSum();
        Scanner s = new Scanner(System.in);
        List l = new ArrayList<Integer>();
        while(!s.hasNext("end")){
            l.add(s.nextInt());
        }
        s.close();
        int[] nums = new int[l.size()];
        for(int i=0;i<l.size();i++){
            nums[i] = (int)l.get(i);
        }
        List<List<Integer>> sum = ts.threeSum(nums);
        System.out.println(sum);
    }
}
