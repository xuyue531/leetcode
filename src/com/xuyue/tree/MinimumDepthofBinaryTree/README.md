# Minimum Depth of Binary Tree
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

# Links
- https://leetcode.com/problems/minimum-depth-of-binary-tree/
- https://leetcode.com/discuss/questions/oj/minimum-depth-of-binary-tree

# Disscuss
之前一个错误的版本是这样写的：
```
public int minDepth(TreeNode root) {
		if (root != null) {
			return 1 + (Math.min(minDepth(root.left), minDepth(root.right)));
		}	
		return 0;
	}
```

如果以上的写法，那下面这种情况：
```
    1
      \
        2
```
最小深度为`1`，咋看好像是哦，取两边比较小的深度作为最小深度。但再看这种情况：
```
         1
       /   \
      2     3
     / \   /
    4   5 6 
```
明显最小深度为`3`, 但用以上错误方法得出结果是`2`.

因此以上错误纯属本人对树深度的理解错误又想贪图代码最小化导致的。正确的解题思路应该是这样的：

*分情况讨论，没有孩子的结点是叶子，这时候递归应该返回。只有一个孩子的结点，应该返回这个子树的最小深度。有两个孩子的结点，应该比较两个子树的最小深度并返回较小的一个。*

