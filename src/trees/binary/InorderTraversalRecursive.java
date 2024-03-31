package trees.binary;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InorderTraversalRecursive {
  public static void main(String[] args) {
    Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
    /*
           1 index 0
           /\
     2*0+1 # 2 2*0+2
             /
             3
    */

    TreeNode root = Util.createTree(values);
    List<Integer> res = new ArrayList<>();
    inorderTraversal(root, res);
    res.forEach(System.out::println);
  }

  private static void inorderTraversal(TreeNode root, List<Integer> res) {
    if (root != null) { // 1
      inorderTraversal(root.left, res);
      res.add(root.val);
      inorderTraversal(root.right, res);
    }
  }
}
