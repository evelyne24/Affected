package org.codeandmagic.affected.service;

import java.util.List;

import org.codeandmagic.affected.component.Component;

public interface ComponentService {
	public Component get(int id);

	public Component getByTag(String tag);

	public List<Component> getAll();

	public boolean save(Component component);

	public boolean delete(Component component);
}
