package org.codeandmagic.affected.service;

import java.util.List;

import org.codeandmagic.affected.component.Component;

public interface ComponentService {
	Component get(int id);

	Component getByTag(String tag);

	List<Component> getAll();

	Component create(String prettyName, String tag, int projectId, Integer parentId);

	void save(Component component);

	void delete(Component component);
}
