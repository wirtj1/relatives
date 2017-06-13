package ch.bfh.bti7081.s2017.orange;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.*;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.*;
import ch.bfh.bti7081.s2017.orange.presentation.views.*;
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
     *
     * @param vaadinRequest: The Vaadin request issued
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        buildLayout();

        MvpNavigator navigator = new MvpNavigator(this, contentLayout, navigationBar);

        // Add views
        navigator.addView(new LogonPresenter(new LogonView(), new LogonModel()), false);
        navigator.addView(new PinboardPresenter(new PinboardView(), new PinboardModel()), VaadinIcons.TASKS, true);
        navigator.addView(new PinCreationPresenter(new PinCreationView(), new PinboardModel()), false);
        navigator.addView(new MedicationPresenter(new MedicationView(), new MedicationModel()), VaadinIcons.PILLS ,true);
        navigator.addView(new PersonDataPresenter(new PersonDataView(), new PersonDataModel()), VaadinIcons.GROUP,true);
        navigator.addView(new ChangePasswordPresenter(new ChangePasswordView(), new ChangePasswordModel()), false );

        setNavigator(navigator);

        if (sessionActive()) {
            getNavigator().navigateTo(PersonDataView.class);
        } else {
            getNavigator().navigateTo(LogonView.class);
        }
    }

    /**
     * Builds the layout
     */
    private void buildLayout() {
        rootLayout = new GridLayout(1, 3);
        //1 rootLayout.setStyleName(ValoTheme.PANEL_BORDERLESS);
        //2 rootLayout.setMargin(false);

        navigationBar = new MenuBar();
        navigationBar.setStyleName(ValoTheme.MENUBAR_BORDERLESS);
        navigationBar.setResponsive(true);
        MenuBar.MenuItem settings = navigationBar.addItem("", VaadinIcons.COGS, null);
        settings.addItem("Change password", VaadinIcons.PASSWORD, menuItem -> {
            this.getNavigator().navigateTo(ChangePasswordView.class);
        });
        settings.addItem("Logout", VaadinIcons.SIGN_OUT, menuItem -> doLogout());

        Label footer = new Label("PMS - Patient Management System / Created by Team Orange for SE @ BFH");
        footer.setResponsive(true);

        // Initial config for grid layout
        rootLayout.setWidth("100%");
        rootLayout.setHeight("100%");

        rootLayout.addComponent(navigationBar, 0, 0);
        rootLayout.addComponent(footer, 0, 2);
        rootLayout.setComponentAlignment(navigationBar, Alignment.TOP_CENTER);
        rootLayout.setComponentAlignment(footer, Alignment.BOTTOM_CENTER);

        contentLayout = new VerticalLayout();
        //3 contentLayout.setHeight("100%");


        Panel panel = new Panel();
        panel.setSizeFull();
        panel.setContent(contentLayout);
        panel.setResponsive(true);
        panel.setStyleName(ValoTheme.PANEL_BORDERLESS);

        rootLayout.addComponent(panel, 0, 1);
        rootLayout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);


        contentLayout.setResponsive(true);


        rootLayout.setColumnExpandRatio(0, 1);
        rootLayout.setRowExpandRatio(1, 1);
        rootLayout.setResponsive(true);


        // Set grid as root layout
        setContent(rootLayout);
    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Bootstrap.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
