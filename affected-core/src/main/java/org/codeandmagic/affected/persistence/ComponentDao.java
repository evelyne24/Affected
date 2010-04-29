package org.codeandmagic.affected.persistence;

import java.util.List;

import org.codeandmagic.affected.component.Component;

public interface ComponentDao {
	public boolean save(Component component);

	public boolean delete(Component component);

	public Component get(int id);

	public Component getByTag(String tag);

	public List<Component> getAll();
}
