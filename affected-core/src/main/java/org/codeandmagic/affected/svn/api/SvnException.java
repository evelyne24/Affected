package org.codeandmagic.affected.svn.api;

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
