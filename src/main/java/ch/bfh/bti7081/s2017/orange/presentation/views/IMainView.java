package ch.bfh.bti7081.s2017.orange.presentation.views;

import com.vaadin.event.MethodEventSource;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.ClientConnector;

/**
 * Created by Sascha on 01/05/2017.
 */
public interface IMainView extends View, ClientConnector, MethodEventSource {
    void setUsername(String username);

    interface IMainViewListener {
        void logout(Navigator navigator);
    }

    void addListener(IMainViewListener listener);
}
