package org.codeandmagic.affected.svn.impl.svnkit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;

// @affects: SvnKitPathChangeChecker, SvnKitVersionChecker

public class SvnKitAbstractClientManager {
    protected SvnKitManagerPool managerPool;
    protected Log log = LogFactory.getLog(this.getClass());

    @Required
    public void setManagerPool(SvnKitManagerPool managerPool) {
        this.managerPool = managerPool;
    }
}
