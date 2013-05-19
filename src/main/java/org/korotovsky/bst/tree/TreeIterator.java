package org.korotovsky.bst.tree;

import java.util.Iterator;

public class TreeIterator<T> implements Iterable<T> {
    private Tree tree;
    private TreeNode<T> currentNode;

    public TreeIterator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public T next() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void remove() {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }
}
