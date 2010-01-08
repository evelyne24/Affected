package org.codeandmagic.affected.svn.api;

/**
 * An abstract concept representing a svn project, located on a repository at the given url. The
 * repository credentials are also provided.
 */
public class SvnProject {
    private int id;
    private String url;
    private long localVersion;
    private String username;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /** @return the url of the project on the svn repository */
    public String getUrl() {
        return url;
    }

    /** @param url the url of the project on the svn repository */
    public void setUrl(String url) {
        this.url = url;
    }

    /** @return the username used to access the project's repository */
    public String getUsername() {
        return username;
    }

    /** @param username the username used to access the project's repository */
    public void setUsername(String username) {
        this.username = username;
    }

    /** @return the password used to access the project's repository */
    public String getPassword() {
        return password;
    }

    /** @param password the password used to access the project's repository */
    public void setPassword(String password) {
        this.password = password;
    }

    /** @return the version of the local working copy of the project */
    public long getLocalVersion() {
        return localVersion;
    }

    /** @param localVersion the version of the local working copy of the project */
    public void setLocalVersion(long localVersion) {
        this.localVersion = localVersion;
    }

    @Override
    public String toString() {
        return "{url=" + url + ",localVer=" + localVersion + ",username=" + username + ",pass=" + password + "}";
    }

}
