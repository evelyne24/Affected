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

package org.codeandmagic.affected.svn;

/** General type of exception, mostly used as a wrapper for other custom exceptions. */
public class SvnException extends Exception {
    private static final long serialVersionUID = -7039127472182875167L;

    public SvnException(String message, Throwable e) {
        super(message, e);
    }

    public SvnException(String message) {
        this(message, null);
    }

    public SvnException(Throwable e) {
        this(null, e);
    }
}
