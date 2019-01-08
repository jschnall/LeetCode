/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int carry = sum / 10;
        ListNode result = new ListNode(sum % 10);
        ListNode node = result;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        // If one number has more digits, one of these will run
        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            l2 = l2.next;
            node = node.next;
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return result;
    }
}