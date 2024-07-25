package common;

public class ListNode {
        int val;
        public ListNode next;
        public ListNode() {}

        public int getVal() {
                return val;
        }

        public ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public void setVal(int val) {
                this.val = val;
        }
}