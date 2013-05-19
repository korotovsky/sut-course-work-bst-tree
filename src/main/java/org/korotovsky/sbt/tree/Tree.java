package org.korotovsky.sbt.tree;

import org.korotovsky.sbt.tree.exceptions.DuplicateItemTreeException;
import org.korotovsky.sbt.tree.exceptions.NotFoundTreeException;

import java.util.logging.Logger;

public class Tree implements TreeInterface {
    private Integer size = 0;
    private TreeNode root;
    private Logger logger;

    public Tree(Logger logger) {
        this.logger = logger;
    }

    public void create(Comparable key, Integer data) {
        try {
            root = createNode(key, data, root);
        } catch (DuplicateItemTreeException e) {
            logger.warning(e.getMessage());
        }
    }

    public TreeNode find(Comparable key) {
        return find(key, root);
    }

    public Integer size() {
        return size;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    private Comparable elementAt(TreeNode treeNode) {
        return treeNode == null ? null : treeNode.getKey();
    }

    private void changeTreeSize(Integer how) {
        size = size + how;
    }

    @SuppressWarnings("unchecked")
    private TreeNode find(Comparable key, TreeNode treeNode) {
        if (treeNode == null) {
            throw new NotFoundTreeException();
        }

        if (key.compareTo(treeNode.getKey()) < 0) {
            return find(key, treeNode.getLeftChild());
        } else if (key.compareTo(treeNode.getKey()) > 0) {
            return find(key, treeNode.getRightChild());
        }

        return treeNode;
    }

    @SuppressWarnings("unchecked")
    private TreeNode createNode(Comparable key, Integer data, TreeNode treeNode) {
        if (treeNode == null) {
            treeNode = new TreeNode(key, data);
            changeTreeSize(1);

        } else if (key.compareTo(treeNode.getKey()) < 0) {
            treeNode.setLeftChild(createNode(key, data, treeNode.getLeftChild()));

        } else if (key.compareTo(treeNode.getKey()) > 0) {
            treeNode.setRightChild(createNode(key, data, treeNode.getRightChild()));

        } else {
            throw new DuplicateItemTreeException("TreeNode already exists");
        }

        return treeNode;
    }
}
