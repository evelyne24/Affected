package org.codeandmagic.affected.service;

import java.util.List;

import org.codeandmagic.affected.svn.SvnProject;

public interface SvnProjectService {
	SvnProject get(int id);

	List<SvnProject> getAll();

	SvnProject create(String name, String url, long lastCheckedVersion);

	void save(SvnProject project);

	void delete(int id);
}
