package org.codeandmagic.affected.daemon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codeandmagic.affected.service.api.SvnProjectService;
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
