package org.korotovsky.bst.tree;

public class TreeNode<T> {
    private TreeNode<T> rightChild;
    private TreeNode<T> leftChild;
    private TreeNode<T> parent;
    private Comparable key;
    private T data;

    public TreeNode(TreeNode<T> parent, Comparable key, T data) {
        this.key = key;
        this.data = data;
        this.parent = parent;
    }

    public Comparable getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public String getLine() {
        return "[" + getKey() + ", " + getData() + "]";
    }
}
