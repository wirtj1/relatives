package ch.bfh.bti7081.s2017.orange;

import ch.bfh.bti7081.s2017.orange.presentation.utils.NavigationUtils;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.BasePresenter;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;
import ch.bfh.bti7081.s2017.orange.presentation.views.LogonView;
import ch.bfh.bti7081.s2017.orange.presentation.views.MainView;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

import java.util.ArrayList;
import java.util.List;

/**
 * Navigator customized to meet MVP requirements and for easier navigation between views in MVP
 */
public class MvpNavigator extends BaseNavigator {

    private MenuBar navigationBar;
    private List<BaseView> views = new ArrayList<>();


    public MvpNavigator(BaseUI ui, ComponentContainer container, MenuBar navigation)
    {
        super(ui, container);
        this.navigationBar = navigation;
    }

    /**
     * Adds the view to the navigator and optionally also to the menu of the Bootstrapper.
     * @param presenter: Presenter (represents an MVP set) to be observed by the navigator.
     * @param addToMenu: Switch, if the View should be available through the menu.
     */
    public void addView(BasePresenter presenter, boolean addToMenu) {
        addView(presenter.getView().getViewName(), presenter.getView());
        views.add(presenter.getView());

        if (addToMenu)
        {
            MenuBar.MenuItem firstMenuItem = navigationBar.getItems().get(0);
            navigationBar.addItemBefore(presenter.getView().getCaption(), null, menuItem -> navigateTo(presenter.getView().getClass()), firstMenuItem);
        }

    }

    /**
     * Navigates to the specified View
     * @param destinationView: View to be navigated to
     * @param parameterSet: Parameters to be passed to the view
     * @param <T>: Class extending BaseView
     */
    public <T extends BaseView> void navigateTo(Class<T> destinationView, ParameterSet parameterSet)
    {
        // Navigation to logon view is always possible
        if (getUI().sessionRegistered() || destinationView.equals(LogonView.class)){
            views.stream()
                    .filter(components -> components.getClass().equals(destinationView))
                    .findFirst()
                    .ifPresent(components -> navigateTo(NavigationUtils.combineNameAndParams(components.getViewName(), parameterSet)));
        }
    }

    /**
     * Navigates to the specified View
     * @param destinationView: View to be navigated to
     * @param <T>: Class extending BaseView
     */
    public <T extends BaseView> void navigateTo(Class<T> destinationView)
    {
        navigateTo(destinationView, null);
    }
}
