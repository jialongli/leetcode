package 回文;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/2/1-1:18 PM.
 * @since 2021/2/1-1:18 PM
 */
public class 最长回文串_409 {
    public static void main(String[] args) {
        System.out.println(new 最长回文串_409().longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer a = map.get(c);
            if (a == null) {
                a = 1;
            } else {
                a++;
            }
            map.put(c, a);
        }

        int result = 0;
        boolean single = false;
        for (Integer i : map.values()) {
            if (i % 2 == 1) {
                single = true;
                if (i > 1) {
                    result = result + i - 1;
                }
            } else {
                result = result + i;
            }
        }
        if (single) {
            return result + 1;
        } else {
            return result;
        }
    }

}

