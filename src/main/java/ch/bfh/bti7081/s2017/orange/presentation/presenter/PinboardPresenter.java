package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPinboardView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinCreationView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinboardView;

/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinboardPresenter extends BasePresenter<PinboardView, PinboardModel> implements IPinboardView.IPinboardViewListener {
    public PinboardPresenter(PinboardView view, PinboardModel model) {
        super(view, model);
        view.addListener(this);
    }

    @Override
    public void addPinEntry() {
        String user = view.getUI().getSession().getAttribute(Session.class).get_user();
        view.getUI().getNavigator().navigateTo(PinCreationView.class);

    }
}
