package org.korotovsky.bst.tree.exceptions;

import org.korotovsky.bst.tree.TreeException;

public class NotFoundTreeException extends TreeException {
    public NotFoundTreeException() {
        super();
    }

    public NotFoundTreeException(String message) {
        super(message);
    }
}
