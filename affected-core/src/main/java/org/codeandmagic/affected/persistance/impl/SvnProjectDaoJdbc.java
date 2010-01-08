package org.codeandmagic.affected.persistance.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codeandmagic.affected.persistance.api.SvnProjectDao;
import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SvnProjectDaoJdbc implements SvnProjectDao {
    private JdbcTemplate jdbcTemplate;
    private final Log log = LogFactory.getLog(this.getClass());

    @Required
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<SvnProject> getAllProjects() {
        return jdbcTemplate.query("select * from project", new RowMapper<SvnProject>() {

            public SvnProject mapRow(ResultSet resSet, int rowNum) throws SQLException {
                return populate(resSet);
            }
        });
    }

    public SvnProject get(String url) throws SvnException {
        SvnProject proj = jdbcTemplate.queryForObject("select * from project where url= ?",
                new Object[]{url}, new RowMapper<SvnProject>() {

                    public SvnProject mapRow(ResultSet resSet, int rowNum) throws SQLException {
                        return populate(resSet);
                    }

                });
        if (proj == null) {
            throw new SvnException("No project with url '" + url + "' to retrieve.");
        }
        return proj;
    }

    public SvnProject create(String url, long localVersion, String username, String password) throws SvnException {
        jdbcTemplate.update("insert into project (url, localVersion, username, password) values (?,?,?,?)",
                new Object[]{url, localVersion, username, password});
        return get(url);
    }


    public void update(SvnProject proj) {
        jdbcTemplate.update("update project set url=?, localVersion=?, username=?, password=? where id=?",
                new Object[]{proj.getUrl(), proj.getLocalVersion(), proj.getUsername(), proj.getPassword(), proj.getId()});

    }

    public void delete(String url) {
        jdbcTemplate.update("delete from project where url=?", new Object[]{url});
    }

    protected SvnProject createNoSave(String url, long localVersion, String username, String password) {
        SvnProject project = new SvnProject();
        project.setUrl(url);
        project.setLocalVersion(localVersion);
        project.setUsername(username);
        project.setPassword(password);
        return project;
    }

    protected SvnProject populate(ResultSet resSet) {
        try {
            return populate(resSet.getInt("id"), resSet.getString("url"), resSet
                    .getLong("localVersion"), resSet.getString("username"), resSet
                    .getString("password"));
        }
        catch (SQLException e) {
            log.error("Could not populate a SvnProject object with data from the given ResultSet", e);
            return null;
        }
    }

    protected SvnProject populate(int id, String url, long localVersion, String username,
                                  String password) {
        SvnProject proj = createNoSave(url, localVersion, username, password);
        proj.setId(id);
        return proj;
    }

}
