/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 *   
 * This file is part of Affected.
 *   
 * Affected is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *   
 * Affected is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied   warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU Lesser General Public License for more details.
 *   
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/
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
