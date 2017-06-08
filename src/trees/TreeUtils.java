package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Some utilities for doing stuff with Trees
 */
public final class TreeUtils {

    private TreeUtils() {

    }

    /**
     * Check whether a tree is balanced (the difference in height of the two subtrees is <= 1)
     * @param root The root of the tree
     * @return Whether the tree is balanced
     */
    public static boolean treeIsBalanced(TreeNode<?> root) {
        if (root == null) {
            return true;
        }

        int leftHeight = treeHeight(root.getLeft());
        int rightHeight = treeHeight(root.getRight());

        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    public static int treeHeight(TreeNode<?> root) {
        return treeHeight(root, 0);
    }

    private static int treeHeight(TreeNode<?> node, int currentHeight) {
        if (node == null) {
            return currentHeight;
        }

        int leftHeight = treeHeight(node.getLeft(), currentHeight + 1);
        int rightHeight = treeHeight(node.getRight(), currentHeight + 1);

        return Math.max(rightHeight, leftHeight);
    }

    /**
     * Determine if two trees are identical
     *
     * @param left  The left tree to compare
     * @param right The right tree to compare
     * @return Whether or not the two trees are identical
     */
    public static boolean areTreesEqual(TreeNode<?> left, TreeNode<?> right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            return left.getData().equals(right.getData())
                    && areTreesEqual(left.getLeft(), right.getLeft())
                    && areTreesEqual(left.getRight(), right.getRight());
        }

        return false;
    }

    /**
     * Print a tree using PreOrder traversal
     *
     * @param node The root of the tree to traverse
     */
    public static void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getData());
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    /**
     * Print a tree using InOrder traversal
     *
     * @param node The root of the tree to traverse
     */
    public static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        printInOrder(node.getLeft());
        System.out.println(node.getData());
        printInOrder(node.getRight());
    }

    /**
     * Print a tree using PostOrder traversal
     *
     * @param node The root of the tree to traverse
     */
    public static void printPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());
        System.out.println(node.getData());
    }

    /**
     * Print a tree level-by-level
     * This is essentially the same as a BFS in a graph
     */
    public static void printLevels(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            System.out.println(n);

            if (n.getLeft() != null) {
                queue.offer(n.getLeft());
            }

            if (n.getRight() != null) {
                queue.offer(n.getRight());
            }
        }
    }

    /**
     * Check whether a tree in a binary search tree
     * Rules for a BST are that every node has a most two children and that every
     * child on the left half of each subtree is less than the root of that subtree and that
     * every node on the right half of each subtree is greater than the root
     *
     * @param root The root of the tree to check
     * @return Whether the tree is a BST
     */
    public static boolean isBinarySearchTree(TreeNode<Integer> root) {
        if (root == null) {
            return false;
        }

        return isBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * A private helper method for use by {@link TreeUtils#isBinarySearchTree(TreeNode)}
     *
     * @param node       The root of the tree to check
     * @param lowerBound A lower bound for this sub-tree
     * @param upperBound An upper bound for this sub-tree
     * @return Whether or not this subtree is a valid BST
     */
    private static boolean isBSTRecursive(TreeNode<Integer> node, int lowerBound, int upperBound) {
        if (node == null) {
            return true;
        }

        if (node.getData() > lowerBound && node.getData() < upperBound) {
            return isBSTRecursive(node.getLeft(), lowerBound, node.getData())
                    && isBSTRecursive(node.getRight(), node.getData(), upperBound);
        } else {
            return false;
        }
    }
}
