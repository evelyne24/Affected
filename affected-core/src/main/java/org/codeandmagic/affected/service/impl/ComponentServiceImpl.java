package org.codeandmagic.affected.service.impl;

import java.util.List;

import org.codeandmagic.affected.component.Component;
import org.codeandmagic.affected.persistence.ComponentDao;
import org.codeandmagic.affected.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComponentServiceImpl implements ComponentService {
	private ComponentDao componentDao;

	@Required
	@Autowired
	public void setComponentDao(ComponentDao componentDao) {
		this.componentDao = componentDao;
	}

	@Transactional(readOnly = true)
	public Component get(int id) {
		return componentDao.get(id);
	}

	@Transactional(readOnly = true)
	public List<Component> getAll() {
		return componentDao.getAll();
	}

	@Transactional(readOnly = true)
	public Component getByTag(String tag) {
		return componentDao.getByTag(tag);
	}

	@Transactional(readOnly = false)
	public boolean save(Component component) {
		return componentDao.save(component);
	}

	@Transactional(readOnly = false)
	public boolean delete(Component component) {
		return componentDao.delete(component);
	}
}
