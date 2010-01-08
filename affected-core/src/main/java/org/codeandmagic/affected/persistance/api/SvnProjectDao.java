package org.codeandmagic.affected.persistance.api;

import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;

import java.util.List;

// @affects: SvnProjectService, SvnProjectController
public interface SvnProjectDao {
    SvnProject get(String name) throws SvnException;

    List<SvnProject> getAll();

    void save(SvnProject project);

    void delete(SvnProject project);
}
