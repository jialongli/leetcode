package 链表;

import java.util.List;

/**
 * <pre>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 2 个节点是值为 4 的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * </pre>
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/2/2-9:18 AM.
 * @since 2021/2/2-9:18 AM
 */
public class 链表中倒数第k个节点_offer22 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        new 链表中倒数第k个节点_offer22().getKthFromEnd(l1, 2);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        int dif = 0;
        while (fast != null) {
            if (dif >= k) {
                slow = slow.next;
            }
            dif++;
            fast = fast.next;
        }
        return slow;
    }
}
