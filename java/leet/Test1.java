package leet;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map  = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int value = target-nums[i];
            Integer index = map.get(value);
            if (index != null && index != i) {
                result[0] = i;
                result[1] = index;
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {2,3,4,5,6,7};
        int target = 9;
        Test1 test = new Test1();
        test.twoSum2(nums, target);
    }
}
