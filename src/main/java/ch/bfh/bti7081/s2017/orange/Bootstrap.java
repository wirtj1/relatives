package ch.bfh.bti7081.s2017.orange;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.LogonModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.MedicationModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.PersonDataModel;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.LogonPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.views.LogonView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 *
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 *
 * @author Sascha
 * @author Leandro
 */
@Theme("mytheme")
public class Bootstrap extends BaseUI {

    private GridLayout rootLayout;
    private VerticalLayout contentLayout;
    private MenuBar navigationBar;

    /**
     * Initializes and sets a MvpNavigator, builds the view
     * @param vaadinRequest: The Vaadin request issued
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        buildLayout();

        MvpNavigator navigator = new MvpNavigator(this, contentLayout, navigationBar);

        navigator.addView(new LogonPresenter(new LogonView(), new LogonModel()), false);
        navigator.addView(new PersonDataPresenter(new PersonDataView(), new PersonDataModel()), true);

        setNavigator(navigator);

        if(sessionRegistered()) {
            getNavigator().navigateTo(PersonDataView.class);
        } else {
            getNavigator().navigateTo(LogonView.class);
        }
    }

    /**
     * Builds the layout
     */
    private void buildLayout()
    {
        rootLayout = new GridLayout(1, 3);
        navigationBar = new MenuBar();
        navigationBar.setStyleName(ValoTheme.MENUBAR_BORDERLESS);
        navigationBar.setResponsive(true);
        MenuBar.MenuItem settings = navigationBar.addItem("", VaadinIcons.COGS, null);
        settings.addItem("Account", VaadinIcons.USER, null);
        settings.addItem("Logout", VaadinIcons.SIGN_OUT,menuItem -> doLogout());

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
