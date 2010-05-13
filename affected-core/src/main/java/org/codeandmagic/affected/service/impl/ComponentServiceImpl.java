package org.codeandmagic.affected.service.impl;

import java.util.HashSet;
import java.util.List;

import org.codeandmagic.affected.component.Component;
import org.codeandmagic.affected.persistence.ComponentDao;
import org.codeandmagic.affected.service.ComponentService;
import org.codeandmagic.affected.service.SvnProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComponentServiceImpl implements ComponentService {
	private ComponentDao componentDao;

	private SvnProjectService projectService;

	@Required
	@Autowired
	public void setComponentDao(ComponentDao componentDao) {
		this.componentDao = componentDao;
	}

	@Autowired
	@Required
	public void setProjectService(SvnProjectService projectService) {
		this.projectService = projectService;
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
	public Component create(String prettyName, String tag, int projectId, Integer parentId) {
		Component comp = new Component();
		comp.setPrettyName(prettyName);
		comp.setTag(tag);
		comp.setProject(projectService.get(projectId));
		if (parentId != null) {
			if (comp.getParents() == null) {
				comp.setParents(new HashSet<Component>());
			}
			comp.getParents().add(get(parentId));
		}
		save(comp);
		return comp;
	}

	@Transactional(readOnly = false)
	public void save(Component component) {
		componentDao.save(component);
	}

	@Transactional(readOnly = false)
	public void delete(Component component) {
		componentDao.delete(component);
	}
}
