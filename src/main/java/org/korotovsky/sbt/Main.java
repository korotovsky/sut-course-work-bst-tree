package org.korotovsky.sbt;

import org.korotovsky.sbt.tree.Tree;
import org.korotovsky.sbt.tree.TreeNode;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Tree<String> tree = new Tree<String>(Logger.getLogger("tree"));

        tree.create(1, "first");
        tree.create(2, "second");
        tree.create(5, "foo");
        tree.create(3, "bar");
        tree.create(3, "baz");

        Integer size = tree.size();

        TreeNode treeNode = tree.find(3);
    }
}
