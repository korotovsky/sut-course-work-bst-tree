package org.korotovsky.bst.tree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Stack;

public class TreePrint<T> {
    private TreeNode<T> treeNode;
    private BufferedWriter writer;

    public TreePrint(TreeNode<T> treeNode, BufferedWriter writer) {
        this.treeNode = treeNode;
        this.writer = writer;
    }

    public void print() throws IOException {
        Stack<TreeNode<T>> globalStack = new Stack<TreeNode<T>>();
        globalStack.push(treeNode);

        Integer emptyLeaf = 32;
        Boolean isRowEmpty = false;

        while (!isRowEmpty) {
            Stack<TreeNode<T>> localStack = new Stack<TreeNode<T>>();
            isRowEmpty = true;

            for (Integer j = 0; j < emptyLeaf; j++) {
                writer.write(' ');
            }

            while (!globalStack.isEmpty()) {
                TreeNode<T> temp = globalStack.pop();

                if (temp != null) {
                    writer.write(temp.getLine());

                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    writer.write("[  ]");

                    localStack.push(null);
                    localStack.push(null);
                }

                for (Integer j = 0; j < emptyLeaf * 2 - 4; j++) {
                    writer.write(' ');
                }
            }

            writer.newLine();

            emptyLeaf /= 2;

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }

        writer.flush();
    }
}
