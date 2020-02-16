package tree;

import tewtss.BinaryTreeEx;

public class CreateBT extends BinaryTreeEx {

	LNode root;

	public CreateBT(int item) {
		root = new LNode(item);
	}

	public CreateBT() {
	}

	public void preorder(LNode n) {
		if (n == null)
			return;
		printNode(n);
		preorder(n.left);
		preorder(n.right);
	}

	public void printNode(LNode n) {
		System.out.println(n.data);
	}

	public static void main(String[] args) {

		CreateBT bt = new CreateBT();
		bt.root = new LNode(1);

		bt.root.left = new LNode(2);
		bt.root.right = new LNode(5);
		bt.root.left.left = new LNode(3);
		bt.root.left.right = new LNode(4);
		int ht = heightOfTree(bt.root);
		System.out.println(treeToString(bt.root, ht));

	}

	/* Print nodes at the given level */
	static String treeToString(LNode root, int level) {
		String s = "";
		if (root == null)
			s = s.concat("-1");
		if (level == 1)
			s = s.concat(root.data + "");
		else if (level > 1) {
			s = s.concat(treeToString(root.left, level - 1));
			s = s.concat(treeToString(root.right, level - 1));
		}
		return s;
	}

	static int heightOfTree(LNode n) {
		if (n == null)
			return 0;
		else {
			int lht = heightOfTree(n.left);
			int rht = heightOfTree(n.right);
			if (lht > rht)
				return lht + 1;
			else
				return rht + 1;
		}

	}

	static int findLevel(LNode r, int data, int level) {

		if (r == null) {
			return -1;
		}
		if (r.data == data) {
			return level;
		}

		int l = findLevel(r.left, data, level + 1);
		return (l != -1) ? l : findLevel(r.right, data, level + 1);
	}

}

class Node {

	int data;
	LNode left, right;

	Node() {

	}

	public Node(int item) {
		data = item;
		left = null;
		right = null;
	}

}


