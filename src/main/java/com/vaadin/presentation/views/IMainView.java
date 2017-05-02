package com.vaadin.presentation.views;

/**
 * Created by Sascha on 01/05/2017.
 */
public interface IMainView {
    void setUsername(String username);

    interface IMainViewListener {
        void logout();
    }

    void addListener(IMainViewListener listener);
}
