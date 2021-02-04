package 栈;

import java.util.Stack;

/**
 * <pre>
 *     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/2/3-12:45 AM.
 * @since 2021/2/3-12:45 AM
 */
public class 有效的括号_20 {


    public boolean isValid(String s) {
        Stack<Character> t = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '{' || c == '[') {
                t.push(c);
            } else if (c == '}' && t.pop() != '{') {
                return false;
            } else if (c == ']' && t.pop() != '[') {
                return false;
            } else if (c == ')' && t.pop() != '(') {
                return false;
            }
        }
        return true;
    }
}
