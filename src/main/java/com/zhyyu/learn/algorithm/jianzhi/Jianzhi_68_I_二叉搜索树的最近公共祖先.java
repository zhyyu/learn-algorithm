package com.zhyyu.learn.algorithm.jianzhi;

/**
 * @see https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
 */
public class Jianzhi_68_I_二叉搜索树的最近公共祖先 {

    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root.val < p.val && root.val < q.val)
                return lowestCommonAncestor(root.right, p, q);
            if(root.val > p.val && root.val > q.val)
                return lowestCommonAncestor(root.left, p, q);
            return root;
        }
    }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
