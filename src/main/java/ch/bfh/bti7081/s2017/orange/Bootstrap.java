package ch.bfh.bti7081.s2017.orange;

import javax.servlet.annotation.WebServlet;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.LogonModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.MainModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.TestModel;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.BasePresenter;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.LogonPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.MainPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.TestPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.LogonView;
import ch.bfh.bti7081.s2017.orange.presentation.views.MainView;
import ch.bfh.bti7081.s2017.orange.presentation.views.TestView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class Bootstrap extends BaseUI {

    private GridLayout rootLayout;
    private VerticalLayout contentLayout;
    private MenuBar navigationBar;

    private MainModel mainModel;
    private MainView mainView;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        buildLayout();

        MvpNavigator navigator = new MvpNavigator(this, contentLayout, navigationBar);

        navigator.addView(new LogonPresenter(new LogonView(), new LogonModel()), false);
        navigator.addView(new MainPresenter(new MainView(), new MainModel()), true);
        navigator.addView(new TestPresenter(new TestView(), new TestModel()), true);

        setNavigator(navigator);

        if(sessionRegistered()) {
            getNavigator().navigateTo(MainView.class);
        } else {
            getNavigator().navigateTo(LogonView.class);
        }
    }

    private void buildLayout()
    {
        rootLayout = new GridLayout(1, 3);
        navigationBar = new MenuBar();
        navigationBar.setStyleName(ValoTheme.MENUBAR_BORDERLESS);
        navigationBar.setResponsive(true);

        Label footer = new Label("PMS - Patient Management System / Created by Team Orange for SE @ BFH");
        footer.setResponsive(true);

        // Initial config for grid layout
        rootLayout.setWidth("100%");
        rootLayout.setHeight("100%");

        rootLayout.addComponent(navigationBar, 0,0);
        rootLayout.addComponent(footer, 0,2);
        rootLayout.setComponentAlignment(navigationBar, Alignment.TOP_CENTER);
        rootLayout.setComponentAlignment(footer, Alignment.BOTTOM_CENTER);

        contentLayout = new VerticalLayout();

        rootLayout.addComponent(contentLayout, 0, 1);
        rootLayout.setComponentAlignment(contentLayout, Alignment.MIDDLE_CENTER);

        rootLayout.setColumnExpandRatio(0,1);
        rootLayout.setRowExpandRatio(1,1);
        rootLayout.setResponsive(true);


        // Set grid as root layout
        setContent(rootLayout);
    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Bootstrap.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
