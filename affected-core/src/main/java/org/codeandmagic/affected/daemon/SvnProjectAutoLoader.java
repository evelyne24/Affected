/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 *   
 * This file is part of Affected.
 *   
 * Affected is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *   
 * Affected is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied   warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU Lesser General Public License for more details.
 *   
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/
package org.codeandmagic.affected.daemon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codeandmagic.affected.service.SvnProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class SvnProjectAutoLoader implements ApplicationListener<ContextRefreshedEvent> {
    private SvnProjectService svnProjService;
    private final Log log = LogFactory.getLog(SvnProjectAutoLoader.class);
    private boolean started = false;

    @Required
    @Autowired
    public void setSvnProjService(SvnProjectService svnProjService) {
        this.svnProjService = svnProjService;
    }

    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!started) {
            this.start();
            started = true;
        }
    }

    private void start() {
        if (log.isDebugEnabled()) {
            log.debug("Application context started. Loading all SvnProjects.");
        }
        svnProjService.getAll();
    }
}
