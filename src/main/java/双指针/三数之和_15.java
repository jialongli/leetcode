package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15 三数之和
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/2/3-4:45 PM.
 * @since 2021/2/3-4:45 PM
 */
public class 三数之和_15 {

    public static void main(String[] args) {
        new 三数之和_15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            //这一步,去重 -1,-1,0,1这种
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp == 0) {
                    result.add(getR(nums[i], nums[l], nums[r]));
                    //这里需要过滤掉重复
                    while (l < r && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    l++;
                    while (l < r && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    r--;
                    //小于0.说明l得向右移动
                } else if (tmp < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }


    private List<Integer> getR(int a, int b, int c) {
        List<Integer> r = new ArrayList<>();
        r.add(a);
        r.add(b);
        r.add(c);
        return r;
    }
}
