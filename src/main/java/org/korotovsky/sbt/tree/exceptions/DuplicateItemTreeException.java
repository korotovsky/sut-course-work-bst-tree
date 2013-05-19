package org.korotovsky.sbt.tree.exceptions;

import org.korotovsky.sbt.tree.TreeException;

public class DuplicateItemTreeException extends TreeException {
    public DuplicateItemTreeException() {
        super();
    }

    public DuplicateItemTreeException(String message) {
        super(message);
    }
}
