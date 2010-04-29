package org.codeandmagic.affected.persistence;

import java.util.List;

import org.codeandmagic.affected.svn.SvnException;
import org.codeandmagic.affected.svn.SvnProject;

// @affects: SvnProjectService, SvnProjectController
public interface SvnProjectDao {
	SvnProject get(String name) throws SvnException;

	List<SvnProject> getAll();

	boolean save(SvnProject project);

	boolean delete(SvnProject project);
}
