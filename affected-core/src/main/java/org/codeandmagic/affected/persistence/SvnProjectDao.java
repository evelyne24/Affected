package org.codeandmagic.affected.persistence;

import java.util.List;

import org.codeandmagic.affected.svn.SvnProject;

// @affects: SvnProjectService, SvnProjectController
public interface SvnProjectDao {
	SvnProject get(int id);

	List<SvnProject> getAll();

	void save(SvnProject project);

	void delete(SvnProject project);
}
