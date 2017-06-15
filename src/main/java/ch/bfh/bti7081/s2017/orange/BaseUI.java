package ch.bfh.bti7081.s2017.orange;

import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.LogonView;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.UI;

/**
 * Base class for Vaadin Ui
 *
 * @author Leandro
 * @author Sascha
 */
public abstract class BaseUI extends UI {

    @Override
    public BaseNavigator getNavigator() {
        return (BaseNavigator) super.getNavigator();
    }

    /**
     * Checks, if session is still active
     * @return true, if active.
     */
    public Boolean sessionActive(){
        Session session = getSession().getAttribute(Session.class);
        if (session == null)
            return false;

        return session.isActive();
    }

    /**
     * Gets current Session object
     * @return Session object
     */
    public Session getCurrentSession()
    {
        Session session = getSession().getAttribute(Session.class);

        return session;
    }

    public void doLogout()
    {
        Session session = getSession().getAttribute(Session.class);
        if (session != null)
        {
            getSession().setAttribute(Session.class, null);
            getNavigator().resetViewHistory();
            getNavigator().navigateTo(LogonView.class);
        }
    }
}
