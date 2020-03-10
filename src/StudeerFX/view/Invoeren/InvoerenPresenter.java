package StudeerFX.view.Invoeren;

import StudeerFX.model.Spel;
import StudeerFX.view.Genereren.GenererenPresenter;
import StudeerFX.view.Genereren.GenererenView;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Alex Van Dijck on 27/02/2020
 * @project StudeerFX
 */
public class InvoerenPresenter {
    private Spel model;
    private InvoerenView view;

    public InvoerenPresenter(Spel model, InvoerenView view) {
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
        view.getToevoegen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.setAntwoord(view.getAntwoordField().getText());
                model.setVraag(view.getVraagField().getText());
                model.addVraag();
                model.setVakkeuze(view.getVakkeuze().getValue());
                InvoerenView invoerenView = new InvoerenView();
                InvoerenPresenter invoerenPresenter = new InvoerenPresenter(model, invoerenView);
                view.getScene().setRoot(invoerenView);
                invoerenView.getScene().getWindow().sizeToScene();
            }
        });
        view.getGenereren().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GenererenView genererenView = new GenererenView();
                GenererenPresenter genererenPresenter = new GenererenPresenter(model, genererenView);
                view.getScene().setRoot(genererenView);
                genererenView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView() {

    }
}


//test