package org.codeandmagic.affected.scanner.api;

import java.util.List;

/** This will scan a String input, looking for affected tags. */
public interface TagScanner {
    /**
     * @param input the input to be scanned, probably the content of a file
     *
     * @return a list of Strings representing the names of the components (tags), possibly affected
     *         by changes in the given input; if no tags are found, returns null
     */
    List<String> scan(String input);
}
