package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/add-two-numbers/#/description
 * Created by wangl on 2017/7/13.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newHead = null;
        ListNode newTail = null;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int carry = 0;
        while (c1 != null && c2 != null) {

            int val = c1.val + c2.val + carry;
            carry = val / 10;
            int extra = val - carry * 10;
            ListNode node = new ListNode(extra);
            if (newHead == null) {
                newHead = newTail = node;
            } else {
                newTail.next = node;
                newTail=node;
            }

            c1 = c1.next;
            c2 = c2.next;

        }

        while (c1 != null) {

            int val = c1.val + carry;
            carry = val / 10;
            ListNode node = new ListNode(val - carry * 10);
            if (newHead == null) {
                newHead = newTail = node;
            } else {
                newTail.next = node;
                newTail=node;

            }

            c1 = c1.next;

        }

        while (c2 != null) {

            int val = c2.val + carry;
            carry = val / 10;
            ListNode node = new ListNode(val - carry * 10);
            if (newHead == null) {
                newHead = newTail = node;
            } else {
                newTail.next = node;
                newTail=node;

            }

            c2 = c2.next;

        }


        if(carry!=0){
            newTail.next=new ListNode(carry);
        }


        return newHead;

    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(6);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(4);

        new AddTwoNumbers().addTwoNumbers(head1, head2);


    }


}
