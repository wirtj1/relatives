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
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class Bootstrap extends UI {

    private GridLayout rootLayout;

    private MainModel mainModel;
    private MainView mainView;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        initMVP();
        buildLayout();
    }

    private void initMVP()
    {
        initModels();
        initViews();

        new MainPresenter(mainModel, mainView);
    }


    private void initModels()
    {
        mainModel = new MainModel();
        mainModel.setUserName("Team orange");
    }

    private void initViews(){
        mainView = new MainView();
    }

    private void buildLayout()
    {
        rootLayout = new GridLayout(1, 3);
        MenuBar menu = new MenuBar();

        menu.addItem("Home", null, menuItem -> navigateToView(mainView));
        menu.addItem("Medication", null, null);
        menu.addItem("Calendar", null, null);

        menu.setStyleName(ValoTheme.MENUBAR_BORDERLESS);
        menu.setResponsive(true);

        Label footer = new Label("PMS - Patient Management System / Created by Team Orange for SE @ BFH");
        footer.setResponsive(true);

        // Initial config for grid layout
        rootLayout.setWidth("100%");
        rootLayout.setHeight("100%");

        rootLayout.addComponent(menu, 0,0);
        rootLayout.addComponent(footer, 0,2);
        rootLayout.setComponentAlignment(menu, Alignment.TOP_CENTER);
        rootLayout.setComponentAlignment(footer, Alignment.BOTTOM_CENTER);

        rootLayout.setColumnExpandRatio(0,1);
        rootLayout.setRowExpandRatio(1,1);
        rootLayout.setResponsive(true);

        // Set grid as root layout
        setContent(rootLayout);
    }

    /** add view to grid and center align it **/
    private void navigateToView(Component view){
        rootLayout.removeComponent(0,1);
        rootLayout.addComponent(view, 0,1);
        rootLayout.setComponentAlignment(view, Alignment.MIDDLE_CENTER);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Bootstrap.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
