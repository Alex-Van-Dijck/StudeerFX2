package StudeerFX.view.Resultaat;

import StudeerFX.model.Spel;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import StudeerFX.view.Start.StartView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Alex Van Dijck on 13/03/2020
 * @project StudeerFX
 */
public class ResultaatPresenter {
    private Spel model;
    private ResultaatView view;

    public ResultaatPresenter(Spel model, ResultaatView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
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
}