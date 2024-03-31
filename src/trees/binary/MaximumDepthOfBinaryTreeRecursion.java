package trees.binary;

public class MaximumDepthOfBinaryTreeRecursion {

  public static void main(String[] args) {
    Integer[] values = {3, 9, 20, null, null, 15, 7};
    TreeNode root = Util.createTree(values);
    System.out.println(depth(root));
  }

  private static int depth(TreeNode root) {
    int leftDepth, rightDepth;
    if (root == null) return 0;
    leftDepth = depth(root.left);
    rightDepth = depth(root.right);
    return 1 + Math.max(leftDepth, rightDepth);
  }
}
