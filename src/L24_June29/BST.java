package L24_June29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Jun-2019
 *
 */

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] in) {
		root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;

		Node nn = new Node();
		nn.data = in[mid];

		nn.left = construct(in, lo, mid - 1);
		nn.right = construct(in, mid + 1, hi);

		return nn;

	}

	public void display() {
		System.out.println("------------------");
		display(root);
		System.out.println("------------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;

		}
		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null)
			return false;

		if (item < node.data)
			return find(node.left, item);

		else if (item > node.data)
			return find(node.right, item);

		else
			return true;

	}

	public void printInRange(int lo, int hi) {
		printInRange(root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {

		if (node == null) {
			return;
		}

		if (node.data < lo) {
			printInRange(node.right, lo, hi);
		} else if (node.data > hi) {
			printInRange(node.left, lo, hi);
		} else {

			printInRange(node.left, lo, hi);
			System.out.println(node.data);
			printInRange(node.right, lo, hi);
		}

	}

	// Ques : https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
	
	public void replaceWithSumLarger() {

		int[] sum = new int[1];

		// replaceWithSumLarger(root, sum);

		System.out.println(replaceWithSumLarger2(root, 0));
	}

	private void replaceWithSumLarger(Node node, int[] sum) {

		if (node == null)
			return;

		replaceWithSumLarger(node.right, sum);

		int temp = node.data;
		node.data = sum[0];
		sum[0] += temp;

		replaceWithSumLarger(node.left, sum);
	}

	private int replaceWithSumLarger2(Node node, int sum) {

		if (node == null)
			return sum;

		int sumOfLargerValues = replaceWithSumLarger2(node.right, sum);

		int temp = node.data;
		node.data = sumOfLargerValues;

		return replaceWithSumLarger2(node.left, sumOfLargerValues + temp);

	}

}
