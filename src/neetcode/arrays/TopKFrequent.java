package neetcode.arrays;

import java.util.*;

/**
 * Map value with frequency count. Arrange the values by frequency (index). Iterate frequencies array backwards and pick values.
 */
public class TopKFrequent {
  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 2, 2, 3};
    int k = 2;
    System.out.println(
        Arrays.toString(iTopKFrequent(nums, k).stream().mapToInt(Integer::intValue).toArray()));
  }

  private static List<Integer> iTopKFrequent(int[] nums, int k) {
    List<Integer>[] count = new List[nums.length + 1];
    Map<Integer, Integer> mapping = new HashMap<>();
    for (int num : nums) {
      mapping.merge(num, 1, Integer::sum);
    }
    for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
      if (count[entry.getValue()] == null) {
        count[entry.getValue()] = new ArrayList<>();
      }
      count[entry.getValue()].add(entry.getKey());
    }
    List<Integer> res = new ArrayList<>();
    for (int i = count.length - 1; i > 0; i--) {
      if (count[i] != null) {
        for (Integer n : count[i]) {
          res.add(n);
          if (res.size() == k) {
            return res;
          }
        }
      }
    }
    return res;
  }
}
