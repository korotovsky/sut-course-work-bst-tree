package org.korotovsky.bst.cli;

import org.korotovsky.bst.tree.TreeIterator;

import java.io.BufferedWriter;

public class IteratorMenu<T> extends Menu {
    private TreeIterator<T> treeIterator;

    public IteratorMenu(TreeIterator<T> treeIterator, BufferedWriter writer) {
        super(writer);

        append("Set cursor to root TreeNode");
        append("Get data from cursor");
        append("Next TreeNode");
        append("Previous TreeNode");
        append("Check if end of Tree");
        append("Return back");
    }

    public void dispatch(MenuDispatcher dispatcher, Integer index) {
        if (index == 5) {
            dispatcher.setMenu(0);
        }
    }
}
