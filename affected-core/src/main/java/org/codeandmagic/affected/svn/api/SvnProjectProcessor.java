package org.codeandmagic.affected.svn.api;

import java.util.List;
import java.util.Map;

/**
 * This processor will receive information about a working copy of a svn project and perform the
 * following actions upon it:
 * <ul>
 * <li> gather the modified files list</li>
 * <li> for each modified file, retrieve its content from the svn</li>
 * <li> parse the content of the modified file in order to retrieve the '@affects'' tags</li>
 * <li> modify the local version of the project in the database,
 * to mark the fact that this version was processed</li>
 * </ul>
 */
public interface SvnProjectProcessor {
    /**
     * For the given project, perform the operations described above
     *
     * @param project the {@link org.codeandmagic.affected.svn.api.SvnProject} to be scanned for tags
     *
     * @return a map where the key represents the path of a modified file, and the value
     *         represents the list of parsed '@affects' tags found in that file
     */
    Map<String, List<String>> process(SvnProject project) throws SvnException;
}
