package 链表;

/**
 * <pre>
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * </pre>
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/2/3-12:01 AM.
 * @since 2021/2/3-12:01 AM
 */
public class 反转链表_206 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        new 反转链表_206().reverseList(l1);
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //注意这里返回上一个,我返回了next........
        return pre;
    }
}
