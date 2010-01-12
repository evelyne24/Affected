package org.codeandmagic.affected.service.api;

import java.util.List;

import org.codeandmagic.affected.component.Component;

public interface ComponentService {
	public void save(Component component);
	public void delete(Component component);
	public Component get(int id);
	public Component getByTag(String tag);
	public List<Component> getAll();
}
