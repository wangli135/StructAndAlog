package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/rotate-list/#/description
 * Created by Xingfeng on 2017-07-06.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return head;


        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        cur = head;

        k = k % len;

        int step = len - k;

        while (step > 1) {
            cur = cur.next;
            step--;
        }

        ListNode newHead = null, newTail = null;

        while (cur != null) {

            ListNode next = cur.next;
            if (next != null) {

                cur.next = next.next;
                if (newHead == null) {
                    next.next = head;
                    newHead = newTail = next;
                } else {
                    next.next = head;
                    newTail.next = next;
                    newTail = next;
                }

            } else {
                break;
            }

        }

        if (newHead == null)
            newHead = head;

        return newHead;


    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        new RotateList().rotateRight(head, 0);

    }

}
