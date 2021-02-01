package 数组;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/28-5:18 PM.
 * @since 2021/1/28-5:18 PM
 */
public class 三数之和_15 {

    public static void main(String[] args) {
        new 三数之和_15().threeSum(new int[]{1, 2, -3});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }


        numSet.forEach(n -> {
            for (int i : nums) {
                Set<Integer> s = new HashSet<>();
                if (numSet.contains(n - i) && !s.contains(n - i)) {
                    List<Integer> a = new ArrayList<>();
                    a.add(n);
                    a.add(i);
                    a.add(n - i);
                    result.add(a);
                    s.add(i);
                    s.add(n - i);
                }
            }
        });
        return result;
    }

}
