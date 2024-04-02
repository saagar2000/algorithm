package trees.binary;

import com.sun.source.tree.*;

public class Util {

  /*

  index 0 -> 3
  left - 1 -> 5, parent - 0 -> 3
  right - 2 -> 1, parent - 0 -> 3
  Recurse with index 1
  //[3,5,1,6,2,0,8,null,null,7,4]
  //[0,1,2,3,4,5,6,7   ,8   ,9,10]
  //[null,3,3,5,5,1,1,   ,2, 2]
                   root 3(0)
             //                 \\
        left 5(1)               right 1(2)
        //     \\               //      \\
    left 6(3)   right 2(4)    left 0(5) right 8(6)
                //     \\
               7(9)    4(10)
  */
  public static TreeNode createTree(Integer[] values) {
    // i
    // 2i + 1
    // 2i + 2
    TreeNode root = new TreeNode();
    if (values.length == 0) {
      return root;
    }
    root.val = values[0];
    buildTreeRecursively(root, 0, values);
    return root;
  }
  private static void buildTreeRecursively(TreeNode root, int index, Integer[] values) {
    if (root != null) {
      if (2 * index + 1 < values.length) { // 0, 3
        if (values[2 * index + 1] == null) {
          root.left = null;
          // System.out.println(root.left);
        } else {
          TreeNode left = new TreeNode();
          left.val = values[2 * index + 1];
          left.parent = root;
          root.left = left;
          // System.out.println(root.left.val);
        }
        buildTreeRecursively(root.left, 2 * index + 1, values);
      }
      if (2 * index + 2 < values.length) { // 0, 3
        if (values[2 * index + 2] == null) {
          root.right = null;
          // System.out.println(root.right);
        } else {
          TreeNode right = new TreeNode();
          right.val = values[2 * index + 2];
          right.parent = root;
          root.right = right;
          // System.out.println(root.right.val);
        }
        buildTreeRecursively(root.right, 2 * index + 2, values);
      }

    }
  }

  public static TreeNode dfs(TreeNode root, int value) {
    if (root == null) {
      return null;
    }
    if (root.val == value) {
      return root;
    }
    TreeNode node = dfs(root.left, value);
    if (node != null) return node;
    node = dfs(root.right, value);
    return node;
  }

}
