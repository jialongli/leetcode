package 回文;

/**
 * <pre>
 *
 *
 * 9.回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 ture ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 * </pre>
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/2/1-12:34 PM.
 * @since 2021/2/1-12:34 PM
 */
public class 回文数_9 {
    public static void main(String[] args) {
        boolean result = new 回文数_9().isPalindrome(1211);
        System.out.println(result);
    }

    /**
     * 是否是回文数字
     * <p>
     * 我的解法:
     * 转为字符串,反转字符串然后看是否和原有字符串相等
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        String a = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            sb.append(a.charAt(i));
        }
        if (a.endsWith(sb.toString())) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 是否是回文数字
     * <p>
     * 官方解法:
     * 反转一半就行了
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            //因为每次对比,都会少两位数,因此div要除以100
            div /= 100;
        }
        return true;
    }

//    public static void main(String[] args) {
//        System.out.println(1211%1000);
//    }
}
