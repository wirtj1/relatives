package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.MvpNavigator;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.MainModel;
import ch.bfh.bti7081.s2017.orange.presentation.Utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.views.IMainView;

import ch.bfh.bti7081.s2017.orange.presentation.views.MainView;
import ch.bfh.bti7081.s2017.orange.presentation.views.TestView;
import com.vaadin.navigator.Navigator;

/**
 * Created by Sascha on 01/05/2017.
 */
public class MainPresenter extends BasePresenter<MainView, MainModel> implements IMainView.IMainViewListener  {


    public MainPresenter(MainView view, MainModel model) {
        super(view, model);
        view.addListener(this);
    }

    @Override
    public void logout(Navigator navigator) {
        // Do logout
        model.setUserName("");
        view.setUsername(model.getUserName());

        //start Detail View
        //navigator.navigateTo("Test/fromMainView");
        ParameterSet parameterSet = new ParameterSet();
        parameterSet.addParameter("message", "helloFromMainView");
        ((MvpNavigator)navigator).navigateTo(TestView.class, parameterSet);


    }
}
