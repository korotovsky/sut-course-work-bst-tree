package org.korotovsky.bst.cli;

import org.korotovsky.bst.cli.menu.IteratorMenu;
import org.korotovsky.bst.cli.menu.MainMenu;
import org.korotovsky.bst.tree.Tree;
import org.korotovsky.bst.tree.TreeIterator;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Cli<T> {
    private BufferedWriter writer;
    private BufferedReader reader;
    private Tree<T> tree;

    public Cli(Tree<T> tree, BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.tree = tree;
    }

    public void dispatch() {
        IteratorMenu<T> iteratorMenu = new IteratorMenu<T>(tree, writer, reader);
        MainMenu menu = new MainMenu<T>(tree, writer, reader);

        MenuDispatcher menuDispatcher = new MenuDispatcher(writer, reader);
        menuDispatcher.addMenu(menu);
        menuDispatcher.addMenu(iteratorMenu);
        menuDispatcher.dispatch();
    }
}
