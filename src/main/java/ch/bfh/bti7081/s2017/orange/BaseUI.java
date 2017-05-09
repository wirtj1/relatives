package ch.bfh.bti7081.s2017.orange;

import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.UI;

/**
 * Created by Leandro on 9/5/2017.
 */
public abstract class BaseUI extends UI {
    @Override
    public BaseNavigator getNavigator() {
        return (BaseNavigator) super.getNavigator();
    }

    public Boolean sessionRegistered(){
        Session session = getSession().getAttribute(Session.class);
        if (session == null)
            return false;

        return session.get_active();
    }
}
