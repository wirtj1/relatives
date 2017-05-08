package ch.bfh.bti7081.s2017.orange.presentation.views;

import com.vaadin.navigator.View;

/**
 * Created by Sascha on 01/05/2017.
 */
public interface ITestView extends View {
    void setMessage(String message);

    interface ITestViewListener {

    }

    void addListener(ITestViewListener listener);
}
