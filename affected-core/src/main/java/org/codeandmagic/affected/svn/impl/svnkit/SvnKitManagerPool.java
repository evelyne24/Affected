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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;
import org.codeandmagic.affected.user.User;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Class whose the responsibility to create and maintain a pool of svn client managers and svn
 * repositories used for processing with SvnKit
 */
public class SvnKitManagerPool {
    private final DefaultSVNOptions defaultOpts = SVNWCUtil.createDefaultOptions(false);

    private final Map<String, SVNClientManager> clientManagers = new HashMap<String, SVNClientManager>();
    private final HashMap<String, SVNRepository> repositories = new HashMap<String, SVNRepository>();

    private final Log log = LogFactory.getLog(this.getClass());

    public void init() {
        if (log.isDebugEnabled()) {
            log.debug("Init SvnKitManagerPool method called.");
        }
        //do this once in your application prior to using the library

        //enables working with a repository via the svn-protocol (over svn and svn+ssh)
        SVNRepositoryFactoryImpl.setup();

        //enables working with a repository via the http-protocol (over http and https)
        DAVRepositoryFactory.setup();
    }

    private void initClientManager(String url, String username, String password) {
        // 1# instantiate a new object of type SVNClientManager and
        SVNClientManager manager = SVNClientManager.newInstance(defaultOpts, username, password);
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(username, password);
        manager.setAuthenticationManager(authManager);

        // 2# add the client manager to the pool, for later use
        clientManagers.put(url, manager);
    }

    private void initRepository(String url, String username, String password) throws SvnException {
        try {
            // 1# instantiate a new object of type SVNRepository
            SVNRepository repo = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(url));
            ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(username, password);
            repo.setAuthenticationManager(authManager);

            // 2# add the repository to the pool, for later use
            repositories.put(url, repo);

        } catch (SVNException e) {
            throw new SvnException("Could not parse the url of the project '" + url + "'", e);
        }
    }


    public SVNClientManager getSvnManager(SvnProject project, User user) {
        if (!clientManagers.containsKey(project.getUrl())) {
            initClientManager(project.getUrl(), user.getUsername(), user.getPassword());
        }

        return clientManagers.get(project.getUrl());
    }

    public SVNRepository getSvnRepository(SvnProject project, User user) throws SvnException {
        if (!repositories.containsKey(project.getUrl())) {
            initRepository(project.getUrl(), user.getUsername(), user.getPassword());
        }

        return repositories.get(project.getUrl());
    }
}
