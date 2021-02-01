package 回文;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 *  
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/2/1-12:59 PM.
 * @since 2021/2/1-12:59 PM
 */
public class 回文排列_01_04 {
    public static void main(String[] args) {
        boolean b = new 回文排列_01_04().canPermutePalindrome("code");
        System.out.println(b);
    }

    /**
     * 我第一个想到的就是
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(s.charAt(i), count);
        }
        int single = 0;
        for (Integer a : map.values()) {
            if (a % 2 == 1) {
                single++;
            }
        }
        if (single > 1) {
            return false;
        } else {
            return true;
        }
    }
}
