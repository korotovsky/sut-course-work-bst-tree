package org.korotovsky.bst.cli;

import java.io.BufferedWriter;

public class MainMenu extends Menu {
    public MainMenu(BufferedWriter writer) {
        super(writer);

        append("Clear tree");
        append("Get tree size");
        append("Check if tree is empty");
        append("Find node by key");
        append("Delete node by key");
        append("Iterator menu");
    }

    public void dispatch(MenuDispatcher dispatcher, Integer index) {
        if (index == 5) {
            dispatcher.setMenu(1);
        }
    }
}
