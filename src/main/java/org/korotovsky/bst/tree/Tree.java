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

    public TreeNode<T> find(Comparable key) throws NotFoundTreeException {
        return findNode(key, root);
    }

    public void remove(Comparable key) throws NotFoundTreeException {
        root = removeNode(key, root);
    }

    public void create(Comparable key, T data) throws DuplicateItemTreeException {
        root = createNode(root, key, data, root);
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
