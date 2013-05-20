package org.korotovsky.bst.cli;

import java.io.IOException;

public interface MenuInterface {
    public void dispatch(MenuDispatcher dispatcher, Integer index) throws IOException;
}
