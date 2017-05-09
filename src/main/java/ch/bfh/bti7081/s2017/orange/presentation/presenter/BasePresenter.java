package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.BaseModel;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;

/**
 * Created by Sascha on 05/05/2017.
 */
public class BasePresenter<TView extends BaseView, TModel extends BaseModel> {

    public TView view;
    public TModel model;

    public BasePresenter(TView view, TModel model){
        this.view = view;
        this.model = model;
    }
}
