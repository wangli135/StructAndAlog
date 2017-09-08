package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/#/description
 * Created by Xingfeng on 2017-07-06.
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (true) {

            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;

            if (fast == null || slow == null) {
                break;
            }

            if (fast == slow) {
                hasCycle = true;
                break;
            }


        }

        if (hasCycle) {

            fast = head;
            while (slow != fast) {

                slow = slow.next;
                fast = fast.next;

            }

            return slow;


        }

        return null;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode thrid = new ListNode(0);
        ListNode fourth = new ListNode(-1);

        head.next = second;
        second.next = thrid;
        thrid.next = fourth;
        fourth.next = second;


        new LinkedListCycle2().detectCycle(head);

    }


}
