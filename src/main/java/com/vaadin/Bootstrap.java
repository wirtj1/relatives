package com.vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.businesslogic.models.MainModel;
import com.vaadin.presentation.presenter.MainPresenter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.presentation.views.MainView;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class Bootstrap extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout content = new VerticalLayout();

        GridLayout grid = new GridLayout(1, 3);
        MenuBar menu = new MenuBar();

        menu.addItem("Home", null, menuItem -> {
            MainModel model = new MainModel();
            model.setUserName("Team Orange");

            MainView view = new MainView();

            MainPresenter presenter = new MainPresenter(model, view);

            content.removeAllComponents();
            content.addComponent(view);
        });
        MenuItem medication = menu.addItem("Medication", null, null);

        Label footer = new Label("PMS - Patient Management System / Created by Team Orange for SE @ BFH");

        grid.setWidth("100%");
        grid.setHeight("100%");

        grid.addComponent(menu, 0,0);
        grid.addComponent(content, 0,1);
        grid.addComponent(footer, 0,2);

        grid.setColumnExpandRatio(0,1);
        grid.setRowExpandRatio(1,1);

        setContent(grid);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Bootstrap.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
