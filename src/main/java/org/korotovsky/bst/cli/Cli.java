package org.korotovsky.bst.cli;

import org.korotovsky.bst.tree.Tree;
import org.korotovsky.bst.tree.TreeIterator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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
        TreeIterator<T> iterator = tree.getIterator();
        IteratorMenu<T> iteratorMenu = new IteratorMenu<T>(iterator, writer);
        MainMenu menu = new MainMenu(writer);

        MenuDispatcher menuDispatcher = new MenuDispatcher(writer, reader, menu, iteratorMenu);
        menuDispatcher.dispatch();
    }
}
