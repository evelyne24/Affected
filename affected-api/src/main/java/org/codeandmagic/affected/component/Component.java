package org.codeandmagic.affected.component;

import java.io.Serializable;
import java.util.Set;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * A Component is an abstract concept of an entity monitored for svn changes
 * through its tag. The linked components (parents or children) can also suffer
 * changes and should be monitored, if this component changes.
 */
public class Component implements Serializable, IsSerializable {
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
