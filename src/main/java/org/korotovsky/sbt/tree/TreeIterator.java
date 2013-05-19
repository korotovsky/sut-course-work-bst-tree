package org.korotovsky.sbt.tree;

import java.util.Iterator;

public class TreeIterator<T> implements Iterable<TreeNode<T>> {
    private Tree tree;
    private TreeNode<T> currentNode;

    public TreeIterator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public Iterator<TreeNode<T>> iterator() {
        return new Iterator<TreeNode<T>>() {
            @Override
            public boolean hasNext() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public TreeNode<T> next() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void remove() {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }
}
