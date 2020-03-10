package StudeerFX.view.Genereren;

import StudeerFX.model.Spel;
import StudeerFX.view.Invoeren.InvoerenView;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenPresenter;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Alex Van Dijck on 10/03/2020
 * @project StudeerFX
 */
public class GenererenPresenter {
    private Spel model;
    private GenererenView view;

    public GenererenPresenter(Spel model, GenererenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getTerug().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuView menuView = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(model, menuView);
                view.getScene().setRoot(menuView);
                menuView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView() {

    }
}


