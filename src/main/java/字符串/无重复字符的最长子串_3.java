package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/27-7:11 PM.
 * @since 2021/1/27-7:11 PM
 */
public class 无重复字符的最长子串_3 {
    public static void main(String[] args) {
        new 无重复字符的最长子串_3().lengthOfLongestSubstring("abba");
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //记录每个字符出现的位置
        Map<Character, Integer> m = new HashMap<>();
        int max = 0;
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            //没出现过
            if (m.get(tmp) == null) {
                m.put(tmp, i);
                r += tmp;
            } else {
                max = Math.max(max, r.length());
                r = r.substring(r.indexOf(tmp) + 1) + tmp;
            }
        }
        return Math.max(r.length(), max);
    }

    /**
     * 滑动窗口
     * left代表窗口的左边界
     * i不断向右移动.
     * 注意 ③ 这个位置,为啥要max
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //记录每个字符出现的位置
        Map<Character, Integer> m = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            //没出现过
            if (m.get(tmp) == null) {
                max = Math.max(max, i - left + 1);
            } else {
                //③ 这里比如abba,当再次到a时,left应该取 0 2中的最大值,刚开始是m.get(tmp)+1.结果就变成了 bba.
                left = Math.max(left, m.get(tmp) + 1);
                max = Math.max(max, i - left + 1);
            }
            m.put(tmp, i);
        }
        return max;
    }
}
