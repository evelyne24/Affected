package org.codeandmagic.affected.svn;

import java.io.Serializable;
import java.util.Set;

import org.codeandmagic.affected.component.Component;

/**
 * An abstract concept representing a svn project, located on a repository at
 * the given url. The credentials for the svn authentication, if needed, are
 * also provided.
 */
public class SvnProject implements Serializable {
	private static final long serialVersionUID = -6425942064434536752L;

	private int id;
	private Integer version;
	private String name;
	private String url;
	private long lastCheckedVersion;
	private String username;
	private String password;
	private Set<Component> components;

	/** @param id */
	public void setId(int id) {
		this.id = id;
	}

	/** @return the unique id of the project */
	public int getId() {
		return id;
	}

	/** @return the url of the project on the svn repository */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url of the project on the svn repository
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/** @return the version of the last processed version of the project */
	public long getLastCheckedVersion() {
		return lastCheckedVersion;
	}

	/**
	 * @param lastCheckedVersion
	 *            the version of the last processed version of the project
	 */
	public void setLastCheckedVersion(long lastCheckedVersion) {
		this.lastCheckedVersion = lastCheckedVersion;
	}

	/** @return the unique name of the project */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the unique name of the project
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** @return the Hibernate version */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the Hibernate version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/** @return the username for svn authentication, if needed */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            for svn authentication, if needed
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/** @return the password for svn authentication, if needed */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            for svn authentication, if needed
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the components of the project
	 */
	public Set<Component> getComponents() {
		return components;
	}

	/**
	 * @param components
	 *            the components of the project to be set
	 */
	public void setComponents(Set<Component> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@{id=" + id + ",name='" + name
				+ "',url='" + url + "',lastCheckedVer=" + lastCheckedVersion
				+ "}";
	}
}
