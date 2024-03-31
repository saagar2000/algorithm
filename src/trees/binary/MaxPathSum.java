package trees.binary;

public class MaxPathSum {
    public static void main(String[] args) {
        Integer[] values = {3, 9, 20, null, null, 15, 7};
        TreeNode root = Util.createTree(values);
/*
        System.out.println(maxPathSum(root, Integer.MIN_VALUE));
*/
         /*
           3 index 0
           /\
          9  20 (42, 35)
             / \
            15  7
         */
    }

   /* public Map.Entry<Integer, Integer> maxPathSumInternal(TreeNode root) {
        if(root == null) return null;
        Map.Entry<Integer, Integer> lefts = maxPathSumInternal(root.left);
        Map.Entry<Integer, Integer> rights = maxPathSumInternal(root.right);
        int roots = root.val;
        Map.Entry<Integer, Integer> maxSum = new AbstractMap.SimpleEntry<>(roots + Math.max(lefts.getKey(), rights.getKey()), Math.max(Math.max(maxSum), lefts.getValue() + roots + rights.getValue()));
        return maxSum;
    }*/
}
