package day14;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class CBTInserter {
    List<TreeNode> memory = new ArrayList(1010);

    public CBTInserter(TreeNode root) {
        if (root == null) {
            return;
        }
        memory.add(root);
        for (int i = 0; i < memory.size(); i++) {
            TreeNode node = memory.get(i);
            if (node.left != null) {
                memory.add(node.left);
            }
            if (node.right != null) {
                memory.add(node.right);
            }
        }
    }


    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        TreeNode fa = memory.get((memory.size() - 1) >> 1);
        if (fa.left == null) {
            fa.left = newNode;
        } else {
            fa.right = newNode;
        }
        memory.add(newNode);
        return fa.val;
    }

    public TreeNode get_root() {
        return memory.get(0);
    }
}
