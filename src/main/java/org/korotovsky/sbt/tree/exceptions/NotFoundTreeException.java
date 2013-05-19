package org.korotovsky.sbt.tree.exceptions;

import org.korotovsky.sbt.tree.TreeException;

public class NotFoundTreeException extends TreeException {
    public NotFoundTreeException() {
        super();
    }

    public NotFoundTreeException(String message) {
        super(message);
    }
}
