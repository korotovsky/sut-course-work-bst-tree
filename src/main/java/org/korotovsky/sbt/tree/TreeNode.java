package org.korotovsky.sbt.tree;

public class TreeNode<T> {
    private TreeNode rightChild;
    private TreeNode leftChild;
    private Comparable key;
    private T data;

    public TreeNode(Comparable key, T data) {
        this.key = key;
        this.data = data;
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

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }
}
