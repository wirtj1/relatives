package ch.bfh.bti7081.s2017.orange;

import ch.bfh.bti7081.s2017.orange.presentation.utils.NavigationUtils;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.BasePresenter;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;
import ch.bfh.bti7081.s2017.orange.presentation.views.LogonView;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.MenuBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Navigator customized to meet MVP requirements and for easier navigation between views in MVP
 * @author Sascha
 * @author Leandro
 */
public class MvpNavigator extends BaseNavigator {

    private MenuBar navigationBar;
    private List<BaseView> views = new ArrayList<>();
    private List<Class> viewHistory;


    public MvpNavigator(BaseUI ui, ComponentContainer container, MenuBar navigation)
    {
        super(ui, container);
        this.navigationBar = navigation;
        this.viewHistory = new ArrayList<>();
    }

    /**
     * Adds the view to the navigator and optionally also to the menu of the Bootstrapper.
     * @param presenter: Presenter (represents an MVP set) to be observed by the navigator.
     * @param addToMenu: Switch, if the View should be available through the menu.
     */
    public void addView(BasePresenter presenter, VaadinIcons icon, boolean addToMenu) {
        addView(presenter.getView().getViewName(), presenter.getView());
        views.add(presenter.getView());

        if (addToMenu)
        {
            MenuBar.MenuItem firstMenuItem = navigationBar.getItems().get(0);
            navigationBar.addItemBefore(presenter.getView().getCaption(), icon, menuItem -> navigateTo(presenter.getView().getClass()), firstMenuItem);
        }
    }

    public void addView(BasePresenter presenter, boolean addToMenu){
        addView(presenter, null, addToMenu);
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
        if (getUI().sessionActive() || destinationView.equals(LogonView.class)){
            viewHistory.add(destinationView);
            views.stream()
                    .filter(components -> components.getClass().equals(destinationView))
                    .findFirst()
                    .ifPresent(components -> navigateTo(NavigationUtils.combineNameAndParams(components.getViewName(), parameterSet)));
        } else { // Navigation to other view than logon despite no valid session
            ParameterSet parameter = new ParameterSet();
            parameter.addParameter("timeout", "true");
            viewHistory.add(LogonView.class);
            views.stream()
                    .filter(components -> components.getClass().equals(LogonView.class))
                    .findFirst()
                    .ifPresent(components -> navigateTo(NavigationUtils.combineNameAndParams(components.getViewName(), parameter)));
        }
    }

    /**
     * Navigates one step back
     */
    public void navigateBack()
    {
        if (viewHistory.size() > 2){
            // Navigate to last view. Current view is size -1, last view is size -2
            navigateTo(viewHistory.get(viewHistory.size() - 2));
        }
    }

    /**
     * Resets Navigation history
     */
    public void resetViewHistory(){
        viewHistory.clear();
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
