package StudeerFX.view.Genereren;

import StudeerFX.model.Spel;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 * @author Alex Van Dijck and Miguel Reyntjens on 10/03/2020
 * @project StudeerFX
 */
public class GenererenPresenter {
    //Declareren
    private Spel model;
    private GenererenView view;

    public GenererenPresenter(Spel model, GenererenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();

    }
// Eventlistner om terug naar menu te gaan
    private void addEventHandlers() {
        view.getBtnterug().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuView menuView = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(model, menuView);
                view.getScene().setRoot(menuView);
                menuView.getScene().getWindow().sizeToScene();
            }
        });
        // Eventlistner om vraag toe te voegen

        view.getBtntoevoegen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!model.isInteger(view.getTfaantalVraagField().getText())) {
                    Alert intAlert = new Alert(Alert.AlertType.ERROR);
                    intAlert.setHeaderText("Geef een geheel getal!");
                    intAlert.showAndWait();

                } else if (Integer.parseInt(view.getTfaantalVraagField().getText()) > 9999 || Integer.parseInt(view.getTfaantalVraagField().getText()) < 1) {
                    Alert grensAlert = new Alert(Alert.AlertType.ERROR);
                    grensAlert.setHeaderText("Geef een geheel getal tussen 1 en 9999! ");
                    grensAlert.showAndWait();
                } else {
                    model.setAantalVragenInvoeren(Integer.parseInt(view.getTfaantalVraagField().getText()));
                    model.genereerVraag();
                    GenererenView genererenView = new GenererenView();
                    GenererenPresenter genererenPresenter = new GenererenPresenter(model, genererenView);
                    view.getScene().setRoot(genererenView);
                    genererenView.getScene().getWindow().sizeToScene();
                }
            }
        });

    }

    private void updateView() {

    }
}


