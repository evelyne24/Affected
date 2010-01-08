package org.codeandmagic.affected.svn.api;

/** An abstract concept representing a svn project, located on a repository at the given url. */
public class SvnProject {
    private int id;
    private Integer version;
    private String name;
    private String url;
    private long lastCheckedVersion;

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

    /** @return the version of the last processed version of the project */
    public long getLastCheckedVersion() {
        return lastCheckedVersion;
    }

    /** @param lastCheckedVersion the version of the last processed version of the project */
    public void setLastCheckedVersion(long lastCheckedVersion) {
        this.lastCheckedVersion = lastCheckedVersion;
    }

    /** @return the unique name of the project */
    public String getName() {
        return name;
    }

    /** @param name the unique name of the project */
    public void setName(String name) {
        this.name = name;
    }

    /** @return the Hibernate version */
    public Integer getVersion() {
        return version;
    }

    /** @param version the Hibernate version */
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@{id=" + id + ",name='" + name +
                "',url='" + url + "',lastCheckedVer=" + lastCheckedVersion + "}";
    }
}
