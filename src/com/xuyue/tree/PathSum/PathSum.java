package com.xuyue.tree.PathSum;


/**
 * https://leetcode.com/problems/path-sum/
 * @author xuyue
 *
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		int newSum = sum - root.val;
		if (newSum == 0 && root.left == null && root.right == null) {
			return true;
		}
		return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
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
