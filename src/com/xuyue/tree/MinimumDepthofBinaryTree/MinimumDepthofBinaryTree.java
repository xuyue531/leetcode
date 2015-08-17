package com.xuyue.tree.MinimumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @author xuyue
 *
 */
public class MinimumDepthofBinaryTree {
	
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}else if (root.left == null && root.right == null) {
			return 1;
		}else if (root.left == null) {
			return 1 + minDepth(root.right);
		}else if (root.right == null) {
			return 1 + minDepth(root.left);
		}
		
		return 1 + (Math.min(minDepth(root.left), minDepth(root.right)));
	}
	
	//Wrong
	/*
	public int minDepth(TreeNode root) {
		if (root != null) {
			return 1 + (Math.min(minDepth(root.left), minDepth(root.right)));
		}
		
		return 0;
	}
	*/
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	/**
	 * 给出层次遍历数组，初始化一棵二叉树，不存在的节点为null
	 * @param tree
	 * @return
	 */
	private TreeNode initTree(Integer[] tree) {
		TreeNode root = null;
		TreeNode preNode;
		boolean isLeft = true;
		boolean firstNode = true;
		
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		for (Integer node : tree) {
			if (node == null) {
				continue;
			}
			TreeNode tmpNode = new TreeNode(node);
			if (firstNode) {
				root = tmpNode;
				firstNode = false;
			}
			if ((preNode = nodes.peek()) != null) {
				if (isLeft) {
					preNode.left = tmpNode;
					isLeft = false;
				}else {
					preNode.right = tmpNode;
					nodes.poll();
					isLeft = true;
				}
			}
			nodes.offer(tmpNode);
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		MinimumDepthofBinaryTree minBinaryTree = new MinimumDepthofBinaryTree();
		Integer[] tree = {1, null, 2};
		TreeNode root = minBinaryTree.initTree(tree);
		int result = minBinaryTree.minDepth(root);
		System.out.println(result);
	}

	

}
