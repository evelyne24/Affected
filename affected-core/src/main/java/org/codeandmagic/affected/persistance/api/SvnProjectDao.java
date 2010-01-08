package org.codeandmagic.affected.persistance.api;

import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;

import java.util.List;

// @affects: SvnProjectService
public interface SvnProjectDao {
    SvnProject get(String url) throws SvnException;

    List<SvnProject> getAllProjects();

    SvnProject create(String url, long localVersion, String username, String password) throws SvnException;

    void update(SvnProject project);

    void delete(String url);
}
