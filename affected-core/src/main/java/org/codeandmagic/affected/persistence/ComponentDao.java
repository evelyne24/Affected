package org.codeandmagic.affected.persistence;

import java.util.List;

import org.codeandmagic.affected.component.Component;

public interface ComponentDao {
	public void save(Component component);

	public void delete(Component component);

	public Component get(int id);

	public Component getByTag(String tag);

	public List<Component> getAll();
}
