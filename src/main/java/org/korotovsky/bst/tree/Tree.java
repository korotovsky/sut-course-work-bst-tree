package org.korotovsky.bst.tree;

import org.korotovsky.bst.tree.exceptions.DuplicateItemTreeException;
import org.korotovsky.bst.tree.exceptions.NotFoundTreeException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Logger;

public class Tree<T> extends TreeBase<T> {
    private Logger logger;
    private Integer emptyLeaf = 32;
    private Boolean isRowEmpty = false;

    public Tree(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return logger;
    }

    public TreeNode<T> getRootNode() {
        return root;
    }

    public TreeNode<T> find(Comparable key) {
        TreeNode<T> treeNode = null;

        try {
            treeNode = findNode(key, root);
        } catch (NotFoundTreeException e) {
            logger.warning(e.getMessage());
        }

        return treeNode;
    }

    public void create(Comparable key, T data) {
        try {
            root = createNode(root, key, data, root);
        } catch (DuplicateItemTreeException e) {
            logger.warning(e.getMessage());
        }
    }

    public void remove(Comparable key) {
        try {
            root = removeNode(key, root);
        } catch (NotFoundTreeException e) {
            logger.warning(e.getMessage());
        }
    }

    public void clear() {
        super.clear();
    }

    public void print(BufferedWriter writer) {
        TreePrint<T> treePrint = new TreePrint<T>(this.getRootNode(), writer);

        try {
            treePrint.print();
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }
}
