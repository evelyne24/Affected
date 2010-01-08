package org.codeandmagic.affected.user;

/**
 * Represents an user with an account on the svn, with access to an
 * {@link org.codeandmagic.affected.svn.api.SvnProject}
 */
public class User {
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
