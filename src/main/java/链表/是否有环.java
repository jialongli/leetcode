package 链表;

import java.util.List;

/**
 * Description Of The Class
 *
 * @author jialong2.li
 * @version 1.0.0, 2020/12/27-12:47 AM.
 * @since 2020/12/27-12:47 AM
 */
public class 是否有环 {
    /**
     * 是否有环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        //如果只有一个节点,那么不可能是环
        if (head == null || head.next == null) {
            return false;
        }
        ListNode oneStepNode = head.next;
        ListNode twoStepNode = head.next.next;
        //1.如果任意一个指针指向了null  2.两个指针指向同一个节点 都说明应该停止了.
        while (oneStepNode != null && twoStepNode != null && oneStepNode != twoStepNode) {
            oneStepNode = oneStepNode.next;
            if (twoStepNode.next == null) {
                twoStepNode = null;
            } else {
                twoStepNode = twoStepNode.next.next;
            }
        }
        if (oneStepNode == null || twoStepNode == null) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        boolean hasCycle = hasCycle(l1);
        System.out.println(hasCycle);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
