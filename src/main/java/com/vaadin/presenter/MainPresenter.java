package com.vaadin.presenter;

import com.vaadin.models.MainModel;
import com.vaadin.views.IMainView;
import com.vaadin.views.MainView;

/**
 * Created by Sascha on 01/05/2017.
 */
public class MainPresenter implements IMainView.IMainViewListener {

    private MainModel model;
    private IMainView view;

    public MainPresenter(MainModel model, IMainView view){
        this.model = model;
        this.view = view;
        view.setUsername(model.getUserName());
        view.addListener(this);
    }

    @Override
    public void logout() {
        // Do logout
        model.setUserName("");
        view.setUsername(model.getUserName());
    }
}
