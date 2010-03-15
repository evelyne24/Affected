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
