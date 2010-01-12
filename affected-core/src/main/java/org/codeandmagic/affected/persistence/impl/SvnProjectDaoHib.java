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

package org.codeandmagic.affected.persistence.impl;

import org.codeandmagic.affected.persistence.api.SvnProjectDao;
import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class SvnProjectDaoHib extends GenericDaoHib implements SvnProjectDao {

    @SuppressWarnings("unchecked")
    public SvnProject get(String name) throws SvnException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SvnProject.class);
        criteria.add(Restrictions.eq("name", name));
        List<SvnProject> results = criteria.list();
        if (results == null || results.size() == 0) {
            throw new SvnException("No SvnProject with name '" + name + "'");
        }
        return results.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<SvnProject> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(SvnProject.class).list();
    }

    public void save(SvnProject project) {
        sessionFactory.getCurrentSession().saveOrUpdate(project);
    }

    public void delete(SvnProject project) {
        sessionFactory.getCurrentSession().delete(project);
    }
}
