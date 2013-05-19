package org.korotovsky.bst.tree;

import org.korotovsky.bst.tree.exceptions.DuplicateItemTreeException;
import org.korotovsky.bst.tree.exceptions.NotFoundTreeException;

import java.util.logging.Logger;

public class Tree<T> extends TreeBase<T> {
    private Logger logger;

    public Tree(Logger logger) {
        this.logger = logger;
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
            root = createNode(key, data, root);
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
}
