package org.korotovsky.bst.cli.menu;

import org.korotovsky.bst.cli.Menu;
import org.korotovsky.bst.cli.MenuDispatcher;
import org.korotovsky.bst.tree.Tree;
import org.korotovsky.bst.tree.TreeNode;
import org.korotovsky.bst.tree.exceptions.DuplicateItemTreeException;
import org.korotovsky.bst.tree.exceptions.NotFoundTreeException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MainMenu<T> extends Menu<T> {
    public MainMenu(Tree<T> tree, BufferedWriter writer, BufferedReader reader) {
        super(tree, writer, reader);

        append("Print tree");
        append("Clear tree");
        append("Get tree size");
        append("Check if tree is empty");
        append("Create node");
        append("Find node by key");
        append("Delete node by key");
        append("Iterator menu");
    }

    public void dispatch(MenuDispatcher dispatcher, Integer index) throws IOException {
        switch (index) {
            case 0:
                printTree();
                break;
            case 1:
                clear();
                break;
            case 2:
                size();
                break;
            case 3:
                isEmpty();
                break;
            case 4:
                createNode();
                break;
            case 5:
                findNode();
                break;
            case 6:
                removeNode();
                break;
            default:
                dispatcher.setMenu(1);
        }
    }

    private void printTree() throws IOException {
        tree.print(writer);
    }

    private void createNode() throws IOException {
        writer.write("NOTICE: Input node key: ");
        writer.flush();
        String key = reader.readLine();

        writer.write("NOTICE: Input node data: ");
        writer.flush();
        String value = reader.readLine();

        if (key.equals("") || value.equals("")) {
            writer.write("ERROR: Invalid key or data provided");
            writer.flush();
        } else {
            try {
                tree.create(key, (T) value); // Shit
                writer.newLine();
                writer.write("SUCCESS: Node contains " + key + ":" + value);
            } catch (DuplicateItemTreeException e) {
                writer.write("ERROR: " + e.getMessage());
            }
        }

        writer.flush();
    }

    private void removeNode() throws IOException {
        writer.write("NOTICE: Input node key: ");
        writer.flush();
        String key = reader.readLine();

        if (key.equals("")) {
            writer.write("ERROR: Invalid key provided");
            writer.flush();
        } else {
            try {
                tree.remove(key);
            } catch (NotFoundTreeException e) {
                writer.write("ERROR: " + e.getMessage());
            }
        }

        writer.flush();
    }

    private void findNode() throws IOException {
        writer.write("NOTICE: Input node key: ");
        writer.flush();
        String key = reader.readLine();

        if (key.equals("")) {
            writer.write("ERROR: Invalid key provided");
            writer.flush();
        } else {
            try {
                TreeNode<T> treeNode = tree.find(key);
                writer.newLine();
                writer.write("SUCCESS: Node contains " + treeNode.getLine());
            } catch (NotFoundTreeException e) {
                writer.write("ERROR: " + e.getMessage());
            }
        }

        writer.flush();
    }

    private void isEmpty() throws IOException {
        Boolean isEmpty = tree.isEmpty();
        writer.newLine();
        writer.write(isEmpty ? "SUCCESS: Tree is empty" : "SUCCESS: Tree is not empty");
        writer.newLine();
        writer.flush();
    }

    private void size() throws IOException {
        Integer size = tree.size();
        writer.newLine();
        writer.write("SUCCESS: Tree size is: " + size);
        writer.newLine();
        writer.flush();
    }

    private void clear() throws IOException {
        tree.clear();
        writer.newLine();
        writer.write("SUCCESS: Tree was cleaned");
        writer.newLine();
        writer.flush();
    }
}
