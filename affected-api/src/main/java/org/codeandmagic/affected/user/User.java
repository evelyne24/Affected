package org.codeandmagic.affected.user;

import java.io.Serializable;

/**
 * Represents an user with an account on the svn, with access to an
 * {@link org.codeandmagic.affected.svn.api.SvnProject}
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1387255460042337739L;

	private int id;
	private Integer version;
	private String username;
	private String password;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
