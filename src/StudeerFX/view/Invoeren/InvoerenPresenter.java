package StudeerFX.view.Invoeren;

import StudeerFX.model.StudeerModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Alex Van Dijck on 27/02/2020
 * @project StudeerFX
 */
public class InvoerenPresenter {
    private StudeerModel model;
    private InvoerenView view;

    public InvoerenPresenter(StudeerModel model, InvoerenView view) {
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


