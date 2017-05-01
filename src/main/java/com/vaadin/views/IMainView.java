package com.vaadin.views;

/**
 * Created by Sascha on 01/05/2017.
 */
public interface IMainView {
    public void setUsername(String username);

    interface IMainViewListener {
        void logout();
    }

    public void addListener(IMainViewListener listener);
}
