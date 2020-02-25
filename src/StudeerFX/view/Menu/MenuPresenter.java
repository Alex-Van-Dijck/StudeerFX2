package StudeerFX.view.Menu;

/**
 * @author Alex Van Dijck on 25/02/2020
 * @project StudeerFX
 */

import StudeerFX.model.StudeerModel;
import StudeerFX.view.Start.StartView;


public class MenuPresenter {
    private StudeerModel model;
    private MenuView view;

    public MenuPresenter(StudeerModel model, MenuView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {

    }

    private void updateView() {

    }
}


