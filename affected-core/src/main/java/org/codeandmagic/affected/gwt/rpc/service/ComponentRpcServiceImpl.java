package org.codeandmagic.affected.gwt.rpc.service;

import java.util.List;

import org.codeandmagic.affected.component.Component;
import org.codeandmagic.affected.gwt.rpc.adapter.GwtRpcEndPoint;
import org.codeandmagic.affected.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

@GwtRpcEndPoint
@org.springframework.stereotype.Component
public class ComponentRpcServiceImpl implements ComponentRpcService {
	private ComponentService service;

	@Required
	@Autowired
	public void setService(ComponentService service) {
		this.service = service;
	}

	public boolean delete(Component component) {
		return service.delete(component);
	}

	public Component get(int id) {
		return service.get(id);
	}

	public List<Component> getAll() {
		return service.getAll();
	}

	public Component getByTag(String tag) {
		return service.getByTag(tag);
	}

	public boolean save(Component component) {
		return service.save(component);
	}
}
