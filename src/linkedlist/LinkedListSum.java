package linkedlist;

public class LinkedListSum {
	
	public static class ListNode {
		int data;
		ListNode next;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	private static int getSumByIteration(ListNode head) {
		int ans = 0;
		while (head != null) {
			ans += head.data;
			head = head.next;
		}
		return ans;
	}
	
	private static int getSUmByRecursion(ListNode head) {
		if (head == null) {
			return 0;
		}
		return head.data + getSUmByRecursion(head.next);
	}
	
	private static void traversal(ListNode head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(10);
		ListNode a2 = new ListNode(34);
		ListNode a3 = new ListNode(45);
		ListNode a4 = new ListNode(66);
		ListNode a5 = new ListNode(75);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		
		System.out.println("Linked list's elements are :: " );
		traversal(a1);
		System.out.println("Sum of List by Recursion :: " + getSUmByRecursion(a1));
		System.out.println("Sum of List by Iteration :: " + getSumByIteration(a1));
		
		
	}

}
