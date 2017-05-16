package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.Pinnboard;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPinnboardView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinnboardView;

/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinnboardPresenter extends BasePresenter<PinnboardView, Pinnboard> implements IPinnboardView.IPinnboardViewListener
{
    PinnboardPresenter(PinnboardView view, Pinnboard model)
    {
        super(view, model);
    }
}
