package org.korotovsky.bst;

import org.korotovsky.bst.tree.Tree;
import org.korotovsky.bst.tree.TreeIterator;

import java.io.*;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("tree");
        Tree<String> tree = new Tree<String>(logger);

        tree.create(6, "F");
        tree.create(2, "B");
        tree.create(4, "D");
        tree.create(1, "A");
        tree.create(3, "C");
        tree.create(5, "E");
        tree.create(7, "G");
        tree.create(9, "I");
        tree.create(8, "H");
        tree.create(10, "K");

        Integer size = tree.size();

        TreeIterator<String> treeIterator = new TreeIterator<String>(tree);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        tree.print(writer);

//        while (treeIterator.hasNext()) {
//            String treeNode = treeIterator.next();
//
//            logger.info(treeNode);
//        }

//        String choose = "";
//
//        while (true) {
//            try {
//                choose = reader.readLine();
//            } catch (IOException e) {
//                logger.warning(e.getMessage());
//                break;
//            }
//
//            if (choose.equals("next")) {
//                treeIterator.next();
//            }
//        }
    }
}
