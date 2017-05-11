package ch.bfh.bti7081.s2017.orange.presentation.utils;

import java.util.Date;

/**
 * Representation class for User session
 * @author Sascha
 */
public class Session {
    public String get_user() {
        return _user;
    }

    private String _user;

    public Date get_logonTime() {
        return _logonTime;
    }

    private Date _logonTime;

    public Boolean get_active() {
        return _active;
    }

    private Boolean _active;

    public Session(String user)
    {
        this._user = user;
        this._active = true;
    }

}
