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

package org.codeandmagic.affected.svn.svnkit;

import java.util.HashSet;
import java.util.Set;

import org.codeandmagic.affected.svn.SvnException;
import org.codeandmagic.affected.svn.SvnPathChangeChecker;
import org.codeandmagic.affected.svn.SvnProject;
import org.tmatesoft.svn.core.ISVNLogEntryHandler;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.SVNLogClient;
import org.tmatesoft.svn.core.wc.SVNRevision;

public class SvnKitPathChangeChecker extends SvnKitAbstractClientManager implements
		SvnPathChangeChecker {

	public Set<String> getChangedPaths(SvnProject project, long targetRevision) throws SvnException {
		SVNLogClient logClient = managerPool.getSvnManager(project).getLogClient();
		final Set<String> changedPaths = new HashSet<String>();

		try {
			if (log.isDebugEnabled()) {
				log.debug("Getting changes from rev " + project.getLastCheckedVersion()
						+ " to rev " + targetRevision);
			}

			// we want to check all the paths that have changed
			logClient.doLog(SVNURL.parseURIEncoded(project.getUrl()), new String[] { "" },
					SVNRevision.HEAD, SVNRevision.create(project.getLastCheckedVersion()),
					SVNRevision.create(targetRevision), true, true, 0, new ISVNLogEntryHandler() {

						public void handleLogEntry(SVNLogEntry entry) throws SVNException {
							for (Object key : entry.getChangedPaths().keySet()) {
								changedPaths.add(key.toString());
							}

						}
					});
			return changedPaths;

		}
		catch (SVNException e) {
			throw new SvnException("Exception while getting the changed paths for the project "
					+ project, e);
		}
	}
}
