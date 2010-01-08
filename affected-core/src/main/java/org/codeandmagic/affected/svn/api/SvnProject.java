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
