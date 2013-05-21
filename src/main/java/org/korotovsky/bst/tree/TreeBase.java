package org.korotovsky.bst.tree;

import org.korotovsky.bst.tree.exceptions.DuplicateItemTreeException;
import org.korotovsky.bst.tree.exceptions.NotFoundTreeException;

import java.io.IOException;

public class TreeBase<T> implements TreeInterface<T> {
    public static final String TREE_NODE_ALREADY_EXISTS = "TreeNode already exists";
    public static final String TREE_NODE_NOT_FOUND = "TreeNode not found";

    protected TreeNode<T> root;
    private Integer size = 0;

    public Integer size() {
        return size;
    }

    public Boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public void changeTreeSize(Integer how) {
        size = size + how;
    }

    @SuppressWarnings("unchecked")
    public TreeNode<T> findNode(Comparable key, TreeNode<T> treeNode) throws NotFoundTreeException {
        if (treeNode == null) {
            throw new NotFoundTreeException(TREE_NODE_NOT_FOUND);
        }

        if (key.compareTo(treeNode.getKey()) < 0) {
            return findNode(key, treeNode.getLeftChild());
        } else if (key.compareTo(treeNode.getKey()) > 0) {
            return findNode(key, treeNode.getRightChild());
        }

        return treeNode;
    }

    public TreeNode<T> createRootNode(TreeNode<T> treeNode, Comparable key, T data) throws IOException {
        if (treeNode == null) {
            return new TreeNode<T>(null, key, data);
        } else if (key.compareTo(treeNode.getKey()) == 0) {
            return treeNode;
        } else if (key.compareTo(treeNode.getKey()) < 0) {
            treeNode.setLeftChild(createRootNode(treeNode.getLeftChild(), key, data));
        }

        return treeNode;
    }

    public TreeNode<T> leftRotate(TreeNode<T> treeNode) {
        TreeNode<T> node = treeNode.getRightChild();
        treeNode.setRightChild(node.getLeftChild());
        node.setLeftChild(treeNode);

        return node;
    }

    public TreeNode<T> rightRotate(TreeNode<T> treeNode) {
        TreeNode<T> node = treeNode.getLeftChild();
        treeNode.setLeftChild(node.getRightChild());
        node.setRightChild(treeNode);

        return node;
    }

    @SuppressWarnings("unchecked")
    public TreeNode<T> createNode(TreeNode<T> parent, Comparable key, T data, TreeNode<T> treeNode) throws DuplicateItemTreeException {
        if (treeNode == null) {
            treeNode = new TreeNode(parent, key, data);
            changeTreeSize(1);

        } else if (key.compareTo(treeNode.getKey()) < 0) {
            treeNode.setLeftChild(createNode(treeNode, key, data, treeNode.getLeftChild()));

        } else if (key.compareTo(treeNode.getKey()) > 0) {
            treeNode.setRightChild(createNode(treeNode, key, data, treeNode.getRightChild()));

        } else {
            throw new DuplicateItemTreeException(TREE_NODE_ALREADY_EXISTS);
        }

        return treeNode;
    }

    @SuppressWarnings("unchecked")
    public TreeNode<T> removeNode(Comparable key, TreeNode<T> treeNode) throws NotFoundTreeException {
        if (treeNode == null) {
            throw new NotFoundTreeException(TREE_NODE_NOT_FOUND);
        }

        if (key.compareTo(treeNode.getKey()) < 0) {
            treeNode.setLeftChild(removeNode(key, treeNode.getLeftChild()));

        } else if (key.compareTo(treeNode.getKey()) > 0) {
            treeNode.setRightChild(removeNode(key, treeNode.getRightChild()));

        } else if (treeNode.getLeftChild() != null && treeNode.getRightChild() != null) {
            treeNode.setKey(findMin(treeNode.getRightChild()).getKey());
            treeNode.setRightChild(removeMin(treeNode.getRightChild()));

        } else {
            changeTreeSize(-1);
            treeNode = treeNode.getLeftChild() != null
                    ? treeNode.getLeftChild()
                    : treeNode.getRightChild();
        }

        return treeNode;
    }

    protected TreeNode<T> removeMin(TreeNode<T> treeNode) throws NotFoundTreeException {
        if (treeNode == null) {
            throw new NotFoundTreeException(TREE_NODE_NOT_FOUND);
        }

        if (treeNode.getLeftChild() != null) {
            treeNode.setLeftChild(removeMin(treeNode.getLeftChild()));

            return treeNode;
        } else {
            return treeNode.getRightChild();
        }
    }

    protected TreeNode<T> findMin(TreeNode<T> treeNode) {
        if (treeNode != null) {
            return findMin(treeNode.getLeftChild());
        }

        return treeNode;
    }
}
