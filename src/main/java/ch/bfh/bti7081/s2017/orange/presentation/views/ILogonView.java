package ch.bfh.bti7081.s2017.orange.presentation.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

/**
 * @author Sascha
 */
public interface ILogonView extends View {
    interface ILogonViewListener {
        void doLogin(String user, String password);
    }

    void addListener(ILogonViewListener listener);
}
