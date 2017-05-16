package ch.bfh.bti7081.s2017.orange.presentation.views;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

import java.util.List;

/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinnboardView extends BaseView implements IPinnboardView
{
    private List<IPinnboardViewListener> listeners;
    private TextField _userName;
    private PasswordField _password;
    private Button _doLogon;

    @Override
    public String getViewName()
    {
        return null;
    }

    @Override
    public String getCaption()
    {
        return null;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent)
    {

    }


}
