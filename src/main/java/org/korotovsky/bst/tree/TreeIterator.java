package org.korotovsky.bst.tree;

import org.korotovsky.bst.tree.exceptions.NotFoundTreeException;

import java.util.ListIterator;
import java.util.logging.Logger;

public class TreeIterator<T> implements ListIterator<T> {
    private Logger logger;

    private TreeNode<T> root;
    private TreeNode<T> nextNode;
    private TreeNode<T> previousNode;

    public TreeIterator(Tree<T> tree) {
        TreeNode<T> root = tree.getRootNode();

        this.logger = tree.getLogger();
        this.previousNode = root;
        this.nextNode = root;
        this.root = root;
    }

    public TreeNode<T> getNode() {
        return nextNode;
    }

    @Override
    public boolean hasNext() {
        return nextNode != null;
    }

    @Override
    public T next() {
        if (nextNode == null) {
            logger.warning(new NotFoundTreeException(TreeBase.TREE_NODE_NOT_FOUND).getMessage());
        }

        T value = nextNode.getData();

        if (nextNode.getLeftChild() != null) {
            previousNode = nextNode;
            nextNode = nextNode.getLeftChild();
        } else if (nextNode.getRightChild() != null) {
            previousNode = nextNode;
            nextNode = nextNode.getRightChild();
        } else {
            /**
             * Leaf node visited
             */
            TreeNode<T> parent = nextNode.getParent();
            TreeNode<T> child = nextNode;

            while (parent != null && (parent.getRightChild() == child
                    || parent.getRightChild() == null
            )) {
                child = parent;
                parent = parent.getParent();
            }

            if (parent == null) {
                previousNode = null;
                nextNode = null; // the traversal is complete
            } else {
                previousNode = parent;
                nextNode = parent.getRightChild();
            }
        }

        return value;
    }

    @Override
    public boolean hasPrevious() {
        return previousNode != null;
    }

    @Override
    public T previous() {
        T value = previousNode.getData();

        return value;
    }

    public void rewind() {
        previousNode = root;
        nextNode = root;
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
