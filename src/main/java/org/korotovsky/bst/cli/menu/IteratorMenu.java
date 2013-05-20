package org.korotovsky.bst.cli.menu;

import org.korotovsky.bst.cli.Menu;
import org.korotovsky.bst.cli.MenuDispatcher;
import org.korotovsky.bst.tree.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class IteratorMenu<T> extends Menu<T> {
    public IteratorMenu(Tree<T> tree, BufferedWriter writer, BufferedReader reader) {
        super(tree, writer, reader);

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
