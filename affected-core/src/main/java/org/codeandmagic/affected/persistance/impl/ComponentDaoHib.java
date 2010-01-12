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

package org.codeandmagic.affected.persistance.impl;

import org.codeandmagic.affected.component.Component;
import org.codeandmagic.affected.persistance.api.ComponentDao;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;
import java.util.List;

public class ComponentDaoHib extends GenericDaoHib implements ComponentDao {

    public void delete(Component component) {
        getSession().delete(component);
    }

    public Component get(int id) {
        return (Component) getSession().get(Component.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Component> getAll() {
        return getSession().createCriteria(Component.class).list();
    }

    public Component getByTag(String tag) {
        return (Component) getSession().createCriteria(Component.class).add(Restrictions.eq("tag", tag)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Component> getByTags(Collection<Component> tags) {
        return (List<Component>) getSession().createCriteria(Component.class).add(Restrictions.in("tag", tags)).list();
    }

    public void save(Component component) {
        getSession().save(component);
    }

}
