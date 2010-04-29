package org.codeandmagic.affected.svn;

// @affects: SvnProjectProcessor

/**
 * Represents the svn types we can find on a repository.
 * <ul>
 * <li>FILE - represents a file
 * <li>DIR - represents a directory
 * <li>NONE - represents a missing path
 * <li>UNKNOWN - represents an unknown type (cannot be recognized)
 * </ul>
 */
public enum SvnFileType {
	FILE, DIR, NONE, UNKNOWN
}
