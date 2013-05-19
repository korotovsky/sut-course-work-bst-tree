package org.korotovsky.sbt.tree;

public class TreeNode<T> {
    private TreeNode<T> rightChild;
    private TreeNode<T> leftChild;
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
}
