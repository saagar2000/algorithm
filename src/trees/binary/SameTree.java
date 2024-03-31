package trees.binary;

import java.util.Objects;

public class SameTree {
  public static void main(String[] args) {
    Integer[] first = {1, 2, 3};
    Integer[] second = {1, 2, 3};
    TreeNode r1 = Util.createTree(first);
    TreeNode r2 = Util.createTree(second);
    System.out.println(isSameTree(r1, r2));
  }

  private static boolean isSameTree(TreeNode r1, TreeNode r2) {
    return r1 != null
        && r2 != null
        && Objects.equals(r1.val, r2.val)
        && isSameTree(r1.left, r2.left)
        && isSameTree(r1.right, r2.right);
  }

 /* private static boolean isSameTree(TreeNode r1, TreeNode r2) {
    // p and q are both null
    if (r1 == null && r2 == null) return true;
    // one of p and q is null
    if (r2 == null || r1 == null) return false;
    if (r1.getVal() != r2.getVal()) return false;
    return isSameTree(r1.getRight(), r2.getRight()) &&
            isSameTree(r1.getLeft(), r2.getLeft());
  }*/
}
