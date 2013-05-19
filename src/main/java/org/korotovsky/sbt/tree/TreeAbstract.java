package org.korotovsky.sbt.tree;

import org.korotovsky.sbt.tree.exceptions.DuplicateItemTreeException;
import org.korotovsky.sbt.tree.exceptions.NotFoundTreeException;

public class TreeAbstract<T> implements TreeInterface<T> {
    public static final String TREE_NODE_ALREADY_EXISTS = "TreeNode already exists";
    public static final String TREE_NODE_NOT_FOUND = "TreeNode not found";
    
    protected TreeNode<T> root;
    private Integer size = 0;

    public Integer size() {
        return size;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public void changeTreeSize(Integer how) {
        size = size + how;
    }

    @SuppressWarnings("unchecked")
    public TreeNode<T> find(Comparable key, TreeNode<T> treeNode) {
        if (treeNode == null) {
            throw new NotFoundTreeException(TREE_NODE_NOT_FOUND);
        }

        if (key.compareTo(treeNode.getKey()) < 0) {
            return find(key, treeNode.getLeftChild());
        } else if (key.compareTo(treeNode.getKey()) > 0) {
            return find(key, treeNode.getRightChild());
        }

        return treeNode;
    }

    @SuppressWarnings("unchecked")
    public TreeNode<T> createNode(Comparable key, T data, TreeNode<T> treeNode) {
        if (treeNode == null) {
            treeNode = new TreeNode(key, data);
            changeTreeSize(1);

        } else if (key.compareTo(treeNode.getKey()) < 0) {
            treeNode.setLeftChild(createNode(key, data, treeNode.getLeftChild()));

        } else if (key.compareTo(treeNode.getKey()) > 0) {
            treeNode.setRightChild(createNode(key, data, treeNode.getRightChild()));

        } else {
            throw new DuplicateItemTreeException(TREE_NODE_ALREADY_EXISTS);
        }

        return treeNode;
    }

    public Boolean isEmpty() {
        return root == null;
    }
}
