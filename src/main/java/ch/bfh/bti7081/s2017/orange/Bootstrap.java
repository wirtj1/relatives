package ch.bfh.bti7081.s2017.orange;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.MainModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.PersonDataModel;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.MainPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.views.MainView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.servlet.annotation.WebServlet;

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

    //TODO (von joy) keine Ahnung ob das richtig ist wenn die View hier ist.. ich glaube laut vaadin sollte das ueber einen Navigator gemacht werden
    private PersonDataView personDataView;
    private PersonDataModel personDataModel;

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
        new PersonDataPresenter(personDataModel, personDataView);
    }


    private void initModels()
    {
        mainModel = new MainModel();
        mainModel.setUserName("Team orange");
        personDataModel = new PersonDataModel();
    }

    private void initViews(){
        mainView = new MainView();
        personDataView = new PersonDataView();
    }

    private void buildLayout()
    {
        rootLayout = new GridLayout(1, 3);
        MenuBar menu = new MenuBar();

        menu.addItem("Home", null, menuItem -> navigateToView(mainView));
        menu.addItem("Medication", null, null);
        menu.addItem("Calendar", null, null);
        menu.addItem("Basic Data", null, menuItem -> navigateToView(personDataView));

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
