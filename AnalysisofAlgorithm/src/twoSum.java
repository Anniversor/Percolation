import java.util.HashMap;
import java.util.Map;

public class twoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int [2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public int threeSum(int[] nums){
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(map.containsKey(-(nums[i]+nums[j]))){
                    count++;
                    System.out.format("%d %d %d\n",nums[i],nums[j],-(nums[i]+nums[j]));
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,-1,-2,5,9,-7,0,18,-4,-3};
        twoSum t = new twoSum();
        System.out.println(t.threeSum(a));

    }
}
