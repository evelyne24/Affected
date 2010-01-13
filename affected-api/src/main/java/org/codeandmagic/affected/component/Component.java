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

package org.codeandmagic.affected.component;

import java.io.Serializable;
import java.util.Set;

/**
 * A Component is an abstract concept of an entity monitored for svn changes
 * through its tag. The linked components (parents or children) can also suffer
 * changes and should be monitored, if this component changes.
 */
public class Component implements Serializable {
	private static final long serialVersionUID = 4883913119766955510L;

	private int id;
	private Integer version;
	private String prettyName;
	private String tag;
	private Set<Component> parents;
	private Set<Component> children;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getPrettyName() {
		return prettyName;
	}

	public void setPrettyName(String prettyName) {
		this.prettyName = prettyName;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Set<Component> getParents() {
		return parents;
	}

	public void setParents(Set<Component> parents) {
		this.parents = parents;
	}

	public Set<Component> getChildren() {
		return children;
	}

	public void setChildren(Set<Component> children) {
		this.children = children;
	}

}
