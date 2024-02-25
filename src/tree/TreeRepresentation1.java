package tree;

import java.util.*;

public class TreeRepresentation1 {

	static class Node {
		int data;
		Node right;
		Node left;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class BinaryTree {
		static int index = -1;

		public static Node buildTree(int nodes[]) {
			index++;
			if (nodes[index] == -1)
				return null;

			Node newNode = new Node(nodes[index]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);

			return newNode;
		}
	}

	public static void preorder(Node node) {
		if (node == null) {
			//System.out.print(-1 + ", ");
			return;
		}
		System.out.print(node.data + ", ");
		preorder(node.left);
		preorder(node.right);
	}

	public static void inorder(Node node) {
		if (node == null) {
			//System.out.print(-1 + ", ");
			return;
		}
		inorder(node.left);
		System.out.print(node.data + ", ");
		inorder(node.right);
	}

	public static void postorder(Node node) {
		if (node == null) {
			//System.out.print(-1 + ", ");
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + ", ");
	}

	public static void levelOrderTraversal(Node node) {
		if (node == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);

		while (!queue.isEmpty()) {
			Node currNode = queue.remove();
			if (currNode == null) {
				System.out.println();
				if (queue.isEmpty())
					break;
				else
					queue.add(null);
			} else {
				System.out.print(currNode.data + ", ");
				if (currNode.left != null) {
					queue.add(currNode.left);
				}
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
			}
		}
	}

	public static int countOfNodes(Node node) {

		if (node == null)
			return 0;

		int leftNode = countOfNodes(node.left);
		int rightNode = countOfNodes(node.right);

		return leftNode + rightNode + 1;
	}

	public static int heightOfTree(Node node) {
		if (node == null)
			return 0;
		int leftNode = heightOfTree(node.left);
		int rightNode = heightOfTree(node.right);
		return (leftNode > rightNode ? leftNode : rightNode) + 1;
	}

	public static int sumOfNodes(Node node) {

		if (node == null)
			return 0;

		int leftSum = sumOfNodes(node.left);
		int rightSum = sumOfNodes(node.right);

		return leftSum + rightSum + node.data;
	}

	public static int diameter(Node node) {
		if (node == null)
			return 0;
		int diam1 = diameter(node.left);
		int diam2 = diameter(node.right);
		int diam3 = heightOfTree(node.left) + heightOfTree(node.right) + 1;
		return Math.max(Math.max(diam1, diam2), diam3);
	}

	static class TreeInfo {
		int ht;
		int diam;

		TreeInfo(int ht, int diam) {
			this.ht = ht;
			this.diam = diam;
		}
	}

	public static TreeInfo diameter2(Node node) {
		if (node == null) {
			return new TreeInfo(0, 0);
		}

		TreeInfo left = diameter2(node.left);
		TreeInfo right = diameter2(node.right);
		int myHeight = Math.max(left.ht, right.ht) + 1;

		int diam1 = left.diam;
		int diam2 = right.diam;
		int diam3 = left.ht + right.ht + 1;

		int myDiam = Math.max(Math.max(diam1, diam2), diam3);
		TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
		return myInfo;

	}

	public static void main(String[] args) {
		int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree bTree = new BinaryTree();
		Node root = bTree.buildTree(nodes);
		System.out.println("\n PreOrder Traversal :: ");
		preorder(root);
		System.out.println("\n InOrder Traversal :: ");
		inorder(root);
		System.out.println("\n PostOrder Traversal :: ");
		postorder(root);
		System.out.println("\n Level Order Traversal :: ");
		levelOrderTraversal(root);
		System.out.println("\n Count of Nodes :: " + countOfNodes(root));
		System.out.println("\n Sum of Nodes :: " + sumOfNodes(root));
		System.out.println("\n Height of Nodes :: " + heightOfTree(root));
		System.out.println("\n Diameter of Nodes :: " + diameter(root));
		System.out.println("\n Diameter of Nodes :: " + diameter2(root).diam);

	}
}
