package org.codeandmagic.affected.gwt.rpc;

import org.codeandmagic.affected.component.Component;

import com.google.gwt.user.client.rpc.RemoteService;

public interface ComponentRpcService extends RemoteService {
	Component get(String tag);
}
