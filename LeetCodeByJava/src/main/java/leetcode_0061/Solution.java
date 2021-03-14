package leetcode_0061;

/**
 * @Author Halo
 * @Create 2021-03-10 下午 03:53
 * @Description
 */
class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        int n;
        for (n = 1; tail.next != null; n++) {
            tail = tail.next;
        }
        tail.next = head;

        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;


        new_tail.next = null;

        return new_head;
    }

}
