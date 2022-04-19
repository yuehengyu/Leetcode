## 题目地址(99. Recover Binary Search Tree)
https://leetcode.com/problems/recover-binary-search-tree/

## 题目描述
```text
给定一个二叉搜索树（BST）， 已知其中有两个节点的值被错误的调换了
让我们在不破坏树的结构的情况下恢复二叉树


Follow up: A solution using O(n) space is pretty straight-forward.
Could you devise a constant O(1) space solution?
如何优化到O（1）空间复杂度？
```

## 需要学习的知识点
-  Binary Search Tree（BST）特点
- 二叉树递归（Recursive）
- 二叉树遍历（Iterative）
- Inorder traversal（对于BST来说，相当于TreeNode.val从小到大进行遍历）

## 代码
### 遍历二叉树（Inorder traversal）
```java
public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        TreeNode first = null, second = null, prev = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (prev != null && prev.val >= node.val) {
                second = node;
                if (first == null) {
                    first = prev;
                } else {
                    break;
                }
            }
            prev = node;
            node = node.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
```
---
**复杂度分析**

其中N为TreeNode的数量
- 时间复杂度：O（N）
- 空间复杂度：O（N）
---
**思路讲解**

这道题我使用的是Inorder traversal， 这个一定要会无论是递归还是遍历，个人认为中序遍历是最常用的遍历之一
已知有两个节点的值被错误调换，所以一定是一个larger val被放到了smaller TreeNode， 一个smaller val被放到了larger TreeNode
我们初始化三个节点 **first**, **second**和**prev**, 我们的目标就是找到哪两个节点的值被错误调换然后交换他们，

- 我们用prev来存储上一个树节点，初始化时为`null`
- 当第一次`prev != null && curr.val < prev.val`时， 找到第一个错误节点，一定是prev。
因为第一个被找到的错误节点一定是一个`larger value`在smaller TreeNode区，被视为了prev（因为他一定是之前节点中最大的）
- 将prev节点赋给first --> `first = prev;`
- 然后继续遍历，当第二次`prev != null && curr.val < prev.val`时，找到第二个错误节点，一定是curr.
因为第二个错误节点一定是一个smaller num但是在larger TreeNode区域，被视为了当前的curr TreeNode
- 然后将错误节点curr赋给second， -->`second = curr;`， 这里为什么要检查`if (first == null)`?
因为我们需要知道当前的错误节点是第一个还是第二个来判断如何赋值。如果两个错误节点都找到了，就直接交换结束





