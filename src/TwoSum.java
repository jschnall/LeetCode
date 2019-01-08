/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // map nums to how many times they occur
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = map.get(num);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(num, list);
        }
        for (int key : map.keySet()) {
            int key2 = target - key;
            List<Integer> list1 = map.get(key);
            if (key == key2) {
                // Array contains 2 copies of target / 2
                if (list1.size() > 1) {
                    int[] result = { list1.get(0), list1.get(1) };
                    return result;
                }
            } else if (map.containsKey(key2)) {
                // Array contains 2 different values that sum to the target
                List<Integer> list2 = map.get(key2);
                int[] result = { list1.get(0), list2.get(0) };
                return result;
            }
        }
        return null;
    }
}