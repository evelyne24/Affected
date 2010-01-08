package org.codeandmagic.affected.service.api;

import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;

import java.util.List;

public interface SvnProjectService {
    SvnProject get(String name) throws SvnException;

    List<SvnProject> getAll();

    SvnProject create(String name, String url, long lastCheckedVersion) throws SvnException;

    void save(SvnProject project);

    void delete(String name) throws SvnException;
}
