package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPinboardView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinCreationView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinboardView;

/**
 * Created by NTHEVJ on 28.05.2017.
 */
public class PinCreationPresenter extends BasePresenter<PinCreationView, PinboardModel>
        implements IPinboardView.IPinCreationViewListener {

    public PinCreationPresenter(PinCreationView view, PinboardModel pinboardModel) {
        super(view, pinboardModel);
        this.view.addListener(this);
    }


    @Override
    public void createPinEntry(PinBoardEntry entry) {
        System.out.println(entry.toString());
        view.getUI().getNavigator().navigateTo(PinboardView.class);
    }

    @Override
    public void onViewEnter() {

        String user = view.getUI().getSession().getAttribute(Session.class).get_user();
        view.setAuthorName(user);
    }
}
