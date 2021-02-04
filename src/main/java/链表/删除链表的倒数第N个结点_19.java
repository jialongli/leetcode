package 链表;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/29-6:34 PM.
 * @since 2021/1/29-6:34 PM
 */
public class 删除链表的倒数第N个结点_19 {

//    /**
//     * 快慢指针
//     * 快的比慢的先多走n步.
//     *
//     * @param head
//     * @param n
//     * @return
//     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int fast = n - 1;
//        int slow = 0;
//        ListNode tmp = head;
////        ListNode
//        while (tmp != null) {
//
//        }
//    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
//        ListNode l3 = new ListNode(5);
//        ListNode l4 = new ListNode(7);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        new 删除链表的倒数第N个结点_19().removeNthFromEnd(l1, 1);
        new 删除链表的倒数第N个结点_19().removeNthFromEnd(l1, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        ListNode pre = null;
        int t = 0;
        while (fast != null) {
            if (t >= n) {
                pre = slow;
                slow = slow.next;
            }
            fast = fast.next;
            t++;
        }
        //如果倒数第n个整合是header节点,那么就返回header.next就ok了
        if (pre == null) {
            head = head.next;
        } else {
            pre.next = slow.next;
        }
        return head;
    }

}
