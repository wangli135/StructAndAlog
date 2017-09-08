package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/reorder-list/#/description
 * Created by Xingfeng on 2017-07-06.
 */
public class RecordList {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return;

        //Step 1:找到链表中点
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (true) {

            if (fast == null)
                break;
            else if (fast.next == null) {
                slow = slow.next;
                break;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }

        }

        //Step 2:反转链表中点之后的部分
        ListNode cur = slow.next;
        ListNode secondHead = null, prev = null;
        while (cur != null) {

            if (secondHead == null) {
                secondHead = cur;
                prev = cur;
            } else {
                prev.next = cur.next;
                cur.next = secondHead;
                slow.next = cur;
                secondHead = cur;
            }

            cur = prev.next;

        }

        //Step 3: 从newHead开始
        cur = head;
        while (secondHead != null) {

            ListNode tmp = secondHead;
            slow.next = secondHead.next;
            secondHead = slow.next;
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;

        }

    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        new RecordList().reorderList(head);

    }

}
