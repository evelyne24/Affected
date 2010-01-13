/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 * 
 * This file is part of Affected.
 * 
 * Affected is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Affected is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package org.codeandmagic.affected.gwt.client;

import java.util.Set;

import org.codeandmagic.affected.component.Component;
import org.codeandmagic.affected.gwt.client.component.ComponentUi;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dev.util.collect.HashSet;
import com.google.gwt.dom.client.Document;

public class Affected implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// test
		Component parent = new Component();
		parent.setId(1);
		parent.setPrettyName("Parent");
		parent.setTag("parent");

		Component child1 = new Component();
		child1.setId(1);
		child1.setPrettyName("Child1");
		child1.setTag("child1");

		Component child2 = new Component();
		child2.setId(1);
		child2.setPrettyName("Child2");
		child2.setTag("child2");

		Set<Component> children = new HashSet<Component>();
		children.add(child1);
		children.add(child2);

		parent.setChildren(children);

		Document.get().appendChild(new ComponentUi(parent).getElement());
	}
}
