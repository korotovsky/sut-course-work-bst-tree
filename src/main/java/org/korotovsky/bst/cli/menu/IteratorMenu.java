package org.korotovsky.bst.cli.menu;

import org.korotovsky.bst.cli.Menu;
import org.korotovsky.bst.cli.MenuDispatcher;
import org.korotovsky.bst.tree.Tree;
import org.korotovsky.bst.tree.TreeIterator;
import org.korotovsky.bst.tree.TreeNode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class IteratorMenu extends Menu {
    public static final String ITEM_SET_CURSOR_TO_ROOT_TREE_NODE = "Set cursor to root TreeNode";
    public static final String ITEM_GET_DATA_FROM_CURSOR = "Get data from cursor";
    public static final String ITEM_NEXT_TREE_NODE = "Next TreeNode";
    public static final String ITEM_PREVIOUS_TREE_NODE = "Previous TreeNode";
    public static final String ITEM_CHECK_IF_END_OF_TREE = "Check if end of Tree";
    public static final String ITEM_MAIN_MENU = "Main menu";

    private TreeIterator<String> iterator;
    
    public IteratorMenu(Tree<String> tree, BufferedWriter writer, BufferedReader reader) {
        super(tree, writer, reader);

        append(ITEM_SET_CURSOR_TO_ROOT_TREE_NODE);
        append(ITEM_GET_DATA_FROM_CURSOR);
        append(ITEM_NEXT_TREE_NODE);
        append(ITEM_PREVIOUS_TREE_NODE);
        append(ITEM_CHECK_IF_END_OF_TREE);
        append(ITEM_MAIN_MENU);
    }

    public void dispatch(MenuDispatcher dispatcher, Integer index) throws IOException {
        if (iterator == null) {
            iterator = new TreeIterator<String>(tree);
        }
        
        switch (index) {
            case 0:
                setToRoot();

                break;
            case 1:
                getData();

                break;
            case 2:
                next();

                break;
            case 3:
                previous();

                break;
            case 4:
                hasNext();

                break;
            case 5:
                iterator = null;
                dispatcher.setMenu(0);
                break;
            default:
                iterator = null;
                dispatcher.setMenu(0);
        }
    }

    private void hasNext() throws IOException {
        Boolean hasNext = iterator.hasNext();

        writer.newLine();
        writer.write("SUCCESS: is " + (!hasNext ? "end tree" : "not end tree"));
        writer.newLine();
        writer.flush();
    }

    private void previous() throws IOException {
        writer.newLine();

        if (!tree.isEmpty()) {
            writer.write("SUCCESS: moved to previous node " + iterator.previous());
        } else {
            writer.write("ERROR: tree is empty");
        }

        writer.newLine();
        writer.flush();
    }

    private void next() throws IOException {
        writer.newLine();

        if (iterator.hasNext()) {
            writer.write("SUCCESS: leave node "
                    + iterator.next()
                    + ", current node is "
                    + iterator.getNode().getLine());
        } else {
            writer.write("ERROR: traverse is complete");
        }

        writer.newLine();
        writer.flush();
    }

    private void getData() throws IOException {
        TreeNode<String> treeNode = iterator.getNode();

        writer.newLine();
        if (!tree.isEmpty() && treeNode != null) {
            writer.write("SUCCESS: node contains " + treeNode.getLine());
        } else {
            writer.write("ERROR: current node is empty");
        }

        writer.newLine();
        writer.flush();
    }

    private void setToRoot() throws IOException {
        iterator.rewind();

        writer.newLine();
        writer.write("SUCCESS: cursor is now root");
        writer.newLine();
        writer.flush();
    }
}
