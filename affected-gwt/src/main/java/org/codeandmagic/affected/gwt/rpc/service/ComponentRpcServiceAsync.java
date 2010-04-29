package org.codeandmagic.affected.gwt.rpc.service;

import java.util.List;

import org.codeandmagic.affected.component.Component;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ComponentRpcServiceAsync {
	void get(int id, AsyncCallback<Component> callback);

	void getByTag(String tag, AsyncCallback<Component> callback);

	void getAll(AsyncCallback<List<Component>> callback);

	void save(Component component, AsyncCallback<Boolean> callback);

	void delete(Component component, AsyncCallback<Boolean> callback);
}
