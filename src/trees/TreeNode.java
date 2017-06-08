package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * A binary tree node implementation, the default iterator of which will perform a pre-order traversal
 */
public class TreeNode<T extends Comparable<T>> implements Iterable<TreeNode> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }

    private TreeNode(TreeNode<T> node) {
        this.data = node.data;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    @Override
    public java.util.Iterator<TreeNode> iterator() {
        return new PreOrderIterator();
    }

    /**
     * Retrieve an Iterable version of this tree that will traverse level-by-level
     *
     * @return The Iterable version of this tree
     */
    public Iterable<TreeNode> byLevel() {
        return new Iterable<TreeNode>() {
            @Override
            public java.util.Iterator<TreeNode> iterator() {
                return new LevelIterator();
            }
        };
    }

    /**
     * The default iterator for this class that will perform a pre-order traversal
     * Without a recursive method, we need to use a stack
     */
    private class PreOrderIterator implements java.util.Iterator<TreeNode> {
        Stack<TreeNode> stack;

        PreOrderIterator() {
            stack = new Stack<TreeNode>();
            stack.push(TreeNode.this);
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public TreeNode next() {
            TreeNode current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }

            return current;
        }


        /**
         * make all combinations of words using a phone number
         * @param a
         */
        public void whatever(int... a) {
            LinkedList<Integer> q = new LinkedList<>();
        }

        @Override
        public void remove() {

        }
    }

    /**
     * An iterator that will traverse level-by-level
     * 1.) Create a queue and add the root to it
     * 2.) Pop the queue and print popped value
     * 3.) Push popped node's children to the queue and repeat step 2 until queue is empty
     */
    private class LevelIterator implements java.util.Iterator<TreeNode> {
        Queue<TreeNode> queue;

        LevelIterator() {
            this.queue = new LinkedList<>();
            queue.offer(TreeNode.this);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public TreeNode next() {
            TreeNode n = queue.poll();

            if (n.left != null) {
                queue.offer(n.left);
            }

            if (n.right != null) {
                queue.offer(n.right);
            }

            return n;
        }

        @Override
        public void remove() {

        }
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode<?> treeNode = (TreeNode<?>) o;

        if (data != null ? !data.equals(treeNode.data) : treeNode.data != null) return false;
        if (left != null ? !left.equals(treeNode.left) : treeNode.left != null) return false;
        return right != null ? right.equals(treeNode.right) : treeNode.right == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }
}
