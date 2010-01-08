/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 *
 * This file is part of Affected.
 *
 * Affected is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Affected is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package org.codeandmagic.affected.svn.impl.svnkit;

import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnFileContentRetriever;
import org.codeandmagic.affected.svn.api.SvnProject;
import org.codeandmagic.affected.user.User;
import org.tmatesoft.svn.core.*;
import org.tmatesoft.svn.core.io.ISVNFileCheckoutTarget;
import org.tmatesoft.svn.core.io.SVNRepository;

import java.io.*;

public class SvnKitFileContentRetriever extends SvnKitAbstractRepository implements
        SvnFileContentRetriever {
    protected final static String TEMP_FILE = "TempCheckout.txt";

    public String getFileContent(SvnProject project, User user, String filePath, long revision) throws SvnException {
        try {
            final File destPath = new File(TEMP_FILE);
            if (!destPath.exists()) {
                destPath.createNewFile();
            }

            // remove the base project path
            SVNRepository repo = managerPool.getSvnRepository(project, user);
            filePath = removeBasePath(filePath, repo);

            repo.checkoutFiles(revision, new String[]{filePath},
                    new ISVNFileCheckoutTarget() {

                        public void filePropertyChanged(String arg0, String arg1,
                                                        SVNPropertyValue arg2) throws SVNException {
                        }

                        public OutputStream getOutputStream(String path) throws SVNException {
                            try {
                                return new FileOutputStream(destPath);
                            } catch (FileNotFoundException e) {
                                throw new SVNException(SVNErrorMessage.create(
                                        SVNErrorCode.BAD_FILENAME, e.getMessage()));
                            }
                        }
                    });

            // read the content of the file
            BufferedReader reader = new BufferedReader(new FileReader(destPath));
            String content = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                content += line;
            }
            // delete the temporary file
            destPath.delete();

            return content;

        } catch (SVNException e) {
            throw new SvnException("Exception while retrieving the content of the file " + filePath
                    + " from svn", e);
        } catch (FileNotFoundException e) {
            throw new SvnException("Could not find the temporary file " + TEMP_FILE
                    + " whose content was retrieved from the svn", e);
        } catch (IOException e) {
            throw new SvnException("Could not read from the temporary file " + TEMP_FILE
                    + " whose content was retrieved from the svn", e);
        }
    }

    private String removeBasePath(String path, SVNRepository repo) throws SVNException {
        // something like  /svn/core/
        SVNURL repoRoot = repo.getRepositoryRoot(true);
        // something like  /svn/core/trunk/affected
        SVNURL basePath = repo.getLocation();
        // remove the last separator, to make the path relative

        path = path.replace(basePath.getPath().replace(repoRoot.getPath(), ""), "");
        if (path.length() > 0)
            path = path.substring(1);

        return path;
    }
}
