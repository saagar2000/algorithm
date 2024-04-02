package trees.binary;

import lombok.*;

@Getter
@EqualsAndHashCode
public class TreeNode {
    public TreeNode parent;
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode() {
    }
}
