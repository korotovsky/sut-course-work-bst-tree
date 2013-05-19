package org.korotovsky.bst.tree.exceptions;

import org.korotovsky.bst.tree.TreeException;

public class DuplicateItemTreeException extends TreeException {
    public DuplicateItemTreeException() {
        super();
    }

    public DuplicateItemTreeException(String message) {
        super(message);
    }
}
