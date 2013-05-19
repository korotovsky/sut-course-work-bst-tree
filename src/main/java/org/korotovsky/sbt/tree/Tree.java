package org.korotovsky.sbt.tree;

import org.korotovsky.sbt.tree.exceptions.DuplicateItemTreeException;
import org.korotovsky.sbt.tree.exceptions.NotFoundTreeException;

import java.util.logging.Logger;

public class Tree<T> extends TreeAbstract<T> {
    private Logger logger;

    public Tree(Logger logger) {
        this.logger = logger;
    }

    public void create(Comparable key, T data) {
        try {
            root = createNode(key, data, root);
        } catch (DuplicateItemTreeException e) {
            logger.warning(e.getMessage());
        }
    }

    public TreeNode<T> find(Comparable key) {
        TreeNode<T> treeNode = null;

        try {
            treeNode = find(key, root);
        } catch (NotFoundTreeException e) {
            logger.warning(e.getMessage());
        }

        return treeNode;
    }

    public void clear() {
        super.clear();
    }
}
