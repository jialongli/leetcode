package 数组;

/**
 * <pre>
 *     给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/2/2-9:30 PM.
 * @since 2021/2/2-9:30 PM
 */
public class 有序数组中的单一元素_540 {

    public static void main(String[] args) {
        new 有序数组中的单一元素_540().singleNonDuplicate(new int[]{1,1,2,2,3,4,4});
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid - 1]) {//中点跟左边的相等，则判断除开中点，左边还剩几位数；
                if ((mid - left) % 2 == 0) {//若为偶数，则说明左边的存在答案值，改变right的值
                    right = mid - 2;
                } else {//若为奇数，则说明右边的存在答案值，改变left的值
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {//中点跟右边的相等，则判断除开中点，右边还剩几位数；
                if ((right - mid) % 2 == 0) {//若为偶数，则说明右边的存在答案值，改变left的值
                    left = mid + 2;
                } else {//若为奇数，则说明左边的存在答案值，改变right的值
                    right = mid - 1;
                }
            } else {//中点跟左右都不相等，直接返回
                return nums[mid];
            }
        }

        return nums[right];
    }
}
