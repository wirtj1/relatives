package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPinboardView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinCreationView;

/**
 * Created by NTHEVJ on 28.05.2017.
 */
public class PinCreationPresenter extends BasePresenter<PinCreationView, PinboardModel> implements IPinboardView.IPinCreationViewListener {
    public PinCreationPresenter(PinCreationView components, PinboardModel pinboardModel) {
        super(components, pinboardModel);
    }


    @Override
    public void createPinEntry(PinBoardEntry entry) {
        System.out.println(entry.toString());
    }
}
