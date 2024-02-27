package linkedlist;

public class LinkedListDummyNode {
	
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	static int getSum(ListNode head) {
		int res = 0;
		ListNode dummy = head;
		while (dummy != null) {
			 res += dummy.val;
			 dummy = dummy.next;
		}
		return res;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(13);
		ListNode l3 = new ListNode(114);
		ListNode l4 = new ListNode(122);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		System.out.println("Sum is :: " + getSum(l1));
	}

}
