package org.korotovsky.bst;

import org.korotovsky.bst.tree.Tree;
import org.korotovsky.bst.tree.TreeIterator;
import org.korotovsky.bst.tree.TreeNode;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("tree");
        Tree<String> tree = new Tree<String>(logger);

        tree.create(1, "first");
        tree.create(2, "second");
        tree.create(5, "foo");
        tree.create(4, "foo");
        tree.create(3, "bar");

        Integer size = tree.size();

        for (TreeNode<String> treeNode : new TreeIterator<TreeNode<String>>(tree)) {
            logger.info(treeNode.getData());
        }
    }
}
