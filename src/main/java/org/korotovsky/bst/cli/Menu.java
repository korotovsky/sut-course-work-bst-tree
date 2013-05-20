package org.korotovsky.bst.cli;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

abstract class Menu {
    protected ArrayList<String> items = new ArrayList<String>();
    protected BufferedWriter writer;

    public Menu(BufferedWriter writer) {
        this.writer = writer;
    }

    abstract public void dispatch(MenuDispatcher dispatcher, Integer index);

    public ArrayList<String> getItems() {
        return items;
    }

    public void append(String label) {
        items.add(label + "\n");
    }

    public void print() throws IOException {
        ArrayList<String> items = getItems();

        for (Integer i = 0; i < items.size(); i++) {
            writer.write(" " + i + ") " + items.get(i));
        }

        writer.flush();
    }
}
