package org.korotovsky.bst.cli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MenuDispatcher {
    private ArrayList<Menu> menus = new ArrayList<Menu>();
    private Integer currentMenu = 0;
    private BufferedWriter writer;
    private BufferedReader reader;

    public MenuDispatcher(BufferedWriter writer, BufferedReader reader, MainMenu mainMenu, IteratorMenu iteratorMenu) {
        this.writer = writer;
        this.reader = reader;

        menus.add(mainMenu);
        menus.add(iteratorMenu);
    }

    public void dispatch() {
        while (true) {
            try {
                Menu menu = menus.get(currentMenu);

                menu.print();
                menu.dispatch(this, getMenuIndex());
            } catch (IOException e) {
                return;
            }
        }
    }

    public void setMenu(Integer index) {
        currentMenu = index;
    }

    private Integer getMenuIndex() {
        try {
            writer.write("Input menu index [0]: ");
            writer.flush();

            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
