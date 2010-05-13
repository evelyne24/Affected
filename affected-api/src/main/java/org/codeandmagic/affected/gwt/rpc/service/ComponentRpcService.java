package org.codeandmagic.affected.gwt.rpc.service;

import java.util.List;

import org.codeandmagic.affected.component.Component;

import com.google.gwt.user.client.rpc.RemoteService;

public interface ComponentRpcService extends RemoteService {
	Component get(int id);

	Component getByTag(String tag);

	List<Component> getAll();

	void save(Component component);

	void delete(Component component);
}
