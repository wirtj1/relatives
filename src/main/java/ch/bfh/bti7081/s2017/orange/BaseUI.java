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

    public Boolean sessionActive(){
        Session session = getSession().getAttribute(Session.class);
        if (session == null)
            return false;

        return session.isActive();
    }

    public void doLogout()
    {
        Session session = getSession().getAttribute(Session.class);
        if (session != null)
        {
            getSession().setAttribute(Session.class, null);
            getNavigator().navigateTo(LogonView.class);
        }
    }
}
