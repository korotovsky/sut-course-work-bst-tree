package org.korotovsky.sbt;

import org.korotovsky.sbt.tree.Tree;
import org.korotovsky.sbt.tree.TreeNode;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(Logger.getLogger("tree"));

        tree.create(1, 1);
        tree.create(2, 1);
        tree.create(5, 1);
        tree.create(3, 1);
        tree.create(3, 1);

        Integer size = tree.size();

        TreeNode treeNode = tree.find(3);
    }
}
