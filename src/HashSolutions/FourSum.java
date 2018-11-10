package HashSolutions;
import java.util.*;
/*利用三数之和的方法，在外部再加一层循环*/
/*最优解法*/
/*同样的，set除重比较浪费时间，可以增加一个判断，left++或right- -，直至找到不一样的nums[left]和nums[left-1]*/

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> st = new ArrayList<List<Integer>>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        if(nums.length <= 3) return st;

        Arrays.sort(nums);
        int sum;
        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++ ){  //j要从i+1开始，否则会出现重复，并且hashset检测不出来
                int low = j + 1;    //从j + 1开始
                int high = nums.length - 1;

                while(low < high){
                    sum = nums[i] + nums[j] + nums[low] + nums[high];

                    if(sum == target){
                        ArrayList<Integer> a = new ArrayList<Integer>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[low]);
                        a.add(nums[high]);
                        if(!set.contains(a)){ //只会检测每一位都一模一样的 比如1,0,-1和-1, 0, 1就检测不出来
                            set.add(a);
                            st.add(a);
                        }
                        low ++;
                        high --;
                    }
                    else{
                        if(sum < target){
                            low ++;
                        }
                        else{
                            high --;
                        }
                    }
                }
            }
        }
        return st;
    }

    public static void main(String[] args){
        FourSum ts = new FourSum();
        Scanner s = new Scanner(System.in);
        List l = new ArrayList<Integer>();
        while(!s.hasNext("end")){
            l.add(s.nextInt());
        }
        s.close();
        int[] nums = new int[l.size()-1];
        for(int i=0;i<l.size()-1;i++){
            nums[i] = (int)l.get(i);
        }
        int target = (int)l.get(l.size()-1);
        List<List<Integer>> sum = ts.fourSum(nums,target);
        System.out.println(sum);
    }
}
