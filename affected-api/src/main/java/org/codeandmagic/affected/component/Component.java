package org.codeandmagic.affected.component;

import java.io.Serializable;
import java.util.Set;

import org.codeandmagic.affected.svn.SvnProject;

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
	private SvnProject project;

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return
	 */
	public String getPrettyName() {
		return prettyName;
	}

	/**
	 * @param prettyName
	 */
	public void setPrettyName(String prettyName) {
		this.prettyName = prettyName;
	}

	/**
	 * @return
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the parent components (up in the hierarchy) of this component
	 */
	public Set<Component> getParents() {
		return parents;
	}

	/**
	 * @param parents
	 *            the parent components (up in the hierarchy) of this component
	 */
	public void setParents(Set<Component> parents) {
		this.parents = parents;
	}

	/**
	 * @return the children components of this component
	 */
	public Set<Component> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children components of this component
	 */
	public void setChildren(Set<Component> children) {
		this.children = children;
	}

	/**
	 * @param project
	 *            the project this component belongs to
	 */
	public void setProject(SvnProject project) {
		this.project = project;
	}

	/**
	 * @return the project this component belongs to
	 */
	public SvnProject getProject() {
		return project;
	}
}
