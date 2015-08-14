package com.xuyue.tree.SameTree;

/**
 * https://leetcode.com/problems/same-tree/
 * @author xuyue
 *
 */
public class SameTree {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p ==q;
		}
		if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
