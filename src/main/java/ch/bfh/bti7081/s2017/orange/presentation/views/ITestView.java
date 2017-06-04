package ch.bfh.bti7081.s2017.orange.presentation.views;

import com.vaadin.navigator.View;

/**
 * @author Sascha
 */
public interface ITestView extends View {
    void setMessage(String message);

    interface ITestViewListener {

    }

    void addListener(ITestViewListener listener);
}
