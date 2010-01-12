package org.codeandmagic.affected.service.impl;

import java.util.List;

import org.codeandmagic.affected.component.Component;
import org.codeandmagic.affected.persistance.api.ComponentDao;
import org.codeandmagic.affected.service.api.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class ComponentServiceImpl implements ComponentService {

	private ComponentDao componentDao;
	
	@Required
	@Autowired
	public void setComponentDao(ComponentDao componentDao){
		this.componentDao = componentDao;
	}

	public void delete(Component component) {
		componentDao.delete(component);
	}

	public Component get(int id) {
		return componentDao.get(id);
	}

	public List<Component> getAll() {
		return componentDao.getAll();
	}

	public Component getByTag(String tag) {
		return componentDao.getByTag(tag);
	}

	public void save(Component component) {
		componentDao.save(component);
	}
	
}
