package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.BaseModel;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;

/**
 * Base class for presenter
 */
public class BasePresenter<TView extends BaseView, TModel extends BaseModel> {

    TView view;
    TModel model;

    BasePresenter(TView view, TModel model){
        this.view = view;
        this.model = model;
    }

    public TView getView() {
        return view;
    }

    public TModel getModel() {
        return model;
    }
}
