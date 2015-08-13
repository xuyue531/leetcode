package com.xuyue.tree.InvertBinaryTree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * @author xuyue
 *
 */
public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
		invertChild(root);
		if (root != null) {
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}
	
	private void invertChild(TreeNode node){
		if (node != null) {
			TreeNode leftChild = node.left;
			node.left = node.right;
			node.right = leftChild;
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

//	public static void main(String[] args) {
//		InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
//		
//	}
	
	
}
